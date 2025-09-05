package com.adade.gestionaffairesjuridiques.ui;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.adade.gestionaffairesjuridiques.dao.ClientDAO;
import com.adade.gestionaffairesjuridiques.dto.ClientDTO;
import com.adade.gestionaffairesjuridiques.service.ClientService;
import com.adade.gestionaffairesjuridiques.ui.forms.CreateCustomerForm;
import com.adade.gestionaffairesjuridiques.ui.forms.UpdateCustomerForm;

import jakarta.servlet.ServletException;




@Controller
@RequestMapping("/office/customer")
public class BackOfficeCustomerController {
	

	
    @Autowired
    Logger logger;

    @Autowired
    ClientService clientService;
    
    @Autowired
    ClientDAO clientDAO;
    
    @GetMapping("/search")
    protected String showSearchForm() throws ServletException, IOException {
        logger.debug("entering {}", "showSearchForm");
        return "customer/search";
    }
    
    @GetMapping("/view")
    protected ModelAndView displayCustomer(@RequestParam("id") Long id) throws ServletException, IOException {
        logger.debug("entering {}", "displayCustomer");
        Optional<ClientDTO> optCustomer = clientService.findById(id);
        if (optCustomer.isPresent()) {
            return new ModelAndView("customer/view", "client", optCustomer.get());
        } else {
            return new ModelAndView("customer/missingClient", "id",  id);
        }
    }
    
    @GetMapping("/list")
    protected String displayCustomerList(Model model) {
        logger.debug("entering {}", "displayCustomerList");
        List<ClientDTO> customers = clientService.findAll();
        model.addAttribute("clients", customers);
        return "customer/list";
    }
    
    @GetMapping("/create")
    public String customerForm(Model model) {
        logger.debug("entering {}","customerForm");
        model.addAttribute("customerForm", new CreateCustomerForm());
        return "customer/createForm";
    }
    
    @PostMapping("/create")
    public ModelAndView createCustomerProcessV1(
             @ModelAttribute("customerForm") CreateCustomerForm customerForm,
            BindingResult bindingResult, RedirectAttributes redirectAttributes) {

    	logger.debug("entering {}","createCustomerProcess");
        if (bindingResult.hasErrors()) {
            ModelAndView result = new ModelAndView("customer/createForm");
            return result;
        } else {

                try {
                	clientService.save(customerForm.toDTO());
                   
                    redirectAttributes.addFlashAttribute("successMessage",  "Client crée");
                    return new ModelAndView("redirect:/");
                } catch (Exception e) {
                    bindingResult.reject("customer already exists");
                    return new ModelAndView("customer/createForm");                    
                }
        	
            }
        }
    

    
    
    @GetMapping("/update")
    public String displayForm(@RequestParam("id") Long id, Model model) {
    	logger.debug("entering {}","updateForm");

        Optional<ClientDTO> customer = clientService.findById(id);
        ClientDTO myClient=customer.get();
     
        model.addAttribute("client", myClient);
        model.addAttribute("updateForm", new UpdateCustomerForm(myClient));

        return  "customer/update";
    }
    
    @PostMapping("/update/{id}")
    public ModelAndView processForm(
    		@PathVariable("id") Long id,
             @ModelAttribute("updateForm") UpdateCustomerForm updateForm,
            BindingResult bindingResult,
            Model model, RedirectAttributes redirectAttributes) {
    	logger.debug("entering {}","updateselfCustomerProcess");
        if (bindingResult.hasErrors()) {
        	ModelAndView result = new ModelAndView("customer/update");
            return result;
        } else {
        	
                try {
                	clientService.update(updateForm.toDTO(id));
                	redirectAttributes.addFlashAttribute("successMessage",  "Client modifié");
                	return new ModelAndView("redirect:/");
                                          
                    
                } catch ( Exception e) {
                    bindingResult.reject("Erreur lors de la modification");
                    return new ModelAndView("customer/update");                    
                }
            }
        }
    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") long id,Model model,RedirectAttributes redirectAttributes) {
    	
        Optional<ClientDTO> customer = clientService.findById(id);
        ClientDTO myClient=customer.get();
        clientDAO.deleteById(id);
        redirectAttributes.addFlashAttribute("successMessage",  "Client supprimé");
        return "redirect:/";
    }

}



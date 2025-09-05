package com.adade.gestionaffairesjuridiques.ui;

import java.io.IOException;
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

import com.adade.gestionaffairesjuridiques.dao.AvocatDAO;
import com.adade.gestionaffairesjuridiques.dto.AvocatDTO;
import com.adade.gestionaffairesjuridiques.service.AvocatService;
import com.adade.gestionaffairesjuridiques.ui.forms.CreateAvocatForm;
import com.adade.gestionaffairesjuridiques.ui.forms.UpdateAvocatForm;


import jakarta.servlet.ServletException;

@Controller
@RequestMapping("/office/avocat")
public class BackOfficeAvocatController {

	
    @Autowired
    Logger logger;

    @Autowired
    AvocatService avocatService;
    
    @Autowired
    AvocatDAO avocatDAO;
    
    @GetMapping("/search")
    protected String showSearchForm() throws ServletException, IOException {
        logger.debug("entering {}", "showSearchForm");
        return "avocat/search";
    }
    
    @GetMapping("/view")
    protected ModelAndView displayCustomer(@RequestParam("id") Long id) throws ServletException, IOException {
        logger.debug("entering {}", "displayCustomer");
        Optional<AvocatDTO> optAvocat = avocatService.findById(id);
        if (optAvocat.isPresent()) {
            return new ModelAndView("avocat/view", "avocat", optAvocat.get());
        } else {
            return new ModelAndView("avocat/missingAvocat", "id",  id);
        }
    }
    
    @GetMapping("/list")
    protected String displayAvocatList(Model model) {
        logger.debug("entering {}", "displayAvocatList");
        List<AvocatDTO> avocats = avocatService.findAll();
        model.addAttribute("avocats", avocats);
        return "avocat/list";
    }
    
    @GetMapping("/create")
    public String avocatForm(Model model) {
        logger.debug("entering {}","avocatForm");
        model.addAttribute("avocatForm", new CreateAvocatForm());
        return "avocat/createForm";
    }
    
    @PostMapping("/create")
    public ModelAndView createAvocatProcessV1(
             @ModelAttribute("avocatForm") CreateAvocatForm avocatForm,
            BindingResult bindingResult, RedirectAttributes redirectAttributes) {

    	logger.debug("entering {}","createAvocatProcess");
        if (bindingResult.hasErrors()) {
            ModelAndView result = new ModelAndView("avocat/createForm");
            return result;
        } else {

                try {
                	avocatService.save(avocatForm.toDTO());
                   
                    redirectAttributes.addFlashAttribute("successMessage",  "Avocat crée");
                    return new ModelAndView("redirect:/");
                } catch (Exception e) {
                    bindingResult.reject("Avocat already exists");
                    return new ModelAndView("avocat/createForm");                    
                }
        	
            }
        }
    

    
    
    @GetMapping("/update")
    public String displayForm(@RequestParam("id") Long id, Model model) {
    	logger.debug("entering {}","updateForm");

        Optional<AvocatDTO> avocat = avocatService.findById(id);
        AvocatDTO myAvocat=avocat.get();
     
        model.addAttribute("client", myAvocat);
        model.addAttribute("updateForm", new UpdateAvocatForm(myAvocat));

        return  "avocat/update";
    }
    
    @PostMapping("/update/{id}")
    public ModelAndView processForm(
    		@PathVariable("id") Long id,
             @ModelAttribute("updateForm") UpdateAvocatForm updateForm,
            BindingResult bindingResult,
            Model model, RedirectAttributes redirectAttributes) {
    	logger.debug("entering {}","updateselfAvocatProcess");
        if (bindingResult.hasErrors()) {
        	ModelAndView result = new ModelAndView("avocat/update");
            return result;
        } else {
        	
                try {
                	avocatService.update(updateForm.toDTO(id));
                	redirectAttributes.addFlashAttribute("successMessage",  "Avocat modifié");
                	return new ModelAndView("redirect:/");
                                          
                    
                } catch ( Exception e) {
                    bindingResult.reject("Erreur lors de la modification");
                    return new ModelAndView("avocat/update");                    
                }
            }
        }
    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") long id,Model model,RedirectAttributes redirectAttributes) {
    	
      //  Optional<AvocatDTO> customer = avocatService.findById(id);
      //  AvocatDTO myAvocat=customer.get();
        avocatDAO.deleteById(id);
        redirectAttributes.addFlashAttribute("successMessage",  "Avocat supprimé");
        return "redirect:/";
    }

}

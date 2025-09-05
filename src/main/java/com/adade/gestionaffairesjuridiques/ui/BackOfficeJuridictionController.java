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

import com.adade.gestionaffairesjuridiques.dao.JuridictionDAO;
import com.adade.gestionaffairesjuridiques.dto.JuridictionDTO;
import com.adade.gestionaffairesjuridiques.service.JuridictionService;
import com.adade.gestionaffairesjuridiques.ui.forms.CreateJuridictionForm;
import com.adade.gestionaffairesjuridiques.ui.forms.UpdateJuridictionForm;
import jakarta.servlet.ServletException;

@Controller
@RequestMapping("/office/juridiction")
public class BackOfficeJuridictionController {
	
    @Autowired
    Logger logger;

    @Autowired
    JuridictionService juridictionService;
    
    @Autowired
    JuridictionDAO juridictionDAO;
    
    @GetMapping("/search")
    protected String showSearchForm() throws ServletException, IOException {
        logger.debug("entering {}", "showSearchForm");
        return "juridiction/search";
    }
    
    @GetMapping("/view")
    protected ModelAndView displayJuridiction(@RequestParam("id") Long id) throws ServletException, IOException {
        logger.debug("entering {}", "displayJuridiction");
        Optional<JuridictionDTO> optJuridiction = juridictionService.findById(id);
        if (optJuridiction.isPresent()) {
            return new ModelAndView("juridiction/view", "juridiction", optJuridiction.get());
        } else {
            return new ModelAndView("juridiction/missingJuridiction", "id",  id);
        }
    }
    
    @GetMapping("/list")
    protected String displayJuridictionList(Model model) {
        logger.debug("entering {}", "displayJuridictionList");
        List<JuridictionDTO> juridictions = juridictionService.findAll();
        model.addAttribute("juridictions", juridictions);
        return "juridiction/list";
    }
    
    @GetMapping("/create")
    public String juridictionForm(Model model) {
        logger.debug("entering {}","juridictionForm");
        model.addAttribute("juridictionForm", new CreateJuridictionForm());
        return "juridiction/createForm";
    }
    
    @PostMapping("/create")
    public ModelAndView createJuridictionProcessV1(
             @ModelAttribute("juridictionForm") CreateJuridictionForm juridictionForm,
            BindingResult bindingResult, RedirectAttributes redirectAttributes) {

    	logger.debug("entering {}","createJuridictionProcess");
        if (bindingResult.hasErrors()) {
            ModelAndView result = new ModelAndView("juridiction/createForm");
            return result;
        } else {

                try {
                	juridictionService.save(juridictionForm.toDTO());
                   
                    redirectAttributes.addFlashAttribute("successMessage",  "Juridiction crée");
                    return new ModelAndView("redirect:/");
                } catch (Exception e) {
                    bindingResult.reject("juriction already exists");
                    return new ModelAndView("juridiction/createForm");                    
                }
        	
            }
        }
    

    
    
    @GetMapping("/update")
    public String displayForm(@RequestParam("id") Long id, Model model) {
    	logger.debug("entering {}","updateForm");

        Optional<JuridictionDTO> juridiction = juridictionService.findById(id);
        JuridictionDTO myJuridiction=juridiction.get();
     
        model.addAttribute("juridication", myJuridiction);
        model.addAttribute("updateForm", new UpdateJuridictionForm(myJuridiction));

        return  "juridiction/update";
    }
    
    @PostMapping("/update/{id}")
    public ModelAndView processForm(
    		@PathVariable("id") Long id,
             @ModelAttribute("updateForm") UpdateJuridictionForm updateForm,
            BindingResult bindingResult,
            Model model, RedirectAttributes redirectAttributes) {
    	logger.debug("entering {}","updateJuridictionProcess");
        if (bindingResult.hasErrors()) {
        	ModelAndView result = new ModelAndView("juridiction/update");
            return result;
        } else {
        	
                try {
                	juridictionService.update(updateForm.toDTO(id));
                	redirectAttributes.addFlashAttribute("successMessage",  "Juridiction modifié");
                	return new ModelAndView("redirect:/");
                                          
                    
                } catch ( Exception e) {
                    bindingResult.reject("Erreur lors de la modification");
                    return new ModelAndView("juridiction/update");                    
                }
            }
        }
    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") long id,Model model,RedirectAttributes redirectAttributes) {
    	

        juridictionDAO.deleteById(id);
        redirectAttributes.addFlashAttribute("successMessage",  "Juridiction supprimée");
        return "redirect:/";
    }


}

package com.adade.gestionaffairesjuridiques.ui;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.adade.gestionaffairesjuridiques.dao.AffaireDAO;
import com.adade.gestionaffairesjuridiques.dto.AffaireDTO;
import com.adade.gestionaffairesjuridiques.dto.AvocatDTO;
import com.adade.gestionaffairesjuridiques.dto.ClientDTO;
import com.adade.gestionaffairesjuridiques.dto.JuridictionDTO;
import com.adade.gestionaffairesjuridiques.dto.TypeAffaireDTO;
import com.adade.gestionaffairesjuridiques.service.AffaireService;
import com.adade.gestionaffairesjuridiques.service.AvocatService;
import com.adade.gestionaffairesjuridiques.service.ClientService;
import com.adade.gestionaffairesjuridiques.service.JuridictionService;
import com.adade.gestionaffairesjuridiques.service.TypeAffaireService;
import com.adade.gestionaffairesjuridiques.ui.forms.CreateAffaireForm;
import com.adade.gestionaffairesjuridiques.ui.forms.CreateAffaireForm1;

import jakarta.servlet.ServletException;

@Controller
@RequestMapping("/office/affaire")
public class AppAffaireController {

    @Autowired
    Logger logger;

    @Autowired
    AffaireService affaireService;
    
    @Autowired
    AvocatService avocatService;
    
    @Autowired
    JuridictionService juridictionService;
    
    @Autowired
    TypeAffaireService typeAffaireService;
    
    @Autowired
    ClientService clientService;
    
    
    @Autowired
    AffaireDAO affaireDAO;
    
    @GetMapping("/search")
    protected String showSearchForm() throws ServletException, IOException {
        logger.debug("entering {}", "showSearchForm");
        return "affaire/search";
    }
    
    @GetMapping("/view")
    protected ModelAndView displayCustomer(@RequestParam("nom") String nom,@RequestParam("prenom") String prenom) throws ServletException, IOException {
        logger.debug("entering {}", "displayCustomer");
        Optional<ClientDTO> optCustomer = clientService.findByNameAndFirstname(nom, prenom);
        if (optCustomer.isPresent()) {
            return new ModelAndView("affaire/view", "client", optCustomer.get());
        } else {
            return new ModelAndView("affaire/missingClient", "nom",  nom);
        }
    }
    
    @GetMapping("/viewaffaire")
    protected ModelAndView displayAffaire(@RequestParam("id") long id) throws ServletException, IOException {
        logger.debug("entering {}", "displayAffaire");
        Optional<AffaireDTO> optAffaire = affaireService.findById(id);
        if (optAffaire.isPresent()) {
            return new ModelAndView("affaire/viewAffaire", "affaire", optAffaire.get());
        } else {
            return new ModelAndView("affaire/missingAffaire", "id",  id);
        }
    }
    @GetMapping("/list")
    protected String displayAffaireList(Model model) {
        logger.debug("entering {}", "displayAffaireList");
        List<AffaireDTO> affaires = affaireService.findAll();
        model.addAttribute("affaires", affaires);
        return "affaire/list";
    }
    
    @GetMapping("/create")
    public String affaireForm(@RequestParam("id") Long id,Model model) {
        logger.debug("entering {}","affaireForm");
       
        List<String> statuts = Arrays.asList("Ouverture du dossier", "En cours","A facturer", "Cloturer");
        model.addAttribute("statuts", statuts);
        List<TypeAffaireDTO> typeAffaires = typeAffaireService.findAll();
        model.addAttribute("typeAffaires", typeAffaires);
        List<AvocatDTO> avocats = avocatService.findAll();
        model.addAttribute("avocats", avocats);
        List<JuridictionDTO> juridictions = juridictionService.findAll();
        model.addAttribute("juridictions", juridictions);
        Optional<ClientDTO> client=clientService.findById(id);
        ClientDTO myClient=client.get();
        model.addAttribute("client", myClient);
        model.addAttribute("affaireForm", new CreateAffaireForm());
        return "affaire/createForm";
    }
	
    @PostMapping("/create")
    public ModelAndView createAffaireProcessV1(
             @ModelAttribute("affaireForm") CreateAffaireForm affaireForm,
            BindingResult bindingResult, RedirectAttributes redirectAttributes) {

    	logger.debug("entering {}","createAffaireProcess");
        if (bindingResult.hasErrors()) {
            ModelAndView result = new ModelAndView("affaire/createForm");
            return result;
        } else {

                try {
                	affaireService.save(affaireForm.toDTO());
                   
                    redirectAttributes.addFlashAttribute("successMessage",  "Affaire crée");
                    return new ModelAndView("redirect:/");
                } catch (Exception e) {
                    bindingResult.reject("affaire already exists");
                    return new ModelAndView("affaire/createForm");                    
                }
        	
            }
        }
}

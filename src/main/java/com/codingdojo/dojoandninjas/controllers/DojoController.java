package com.codingdojo.dojoandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojoandninjas.models.Dojo;
import com.codingdojo.dojoandninjas.models.Ninja;
import com.codingdojo.dojoandninjas.services.DojoService;
import com.codingdojo.dojoandninjas.services.NinjaService;

@Controller
public class DojoController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojoController(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }
    
    @RequestMapping("/dojo")
    public String index(Model model) {
        List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        return "/dojo/index.jsp";
    }
    
    @RequestMapping("/dojo/{id}/ninjas")
    public String selectNinja(@PathVariable("id") Long id, Model model) {
    	Dojo dojo = dojoService.findDojo(id);
    	
    	List<Ninja> ninjas = dojo.getNinjas();
    	
    	model.addAttribute("ninjas",ninjas);
    	
    	model.addAttribute("dojo", dojo);
    	
    	return "/ninja/selectedninjas.jsp";
    }
    
    @RequestMapping("/dojo/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "/dojo/create.jsp";
    }
    
    @RequestMapping(value="/dojo", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "/dojo/create.jsp";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/dojo";
        }
    }

}

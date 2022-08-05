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
public class NinjaController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public NinjaController(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }
	
	@RequestMapping("/ninja")
    public String index(Model model) {
        List<Ninja> ninjas = ninjaService.allNinjas();
        model.addAttribute("ninjas", ninjas);
        return "/ninja/index.jsp";
    }

	@RequestMapping("/ninja/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
	    Ninja ninja = ninjaService.findNinja(id);
	    model.addAttribute("ninja", ninja);
	    return "/ninja/detail.jsp";
	}
	
	@RequestMapping("/ninja/new")
    public String create(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		
        return "/ninja/create.jsp";
    }
	
	@RequestMapping(value="/ninja", method=RequestMethod.POST)
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	List<Dojo> dojos = dojoService.allDojos();
    		model.addAttribute("dojos", dojos);
            return "/ninja/create.jsp";
        } else {
            ninjaService.createNinja(ninja);
            return "redirect:/ninja";
        }
    }
}
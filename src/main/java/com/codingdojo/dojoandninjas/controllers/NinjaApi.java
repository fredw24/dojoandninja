package com.codingdojo.dojoandninjas.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.dojoandninjas.models.Dojo;
import com.codingdojo.dojoandninjas.models.Ninja;
import com.codingdojo.dojoandninjas.services.DojoService;
import com.codingdojo.dojoandninjas.services.NinjaService;

@RestController
public class NinjaApi {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
    public NinjaApi(DojoService dojoService, NinjaService ninjaService){
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }
    @RequestMapping("/api/Ninjas")
    public List<Ninja> index() {
    	System.out.print("All Ninjas");
        return ninjaService.allNinjas();
    }
    
    @RequestMapping(value="/api/Ninjas", method=RequestMethod.POST)
    public Ninja create(@RequestParam(value="firstName") String firstName,@RequestParam(value="lastName") String lastName, @RequestParam(value="age") int age, @RequestParam(value="dojo") long dojoId) {
        System.out.print("Create Ninja!");
    	Dojo dojo = dojoService.findDojo(dojoId);
    	Ninja ninja = new Ninja(firstName, lastName, age, dojo);
        return ninjaService.createNinja(ninja);
    }
    
    @RequestMapping("/api/Ninjas/{id}")
    public Ninja show(@PathVariable("id") Long id) {
        Ninja ninja = ninjaService.findNinja(id);
        return ninja;
    }

}

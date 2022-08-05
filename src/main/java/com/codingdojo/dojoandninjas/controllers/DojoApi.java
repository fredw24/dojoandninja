package com.codingdojo.dojoandninjas.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.dojoandninjas.models.Dojo;
import com.codingdojo.dojoandninjas.services.DojoService;

@RestController
public class DojoApi {
	
	private final DojoService dojoService;
    public DojoApi(DojoService dojoService){
        this.dojoService = dojoService;
    }
    @RequestMapping("/api/Dojos")
    public List<Dojo> index() {
        return dojoService.allDojos();
    }
    
    @RequestMapping(value="/api/Dojos", method=RequestMethod.POST)
    public Dojo create(@RequestParam(value="name") String name) {
        Dojo Dojo = new Dojo(name);
        return dojoService.createDojo(Dojo);
    }
    
    @RequestMapping("/api/Dojos/{id}")
    public Dojo show(@PathVariable("id") Long id) {
        Dojo Dojo = dojoService.findDojo(id);
        return Dojo;
    }
}

package com.dineshonjava.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;






import com.dineshonjava.bean.PetBean;
import com.dineshonjava.model.Pet;
import com.dineshonjava.service.PetService;


/**
 * @author Arun kumar
 * @param <PetBean>
 *
 */
@SuppressWarnings("hiding")
@Controller
public class PetController<PetBean> {
	
	@Autowired
	private PetService petService;
	
	@RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("pet") Pet pet){    
		petService.save(pet);    
        return "redirect:/petsList"; 
	}
	@RequestMapping(value="/pets/{petid}")    
    public String edit(@PathVariable int petId, Model m){    
        Pet pe1t=petService.getPetId();    
        m.addAttribute("command",petService);  
        return "addPet";   
	}
}
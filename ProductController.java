package com.controller;
//import java.util.List;    

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;  

import com.dao.ProductDao;
import com.model.Product;
@EnableAsync
@Controller
public class ProductController {
	@Autowired
	private ProductDao dao;
	@RequestMapping("/productform")
	public String showform(Model model){
	model.addAttribute("command",new Product());
	return "productform";
	
	}
	@RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("product") Product product){  
        dao.save(product);  
        return "redirect:/viewproduct";
	}
	@RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("product") Product product){  
        dao.update(product);  
        return "redirect:/viewproduct";
	}
}

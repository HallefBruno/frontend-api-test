package com.fontend.api.test.controller;

import com.fontend.api.test.model.Person;
import com.fontend.api.test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping
	public ModelAndView pageIndex(Person person) {
		return new ModelAndView("persons");
	}
	
	@PostMapping
    public String save(@ModelAttribute("person") Person person) {
		personService.save(person);
        System.out.println("Saving employee: " + person.getName()+ " " + person.getAge());
        return "redirect:/";
    }
	
}

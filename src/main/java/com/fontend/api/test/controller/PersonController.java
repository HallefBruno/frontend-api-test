package com.fontend.api.test.controller;

import com.fontend.api.test.model.Person;
import com.fontend.api.test.service.Page;
import com.fontend.api.test.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/{pageNumber}/{pageSize}")
	public ResponseEntity<?> pagePerson(@PathVariable(name = "pageNumber") int pageNumber,
			@PathVariable(name = "pageSize") int pageSize) {
		personService.getPagePersons(pageNumber, pageSize);
		return ResponseEntity.ok().build();
	}
	
}

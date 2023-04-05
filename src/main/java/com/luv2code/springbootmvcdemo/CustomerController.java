package com.luv2code.springbootmvcdemo;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	private Logger myLogger = LoggerFactory.getLogger(CustomerController.class);
	
	// add an initbinder .. to convert trim input string
	// remove leading and trailing whitespaces, and trim string down to null if has only whitespace
	// resolve  issue for our validation
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		// defines a editor which will scan all strings present in form data
		// and will trim leading and trailing white spaces
		// true parameter tells Spring to trim string to null of it has only white spaces
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true); 
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		theModel.addAttribute("customer", new Customer()); // defining model attribute as "customer", which will be used by the form for data binding
		
		return "customer-form";
		
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			// @Valid annotation used, to tell Spring to perform validation rules on this Customer object
			// "customer" model attribute here is received from the form submission
			@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult theBindingResult) { //  Spring will store the result of validation in BindingResult object
		
		myLogger.info("Last name: | {} |", theCustomer.getLastName());
		
		myLogger.info("Binding result: {}", theBindingResult);
				
		myLogger.info("\n\n\n");
		
		System.out.println("\n\n\n");
		
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		} else { 
			return "customer-confirmation";
		}
	}

}

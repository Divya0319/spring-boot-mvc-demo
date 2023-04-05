package com.luv2code.springbootmvcdemo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private Environment env;
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// create a student object
		Student theStudent = new Student();
		
		// add student object to the model( as model attribute)
		theModel.addAttribute("student", theStudent);
		
		// add the country options to the model 
		theModel.addAttribute("theCountryOptions", env.getProperty("countries"));
		
		// add the operating systems to the model
		theModel.addAttribute("theOSOptions", env.getProperty("opSys"));
		
		return "student-form";
		
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		// log the input data
		System.out.println("theStudent: " + theStudent.getFirstName() 
					+ " " + theStudent.getLastName());
		
		return "student-confirmation";
	}

}

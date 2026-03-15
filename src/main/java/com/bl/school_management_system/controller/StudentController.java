package com.bl.school_management_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

	@GetMapping("/profile")
	public String studentProfile() {
		return "Student profile details";
	}

	@GetMapping("/marks")
	public String viewMarks() {
		return "Student marks";
	}

}

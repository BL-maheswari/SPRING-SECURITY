package com.bl.school_management_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@GetMapping("/classes")
	public String teacherClasses() {
		return "Teacher classes";
	}

	@PostMapping("/marks")
	public String addMarks() {
		return "Marks added";
	}

}

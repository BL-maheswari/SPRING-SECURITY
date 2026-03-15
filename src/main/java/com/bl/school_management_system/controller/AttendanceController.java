package com.bl.school_management_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance")

public class AttendanceController {

	@PostMapping("/mark")
	public String markAttendance() {
		return "Attendance marked";
	}

	@GetMapping("/report")
	public String attendanceReport() {
		return "Attendance report";
	}

}

package com.bl.SecurityDemoApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
	@GetMapping("/")
    public String home() {
        return "Welcome to Spring Security Practice!";
    }

    @GetMapping("/user")
    public String userPage() {
        return "Hello User!";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "Hello Admin!";
    }
}



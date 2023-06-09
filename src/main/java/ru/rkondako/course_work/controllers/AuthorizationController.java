package ru.rkondako.course_work.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.rkondako.course_work.dto.AuthorizationInfo;
import ru.rkondako.course_work.services.UserService;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AuthorizationController {
	private final UserService userService;

	@GetMapping("/register")
	public String register() {
		return "authorization/registration";
	}


	@PostMapping("/register")
	public String signUp(Map<String, Object> model, AuthorizationInfo authorizationInfo) {
		boolean result = userService.save(authorizationInfo);
		if (result) {
			return "redirect:/login";
		}
		String message = "username already exists!";
		model.put("message", message);
		return "authorization/registration";
	}
}

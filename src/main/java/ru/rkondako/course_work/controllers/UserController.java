package ru.rkondako.course_work.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rkondako.course_work.dto.AccessRights;
import ru.rkondako.course_work.dto.AuthorizationInfo;
import ru.rkondako.course_work.entities.User;
import ru.rkondako.course_work.entities.additional_user_info.Role;
import ru.rkondako.course_work.services.UserService;
import ru.rkondako.course_work.view_models.UserViewModel;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
	private final UserService userService;

	@GetMapping("/all")
	public String mainPage(Map<String, Object> model) {
		List<UserViewModel> users = userService.findAll();
		model.put("roles", Role.values());
		model.put("users", users);
		return "admin/user_page";
	}

	@PostMapping("/add")
	public String save(AuthorizationInfo authorizationInfo, AccessRights accessRights) {
		userService.save(authorizationInfo, accessRights);
		return "redirect:/user/all";
	}

	@PostMapping("/deleteByUsername")
	public String deleteByUsername(@RequestParam(required = false) String username, @AuthenticationPrincipal User user) {
		userService.deleteByUsername(username, user);
		return "redirect:/user/all";
	}

	@PostMapping("/deleteById")
	public String deleteById(@RequestParam(required = false) Long id, @AuthenticationPrincipal User user) {
		userService.deleteById(id, user);
		return "redirect:/user/all";
	}

	@GetMapping("/filterByUsername")
	public String filterByUsername(@RequestParam(required = false) String username, Map<String, Object> model) {
		UserViewModel user = userService.findByUsername(username);
		if (user == null)
			return "redirect:/user/all";
		model.put("roles", Role.values());
		model.put("users", Collections.singleton(user));
		return "admin/user_page";
	}

	@GetMapping("/filterById")
	public String filterById(@RequestParam(required = false) Long id, Map<String, Object> model) {
		UserViewModel user = userService.findById(id);
		if (user == null)
			return "redirect:/user/all";
		model.put("roles", Role.values());
		model.put("users", Collections.singleton(user));
		return "admin/user_page";
	}
}

package ru.rkondako.course_work.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rkondako.course_work.dto.PersonInfo;
import ru.rkondako.course_work.entities.User;
import ru.rkondako.course_work.services.UserService;
import ru.rkondako.course_work.view_models.UserViewModel;

import java.util.Map;


@Controller
@RequestMapping(value = "/client")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('USER')")
public class  ProfileController {
    private final UserService userService;
    @GetMapping("/profile")
    public String mainPage(@AuthenticationPrincipal User user, Map<String, Object> model) {
        UserViewModel userViewModel = userService.mapToViewModel(user);
        model.put("user", userViewModel);
        return "user/profile";
    }

    @PostMapping("/add")
    public String add(@AuthenticationPrincipal User user, PersonInfo personInfo) {
        userService.save(user, personInfo);
        return "redirect:/client/profile";
    }
}

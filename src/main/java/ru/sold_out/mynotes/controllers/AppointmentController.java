package ru.sold_out.mynotes.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sold_out.mynotes.dto.AppointmentInfo;
import ru.sold_out.mynotes.entities.User;
import ru.sold_out.mynotes.services.AppointmentService;
import ru.sold_out.mynotes.view_models.AppointmentViewModel;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/appointment")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('USER')")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/all")
    public String mainPage(@AuthenticationPrincipal User user, Map<String, Object> model) {
        List<AppointmentViewModel> appointments = appointmentService.findAllByUser(user);
        model.put("appointments", appointments);
        return "user/appointment";
    }

    @PostMapping("/add")
    public String save(@AuthenticationPrincipal User user, AppointmentInfo appointmentInfo) {
        appointmentService.save(user, appointmentInfo);
        return "redirect:/appointment/all";
    }

    @PostMapping("/deleteById")
    public String deleteById(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false) Long id
    ) {
        appointmentService.deleteById(id, user);
        return "redirect:/appointment/all";
    }
}

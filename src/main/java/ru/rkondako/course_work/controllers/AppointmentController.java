package ru.rkondako.course_work.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.rkondako.course_work.dto.AppointmentInfo;
import ru.rkondako.course_work.entities.User;
import ru.rkondako.course_work.services.AppointmentService;
import ru.rkondako.course_work.view_models.AppointmentViewModel;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/appointment")
@RequiredArgsConstructor
//Делает все нужные конструкторы
        //тока зачем они нужны...
@PreAuthorize("hasAuthority('USER')")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/all")
    public String mainPage(@AuthenticationPrincipal User user, Map<String, Object> model) {
        List<AppointmentViewModel> appointments = appointmentService.findAllByUser(user);
        String name = "Surgery";
        LocalDate date = LocalDate.now();
        List<String> freeTimes = appointmentService.selectDate(name, date);
        model.put("appointments", appointments);
        model.put("minDate", LocalDate.now());
        model.put("maxDate", LocalDate.now().plusDays(5));
        model.put("freeTimes", new ArrayList<String>());
        model.put("name", name);
        model.put("date", date.toString());
        return "user/appointment";
    }

    @GetMapping("/all/{name}/{date}")
    public String mainPageWithTime(@AuthenticationPrincipal User user,
                                   Map<String, Object> model,
                                   @PathVariable String name,
                                   @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date
    ) {
        List<AppointmentViewModel> appointments = appointmentService.findAllByUser(user);
        List<String> freeTimes = appointmentService.selectDate(name, date);
        model.put("appointments", appointments);
        model.put("minDate", LocalDate.now());
        model.put("maxDate", LocalDate.now().plusDays(5));
        model.put("freeTimes", freeTimes);
        model.put("name", name);
        model.put("date", date.toString());
        System.out.println(freeTimes);
        return "user/appointment";
    }

    @PostMapping("/all/{name}/{date}")
    public String selectTime(@AuthenticationPrincipal User user,
                             String time,
                             @PathVariable String name,
                             @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        System.out.println(time);
        appointmentService.save(user, name, date, time);
        return "redirect:/appointment/all/" + name + "/" + date.toString();
    }

    @PostMapping("/selectDate")
    public String selectDate(AppointmentInfo appointmentInfo) {
        if (appointmentInfo.getDate() == null || appointmentInfo.getHealthServiceName() == null) {
            return "redirect:/appointment/all/";
        }
        LocalDate localDate = appointmentInfo.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return "redirect:/appointment/all/" + appointmentInfo.getHealthServiceName() + "/" + localDate.toString();
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

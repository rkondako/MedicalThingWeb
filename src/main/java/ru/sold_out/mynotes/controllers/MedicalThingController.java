package ru.sold_out.mynotes.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sold_out.mynotes.dto.MedicalThingInfo;
import ru.sold_out.mynotes.services.MedicalThingService;
import ru.sold_out.mynotes.view_models.MedicalThingViewModel;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/healthServices")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('USER')")
public class MedicalThingController {
	private final MedicalThingService medicalThingService;

	@GetMapping("/all")
	public String mainPage(Map<String, Object> model) {
		List<MedicalThingViewModel> medicalThings = medicalThingService.findAll();
		model.put("medicalThings", medicalThings);
		return "pages/healthServices";
	}

	@Secured("ADMIN")
	@PostMapping("/add")
	public String save(MedicalThingInfo medicalThingInfo) {
		System.out.println(medicalThingInfo);
		medicalThingService.save(medicalThingInfo);
		return "redirect:/healthServices/all";
	}

	@Secured("ADMIN")
	@PostMapping("/deleteByName")
	public String deleteByName(@RequestParam(required = false) String name) {
		medicalThingService.deleteByName(name);
		return "redirect:/healthServices/all";
	}
}

package ru.rkondako.course_work.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rkondako.course_work.dto.MedicalThingInfo;
import ru.rkondako.course_work.entities.MedicalThing;
import ru.rkondako.course_work.mappingUtils.MedicalThingMappingUtil;
import ru.rkondako.course_work.repos.MedicalThingRepo;
import ru.rkondako.course_work.view_models.MedicalThingViewModel;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalThingService {
	private final MedicalThingRepo medicalThingRepo;

	public List<MedicalThingViewModel> findAll() {
		return medicalThingRepo.findAll()
				.stream()
				.map(MedicalThingMappingUtil::mapToViewModel)
				.toList();
	}

	public boolean save(MedicalThingInfo medicalThingInfo) {
		MedicalThing medicalThingByName = medicalThingRepo.findByName(medicalThingInfo.getName());
		if (medicalThingInfo.getName().isBlank() || medicalThingByName != null) {
			return false;
		}
		MedicalThing medicalThing = MedicalThingMappingUtil.mapToEntity(medicalThingInfo);
		medicalThingRepo.save(medicalThing);
		return true;
	}

	public void deleteByName(String name) {
		MedicalThing medicalThingByName = medicalThingRepo.findByName(name);
		if (medicalThingByName == null)
			return;
		medicalThingRepo.delete(medicalThingByName);
	}
}

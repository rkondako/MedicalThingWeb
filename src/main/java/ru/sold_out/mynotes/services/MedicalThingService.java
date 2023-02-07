package ru.sold_out.mynotes.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sold_out.mynotes.dto.MedicalThingInfo;
import ru.sold_out.mynotes.entities.MedicalThing;
import ru.sold_out.mynotes.mappingUtils.MedicalThingUtil;
import ru.sold_out.mynotes.repos.MedicalThingRepo;
import ru.sold_out.mynotes.view_models.MedicalThingViewModel;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalThingService {
	private final MedicalThingRepo medicalThingRepo;

	public List<MedicalThingViewModel> findAll() {
		return medicalThingRepo.findAll()
				.stream()
				.map(MedicalThingUtil::mapToViewModel)
				.toList();
	}

	public boolean save(MedicalThingInfo medicalThingInfo) {
		MedicalThing medicalThingByName = medicalThingRepo.findByName(medicalThingInfo.getName());
		if (medicalThingInfo.getName().isBlank() || medicalThingByName != null) {
			return false;
		}
		MedicalThing medicalThing = MedicalThingUtil.mapToEntity(medicalThingInfo);
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

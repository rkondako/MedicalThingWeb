package ru.rkondako.course_work.mappingUtils;

import ru.rkondako.course_work.dto.MedicalThingInfo;
import ru.rkondako.course_work.entities.MedicalThing;
import ru.rkondako.course_work.view_models.MedicalThingViewModel;

public class MedicalThingMappingUtil {
	public static MedicalThing mapToEntity(MedicalThingInfo medicalThingInfo) {
		MedicalThing medicalThing = new MedicalThing();
		medicalThing.setName(medicalThingInfo.getName());
		medicalThing.setConsultationPrice(medicalThingInfo.getConsultationPrice());
		medicalThing.setTreatmentPrice(medicalThingInfo.getTreatmentPrice());
		return medicalThing;
	}

	public static MedicalThingViewModel mapToViewModel(MedicalThing medicalThing) {
		MedicalThingViewModel medicalThingViewModel = new MedicalThingViewModel();
		medicalThingViewModel.setName(medicalThing.getName());
		medicalThingViewModel.setConsultationPrice(medicalThing.getConsultationPrice());
		medicalThingViewModel.setTreatmentPrice(medicalThing.getTreatmentPrice());
		return medicalThingViewModel;
	}
}

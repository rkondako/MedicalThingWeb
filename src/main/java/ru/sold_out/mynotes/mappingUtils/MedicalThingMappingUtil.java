package ru.sold_out.mynotes.mappingUtils;

import ru.sold_out.mynotes.dto.MedicalThingInfo;
import ru.sold_out.mynotes.entities.MedicalThing;
import ru.sold_out.mynotes.view_models.MedicalThingViewModel;

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

package ru.sold_out.mynotes.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sold_out.mynotes.dto.AppointmentInfo;
import ru.sold_out.mynotes.entities.Appointment;
import ru.sold_out.mynotes.entities.MedicalThing;
import ru.sold_out.mynotes.entities.User;
import ru.sold_out.mynotes.mappingUtils.AppointmentMappingUtil;
import ru.sold_out.mynotes.repos.AppointmentRepo;
import ru.sold_out.mynotes.repos.MedicalThingRepo;
import ru.sold_out.mynotes.view_models.AppointmentViewModel;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepo appointmentRepo;
    private final MedicalThingRepo medicalThingRepo;

    public List<AppointmentViewModel> findAllByUser(User user) {
        return appointmentRepo.findByUser(user)
                .stream()
                .map(AppointmentMappingUtil::mapToViewModel)
                .toList();
    }


    public boolean save(User user, AppointmentInfo appointmentInfo) {
        if (appointmentInfo.getHealthServiceName().isBlank() ||
                appointmentInfo.getDate() == null ||
                user.getPerson() == null) {
            return false;
        }
        MedicalThing medicalThing = medicalThingRepo.findByName(appointmentInfo.getHealthServiceName());
        if (medicalThing == null) {
            return false;
        }
        Appointment appointment = AppointmentMappingUtil.mapToEntity(appointmentInfo, user, medicalThing);
        appointmentRepo.save(appointment);
        return true;
    }

    public void deleteById(Long id, User user) {
        Appointment appointment = appointmentRepo.findByIdAndUser(id, user);
        if (appointment == null)
            return;
        appointmentRepo.deleteById(id);
    }
}

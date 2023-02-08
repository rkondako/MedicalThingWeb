package ru.rkondako.course_work.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rkondako.course_work.dto.AppointmentInfo;
import ru.rkondako.course_work.entities.Appointment;
import ru.rkondako.course_work.entities.MedicalThing;
import ru.rkondako.course_work.entities.User;
import ru.rkondako.course_work.mappingUtils.AppointmentMappingUtil;
import ru.rkondako.course_work.repos.AppointmentRepo;
import ru.rkondako.course_work.repos.MedicalThingRepo;
import ru.rkondako.course_work.view_models.AppointmentViewModel;

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

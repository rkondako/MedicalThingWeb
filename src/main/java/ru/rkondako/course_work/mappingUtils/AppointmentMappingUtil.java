package ru.rkondako.course_work.mappingUtils;

import ru.rkondako.course_work.dto.AppointmentInfo;
import ru.rkondako.course_work.entities.Appointment;
import ru.rkondako.course_work.entities.MedicalThing;
import ru.rkondako.course_work.entities.User;
import ru.rkondako.course_work.view_models.AppointmentViewModel;

public class AppointmentMappingUtil {
    public static Appointment mapToEntity(AppointmentInfo appointmentInfo, User user, MedicalThing medicalThing) {
        Appointment appointment = new Appointment();
        appointment.setMedicalThing(medicalThing);
        appointment.setUser(user);
        appointment.setDate(appointmentInfo.getDate());
        return appointment;
    }
    public static AppointmentViewModel mapToViewModel(Appointment appointment) {
        AppointmentViewModel appointmentViewModel = new AppointmentViewModel();
        appointmentViewModel.setName(appointment.getUser().getPerson().getName());
        appointmentViewModel.setSurname(appointment.getUser().getPerson().getSurname());
        appointmentViewModel.setMiddleName(appointment.getUser().getPerson().getMiddleName());
        appointmentViewModel.setLogin(appointment.getUser().getUsername());
        appointmentViewModel.setDate(appointment.getDate());
        appointmentViewModel.setMedicalThingName(appointment.getMedicalThing().getName());
        appointmentViewModel.setId(appointment.getId());
        return appointmentViewModel;
    }


}

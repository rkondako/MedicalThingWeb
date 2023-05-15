package ru.rkondako.course_work.mappingUtils;

import ru.rkondako.course_work.entities.Appointment;
import ru.rkondako.course_work.entities.MedicalThing;
import ru.rkondako.course_work.entities.User;
import ru.rkondako.course_work.view_models.AppointmentViewModel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class AppointmentMappingUtil {
    public static Appointment mapToEntity(LocalDate date, String time, User user, MedicalThing medicalThing) {
        Appointment appointment = new Appointment();
        appointment.setMedicalThing(medicalThing);
        appointment.setUser(user);
        appointment.setDate(Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        appointment.setTime(LocalTime.parse(time));
        return appointment;
    }
    public static AppointmentViewModel mapToViewModel(Appointment appointment) {
        AppointmentViewModel appointmentViewModel = new AppointmentViewModel();
        appointmentViewModel.setName(appointment.getUser().getPerson().getName());
        appointmentViewModel.setSurname(appointment.getUser().getPerson().getSurname());
        appointmentViewModel.setMiddleName(appointment.getUser().getPerson().getMiddleName());
        appointmentViewModel.setLogin(appointment.getUser().getUsername());
        appointmentViewModel.setDate(appointment.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString());
        appointmentViewModel.setTime(appointment.getTime().toString());
        appointmentViewModel.setMedicalThingName(appointment.getMedicalThing().getName());
        appointmentViewModel.setId(appointment.getId());
        return appointmentViewModel;
    }


}

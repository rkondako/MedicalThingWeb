package ru.rkondako.course_work.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rkondako.course_work.entities.Appointment;
import ru.rkondako.course_work.entities.MedicalThing;
import ru.rkondako.course_work.entities.User;
import ru.rkondako.course_work.mappingUtils.AppointmentMappingUtil;
import ru.rkondako.course_work.repos.AppointmentRepo;
import ru.rkondako.course_work.repos.MedicalThingRepo;
import ru.rkondako.course_work.view_models.AppointmentViewModel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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


	public boolean save(User user, String name, LocalDate date, String time) {
		if (name.isBlank() ||
				date == null ||
				date.isBefore(LocalDate.now()) ||
				date.isAfter(LocalDate.now().plusDays(5)) ||
				time == null ||
				user == null) {
			return false;
		}
		MedicalThing medicalThing = medicalThingRepo.findByName(name);
		if (medicalThing == null) {
			return false;
		}
		Appointment appointment = AppointmentMappingUtil.mapToEntity(date, time, user, medicalThing);
		appointmentRepo.save(appointment);
		return true;
	}

	public List<String> selectDate(String serviceName, LocalDate date) {
		if (serviceName.isBlank() ||
				(date == null) ||
				date.isBefore(LocalDate.now()) ||
		        date.isAfter(LocalDate.now().plusDays(5)))
		{
			return new ArrayList<>();
		}
		MedicalThing medicalThing = medicalThingRepo.findByName(serviceName);
		if (medicalThing == null) {
			return new ArrayList<>();
		}
		List<Appointment> appointments = appointmentRepo.findByMedicalThingAndDate(medicalThing, Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		List<LocalTime> times = appointments.stream().map(Appointment::getTime).toList();
		LocalTime tmp = LocalTime.parse("09:00");
		List<LocalTime> freeTimes = new ArrayList<>();
		for (int i = 0; i < 13; i++) {
			if (times.contains(tmp)) {
				tmp = tmp.plusHours(1);
				continue;
			}
			freeTimes.add(tmp);
			tmp = tmp.plusHours(1);
		}
		return freeTimes.stream().map(LocalTime::toString).toList();
	}

	public void deleteById(Long id, User user) {
		Appointment appointment = appointmentRepo.findByIdAndUser(id, user);
		if (appointment == null)
			return;
		appointmentRepo.deleteById(id);
	}
}

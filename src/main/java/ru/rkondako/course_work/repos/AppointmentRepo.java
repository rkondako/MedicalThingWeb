package ru.rkondako.course_work.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rkondako.course_work.entities.Appointment;
import ru.rkondako.course_work.entities.User;

import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    List<Appointment> findByUser(User user);
    Appointment findByIdAndUser(Long id, User user);


}

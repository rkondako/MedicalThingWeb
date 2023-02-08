package ru.sold_out.mynotes.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sold_out.mynotes.entities.Appointment;
import ru.sold_out.mynotes.entities.User;

import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    List<Appointment> findByUser(User user);
    Appointment findByIdAndUser(Long id, User user);
}

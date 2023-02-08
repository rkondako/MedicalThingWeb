package ru.rkondako.course_work.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rkondako.course_work.entities.Person;

public interface PersonRepo extends JpaRepository<Person, Long> {
}

package ru.sold_out.mynotes.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sold_out.mynotes.entities.Person;

public interface PersonRepo extends JpaRepository<Person, Long> {
}

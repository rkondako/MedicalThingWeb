package ru.rkondako.course_work.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rkondako.course_work.entities.MedicalThing;

@Repository
public interface MedicalThingRepo extends JpaRepository<MedicalThing, Long> {
	MedicalThing findByName(String name);
}

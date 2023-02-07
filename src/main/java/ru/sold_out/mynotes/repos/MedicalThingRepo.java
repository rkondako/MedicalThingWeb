package ru.sold_out.mynotes.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sold_out.mynotes.entities.MedicalThing;

@Repository
public interface MedicalThingRepo extends JpaRepository<MedicalThing, Long> {
	MedicalThing findByName(String name);
}

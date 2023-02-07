package ru.sold_out.mynotes.mappingUtils;

import ru.sold_out.mynotes.dto.PersonInfo;
import ru.sold_out.mynotes.entities.Person;

public class PersonMappingUtil {
    public static Person mapToEntity(PersonInfo personInfo) {
        Person person = new Person();
        person.setName(personInfo.getName());
        person.setSurname(personInfo.getSurname());
        person.setMiddleName(personInfo.getMiddleName());
        return person;
    }
}

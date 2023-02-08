package ru.rkondako.course_work.mappingUtils;

import ru.rkondako.course_work.dto.PersonInfo;
import ru.rkondako.course_work.entities.Person;

public class PersonMappingUtil {
    public static Person mapToEntity(PersonInfo personInfo) {
        Person person = new Person();
        person.setName(personInfo.getName());
        person.setSurname(personInfo.getSurname());
        person.setMiddleName(personInfo.getMiddleName());
        return person;
    }
}

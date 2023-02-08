package ru.rkondako.course_work.view_models;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class AppointmentViewModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 15L;

    private Long id;
    private LocalDate date;
    private String medicalThingName;
    private String login;
    private String name;
    private  String surname;
    private  String middleName;


}

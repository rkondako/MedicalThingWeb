package ru.rkondako.course_work.view_models;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
        //@data делает для каждого из полей getter и setter
public class AppointmentViewModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 15L;

    private Long id;
    private String date;
    private String time;
    private String medicalThingName;
    private String login;
    private String name;
    private String surname;
    private String middleName;


}

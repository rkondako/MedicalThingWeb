package ru.rkondako.course_work.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class AppointmentInfo  implements Serializable {
    @Serial
    private static final long serialVersionUID = 14L;

    private String  healthServiceName;
    private @DateTimeFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss ") Date date;

}

package ru.rkondako.course_work.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class MedicalThingInfo implements Serializable {
	@Serial
	private static final long serialVersionUID = 101L;

	private String name;
	private Integer consultationPrice;
	private Integer treatmentPrice;
}

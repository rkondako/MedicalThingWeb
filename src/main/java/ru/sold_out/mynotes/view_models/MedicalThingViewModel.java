package ru.sold_out.mynotes.view_models;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class MedicalThingViewModel implements Serializable {
	@Serial
	private static final long serialVersionUID = 102L;

	private String name;
	private Integer consultationPrice;
	private Integer treatmentPrice;
}

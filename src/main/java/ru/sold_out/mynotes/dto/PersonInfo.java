package ru.sold_out.mynotes.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class PersonInfo implements Serializable {
	@Serial
	private static final long serialVersionUID = 105L;

	private String name;
	private String surname;
	private String middleName;
}

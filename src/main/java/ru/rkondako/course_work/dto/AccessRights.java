package ru.rkondako.course_work.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class AccessRights implements Serializable {
	@Serial
	private static final long serialVersionUID = 6L;

	boolean USER;
	boolean ADMIN;
}

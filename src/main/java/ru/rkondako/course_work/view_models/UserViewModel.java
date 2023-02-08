package ru.rkondako.course_work.view_models;

import lombok.Data;
import ru.rkondako.course_work.entities.additional_user_info.Role;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Data
public class UserViewModel implements Serializable {
	@Serial
	private static final long serialVersionUID = 5L;

	private Long id;
	private String username;
	private String password;
	private boolean active;
	private Set<Role> roles;
	private String name;
	private String surname;
	private String middleName;
}

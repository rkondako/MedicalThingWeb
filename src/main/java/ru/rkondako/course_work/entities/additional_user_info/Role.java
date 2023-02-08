package ru.rkondako.course_work.entities.additional_user_info;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
	USER,
	ADMIN;

	@Override
	public String getAuthority() {
		return name();
	}
}

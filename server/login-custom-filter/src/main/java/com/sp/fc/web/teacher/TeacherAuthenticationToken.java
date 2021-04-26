package com.sp.fc.web.teacher;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherAuthenticationToken implements Authentication{

	private Teacher principal;
	private String credentials;
	private String details;
	private boolean authenticated;
	
	@Override
	public String getName() {
		return principal == null ? "" : principal.getUsername();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return principal == null ? new HashSet<>() : principal.getRole();
	}
	
	
	
}

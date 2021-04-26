package com.sp.fc.web.teacher;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
	private String id;
	private String username;
	private Set<GrantedAuthority> role;
}

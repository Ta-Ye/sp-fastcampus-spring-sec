package com.sp.fc.web.student;

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
public class Student {
	
	private String id;
	private String username;
	private Set<GrantedAuthority> role;
	
}

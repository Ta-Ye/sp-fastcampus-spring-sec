package com.sp.fc.web.teacher;

import java.util.HashMap;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class TeacherManager implements AuthenticationProvider, InitializingBean{

	private HashMap<String, Teacher> teacherDB = new HashMap<>();
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		TeacherAuthenticationToken token = (TeacherAuthenticationToken) authentication;
		if(teacherDB.containsKey(token.getCredentials())) {
			Teacher Teacher = teacherDB.get(token.getCredentials());
			return TeacherAuthenticationToken.builder()
					.principal(Teacher)
					.details(Teacher.getUsername())
					.authenticated(true)
					.build();
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication == TeacherAuthenticationToken.class;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Set.of(
				new Teacher("choi", "�ּ���", Set.of(new SimpleGrantedAuthority("ROLE_TEACHER")))
		).forEach(s->
			teacherDB.put(s.getId(), s)
		);
	}
	
}
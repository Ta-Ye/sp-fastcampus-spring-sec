package com.sp.fc.web.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sp.fc.web.student.StudentAuthenticationToken;
import com.sp.fc.web.teacher.TeacherAuthenticationToken;

public class CustomLoginFilter extends UsernamePasswordAuthenticationFilter{
	
	public CustomLoginFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String username = obtainUsername(request);
		username = (username != null) ? username : "";
		username = username.trim();
		String password = obtainPassword(request);
		password = (password != null) ? password : "";
		
		String type = request.getParameter("type");
		if(type == null || !type.equals("teacher")) {
			return this.getAuthenticationManager().authenticate(
						StudentAuthenticationToken.builder()
												.credentials(username)
												.build()
					);
		}
		return this.getAuthenticationManager().authenticate(
					TeacherAuthenticationToken.builder()
											.credentials(username)
											.build()
				);
	}

}

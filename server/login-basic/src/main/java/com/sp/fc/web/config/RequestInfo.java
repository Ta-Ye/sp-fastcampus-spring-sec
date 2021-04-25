package com.sp.fc.web.config;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestInfo {
	
	private String remoteIp;
	private String sessionId;
	private LocalDateTime loginTime;
}

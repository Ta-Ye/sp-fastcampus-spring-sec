package com.sp.fc.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Base64;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.fc.web.student.Student;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MultiChainProxyTest {

	@LocalServerPort
	int port;

	TestRestTemplate testClient = new TestRestTemplate("choi", "1");

	@DisplayName("1. 학생 조사")
	@Test
	void test_1() throws JsonProcessingException {
		
		System.out.println(testClient.exchange("http://localhost:"+port+"/api/teacher/students",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {
				}).getBody());
	}

}

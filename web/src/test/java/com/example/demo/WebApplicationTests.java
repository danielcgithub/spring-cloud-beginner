package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;

import com.example.demo.NameService.NameFeignClient;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {
		"spring.cloud.config.enabled:false" })
public class WebApplicationTests {

	@Autowired
	TestRestTemplate rest;

	@MockBean
	RestTemplate restTemplate;

	@MockBean
	NameFeignClient nameFeignClient;

	@Before
	public void setup() {
		doReturn("Ryan").when(nameFeignClient).getName();
		doReturn("Hello").when(restTemplate).getForObject(eq("http://greeting/en"), eq(String.class));
	}

	@Test
	public void contextLoads() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept-Language", "en");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> greeting = rest.exchange("/", HttpMethod.GET, entity, String.class);
		assertEquals("Hello Ryan", greeting.getBody());
	}
}

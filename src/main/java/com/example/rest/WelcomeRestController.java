package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.config.ConfigTemp;
import com.example.feign.GreetFeignClient;

@RestController
public class WelcomeRestController {
	
	//@Autowired
	//private GreetFeignClient client;
	
	@Autowired
	private ConfigTemp configTemp;

	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		
		//String greetApi = client.invokeGreetApi();
		//return greetApi+" welcome !!";
		
		RestTemplate restTemplate = configTemp.getRestTemplate();
		
		ResponseEntity<String> forEntity = restTemplate.getForEntity("http://GREET-API/greet", String.class);
		
		String greetApi = forEntity.getBody();
		
		return greetApi+" welcome !!";
	}
}

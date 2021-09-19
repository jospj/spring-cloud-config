package com.example.springcloud.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class WelcomeController {
	
	@Value("${welcome.client.user}")
	String user;
	
	@Value("${welcome.client.password}")
	String password;

	@GetMapping("/hello/{name}")
	public String home(@PathVariable String name) {
		return "Welcome "+name+ " ,Please use "+user +"/"+password +" to access your account!";
	}
}

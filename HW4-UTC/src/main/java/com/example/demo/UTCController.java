package com.example.demo;

import java.time.Instant;
import java.lang.String;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UTCController {

	//http://localhost:8080/UTC
	@GetMapping("/UTC")
		public String UtcGet() {
		String utcIn = Instant.now().toString();
		System.out.printf("/s/n", "UTC: " );
		return utcIn;
		}
	
}
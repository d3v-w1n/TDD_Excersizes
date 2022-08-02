package com.example.demo;

import java.lang.String;
import java.time.ZoneId;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hw4UtcApplication {
	
	
	
	public static void main(String[] args) {
		
		Set<String> zone = ZoneId.getAvailableZoneIds();
		Stream.of(zone).forEach((Zid)-> System.out.println(Zid));
		
		SpringApplication.run(Hw4UtcApplication.class, args);
	}
}


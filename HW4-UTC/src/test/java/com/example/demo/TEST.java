package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.ZoneId;
import java.time.Instant;
import java.util.Set;
import java.util.Random;
import java.util.ArrayList;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

	

class TEST {

	@Autowired
	Timezone testOutput;
	Random rand = new Random();
	Set<String> testZone = ZoneId.getAvailableZoneIds();
	String[] testArray = testZone.toString().split(", ");
	//for(zone : Set<String> ZoneId.getAvailableZoneIds() = testArray);
	
	//set equal to random sequence of ints from testArray.length() 
	int maxArray = testArray.length;
	int ranZone = rand.nextInt(maxArray);
	
	@Test
	void testExists() {
		assert(testOutput.getUtcOutput() !=null); 
}

	@Test
	void testMatches() {
		assert(testOutput.getUtcOutput().equals(Instant.now())); 
	}	
	
	@Test
	void testMultiple() {
		
		assert(testOutput.getUtcOutput().contains(testArray[ranZone])); 
	}	
	
}	
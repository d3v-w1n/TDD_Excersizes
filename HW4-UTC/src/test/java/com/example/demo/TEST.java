package com.example.demo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@SuppressWarnings({ "unlikely-arg-type"})
@ContextConfiguration(classes = {TimezoneController.class })
@WebAppConfiguration

class TEST {

	@Autowired
	
	Random rand = new Random();
	/*Set<String> testZone = ZoneId.getAvailableZoneIds();
	String[] testArray = testZone.toString().split(", ");
	//for(zone : Set<String> ZoneId.getAvailableZoneIds() = testArray);
	//set equal to random sequence of ints from testArray.length()
	int maxArray = testArray.length;
	int ranZone = rand.nextInt(maxArray);
	Timezone testOutput = new Timezone(testArray[ranZone]);
	*/
	int zoneNum = rand.nextInt(14);
	String testZone = "+" + zoneNum;
	String testGMT = "-4";
	Timezone testOutput = new Timezone(testZone);
	UTCController testUtc = new UTCController();
	
	@Test
	void testExists() {
		assert(testOutput.getUtcOutput() !=null);
	 }

	
	@Test
	void testMatches() {
		assert(ZonedDateTime.now().getOffset().equals(ZoneOffset.of(testGMT)));
	}

	@Test
	void testMultiple() {

		assert(testOutput.getUtcOutput().contains(ZoneOffset.of(testZone).toString()));
	}

}
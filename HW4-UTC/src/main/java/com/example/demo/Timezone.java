package com.example.demo;

import java.lang.String;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Component;

@Component
public class Timezone {

	
	public String utcOutput;
	
	public Timezone(String testcase) {
			//temporal import or LocalTime method call 
		getUtcOutput(testcase);
	}

	public ZonedDateTime getZoneDateTime() {
		ZonedDateTime time =  ZonedDateTime.now(ZoneId.of(utcOutput));
		return time;
	}
	
	public String getUtcOutput() {
		utcOutput = this.utcOutput;
		return utcOutput;
	}
	
	public String getUtcOutput(String userTZ) {
		// 'UTC' 'GMT' or 'UT'
		utcOutput = ZoneOffset.of(userTZ).toString();
		return utcOutput;
	}

	public void setUtcOutput(String utcOutput) {
		this.utcOutput = utcOutput;
	}

}
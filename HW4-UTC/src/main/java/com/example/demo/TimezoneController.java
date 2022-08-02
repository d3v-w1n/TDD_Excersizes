package com.example.demo;

import java.time.ZonedDateTime;
import javax.management.AttributeNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimezoneController {
		
								
				//http://localhost:8080/timezone
				@PostMapping("/timezone")
				public ZonedDateTime getUtcOutput(@RequestBody Timezone tz) throws AttributeNotFoundException {
					
				return tz.getZoneDateTime();
				}
	}

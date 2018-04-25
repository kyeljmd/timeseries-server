package com.nxtgen.apm.timeseriesserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class TimeseriesServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeseriesServerApplication.class, args);
	}
}

package com.takeone.webapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@ComponentScan(basePackages = "com.takeone.webapp", excludeFilters = {
		@ComponentScan.Filter(Configuration.class),
		@ComponentScan.Filter(Controller.class) })
public class AppConfig {
}
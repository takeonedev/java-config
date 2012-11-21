package com.takeone.webapp.config;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class WebConfigTest  {
	
	@Inject
	private ApplicationContext applicationContext;
	
	@InjectMocks
	private WebConfig webConfig = new WebConfig();
	
	@Test
	public void testConfigureDefaultServletHandlingDefaultServletHandlerConfigurer() {
		DefaultServletHandlerConfigurer configurer = Mockito.mock(DefaultServletHandlerConfigurer.class);
		webConfig.configureDefaultServletHandling(configurer);
		
		verify(configurer).enable();
	}

	@Test
	public void testAddResourceHandlers() {
		ResourceHandlerRegistry registry = mock(ResourceHandlerRegistry.class);		
		ResourceHandlerRegistration resourceHandlerRegistration = mock(ResourceHandlerRegistration.class);
		
		when(registry.addResourceHandler("/resources/**")).thenReturn(resourceHandlerRegistration);
		
		webConfig.addResourceHandlers(registry);
		
		verify(registry).addResourceHandler("/resources/**");
		verify(resourceHandlerRegistration).addResourceLocations("/static");	
	}

	@Test
	public void testViewResolver() {
		assertThat(webConfig.viewResolver(), is(notNullValue()));
	}
}

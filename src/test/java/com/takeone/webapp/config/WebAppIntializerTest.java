package com.takeone.webapp.config;

import static org.junit.Assert.*;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.DispatcherServlet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WebAppIntializerTest {
	
	@InjectMocks
	private WebAppIntializer webAppIntializer = new WebAppIntializer();

	@Test
	public void testOnSrtartup() throws ServletException {
		ServletContext servletContext = mock(ServletContext.class);
		ServletRegistration.Dynamic dispatcher = mock(ServletRegistration.Dynamic.class);
		
		when(servletContext.addServlet(eq("dispatcher"), Matchers.any(Servlet.class))).thenReturn(dispatcher);
		
		webAppIntializer.onStartup(servletContext);
	}
}


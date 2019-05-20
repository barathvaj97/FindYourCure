package com.infy.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * This class implements WebApplicationInitializer interface of Spring framework to configure <b>web.xml<b> 
 * (an xml file which contains servlet configuration, url mapping, etc. details) programmatically.
 * 
 * @author ETA_JAVA
 *
 */
public class WebServletConfiguration implements WebApplicationInitializer
{

	/**
	 * The below attribute is to hold the dispatcher servlet's(which handles all the HTTP requests and responses, 
	 * it dispatches (sends) the request to the appropriate controller) 
	 * spring application context (servlet's app context to hold beans required for Spring MVC webapp). <br>
	 * 
	 * Using this attribute {@link DispatcherConfig} class is registered to the spring application context.
	 */
	public AnnotationConfigWebApplicationContext webContext = null;
	
	/**
	 * This method is from  WebApplicationInitializer interface of spring framework. It is implemented here to configure
	 * the given ServletContext with DispatcherServlet (handles all the HTTP requests and responses,
	 * it dispatches (sends) the request to the appropriate controller)), 
	 * to add URL mapping as "/" (matches with any URL request having "/" in it) and to set LoadOnStartup to value '1'
	 * which makes the DispatcherServlet get instantiated and initialized early. <br>
	 * 
	 * Note: This method gets called automatically by Spring framework.
	 */
	@Override
	public void onStartup(ServletContext ctx) throws ServletException
	{
		
		/* The below code is to create the dispatcher servlet's Spring application context
		 * by registering  {@link DispatcherConfig} class
		 */
		webContext = new AnnotationConfigWebApplicationContext();            
		webContext.register(DispatcherConfig.class);        
		webContext.setServletContext(ctx);
        
        /* The below code is to Register and map the dispatcher servlet. <br>
         * "addServlet()" method is used to register the dispatcher servlet to the servlet context
         * and this method returns the registered servlet.
         */
        ServletRegistration.Dynamic servlet = ctx.addServlet("dispatcherServlet", new DispatcherServlet(webContext));
        
       /*
        * The below statement is to set LoadOnStartup to value '1' which makes the registered servlet (i.e., DispatcherServlet)
        *  get instantiated and initialized early.
        */
        servlet.setLoadOnStartup(1);
       
        /*
         * The below statement is to add URL mapping as "/" (matches with any URL request having "/" in it)
         * with the registered servlet (i.e., DispatcherServlet) to handle the requests.
         */
        servlet.addMapping("/");
    }
	
}

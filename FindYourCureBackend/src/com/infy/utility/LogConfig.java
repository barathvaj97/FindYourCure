package com.infy.utility;

import java.io.File;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.status.StatusLogger;


public class LogConfig {
	
	static {
		/* Turning off the default console logger */
		StatusLogger.getLogger().setLevel(Level.OFF);
		
		/* The following code sets the path for the log4j2 configuration file */
		/* Default path is the project's src folder */
		((LoggerContext) LogManager.getContext(false)).setConfigLocation(new File("src/com/infy/resources/log4j2.xml").toURI());
	}

	/* Use this method to get the logger object */
	public static Logger getLogger(Class<?> clazz) {
		return LogManager.getLogger(clazz);
	}
}

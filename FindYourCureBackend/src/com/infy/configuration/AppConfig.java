package com.infy.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.infy.utility.LogConfig;

public class AppConfig {
	public static final Properties PROPERTIES;
	public static InputStream inputStream = null;
	static {
		try {
			inputStream = AppConfig.class.getResourceAsStream("/com/infy/resources/configuration.properties");
		}
		catch (Exception exception) {
			LogConfig.getLogger(AppConfig.class).error(exception.getMessage(),exception);
		}
		PROPERTIES = new Properties();
		try {
			PROPERTIES.load(inputStream);
		}
		catch (IOException exception) {
			LogConfig.getLogger(AppConfig.class).error(exception.getMessage(),exception);
		}
	}
}

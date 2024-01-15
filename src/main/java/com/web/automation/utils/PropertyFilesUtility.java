package com.web.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.web.automation.constants.PathConstants;

public class PropertyFilesUtility {

	private static Properties readDataFromPropertyFile(String filePath) {

		Properties properties = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream(new File(filePath));
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public static Properties readEnvProperties() {
		String envFilePath = PathConstants.ENV_PROPERTIES_PATH;
		return readDataFromPropertyFile(envFilePath);

	}

	public static Properties readConfigProperties() {
		String configFilePath = PathConstants.CONFIG_PROPERTIES_PATH;
		return readDataFromPropertyFile(configFilePath);

	}

}

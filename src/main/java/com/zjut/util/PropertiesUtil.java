package com.zjut.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

/**
 * 
 * <p>@author:zongchnaggu</p>
 * <p>@description:created by gu</p>
 * <p>@date:2016年12月13日</p>
 *
 */
public class PropertiesUtil {

	private static Logger logger = Logger.getLogger(PropertiesUtil.class);
	private static final String DEFULT_CONFIG_NAME = "redis.properties";
	private static ConcurrentHashMap<String, String> propertyMap = new ConcurrentHashMap<>();
	private static Properties prop;
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getValueByKey("host"));
	}

	public static Properties getProperties() {
		prop = new Properties();
		String configPath = PropertiesUtil.class.getResource("/").getPath();
		String path = configPath + "/" + DEFULT_CONFIG_NAME;
		try {
			prop.load(new FileInputStream(new File(path)));
		} catch (FileNotFoundException e) {
			logger.info("file not found....");
			e.printStackTrace();
		} catch (IOException e) {
			logger.info("io error...");
			e.printStackTrace();
		}
		return prop;
	}

	public static void checkProp() {
		if (prop == null)
			getProperties();
	}

	public static Set<Object> getKeys(){
		checkProp();
		return prop.keySet();
	}
	
	public static Enumeration<Object> getValues(){
		checkProp();
		return prop.elements();
	} 
	public static Set<Entry<Object,Object>> getEntry(){
		checkProp();
		return prop.entrySet();
	}

	public static String getValue(Properties props, String key) {
		if (props == null)
			props = getProperties();
		String value = null;
		value = propertyMap.get(key);
		if (value == null) {
			String pValue = props.getProperty(key);
			if (pValue == null)
				return key + " not found.";
			else {
				propertyMap.put(key, pValue);
				return pValue;
			}
		}
		return value;
	}

	public static String getValueByKey(String key) {
		return getValue(getProperties(), key);
	}

}

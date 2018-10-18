package com.phq.frame.common.properties;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * 
* @ClassName: PropertiesUtil
* @Description: 
*    配置文件解析类
* @author panhuaqing
* @date 2018年10月17日
*
 */
public class PropertiesUtil {
	@Autowired
    private static Environment env;
	

	// 通过传入的路径及key，获得对应的值
	public static String getValue(String path, String key) {
		Properties properties = new Properties();
		try {
			properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(path));
		} catch (IOException e) {
			throw new RuntimeException("文件读取失败!", e);
		}
		return properties.getProperty(key);
	}

	// 通过key直接获取对应的值
	public static String getValue(String key) {
		System.out.println(env.getProperty("constant.properties"));
		Properties properties = new Properties();
		try {
			properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(env.getProperty("constant.properties")));
		} catch (IOException e) {
			throw new RuntimeException("文件读取失败!", e);
		}
		return properties.getProperty(key);
	}
}

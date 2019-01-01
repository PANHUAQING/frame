package com.phq.frame.util;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class GsonUtil {
	 
	public static Gson gson = new Gson();
	
	/**
	 * @param JSON
	 *            将JavaBean字符串转换为 Json 
	 * @return void
	 */
	public static String beanToJSONString (Object obj) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create(); 
		try { 
			return gson.toJson(obj);
		} catch (JsonSyntaxException e) {
			System.out.println("JavaBean字符串转换为 Json" + e);
		}
		return "";
	}
	/**
	 * 将Json字符串转换成对象
	 * @param json
	 * @param beanClass
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object JSONToObject(String json,Class beanClass) {
		Object res=null;
		try { 
		      res = gson.fromJson(json, beanClass);
		} catch (JsonSyntaxException e) {
			System.out.println("JavaBean字符串转换为 Json" + e);
		}
	    return res;
	}

	public static <T> T parseJSON(String json, Class<T> clazz) {
		T t = null;
		try {
			t = gson.fromJson(json, clazz);
		} catch (JsonSyntaxException e) {
			System.out.println("JavaBean字符串转换为 Json" + e);
		}
		return t;
	}

	/**
	 * 根据json字符串返回Map对象
	 * 
	 * @param json
	 * @return
	 */
	public static Map<String, Object> toMap(String json) {
		return toMap(parseJson(json));
	}
	
	
	/**
	 * 将JSONObjec对象转换成Map-List集合
	 * 
	 * @param json
	 * @return
	 */
	public static Map<String, Object> toMap(JsonObject json) {
		Map<String, Object> map = new HashMap<String, Object>();
		Set<Entry<String, JsonElement>> entrySet = json.entrySet();
		for (Iterator<Entry<String, JsonElement>> iter = entrySet.iterator(); iter
				.hasNext();) {
			Entry<String, JsonElement> entry = iter.next();
			String key = entry.getKey();
			Object value = entry.getValue();
			if (value instanceof JsonArray)
				map.put(key, toList((JsonArray) value));
			else if (value instanceof JsonObject)
				map.put(key, toMap((JsonObject) value));
			else
				map.put(key, value);
		}
		return map;
	}
	
	/**
	 * 将JSONArray对象转换成List集合
	 * 
	 * @param json
	 * @return
	 */
	public static List<Object> toList(JsonArray json) {
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < json.size(); i++) {
			Object value = json.get(i);
			if (value instanceof JsonArray) {
				list.add(toList((JsonArray) value));
			} else if (value instanceof JsonObject) {
				list.add(toMap((JsonObject) value));
			} else {
				list.add(value);
			}
		}
		return list;
	}

	
	/**
	 * jGrid 单条数据
	* @Description 方法描述： 
	* @parameter 参数：   
	* @return 返回值：
	 */
	public static String pageToJson(String dataStr) { 
		JSONObject fromObject = JSONObject.parseObject(dataStr);
		@SuppressWarnings("rawtypes")
		List<?> olist = (List) fromObject.get("list"); 
		String jsonString = "{\"page\":"
				+ 1 + ",\"total\":" + 1
		        +",\"records\":" + olist.size(); 
		if (null != olist && olist.size() > 0) {
			String jsonStr = "";
			try {
				jsonStr = gson.toJson(olist).toString();
			} catch (Exception e) {
				System.out.println("Gson格式转换异常！");
			}
			jsonString += ",\"rows\":" + jsonStr + "}"; 
		} else {
			jsonString += ",\"rows\":[]}";
		} 
		return jsonString;
	}
	
	/**
	 * 
	 *  @Description:data转换
	 *  @param json
	 *  @return  
	 *  @version: v1.0
	 *  @see
	 */
    public static Object parseJsonToObject(String json) {
        if (StringUtils.isNotBlank(json)) {
            Object result = null;
            if (json.trim().startsWith("{")) {
                result = gson.fromJson(json, HashMap.class);
            } else if(json.trim().startsWith("[")) {
                result = parseJsonToList(json, HashMap.class);
            }
            return result;
        } else {
            return null;
        }
    }
	
    public static <T> List<T> parseJsonToList(String json, Class<T> clazz) {
        return gson.fromJson(json, new TypeToken<List<T>>() {}.getType());
    }
    
	/**
	 * 获取JsonObject
	 * 
	 * @param json
	 * @return
	 */
	public static JsonObject parseJson(String json) {
		JsonParser parser = new JsonParser();
		JsonObject jsonObj = parser.parse(json).getAsJsonObject();
		return jsonObj;
	}

    public static JsonArray parseJsonArray(String json) {
        JsonParser parser = new JsonParser();
        JsonArray jsonObj = parser.parse(json).getAsJsonArray();
        return jsonObj;
    }
	
    /**
     * 
    * @Title: beanToMap
    * @Description: 
    *     实体对象转Map
    * @param @param obj
    * @param @return    
    * @return Map<String,Object>    
    * @throws
     */
    public static Map<String, Object> beanToMap(Object obj) { 
        Map<String, Object> params = new HashMap<String, Object>(0); 
        try { 
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean(); 
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj); 
            for (int i = 0; i < descriptors.length; i++) { 
                String name = descriptors[i].getName(); 
                if (!"class".equals(name)) { 
                    params.put(name, propertyUtilsBean.getNestedProperty(obj, name)); 
                } 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return params; 
}

	
	
}

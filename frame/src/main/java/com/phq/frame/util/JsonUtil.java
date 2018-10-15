package com.phq.frame.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil {


    public static<T> T strToObject(String str,Class<T> clazz){
        ObjectMapper mapper = new ObjectMapper();
        T t = null;
        try {
        t = mapper.readValue(str, clazz);
            return t;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }


    //对象转换为字符串
    public static<T> String objectToStr(T t){
        ObjectMapper mapper = new ObjectMapper();
        String str = null;
        try {
            str = mapper.writeValueAsString(t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
   

    //对象转换为List集合
    public static <T> List<T> strToList(String str, Class<T> clazz) {
        JSONArray json = JSONArray.fromObject(str);
        JSONObject object = null;
        T t = null;
        List<T> list = new ArrayList<>();
        for (int i = 0; i < json.size(); i++) {
            object = JSONObject.fromObject(json.get(i));
            t = (T) JSONObject.toBean(object, clazz);
            list.add(t);
        }
        return list;
    }
}

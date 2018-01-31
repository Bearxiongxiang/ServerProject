package com.beacon.imchat.util;

import com.beacon.imchat.bean.MessageBean;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Tina on 10/14/2017.
 */
public class GsonUtil {

    private static final String JSON_CODE = "code";

    private static Gson gson = new Gson();

    /**
     * 转成json
     */
    public static String GsonString(Object object) {
        String gsonString = null;
        if (gson != null) {
            gsonString = gson.toJson(object);
        }
        return gsonString;
    }

    /**
     * 转成bean
     */
    public static <T> T GsonToBean(String gsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonString, cls);
        }
        return t;
    }

    /**
     * 转成list
     */
    public static <T> List<T> GsonToList(String gsonString, Class<T> cls) {
        List<T> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }

    /**
     * 自定义类型转换
     */
    public static <T> T fromJson(String gsonString, Type type) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonString, type);
        }
        return t;
    }

    /**
     * 转成list 解决泛型问题
     */
    public static <T> List<T> jsonToList(String json, Class<T> cls) {
        Gson gson = new Gson();
        List<T> list = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for (final JsonElement elem : array) {
            list.add(gson.fromJson(elem, cls));
        }
        return list;
    }


    /**
     * 转成list中有map的
     */
    public static <T> List<Map<String, T>> GsonToListMaps(String gsonString) {
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString,
                    new TypeToken<List<Map<String, T>>>() {
                    }.getType());
        }
        return list;
    }

    /**
     * 转成map的
     */
    public static <T> Map<String, T> GsonToMaps(String gsonString) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }

    /**
     * 获取Json Code
     *
     * @param json
     * @return
     */
    public static int getJsonCode(String json) {
        try {
            return GsonToBean(json, MessageBean.class).getCode();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 获取Json Message
     *
     * @param json
     * @return
     */
    public static Object getJsonMessage(String json) {
        try {
            return GsonToBean(json, MessageBean.class).getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

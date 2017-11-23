package com.wq.wqnetwork.response;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * JSON格式转换工具类
 */
public class JsonTools {

    /**
     * @param @param json
     * @param @param clazz  泛型类 即T的类型
     * @return T
     * @description 把JSON数据转换成指定的java对象
     * @author jiaBF
     */
    public static <T> T getBean(String json, Class<T> clazz) {
        if (TextUtils.isEmpty(json)) return null;
        try {
            return JSON.parseObject(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 功能描述：把java对象转换成JSON字符串
     *
     * @param object java对象
     * @return
     */
    public static String getJsonString(Object object) {
        if (null == object) return "";

        try {
            return JSON.toJSONString(object, true);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param @param json
     * @param @param clazz 泛型类 即T的类型
     * @return List<T>
     * @description 解析一个json数组
     * @author jiaBF
     */
    public static <T> List<T> getBeanList(String json, Class<T> clazz) {
        if (TextUtils.isEmpty(json)) return null;
        try {
            return JSON.parseArray(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}

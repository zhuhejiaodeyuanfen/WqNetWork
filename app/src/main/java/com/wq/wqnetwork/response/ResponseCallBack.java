package com.wq.wqnetwork.response;

import android.text.TextUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by vivianWQ on 2017/11/22
 * Mail: wangqi_vivian@sina.com
 * desc:
 * Version: 1.0
 */
public abstract class ResponseCallBack<T> {
    private Class<? super T> rawType;

    public <T> T getData(Class<T> cla, String data) {
        if (data != null && !TextUtils.isEmpty(data)) {
            return JsonTools.getBean(data, cla);
        }
        return null;
    }

    public ResponseCallBack() {
        Type myClass = getClass().getGenericSuperclass();    //反射获取带泛型的class
        if (myClass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        rawType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void onSuccess(String s) {
        onResponseSuccess((T) getData(rawType, s));

    }


    public void onError(String error) {

    }


    public abstract void onResponseSuccess(T response);
}

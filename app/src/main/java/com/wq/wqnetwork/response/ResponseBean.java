package com.wq.wqnetwork.response;

import java.io.Serializable;

/**
 * 网络请求实体类,isSuccess判断是否成功
 */
public class ResponseBean implements Serializable {


    private String data;


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }




}

package com.wq.wqnetwork;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * Created by vivianWQ on 2017/11/22
 * Mail: wangqi_vivian@sina.com
 * desc: 网络请求基本工具类
 * Version: 1.0
 */
public class VivianHttpUtil {

    public static final String GET = "GET";

    public static final String POST = "POST";

    public static final int connectTimeOut = 6000;

    public static final int readTimeOut = 30000;


    /**
     * GET方式发送数据
     *
     * @param http
     * @param data
     * @param charset
     * @return
     */
    public static String sendGet(String http, String data, String charset) {
        return request(http, data, charset, GET);
    }

    public static String sendGet(String http, HashMap<String, String> map, String charset) {
        return sendGet(http, map, charset, false);
    }

    public static String sendGet(String http, HashMap<String, String> map, String charset, boolean encode) {
        return sendGet(http, parseMap(map, charset, encode), charset);
    }


    /**
     * POST方式发送数据
     *
     * @param http
     * @param data
     * @param charset
     * @return
     */
    public static String sendPost(String http, String data, String charset) {
        return request(http, data, charset, POST);
    }

    public static String sendPost(String http, HashMap<String, String> map, String charset) {
        return sendPost(http, map, charset, false);
    }

    public static String sendPost(String http, HashMap<String, String> map, String charset, boolean encode) {
        return sendPost(http, parseMap(map, charset, encode), charset);
    }

    /**
     * 解析map
     */
    private static String parseMap(HashMap<String, String> map, String charset, boolean encode) {
        StringBuffer sb = new StringBuffer();
        if (map != null && !map.isEmpty()) {
            try {
                boolean f = true;
                String v;
                for (String k : map.keySet()) {
                    if (k != null && !"".equals(k)) {
                        v = map.get(k).trim();
                        if (!f)
                            sb.append("&");
                        if (encode)
                            v = URLEncoder.encode(v, charset);
                        sb.append(k).append("=").append(v);
                        f = false;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString().trim();
    }

    private static String request(String http, String data, String charset, String type) {

        StringBuilder builder = new StringBuilder();
        HttpURLConnection connection = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;


        try {
            if (GET.equals(type) && data != null && !"".equals(data)) {
                http = http + "?" + data;
            }
            URL url = new URL(http);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(type);
            connection.setConnectTimeout(connectTimeOut);
            connection.setReadTimeout(readTimeOut);
            if (POST.equals(type))
                connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.connect();

            //传送数据
            if (POST.equals(type)) {
                if (data != null && !"".equals(data)) {
                    outputStreamWriter = new OutputStreamWriter(connection.getOutputStream(), charset);
                    bufferedWriter = new BufferedWriter(outputStreamWriter);
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                }
            }
            //接收数据
            if (connection.getResponseCode() == 200) {
                inputStreamReader = new InputStreamReader(connection.getInputStream(), charset);
                bufferedReader = new BufferedReader(inputStreamReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    builder.append(line + "\n");
                }

            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
                if (outputStreamWriter != null)
                    outputStreamWriter.close();
                if (bufferedReader != null)
                    bufferedReader.close();
                if (inputStreamReader != null)
                    inputStreamReader.close();
                if (connection != null)
                    connection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return builder.toString().trim();
        }


    }
}

package com.red.geek.week02;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * OkHttpUtil
 *
 * @author red
 * @class_name OKHttpUtil
 * @date 2021-03-28
 */
public class OkHttpUtil {

    public static String doGet(String url) {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try (Response response = httpClient.newCall(request).execute()) {
            if (response.code() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed response from url: " + url + ", response code: " + response.code());
            }
            return response.body().string();
        } catch (Exception ex) {
            throw new RuntimeException("Failed getting url: " + url, ex);
        }
    }

    public static void main(String[] args) {
        String s = doGet("http://localhost:8801");
        System.out.println(s);
    }
}

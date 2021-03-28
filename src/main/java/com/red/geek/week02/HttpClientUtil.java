package com.red.geek.week02;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

/**
 * HttpClientUtil
 *
 * @author red
 * @class_name HttpClientUtil
 * @date 2021-03-28
 */
public class HttpClientUtil {

    public static String doGet(String url) {
        try {
            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                HttpGet httpGet = new HttpGet(url);
                try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
                    int statusCode = httpResponse.getStatusLine().getStatusCode();
                    if (statusCode != HttpURLConnection.HTTP_OK) {
                        throw new RuntimeException("Failed response from url: " + url + ", response code: " + statusCode);
                    }
                    return EntityUtils.toString(httpResponse.getEntity(), StandardCharsets.UTF_8);
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException("Failed getting url: " + url, ex);
        }
    }

    public static void main(String[] args) {
        String s = doGet("http://localhost:8801");
        System.out.println(s);
    }


}

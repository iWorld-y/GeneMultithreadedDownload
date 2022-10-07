package com.eugene.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 类<code>Doc</code>用于：http 相关工具类
 *
 * @author Eugene
 * @version 1.0
 * @date 2022-10-07
 */
public class HttpUtils {
    private final String url;

    /**
     * 获取 HttpURLConnection 链接对象
     *
     * @param url 文件下载链接
     */
    public HttpUtils(String url) {
        this.url = url;
    }

    /**
     * 获取 HttpURLConnection 链接对象
     *
     * @return 返回 HttpURLConnection 对象
     */
    public HttpURLConnection getHttpURLConnection() throws IOException {
        URL httpUrl = new URL(this.url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpUrl.openConnection();
        // 向下载服务器发送 UserAgent
        httpURLConnection.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36 Edg/106.0.1370.34");
        return httpURLConnection;
    }

    /**
     * 截取 url 中最末一个分隔符 '/' 后的内容作为文件名
     *
     * @return 文件名
     */
    public String getHttpFileName() {
        return this.url.substring(this.url.lastIndexOf('/') + 1);
    }
}

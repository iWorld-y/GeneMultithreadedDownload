package com.eugene.core;

import com.eugene.constant.Constant;
import com.eugene.util.HttpUtils;

import java.io.*;
import java.net.HttpURLConnection;

/**
 * 类<code>Doc</code>用于：下载器类
 *
 * @author Eugene
 * @version 1.0
 * @date 2022-10-07
 */
public class Downloader {
    public void download(String url) {
        // 获取文件名
        String httpFileName = (new HttpUtils(url).getHttpFileName());
        // 构造文件的下载路径
        httpFileName = Constant.getDownloadPATH() + httpFileName;

        // 获取链接对象
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = new HttpUtils(url).getHttpURLConnection();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try (InputStream in = httpURLConnection.getInputStream();
             BufferedInputStream bin = new BufferedInputStream(in);
             FileOutputStream fout = new FileOutputStream(httpFileName);
             BufferedOutputStream bout = new BufferedOutputStream(fout)) {
            int len = -1;
            while ((len = bin.read()) != -1) {
                bout.write(len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("下载文件不存在. ");
        } catch (Exception e) {
            System.out.println("下载失败");
        } finally {
            // 关闭链接对象
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }
}

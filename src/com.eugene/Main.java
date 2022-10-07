package com.eugene;

import java.net.HttpURLConnection;
import java.util.Scanner;

import com.eugene.core.Downloader;
import com.eugene.util.HttpUtils;

/**
 * @author Eugene
 * @date 2022-10-7
 * @describe 主类
 */
public class Main {

    //TODO Everything 下载链接: https://webcdn.m.qq.com/spcmgr/download/Everything-1.4.1.1020.x64-Setup.exe
    public static void main(String[] args) {
        // 下载地址
        String url = null;
        // 参数非法
        if (args == null || args.length == 0) {
            Scanner sc = new Scanner(System.in);
            do {
                System.out.println("请输入下载链接:\t");
                url = sc.next();
            } while (url == null);
        } else {
            url = args[0];
        }

        Downloader downloader = new Downloader();
        downloader.download(url);
    }
}
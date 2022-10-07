package com.eugene.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author Eugene
 * @version 1.0
 * @date 2022-10-07
 */
public class LogUtils {
    public LogUtils() {
    }

    public void info(String msg, Object... args) {
        this.print(msg, "[info]", args);
    }

    public void error(String msg, Object... args) {
        this.print(msg, "[error]", args);
    }

    private void print(String msg, String level, Object... args) {
        if (args != null && args.length > 0) {
            msg = String.format(msg.replace("{}", "%s"), args);
        }
        String name = Thread.currentThread().getName();
        System.out.printf("[%s] %s %s %s\n", (new Date()).toString(), name, level, msg);
    }
}

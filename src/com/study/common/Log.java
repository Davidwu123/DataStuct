package com.study.common;

import static com.study.common.Utils.getCurrentTime;

/**
 * @author wuwei
 * @title: Log
 * @projectName DataStuct
 * @description: TODO
 * @date 2019-12-01 13:26
 */
public class Log {

    private static void println(String type, String tag, Object value) {
        String msg = String.format("%s\tThread-name: %s\t%s/%s:\t%s",
                getCurrentTime(), Thread.currentThread().getName(), type, tag, value.toString());
        System.out.println(msg);
    }

    public static void d(Class clazz, Object value) {
        d(clazz.getSimpleName(), value);
    }

    public static void d(String tag, Object value) {
        println("DEBUG", tag, value);
    }

    public static void e(Class clazz, Object value) {
        e(clazz.getSimpleName(), value);
    }

    public static void e(String tag, Object value) {
        println("ERROR", tag, value);
    }
}
package com.study.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wuwei
 * @title: Log
 * @projectName DataStuct
 * @description: TODO
 * @date 2019-12-0113:26
 */
public class Log {

    public static void d(String tag, String value) {
        System.out.print(getCurrentTime());
        System.out.print(" Thread-name: " + Thread.currentThread().getName() + "\t" + tag + ":\t");
        System.out.println(value);
    }

    private static String getCurrentTime() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:sss");
        return sdf.format(d);
    }
}

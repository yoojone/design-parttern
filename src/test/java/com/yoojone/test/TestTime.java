package com.yoojone.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author yuqiang.zhang
 * @date 2021/9/17
 * description:
 */
public class TestTime {


    public static void main(String[] args) {

        System.out.println(isLessCurrentTime("2021-07-07 00:00:00", "yyyy-MM-dd HH:mm:ss"));

        //LocalDateTime.parse(dateStr, formatter)
    }


    public static boolean isLessCurrentTime(String dateStr, String pattern){
        try {

            LocalDateTime dateTime = LocalDateTime.parse(dateStr,  DateTimeFormatter.ofPattern(pattern));
            LocalDateTime now = LocalDateTime.now();

            return dateTime.compareTo(now) >= 0 ? false : true;
        } catch (Exception e) {
        }

        return false;
    }
}

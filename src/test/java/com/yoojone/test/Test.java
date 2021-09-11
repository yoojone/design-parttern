package com.yoojone.test;

import org.slf4j.MDC;

/**
 * @author yuqiang.zhang
 * @date 2021/9/10
 * description:
 */
public class Test {


    public static void main(String[] args) {
        /*String str = String.format("%s_%s_%s", "a", "b" ,"C");

        System.out.println(str);*/

        MDC.put("current_activity_no", "123");


        System.out.println(1);

        MDC.remove("current_activity_no");

        System.out.println(2);
    }


    private <T> Param<T> getName() {
        return null;
    }
}

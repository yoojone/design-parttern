package com.yoojone.test;

import org.slf4j.MDC;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yuqiang.zhang
 * @date 2021/9/10
 * description:
 */
public class Test {


    public static void main(String[] args) {


        System.out.println("duorencx".substring(4));
        /*Runnable runnable = () -> {
            System.out.println(11);
        };

        new Thread(runnable).start();

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        String name = "小鸡";
        MyInterface myInterface = (o, a) -> {
            System.out.println(o);
            System.out.println(a);
        };
        myInterface.sayHello(name, 12);

        //List<Integer> integers = Arrays.asList(new Integer[]{1, 2, 3});

        List<String> str = Arrays.stream("8,4,8,9,9".split(","))
                .collect(Collectors.toList());
        //List<String> str = Arrays.asList("8,4,8,9,9".split(","));

        str.stream().filter(s -> s.equals("9"))
                .forEach( o -> System.out.println(o));
        System.out.println(1);
    }

    public interface MyInterface {
        void sayHello(String name, Integer age);
    }

    private <T> Param<T> getName() {
        return null;
    }
}

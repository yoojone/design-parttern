package com.yoojone.test.jdk8;

import java.util.function.Function;

/**
 * @author yuqiang.zhang
 * @date 2021/9/14
 * description: 函数型接口
 * T 入参， R返回值
 * collection 8 Function<T, R>
 */
public class FunctionTest {

    static Function<String, String> function = name -> {

        return name.substring(2);
    };

    public static void main(String[] args) {
        System.out.println(function.apply("fdskjhlfdsjkfgkjl"));
    }

    /*public static void main(String[] args) {
        String msg = handler("abcdefg", name -> name.substring(2));
        System.out.println(msg);
    }

    public static String handler (String name, Function<String, String> function) {

        return function.apply(name);
    }*/
}

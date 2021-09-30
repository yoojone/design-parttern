package com.yoojone.test.jdk8;

import java.util.function.Consumer;

/**
 * @author yuqiang.zhang
 * @date 2021/9/14
 * description:
 * jdk8 Consumer 消费型接口
 *
 * 传参，消费
 */
public class ConsumerTest {


    static Consumer<String> consumer = name -> {
        System.out.println(name + "__adsdsa");
    };

    public static void main(String[] args) {
        consumer.accept("a123");
    }

    /*public static void main(String[] args) {

        execute("aa", o -> System.out.println(o + "_dfd"));
    }

    public static void execute(String money, Consumer<String> consumer) {

        consumer.accept(money);

    }*/
}

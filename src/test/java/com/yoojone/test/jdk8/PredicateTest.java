package com.yoojone.test.jdk8;

import java.util.function.Predicate;

/**
 * @author yuqiang.zhang
 * @date 2021/9/14
 * description: 断言型
 * collection 8 Predicate
 */
public class PredicateTest {


    static Predicate<Integer> predicate = o -> {
        if (o % 2 == 0) {
            return true;
        }
        return false;
    };

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(predicate.test(i));
        }
    }
}

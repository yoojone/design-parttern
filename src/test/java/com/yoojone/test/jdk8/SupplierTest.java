package com.yoojone.test.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author yuqiang.zhang
 * @date 2021/9/14
 * description:
 *
 * jdk8 Supplier 供给型接口
 *
 * 无入参，有返回
 */
public class SupplierTest {

    static Supplier<Integer> supplier = () -> {
        return (int)(Math.random() * 100);
    };

    public static void main(String[] args) {
        for (int i = 0; i < 5; i ++ ) {
            System.out.println(supplier.get());
        }
    }


    /*public static void main(String[] args) {

        List<Integer> numList = getNumList(5, () -> (int) (Math.random() * 100));
        System.out.println(1);
    }

    public static List<Integer> getNumList (int num, Supplier<Integer> supplier) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = supplier.get();
            list.add(n);
        }

        return list;
    }*/
}

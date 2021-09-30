package com.yoojone.test.collection;

import java.util.ArrayList;

/**
 * @author yuqiang.zhang
 * @date 2021/9/21
 * description:
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList();
        list.add("a");
        list.add("b");

        list.set(1, "C");
        list.add(1, "Cc");

        System.out.println(list);

        list.remove(1);

        for (int i = 0; i < 10; i++) {

            list.add("string" + i);
        }

    }
}

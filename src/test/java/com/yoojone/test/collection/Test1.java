package com.yoojone.test.collection;

import java.util.*;

/**
 * @author yuqiang.zhang
 * @date 2021/9/22
 * description:
 */
public class Test1 {

    public static void main(String[] args) {

        TreeMap<String, String> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        map.put("3", "c");
        map.put("2", "b");
        map.put("1", "a");

        System.out.println(map);

        /*Stack<String> stack = new Stack<String>();
        stack.push("a");

        stack.push("b");

        stack.push("c");

        System.out.println(stack.pop());*/

        /*HashMap<String, String> map = new HashMap<>();
        map.put("a", "a");*/

        /*LinkedHashMap<String, String> map = new LinkedHashMap<>(16, 0.75f, true);

        map.put("1", "2");
        map.put("3", "4");

        map.put("1", "10");

        //map.remove("2");
        map.get("3");
        System.out.println(map);*/


    }
}

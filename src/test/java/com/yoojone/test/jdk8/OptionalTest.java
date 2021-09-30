package com.yoojone.test.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author yuqiang.zhang
 * @date 2021/9/14
 * description:
 * collection 8 Optional
 * https://blog.csdn.net/csdn9988680/article/details/80816457
 */
public class OptionalTest {

    public static void main(String[] args) throws Exception {
        //参数不能是null
        Optional<Integer> o1 = Optional.of(1);
        //参数可以是null
        Optional<Integer> o11 = Optional.ofNullable(null);

        // null的Optional对象  == Optional.ofNullable(null);
        Optional<Integer> o2 = Optional.empty();


        //判断 值是否存在， o1 存在， o2，不存在, true,false
        System.out.println(o1.isPresent());
        System.out.println(o2.isPresent());

        List<Integer> list = new ArrayList<>();
        // o1有值，就执行下面操作
        /*o1.ifPresent(o -> {
            list.add(o);
        });*/

        o1.ifPresent(list::add);

        o1.ifPresent(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("consumer + " + integer);
            }
        });




        //optional对象保存的值不是null，就返回原来的值，否则返回value，入参
        System.out.println(o1.orElse(111));
        System.out.println(o11.orElse(1000));


        //orElseGet(Supplier supplier) 功能与orElse一样，只不过orElseGet参数是一个对象
        o11.orElseGet(() -> {
            return 111;
        });

        // orElseThrow()：值不存在则抛出异常，存在则什么不做
        try {
            o11.<RuntimeException>orElseThrow(() -> {
                throw new RuntimeException("111");
            });
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        //filter(Predicate)：判断Optional对象中保存的值是否满足Predicate，并返回新的Optional

        System.out.println(o1.filter(o -> o == 1));


        //map(Function)：对Optional中保存的值进行函数运算，并返回新的Optional(可以是任何类型)
        Optional<String> str1Optional = o1.map((a) -> "key" + a);

        System.out.println(str1Optional.get());


        //flatMap()：功能与map()相似，差别请看如下代码。flatMap方法与map方法类似，区别在于mapping函数的返回值不同。
        // map方法的mapping函数返回值可以是任何类型T，而flatMap方法的mapping函数必须是Optional。

        /**
         * Optional<Optional<String>> str1Optional = optional1.map((a) -> {
         *     return Optional.<String>of("key" + a);
         * });
         *
         * Optional<String> str2Optional = optional1.flatMap((a) -> {
         *     return Optional.<String>of("key" + a);
         * });
         */

        Optional<String> str2Optional = o1.flatMap((a) -> {
            return Optional.<String>of("key" + a);
        });



        System.out.println(1);
    }
}

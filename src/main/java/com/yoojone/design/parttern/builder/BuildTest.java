package com.yoojone.design.parttern.builder;

/**
 * @author yoojone
 * @date 2021/8/13
 * description:1
 */
public class BuildTest {

    public static void main(String[] args) {
        PersonInfo personInfo = new PersonInfo.Builder()
                .name("zhangsan")
                .age(12)
                .gender("男")
                .address("北京")
                .phone("123")
                .email("hfjdsha@qq.com")
                .build();

        System.out.println(1);
    }
}

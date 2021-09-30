package com.yoojone.design.parttern.chain;

/**
 * @author yuqiang.zhang
 * @date 2021/9/15
 * description: 没有责任链
 */
public class NonChainPattern {

    public static void main(String[] args) {

        //业务流程1
        System.out.println("执行功能1");
        System.out.println("执行功能2");
        System.out.println("执行功能3");

        //业务流程2
        System.out.println("执行功能3");
        System.out.println("执行功能1");
        System.out.println("执行功能2");

        /**
         * 问题:
         * 1： 大量代码出现了，功能123的代码，都出现在两个地方，有复制粘贴的现象
         * 2. 如果要对某个个功能的代码进行修改，那就会很麻烦，要在多个地方去修改这个功能
         *
         * 3.如果某个个业务流程的顺序进行调整或者改造，很麻烦，要修改大量模式
         *
         */
    }
}

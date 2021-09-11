package com.yoojone.design.parttern.singleton;

/**
 * @author yuqiang.zhang
 * @date 2021/9/9
 * description:
 * 单例模式，有 饿汉式，懒汉式， 双重检查
 */
public class Singleton1
{

    /**
     * 饿汉式
     *
     */
    private static Singleton1 singleton = new Singleton1();

    /**
     * 私有构造方法
     */
    private Singleton1() {

    }

    /**
     * 静态全局访问
     * @return
     */
    public static Singleton1 getInstance() {
        return singleton;
    }
}

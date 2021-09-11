package com.yoojone.design.parttern.singleton;

/**
 * @author yuqiang.zhang
 * @date 2021/9/9
 * description:
 * 单例模式，有 饿汉式，懒汉式， 双重检查
 */
public class Singleton2
{

    /**
     * 懒汉式 线程安全问题
     *
     */
    private static Singleton2 singleton = null;

    /**
     * 私有构造方法
     */
    private Singleton2() {

    }

    /**
     * 静态全局访问
     * @return
     */
    public static Singleton2 getInstance() {

        if (null == singleton) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}

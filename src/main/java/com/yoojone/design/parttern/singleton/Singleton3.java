package com.yoojone.design.parttern.singleton;

/**
 * @author yuqiang.zhang
 * @date 2021/9/9
 * description:
 * 单例模式，有 饿汉式，懒汉式， 双重检查
 */
public class Singleton3
{

    /**
     * 懒汉式  double check + volatile
     *
     */
    private static volatile Singleton3 singleton = null;

    /**
     * 私有构造方法
     */
    private Singleton3() {

    }

    /**
     * 静态全局访问
     * @return
     */
    public static Singleton3 getInstance() {

        if (null == singleton) {
            synchronized(Singleton3.class) {
                if (null == singleton) {
                    singleton = new Singleton3();
                }
            }
        }

        return singleton;
    }
}

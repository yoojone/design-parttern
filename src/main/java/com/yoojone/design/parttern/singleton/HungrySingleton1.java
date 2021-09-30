package com.yoojone.design.parttern.singleton;

/**
 * @author yuqiang.zhang
 * @date 2021/9/9
 * description:
 * 单例模式，有 饿汉式，懒汉式， 双重检查
 *
 * 比如说 定义了一个框架，读取xml格式的配置文件
 * 配置文件的数据读取到类中，这个类的实例 只保存一份就可以，
 * 这时就可以使用 单例模式
 */
public class HungrySingleton1 {

    /**
     * 饿汉式
     * 第一步:
     * static : 类的静态变量
     * final ： 变量的引用 第一次初始化赋予之后，就再也不能修改引用了
     */
    private static HungrySingleton1 singleton = new HungrySingleton1();

    /**
     * 私有构造方法
     * 第二步: 除了这个类自己本身，其他任何人都不能创建他的实例对象
     */
    private HungrySingleton1() {

    }

    /**
     * 静态全局访问
     * 第三步:
     * @return
     */
    public static HungrySingleton1 getInstance() {
        return singleton;
    }

    public void execute() {
        System.out.println(" execute ...");
    }

    public static void main(String[] args) {
        HungrySingleton1 singleton1 = HungrySingleton1.getInstance();

        singleton1.execute();
    }
}

package com.yoojone.design.parttern.prototype.simple;

/**
 * @author yuqiang.zhang
 * @date 2021/9/9
 * description:
 */
public class ClientTest {

    public static void main(String[] args) {
        /**
         * 测试代码，首先创建好两个原型实例，以后创建新的Prototype对象就靠复制它了
         */
        Prototype prototypeA=null;
        Prototype prototypeB=null;
        /**
         * 为原型实例起个名字
         */
        prototypeA=new ConcretePrototypeA();
        prototypeA.setName("A1");
        /**
         * 为原型实例起个名字
         */
        prototypeB=new ConcretePrototypeB();
        prototypeB.setName("B1");
        /**
         * 复制实例
         */
        Prototype copyA=prototypeA.clone();
        Prototype copyB=prototypeB.clone();
        /**
         * 看看新复制的实例名字是否和原型一样
         */
        System.out.println("原型A的名字："+prototypeA.getName());
        System.out.println("原型B的名字："+prototypeB.getName());
        System.out.println("拷贝A的名字："+copyA.getName());
        System.out.println("拷贝B的名字："+copyB.getName());
        /**
         * 看看是不是真正的复制了一份
         */
        copyA.setName("备份A1");
        System.out.println("拷贝A的名字："+copyA.getName());
        System.out.println("原型A的名字："+prototypeA.getName());
    }
}

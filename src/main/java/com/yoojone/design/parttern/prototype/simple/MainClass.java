package com.yoojone.design.parttern.prototype.simple;

/**
 * @author yuqiang.zhang
 * @date 2021/9/9
 * description:
 */
public class MainClass {

    public static void main(String[] args) throws Exception {
        /**
         * 测试代码，首先创建好两个原型实例，以后创建新的Prototype对象就靠复制它了
         */
        Prototype prototypeA = null;
        Prototype prototypeB = null;
        /**
         * 为原型实例起个名字
         */
        prototypeA = new ConcretePrototypeA();
        prototypeA.setName("A");
        /**
         * 为原型实例起个名字
         */
        prototypeB = new ConcretePrototypeB();
        prototypeB.setName("B");
        /**
         * 将创建好的原型实例在PrototypeManager中进行登记
         */
        PrototypeManager.setPrototype("A", prototypeA);
        PrototypeManager.setPrototype("B", prototypeB);
        /**
         * 使用PrototypeManager来对登记好的原型进行选择复制 我想要以 name 为 "A" 的原型为模板进行复制
         */
        Prototype copyA = PrototypeManager.getPrototype("A").clone();
        /**
         * 使用PrototypeManager来对登记好的原型进行选择复制 我想要以 name 为 "B" 的原型为模板进行复制
         */
        Prototype copyB = PrototypeManager.getPrototype("B").clone();
        /**
         * 看看新复制的实例名字是否和你想要的一样
         */
        System.out.println("原型A的名字：" + prototypeA.getName());
        System.out.println("原型B的名字：" + prototypeB.getName());
        System.out.println("拷贝A的名字：" + copyA.getName());
        System.out.println("拷贝B的名字：" + copyB.getName());
        /**
         * 看看是不是真正的复制了一份
         */
        copyA.setName("备份A1");
        System.out.println("拷贝A的名字：" + copyA.getName());
        System.out.println("原型A的名字：" + prototypeA.getName());

    }
}

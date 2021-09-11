package com.yoojone.design.parttern.prototype.simple;

/**
 * @author yuqiang.zhang
 * @date 2021/9/9
 * description:
 */
public class ConcretePrototypeA extends Prototype {


    protected String name;

    @Override
    protected Prototype clone() {

        Prototype prototype = new ConcretePrototypeA();
        prototype.setName(this.name);
        System.out.println("ConcretePrototypeA创建完成！");
        return prototype;
    }

    @Override
    protected String getName() {
        return name;
    }

    @Override
    protected void setName(String name) {
        this.name = name;
    }
}

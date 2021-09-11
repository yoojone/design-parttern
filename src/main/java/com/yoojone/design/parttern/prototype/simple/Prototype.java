package com.yoojone.design.parttern.prototype.simple;

/**
 * @author yuqiang.zhang
 * @date 2021/9/9
 * description:
 */
public abstract class Prototype implements Cloneable {

    /**
     * 为子类提供一个复制方法
     * @return
     */
    protected abstract Prototype clone();

    /**
     * 以下两个方法为测试用，为每一个Prototype取上名字，方便区分
     */
    protected abstract String getName();

    protected abstract void setName(String name);
}

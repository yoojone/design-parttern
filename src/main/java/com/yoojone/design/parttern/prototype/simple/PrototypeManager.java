package com.yoojone.design.parttern.prototype.simple;

import com.yoojone.design.parttern.prototype.simple.Prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuqiang.zhang
 * @date 2021/9/9
 * description:
 * 登记模式
 * 该形式与简单形式的区别在于多增加了一个PrototypeManager(原型管理器)角色，该角色对要复制的原型对象进行登记管理，
 * 这个角色提供必要的方法供外界增加新的原型对象和取得已经登记过的原型对象。
 *
 * 该形式的抽象原型角色Prototype、具体原型角色ConcretePrototypeA、具体原型角色ConcretePrototypeB与简单形式完全相同。
 *
 * 原型管理器角色：此处以Map为容器对要复制的原型进行存储登记，PrototypeManager示例代码如下


 * 使用登记形式原型模式在要复制的原型实例种类比较多而且要使用的原型实例经常变化的情况下比较方便，
 * 你只要写好原型实例并在原型管理器中登记好(起一个自己能够区分的名字作索引)，要复制哪个原型就从管理器直接获取
 */
public class PrototypeManager {

    /**
     * 此处以Map为例，为每一个要复制的原型实例进行存储登记
     */
    private static Map<String, Prototype> map = new HashMap<String, Prototype>();


    /**
     * 私有化构造方法，避免外部创建管理器
     */
    private PrototypeManager() {
    }
    /**
     * 向原型管理器里面登记原型对象或是修改某个原型对象登记信息
     *
     * @param prototypeIndex
     *            原型索引
     * @param prototype
     *            原型实例
     */
    public synchronized static void setPrototype(String prototypeIndex,
                                                 Prototype prototype) {
        map.put(prototypeIndex, prototype);
    }
    /**
     * 从原型管理器里面删除某个登记好的原型对象
     *
     * @param prototypeIndex
     *            原型索引
     */
    public synchronized static void removePrototype(String prototypeIndex) {
        map.remove(prototypeIndex);
    }
    /**
     * 获取某个原型索引对应的原型实例
     *
     * @param prototypeIndex
     *            原型索引
     * @return 原型索引对应的原型实例
     * @throws Exception
     *             如果原型索引对应的实例不存在，则抛出异常
     */
    public synchronized static Prototype getPrototype(String prototypeIndex)
            throws Exception {
        Prototype prototype = map.get(prototypeIndex);
        if (prototype == null) {
            throw new Exception("该原型实例不存在！");
        }
        return prototype;
    }

}

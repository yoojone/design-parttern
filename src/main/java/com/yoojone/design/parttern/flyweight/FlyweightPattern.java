package com.yoojone.design.parttern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuqiang.zhang
 * @date 2021/9/14
 * description: 享元模式
 */
public class FlyweightPattern {

    public static void main(String[] args) {
        Flyweight flyweight = FlyweightFactory.get("对象1");

        flyweight.execute();
        Flyweight flyweight2 = FlyweightFactory.get("对象1");
        flyweight2.execute();

        System.out.println(flyweight == flyweight2);

        /**
         *  享元
         *  享受，元数据
         *  同一个数据，就认为是一个元数据，整个系统这个数据就一份，缓存起来
         *  整个系统对这个数据，全部享受这一个对象实例即可
         *
         *
         *  直接基于内存，实现缓存
         */
    }


    public static interface Flyweight {
        void execute();

        String getName();

        void setName(String name);
    }

    public static class ConcreteFlyweight implements Flyweight {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ConcreteFlyweight(String name) {
            this.name = name;
        }

        @Override
        public void execute() {
            System.out.println(name + "执行此功能");
        }

    }

    public static class FlyweightFactory {

        public static Map<String, Flyweight> cachePool = new HashMap<>();

        /*public void put(Flyweight flyweight) {
            ca
        }*/

        public static Flyweight get(String name) {

            Flyweight flyweight = cachePool.get(name);
            if (flyweight == null) {
                flyweight = new ConcreteFlyweight(name);
                cachePool.put(name, flyweight);
            }
            return flyweight;
        }
    }
}

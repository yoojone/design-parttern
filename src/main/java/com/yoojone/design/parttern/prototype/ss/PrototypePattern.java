package com.yoojone.design.parttern.prototype.ss;

import java.io.*;

/**
 * @author yuqiang.zhang
 * @date 2021/9/12
 * description: 石杉老师 原型模式
 * 自己实现自己的对象拷贝逻辑
 */
public class PrototypePattern {

    // 原型模式 就是在要拷贝的类 实现一个clone()方法，自己拷贝自己
    // 分为 浅拷贝 深拷贝

    //很多地方要克隆这个对象，不要自己维护克隆的逻辑，即使逻辑变了，只要在clone()方法里修改就行

    public static void main(String[] args) throws CloneNotSupportedException {
        Product product = new Product("产品", new Component("产品组件"));

        Product copyProduct = (Product) product.clone();

        System.out.println(copyProduct);
    }



    public static class Component implements Serializable {
        private String name;

        public Component(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Component{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new Component(getName());
        }
    }

    public static class Product implements Serializable {

        private String name;

        private Component component;

        public Product(String name, Component component) {
            this.name = name;
            this.component = component;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Component getComponent() {
            return component;
        }

        public void setComponent(Component component) {
            this.component = component;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", component=" + component +
                    '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            //浅拷贝，就是简单地 对当前所有的变量 进行一个拷贝

            //return new Product(getName(), getComponent());

            // 深拷贝，递归对自己引用的对象也进行拷贝
            // 有个问题，我们不知道引用对象 有多少自己的引用对象，递归问题
            //return new Product(getName(), (Component)getComponent().clone());


            // 将对象写到流里, 所有用到的类 都要实现序列化方法
            try {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                oos.writeObject(this);

                // 从流里读回来
                ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bis);
                return ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}

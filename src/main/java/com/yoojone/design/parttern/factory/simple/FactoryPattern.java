package com.yoojone.design.parttern.factory;

/**
 * @author yuqiang.zhang
 * @date 2021/9/11
 * description: 简单工厂模式
 *
 * 面向接口，实现类 在工厂里面选择
 * 调用方通过工厂获取 实现类，当实现类修改时， 调用方代码不用做修改
 *
 * spring ioc 就是 工厂模式
 */
public class FactoryPattern {

    public static void main(String[] args) {
        Product product = ProductFactory.create();
        product.execute();
    }


    public interface Product {
        void execute();
    }

    public static class Product1Impl implements Product{

        @Override
        public void execute() {
            System.out.println("产品1的功能实现");
        }
    }

    public static class Product2Impl implements Product{

        @Override
        public void execute() {
            System.out.println("产品2的功能实现");
        }
    }

    public static class ProductFactory {

        public static Product create() {

            //return new Product1Impl();
            return new Product2Impl();
        }
    }
}

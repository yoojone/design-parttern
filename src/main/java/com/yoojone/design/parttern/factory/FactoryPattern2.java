package com.yoojone.design.parttern.factory;

/**
 * @author yuqiang.zhang
 * @date 2021/9/11
 * description:
 */
public class FactoryPattern2 {

    public static void main(String[] args) {
        Product p1 = Product1Factory.get().create();

        Product p2 = Product2Factory.get().create();

        Product p3 = Product3Factory.get().create();

        p1.execute();
        p2.execute();
        p3.execute();
    }



    public interface Product {
        void execute();
    }

    public static class Product1 implements Product {
        @Override
        public void execute() {
            System.out.println("产品1");
        }
    }

    public static class Product2 implements Product {
        @Override
        public void execute() {
            System.out.println("产品2");
        }
    }

    public static class Product3 implements Product {
        @Override
        public void execute() {
            System.out.println("产品3");
        }
    }

    public abstract static class AbstractProductFactory {

        public Product create () {
            commonCreate();
            return specficCreate();
        }

        public void commonCreate() {
            System.out.println("生产产品的通用逻辑,11");
        }

        protected abstract Product specficCreate();

    }

    public static class Product1Factory extends AbstractProductFactory{

        public final static Product1Factory product1Factory = new Product1Factory();

        public static Product1Factory get() {
            return product1Factory;
        }

        public Product specficCreate() {
            System.out.println("生产产品1的特殊逻辑");
            return new Product1();
        }
    }

    public static class Product2Factory extends AbstractProductFactory{
        public final static Product2Factory product2Factory = new Product2Factory();

        public static Product2Factory get() {
            return product2Factory;
        }

        public Product specficCreate() {
            System.out.println("生产产品2的特殊逻辑");
            return new Product2();
        }
    }

    public static class Product3Factory extends AbstractProductFactory{

        public final static Product3Factory product3Factory = new Product3Factory();

        public static Product3Factory get() {
            return product3Factory;
        }

        public Product specficCreate() {
            System.out.println("生产产品3的特殊逻辑");
            return new Product3();
        }
    }
}

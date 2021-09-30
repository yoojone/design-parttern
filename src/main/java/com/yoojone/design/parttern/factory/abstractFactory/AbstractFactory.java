package com.yoojone.design.parttern.factory.abstractFactory;

/**
 * @author yuqiang.zhang
 * @date 2021/9/12
 * description: 抽象工厂
 */
public class AbstractFactory {

    public static void main(String[] args) {

        // A1 + B1 --> A1 + B3, 调用方不需要修改代码，只需要在工厂里面修改就行
        Product productA1 = Factory1.get().createProductA();
        Product productB1 = Factory1.get().createProductB();
        productA1.execute();
        productB1.execute();

        // A2 + B2
        Product productA2 = Factory2.get().createProductA();
        Product productB2 = Factory2.get().createProductB();
        productA2.execute();
        productB2.execute();


        // A3 + B3
        Product productA3 = Factory3.get().createProductA();
        Product productB3 = Factory3.get().createProductB();
        productA3.execute();
        productB3.execute();

    }



    public interface Product {
        void execute();
    }

    public static class ProductA1 implements Product {
        @Override
        public void execute() {
            System.out.println("产品A1");
        }
    }

    public static class ProductA2 implements Product {
        @Override
        public void execute() {
            System.out.println("产品A2");
        }
    }

    public static class ProductA3 implements Product {
        @Override
        public void execute() {
            System.out.println("产品A3");
        }
    }



    public static class ProductB1 implements Product {
        @Override
        public void execute() {
            System.out.println("产品B1");
        }
    }

    public static class ProductB2 implements Product {
        @Override
        public void execute() {
            System.out.println("产品B2");
        }
    }

    public static class ProductB3 implements Product {
        @Override
        public void execute() {
            System.out.println("产品B3");
        }
    }




    /**
     * 定义抽象工厂
     */
    public interface Factory {

        Product createProductA();

        Product createProductB();
    }

    /**
     * 具体的工厂组合 实现
     */
    public static class Factory1 implements Factory {

        private final static Factory1 factory1 = new Factory1();

        public static Factory1 get() {
            return factory1;
        }
        private Factory1() {

        }

        @Override
        public Product createProductA() {
            return new ProductA1();
        }

        @Override
        public Product createProductB() {
            //return new ProductB1();
            return new ProductB3();
        }
    }

    public static class Factory2 implements Factory {

        private final static Factory2 factory2 = new Factory2();

        public static Factory2 get() {
            return factory2;
        }
        private Factory2() {

        }

        @Override
        public Product createProductA() {
            return new ProductA2();
        }

        @Override
        public Product createProductB() {
            return new ProductB2();
        }
    }

    public static class Factory3 implements Factory {

        private final static Factory3 factory3 = new Factory3();

        public static Factory3 get() {
            return factory3;
        }
        private Factory3() {

        }

        @Override
        public Product createProductA() {
            return new ProductA3();
        }

        @Override
        public Product createProductB() {
            return new ProductB3();
        }
    }
}

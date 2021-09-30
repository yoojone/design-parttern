package com.yoojone.design.parttern.factory.abstractFactory;

/**
 * @author yuqiang.zhang
 * @date 2021/9/12
 * description: 没有抽象工厂模式
 */
public class NonAbstractFactory {

    public static void main(String[] args) {
        //生产 产品 组合
        //pA1 + pB1  -> 组合方式变了，变成 A1 + B3
        // 问题 调用方 就需要修改 工厂调用的代码 B1Factory -> B3Factory
        /*Product productA1 = ProductA1Factory.get().create();
        Product productB1 = ProductB1Factory.get().create();

        productA1.execute();
        productB1.execute();*/

        Product productA1 = ProductA1Factory.get().create();
        Product productB3 = ProductB3Factory.get().create();

        productA1.execute();
        productB3.execute();


        //pA2 + pB2
        Product productA2 = ProductA2Factory.get().create();
        Product productB2 = ProductB2Factory.get().create();

        productA2.execute();
        productB2.execute();

        //pA3 + pB3
        /*Product productA3 = ProductA3Factory.get().create();
        Product productB3 = ProductB3Factory.get().create();
        productA3.execute();
        productB3.execute();*/
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

    public static class ProductA1Factory {

        public final static ProductA1Factory productA1Factory = new ProductA1Factory();

        public static ProductA1Factory get() {
            return productA1Factory;
        }

        public static Product create() {
            return new ProductA1();
        }
    }

    public static class ProductA2Factory {

        public final static ProductA2Factory product2Factory = new ProductA2Factory();

        public static ProductA2Factory get() {
            return product2Factory;
        }

        public static Product create() {
            return new ProductA2();
        }
    }

    public static class ProductA3Factory {

        public final static ProductA3Factory product3Factory = new ProductA3Factory();

        public static ProductA3Factory get() {
            return product3Factory;
        }

        public static Product create() {
            return new ProductA3();
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

    public static class ProductB1Factory {

        public final static ProductB1Factory productB1Factory = new ProductB1Factory();

        public static ProductB1Factory get() {
            return productB1Factory;
        }

        public static Product create() {
            return new ProductB1();
        }
    }

    public static class ProductB2Factory {

        public final static ProductB2Factory product2Factory = new ProductB2Factory();

        public static ProductB2Factory get() {
            return product2Factory;
        }

        public static Product create() {
            return new ProductB2();
        }
    }

    public static class ProductB3Factory {

        public final static ProductB3Factory product3Factory = new ProductB3Factory();

        public static ProductB3Factory get() {
            return product3Factory;
        }

        public static Product create() {
            return new ProductB3();
        }
    }
}

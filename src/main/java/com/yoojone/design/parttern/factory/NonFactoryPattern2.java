package com.yoojone.design.parttern.factory;

/**
 * @author yuqiang.zhang
 * @date 2021/9/11
 * description: 工厂模式
 *
 */
public class NonFactoryPattern2 {

    public static void main(String[] args) {
        Product p1 = Product1Factory.create();

        Product p2 = Product2Factory.create();

        Product p3 = Product3Factory.create();

        p1.execute();
        p1.execute();
        p1.execute();
    }

    /**
     * 多个工厂类中，有生成产品的相同逻辑，没有抽取出来，直接复制粘贴到 多个工厂里面了
     *
     * 如果那段通用逻辑，需要修改，所有的工厂都要去修改 这块代码
     *
     */

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

    public static class Product1Factory {
        public static Product create() {
            System.out.println("生产产品的通用逻辑");
            System.out.println("生产产品1的特殊逻辑");
            return new Product1();
        }
    }

    public static class Product2Factory {
        public static Product create() {
            System.out.println("生产产品的通用逻辑");
            System.out.println("生产产品2的特殊逻辑");
            return new Product2();
        }
    }

    public static class Product3Factory {
        public static Product create() {
            System.out.println("生产产品的通用逻辑");
            System.out.println("生产产品3的特殊逻辑");
            return new Product3();
        }
    }

}

package com.yoojone.design.parttern.factory;

/**
 * @author yuqiang.zhang
 * @date 2021/9/11
 * description: 没有工厂模式
 */
public class NonFactoryPattern {

    public static void main(String[] args) {
        Product product = new Product("p1");

        System.out.println(product);
    }

    /**
     * 有什么问题
     * 直接秒面向一个类来编程,new来创建类的实例的话，你就是后面会死的很惨
     * 如果对Product 要更换一个类，换一个类的实现
     * 此时就必须在这个 类实例的地方，都要修改这个代码，改动很大
     *
     * 如果实例过程 放在工厂里面，实例类的变化，只需要在工厂里面修改就可以了
     *
     *
     *
     */



    public static class Product {
        private String name;

        public Product(String name) {
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
            return "Product{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}

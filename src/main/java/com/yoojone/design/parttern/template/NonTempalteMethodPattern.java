package com.yoojone.design.parttern.template;

/**
 * @author yuqiang.zhang
 * @date 2021/9/11
 * description: 没有模板方法 设计模式
 */
public class NonTempalteMethodPattern {


    public static void main(String[] args) {

        DiscountCalculator1 discountCalculator1 = new DiscountCalculator1();
        discountCalculator1.calculator();

        DiscountCalculator2 discountCalculator2 = new DiscountCalculator2();
        discountCalculator2.calculator();

        DiscountCalculator3 discountCalculator3 = new DiscountCalculator3();
        discountCalculator3.calculator();
    }

    /**
     * 有一个问题
     * 三个优惠方式中，都有一个通用的计算逻辑，是完全相同的代码
     * 但是相同的代码，是通过复制粘贴的方式，放到不同的类里
     * 一旦说，那段通过计算逻辑，要修改，就设计多个类 都要去修改这块通用逻辑
     * 如果某个类 忘了修改，后果难顶，
     * 而且到了后期，没人记得那些通过逻辑代码放到了 哪些类中，如果要排查，就需要将很多类读一下
     * 这就是垃圾代码，扩展性，维护性 垃圾
     */

    public static class DiscountCalculator1{

        public void calculator() {
            System.out.println("通用计算逻辑");
            System.out.println("优惠计算器1的逻辑");
        }

    }

    public static class DiscountCalculator2{

        public void calculator() {
            System.out.println("通用计算逻辑");
            System.out.println("优惠计算器2的逻辑");
        }

    }

    public static class DiscountCalculator3{

        public void calculator() {
            System.out.println("通用计算逻辑");
            System.out.println("优惠计算器3的逻辑");
        }

    }
}

package com.yoojone.design.parttern.strategy;

/**
 * @author yuqiang.zhang
 * @date 2021/9/13
 * description: 没有策略模式
 */
public class NonStrategyPattern {

    public static void main(String[] args) {
        /**
         * 有一个参数，是discountStyle
         * 如果参数=1，是一种优惠方式
         * 如果参数=2，就是一种优惠方式
         * 如果参数=3，就是一种优惠方式
         */

        int discountStyle = 1;

        if (discountStyle == 1) {
            System.out.println("执行优惠计价1的逻辑");
        } else if (discountStyle == 2) {
            System.out.println("执行优惠计价2的逻辑");
        } else if (discountStyle == 3) {
            System.out.println("执行优惠计价3的逻辑");
        } else {
            System.out.println("执行默认的计价逻辑");
        }
        /**
         * 实际上我们的业务代码，if else 看起来不是这么短，这么简单的
         * if , else if判断条件，很模糊，一年以后，条件判断太多了
         *
         */
    }
}

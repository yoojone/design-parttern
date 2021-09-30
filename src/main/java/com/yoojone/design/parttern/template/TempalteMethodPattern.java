package com.yoojone.design.parttern.template;

/**
 * @author yuqiang.zhang
 * @date 2021/9/11
 * description: 模板方法 设计模式
 *
 * 最高频设计模式，
 * 在任何一个系统中，一定会出现 多个类中都有相同的代码，此时就可以使用模板方法设计模式
 * 就可以将多个类中通用的逻辑 抽取到一个父类中， 特殊的逻辑在子类中实现
 */
public class TempalteMethodPattern {

    public static void main(String[] args) {
        DiscountCalculator calculator1 = new DiscountCalculator1();
        calculator1.calculate();

        DiscountCalculator calculator2 = new DiscountCalculator2();
        calculator2.calculate();

        DiscountCalculator calculator3 = new DiscountCalculator3();
        calculator3.calculate();
    }


    public interface DiscountCalculator {
        void calculate();
    }

    public static abstract class AbstractDiscountCalculator implements DiscountCalculator {

        @Override
        public void calculate() {
            //通用计算逻辑
            commonCalculate();

            //特殊计算逻辑
            specificCalculate();
        }

        private void commonCalculate() {
            System.out.println("通用计算逻辑,修改了");
        }


        protected abstract void specificCalculate();
    }

    public static class DiscountCalculator1 extends AbstractDiscountCalculator {

        public void specificCalculate() {
            System.out.println("优惠计算器1的逻辑");
        }

    }

    public static class DiscountCalculator2 extends AbstractDiscountCalculator {

        public void specificCalculate() {
            System.out.println("优惠计算器2的逻辑");
        }

    }

    public static class DiscountCalculator3 extends AbstractDiscountCalculator {

        public void specificCalculate() {
            System.out.println("优惠计算器3的逻辑");
        }

    }
}

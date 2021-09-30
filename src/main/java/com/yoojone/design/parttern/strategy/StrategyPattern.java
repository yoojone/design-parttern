package com.yoojone.design.parttern.strategy;

/**
 * @author yuqiang.zhang
 * @date 2021/9/13
 * description: 策略模式
 * 替换掉屎一样的if else语句
 *
 * 策略模式，将会成为最最高频使用的一种设计模式，他的常见应用场景，就是替换掉那一大坨复杂难懂的if else if else。
 * 对于那种过于复杂的选择判断逻辑，完全可以将选择哪种策略的过程放到工厂里去。工厂，可以是简单工厂，也可以是工厂方法，
 * 也可以是抽象工厂。
 *
 * 我们这里打算用抽象工厂模式，跟策略模式结合起来，大家可以想象一下复杂的场景，一个复杂的业务逻辑里面，
 * 每个if else判断之后，要跟一堆复杂的业务逻辑，我们可以将不同的业务逻辑抽取成不同的策略，然后一个具体的工厂实现，
 * 可以创建出一个策略组合来。
 */
public class StrategyPattern {

    public static void main(String[] args) {

        int discountStyle = 2;
        DiscountCalculateStrategy discountCalculateStrategy = DiscountCalculateStrategyFactory
                .getDiscountCalculateStrategy(discountStyle);

        Context context = new Context();
        context.setDiscountCalculateStrategy(discountCalculateStrategy);

        context.calculator();
    }

    /**
     * 1.必须将 if  else的代码 封装到不同的策略类中
     * 2.将选择哪种策略的逻辑给放到工厂类中，选择策略的代码务必简洁
     * 3.context 可有可无，具体的代码调用只有一行，就不需要context
     */


    public interface DiscountCalculateStrategy {

        void calculate();
    }

    public static class DiscountCalculateStrategyA implements DiscountCalculateStrategy{

        @Override
        public void calculate() {
            System.out.println("执行优惠计价方式1的逻辑");
        }
    }
    public static class DiscountCalculateStrategyB implements DiscountCalculateStrategy{

        @Override
        public void calculate() {
            System.out.println("执行优惠计价方式2的逻辑");
        }
    }

    public static class DiscountCalculateStrategyC implements DiscountCalculateStrategy{

        @Override
        public void calculate() {
            System.out.println("执行优惠计价方式3的逻辑");
        }
    }

    public static class DiscountCalculateStrategyDefault implements DiscountCalculateStrategy{

        @Override
        public void calculate() {
            System.out.println("执行优惠计价方式 默认的逻辑");
        }
    }

    public static class DiscountCalculateStrategyFactory {

        public static DiscountCalculateStrategy getDiscountCalculateStrategy(int discountStyle) {

            if (discountStyle == 1) {
                return new DiscountCalculateStrategyA();
            } else if (discountStyle == 2) {
                return new DiscountCalculateStrategyB();
            } else if (discountStyle == 3) {
                return new DiscountCalculateStrategyC();
            } else {
                return new DiscountCalculateStrategyDefault();
            }
        }
    }

    public  static class Context {

        private DiscountCalculateStrategy discountCalculateStrategy;

        public DiscountCalculateStrategy getDiscountCalculateStrategy() {
            return discountCalculateStrategy;
        }

        public void setDiscountCalculateStrategy(DiscountCalculateStrategy discountCalculateStrategy) {
            this.discountCalculateStrategy = discountCalculateStrategy;
        }

        public void calculator() {
            discountCalculateStrategy.calculate();
        }
    }

}

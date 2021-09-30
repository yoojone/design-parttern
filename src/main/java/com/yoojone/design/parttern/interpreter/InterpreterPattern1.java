package com.yoojone.design.parttern.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuqiang.zhang
 * @date 2021/9/16
 * description:
 */
public class InterpreterPattern1 {

    //抽象表达式, 声明解释操作
    public static abstract class AbstractExpression {

        //每个表达式都必须有一个解释操作
        public abstract Integer interpret(Map<String, Integer> var);
    }

    //终结符表达式，代表参加运算的元素对象
    public static class VarExpression extends AbstractExpression {

        private String key;

        public VarExpression(String key) {
            this.key = key;
        }

        @Override
        public Integer interpret(Map<String, Integer> var) {

            return var.get(key);
        }
    }

    //非终结符表达式 (此处为加法 和 减法)的抽象父类，真正的解释操作由其子类实现
    public static abstract class SymbolExpression extends AbstractExpression {

        protected AbstractExpression left;

        protected AbstractExpression right;

        // 非终结符表达式的解释操作只关心自己左右两个表达式的结果
        public SymbolExpression(AbstractExpression left, AbstractExpression right) {
            this.left = left;
            this.right = right;
        }
    }

    //加法表达式
    public static class AddExpression extends SymbolExpression {
        public AddExpression(AbstractExpression left, AbstractExpression right) {
            super(left, right);
        }

        @Override
        public Integer interpret(Map<String, Integer> var) {
            //把左右两个表达式运算的结果加起来
            return super.left.interpret(var) + super.right.interpret(var);
        }
    }
    /**
     * 减法表达式
     */
    public static class SubExpression extends SymbolExpression {

        public SubExpression(AbstractExpression left, AbstractExpression right) {
            super(left, right);
        }

        // 左右两个表达式相减
        @Override
        public Integer interpret(Map<String, Integer> var) {
            return super.left.interpret(var) - super.right.interpret(var);
        }
    }



    // 上下文，包含解释器之外的一些全局信息
    public class Context {

    }
}

package com.yoojone.design.parttern.interpreter;

/**
 * @author yuqiang.zhang
 * @date 2021/9/16
 * description:
 * 解释器模式
 */
public class InterpreterPattern {

    //使用解释器的客户端
    // 主要按照语法规则对特定的句子构建抽象语法树
    public static void main(String[] args) {

    }


    //抽象表达式
    public static abstract class AbstractExpression {

        //解释的操作
        public abstract void interpret(Context ctx);
    }

    //终结表达式
    public static class TerminalExpression extends AbstractExpression {

        @Override
        public void interpret(Context ctx) {
            //实现与语法规则中的终结符相关联的解释操作
        }
    }

    //非终结表达式
    public static class NonTerminalExpression extends AbstractExpression {

        @Override
        public void interpret(Context ctx) {
            //实现 与语法规则中的非终结符相关联的操作
        }
    }


    // 上下文，包含解释器之外的一些全局信息
    public class Context {

    }
}

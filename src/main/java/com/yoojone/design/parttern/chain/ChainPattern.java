package com.yoojone.design.parttern.chain;

/**
 * @author yuqiang.zhang
 * @date 2021/9/15
 * description:
 *  责任链模式
 *
 *  1.将一个业务流程的多个步骤拆分开来，每个步骤封装到一个handler处理器中
 *  2.支持业务流程基于handler动态组装，不同业务的流程 -> handler代表的代码组件可以复用
 *
 *  好处:
 *  1. 将代码封装到一个handler中，后面如果要对某个步骤的代码逻辑调整，修改一个handler即可
 *  2. 如果业务流程修改，不需要拷贝大量的代码，只要基于handler动态组装 业务流程即可
 *
 *  面向场景:
 *      就是多个业务流程，这些业务流程之间有相同的代码和步骤，只不过步骤不同
 *      可以用责任链模式
 */
public class ChainPattern {


    public static void main(String[] args) {

        //业务流程1 执行 1,2,3
        Handler thirdHandler = new Handler3(null);

        Handler secondHandler = new Handler2(thirdHandler);

        Handler firstHandler = new Handler1(secondHandler);

        firstHandler.execute();

        //业务流程2 执行 2,1,3
        thirdHandler = new Handler3(null);
        firstHandler = new Handler1(thirdHandler);
        secondHandler = new Handler2(firstHandler);
        secondHandler.execute();

        //3,1,2
        secondHandler = new Handler2(null);
        firstHandler = new Handler1(secondHandler);

        thirdHandler = new Handler3(firstHandler);

        thirdHandler.execute();
    }

    public static abstract class Handler {

        protected Handler successor;

        public Handler(Handler successor) {
            this.successor = successor;
        }

        public abstract void execute();
    }

    public static class Handler1 extends Handler {

        public Handler1(Handler successor) {
            super(successor);
        }

        @Override
        public void execute() {
            System.out.println("执行功能1");

            if (successor != null) {
                successor.execute();
            }
        }
    }

    public static class Handler2 extends Handler {


        public Handler2(Handler successor) {
            super(successor);
        }

        @Override
        public void execute() {
            System.out.println("执行功能2");
            if (successor != null) {
                successor.execute();
            }
        }
    }

    public static class Handler3 extends Handler {
        public Handler3(Handler successor) {
            super(successor);
        }

        @Override
        public void execute() {
            System.out.println("执行功能3");
            if (successor != null) {
                successor.execute();
            }
        }
    }
}

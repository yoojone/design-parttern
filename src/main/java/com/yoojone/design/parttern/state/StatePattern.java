package com.yoojone.design.parttern.state;

/**
 * @author yuqiang.zhang
 * @date 2021/9/14
 * description: 状态模式
 * 封装数据的状态流转逻辑
 */
public class StatePattern {

    /**
     * 适合场景：数据有状态，状态也一定会扭转，从状态1 变成状态2
     * 将不同的状态要执行的代码逻辑封装在不同的state类中
     * 有一个context类，负责根据传入的参数，决定将数据的状态扭转到什么状态
     * 同时负责执行那个新状态的代码
     *
     * 适合场景: 只要有状态，都按照标准的状态模式来实现，改进
     * 不同的状态逻辑放不同的state
     *
     * 有一个类负责状态之间的流转及状态逻辑的执行
     *
     *
     * 而不是说 if开始执行那个状态的逻辑，else if 开始另外一个，shi一样的代码
     * 代码很清晰，可读性好，可维护性好
     */

    public static void main(String[] args) {

        Context context = new Context(new NewState());

        context.execute(2);

        context.execute(3);

        context.execute(4);
    }

    public static class Context {
        private State state;

        public Context(State state) {
            this.state = state;
        }

        public void execute(int stateType) {
            if (stateType == 1) {
                this.state = new NewState();
            } else if (stateType == 2) {
                this.state = new ApprovingState();
            } else if (stateType == 3) {
                this.state = new ApprovedState();
            } else if (stateType == 4) {
                this.state = new FinshedState();
            }
            this.state.execute();
        }
    }

    public interface State {
        void execute();
    }

    public static class NewState implements State {
        @Override
        public void execute() {
            System.out.println("新建");
        }
    }

    public static class ApprovingState implements State {
        @Override
        public void execute() {
            System.out.println("待审批");
        }
    }

    public static class ApprovedState implements State {
        @Override
        public void execute() {
            System.out.println("已审批");
        }
    }

    public static class FinshedState implements State {
        @Override
        public void execute() {
            System.out.println("已完成");
        }
    }
}

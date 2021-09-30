package com.yoojone.design.parttern.command;

/**
 * @author yuqiang.zhang
 * @date 2021/9/12
 * description: 命令模式
 * 给其他模块下达命令
 */
public class CommandPattern {

    public static void main(String[] args) {
        CommandA commandA = new CommandA();

        CommandB commandB = new CommandB();

        Invoker invoker = new Invoker();
        invoker.setCommand(commandA);
        invoker.execute();

        invoker.setCommand(commandB);
        invoker.execute();
    }

    public interface Command {

        void execute();
    }

    public static class CommandA implements Command {

        @Override
        public void execute() {
            System.out.println("命令A的逻辑");
        }
    }

    public static class CommandB implements Command {
        @Override
        public void execute() {
            System.out.println("命令B的逻辑");
        }
    }

    public static class Invoker {
        private Command command;

        public Invoker() {
            System.out.println();
        }

        public void setCommand(Command command) {
            this.command = command;
        }

        public void execute() {
            command.execute();
        }
    }
}

package com.yoojone.design.parttern.facade;

/**
 * @author yuqiang.zhang
 * @date 2021/9/12
 * description: 没有使用 外观模式
 */
public class NonFacadePattern {


    public static void main(String[] args) {
        //假设 这里是系统B， 要基于系统A 的3个模板的功能 完成一个业务逻辑

        ModuleA moduleA = new ModuleA();
        ModuleB moduleB = new ModuleB();
        ModuleC moduleC = new ModuleC();

        moduleA.execute();
        moduleB.execute();
        moduleC.execute();

        /**
         * 问题：
         * 1：对于子系统1，维护成本太高了，要care 系统2的使用，如果3个模块还凑合，若是20个模块？就需要系统1，
         * 对系统2了解很多
         * 2.这么多模块组成的功能，如果在系统2，多个地方使用了，那么那段代码 就会在多个地方有重复
         * 复制粘贴，逻辑一旦改变，就需要将改动所有的代码
         */
    }

    public static class ModuleA {
        public void execute() {
            System.out.println("系统A 。。。");
        }
    }

    public static class ModuleB {
        public void execute() {
            System.out.println("系统B 。。。");
        }
    }

    public static class ModuleC {
        public void execute() {
            System.out.println("系统C 。。。");
        }
    }
}

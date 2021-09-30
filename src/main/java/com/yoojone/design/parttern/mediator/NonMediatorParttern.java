package com.yoojone.design.parttern.mediator;

/**
 * @author yuqiang.zhang
 * @date 2021/9/12
 * description: 没有中介者模式
 *
 */
public class NonMediatorParttern {


    /**
     * （1）三个模块
     * （2）模块1调用模块2和模块3；模块2要调用模块1和模块3；模块3要调用模块1和模块2
     */

    public static void main(String[] args) {
        ModuleA moduleA = new ModuleA();
        ModuleB moduleB = new ModuleB();
        ModuleC moduleC = new ModuleC();

        moduleA.execute();
        moduleB.execute();
        moduleC.execute();

        /**
         * 模块之间有非常高强度的 耦合
         * 如果模块B 修改了代码，可能会影响模块A 和 模块B
         */


    }

    public static class ModuleA {


        public void execute() {
            ModuleB moduleB = new ModuleB();
            ModuleC moduleC = new ModuleC();

            moduleB.execute("模块A");
            moduleC.execute("模块A");
        }
        public void execute(String invoker) {

            System.out.println(invoker + " 调用模块A 。。。");

        }
    }

    public static class ModuleB {

        public void execute() {
            ModuleA moduleA = new ModuleA();
            ModuleC moduleC = new ModuleC();

            moduleA.execute("模块B");
            moduleC.execute("模块B");
        }

        public void execute(String invoker) {

            System.out.println(invoker + "调用模块B 。。。");


        }
    }

    public static class ModuleC {

        public void execute() {
            ModuleA moduleA = new ModuleA();
            ModuleB moduleB = new ModuleB();

            moduleA.execute("模块C");
            moduleB.execute("模块C");
        }

        public void execute(String invoker) {

            System.out.println(invoker + "调用模块C 。。。");


        }
    }
}

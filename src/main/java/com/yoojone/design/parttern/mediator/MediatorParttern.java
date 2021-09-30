package com.yoojone.design.parttern.mediator;

/**
 * @author yuqiang.zhang
 * @date 2021/9/12
 * description: 中介者模式
 * 让互相调用的模块之间解耦合
 */
public class MediatorParttern {


    public static void main(String[] args) {
        Mediator mediator = new Mediator();

        ModuleA moduleA = new ModuleA(mediator);
        ModuleC moduleC = new ModuleC(mediator);
        ModuleB moduleB = new ModuleB(mediator);

        moduleA.execute();
        moduleB.execute();
        moduleC.execute();

        /**
         * 好处:
         * module A 只要知道中介者就可以了，具体跟其他模块的交互都封装在 中介中里了
         * moduel B， C一样
         *
         * module A, B, C 不再由任何的耦合，不再有复杂的交互关系，互相之间修改 不会对对方有任何影响
         *
         *
         */
    }


    public static class Mediator {

        private ModuleA moduleA;

        private ModuleB moduleB;

        private ModuleC moduleC;

        public ModuleA getModuleA() {
            return moduleA;
        }

        public void setModuleA(ModuleA moduleA) {
            this.moduleA = moduleA;
        }

        public ModuleB getModuleB() {
            return moduleB;
        }

        public void setModuleB(ModuleB moduleB) {
            this.moduleB = moduleB;
        }

        public ModuleC getModuleC() {
            return moduleC;
        }

        public void setModuleC(ModuleC moduleC) {
            this.moduleC = moduleC;
        }

        public void moduleAInvoke() {
            moduleB.execute("模块A 通知中介者");
            moduleC.execute("模块A 通知中介者");
        }

        public void moduleBInvoke() {
            moduleA.execute("模块B 通知中介者");
            moduleC.execute("模块B 通知中介者");
        }

        public void moduleCInvoke() {
            moduleA.execute("模块C 通知中介者");
            moduleB.execute("模块C 通知中介者");
        }
    }

    public static class ModuleA {

        private Mediator mediator;

        public ModuleA(Mediator mediator) {
            this.mediator = mediator;
            mediator.setModuleA(this);
        }

        public void execute() {
            mediator.moduleAInvoke();
        }
        public void execute(String invoker) {

            System.out.println(invoker + " 调用模块A 。。。");

        }
    }

    public static class ModuleB {

        private Mediator mediator;

        public ModuleB(Mediator mediator) {
            this.mediator = mediator;
            mediator.setModuleB(this);
        }
        public void execute() {
            mediator.moduleBInvoke();
        }

        public void execute(String invoker) {

            System.out.println(invoker + "调用模块B 。。。");


        }
    }

    public static class ModuleC {

        private Mediator mediator;

        public ModuleC(Mediator mediator) {
            this.mediator = mediator;
            mediator.setModuleC(this);
        }
        public void execute() {
            mediator.moduleCInvoke();
        }

        public void execute(String invoker) {

            System.out.println(invoker + "调用模块C 。。。");


        }
    }
}

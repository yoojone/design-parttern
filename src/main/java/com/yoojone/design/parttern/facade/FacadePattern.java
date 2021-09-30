package com.yoojone.design.parttern.facade;

/**
 * @author yuqiang.zhang
 * @date 2021/9/12
 * description: 外观模式， (门面模式)
 *
 * service 就是门面模式
 * 如果一个子系统里有多个DAO组件，然后如果别的子系统要实现一段业务逻辑，需要使用这个子系统的多个DAO组件，
 * 那就会导致别的子系统代码会很乱，需要care这个子系统很多DAO组件的实现。
 * 但是这个组件可以基于多个DAO组件封装出来一个service接口，然后别的系统就针对一个service接口开发即可。
 * 这个service不就是一个典型的门面吗？
 */
public class FacadePattern {

    public static void main(String[] args) {
        //子系统2
        SystemFacade system = new SystemFacade();
        system.execute();

        /**
         * 好处:
         *  1.子系统2 不需要care系统1太多模块，只要care 一个门面类就行了
         *  2.如果多个地方调用这块逻辑，这块逻辑要修改，只需要在门面类一个地方修改就行了
         */
    }

    /**
     * 系统1的门面类
     */
    public static class SystemFacade {

        public void execute() {
            ModuleA moduleA = new ModuleA();
            ModuleB moduleB = new ModuleB();
            ModuleC moduleC = new ModuleC();

            moduleA.execute();
            moduleB.execute();
            moduleC.execute();
            System.out.println("新增逻辑");
        }
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

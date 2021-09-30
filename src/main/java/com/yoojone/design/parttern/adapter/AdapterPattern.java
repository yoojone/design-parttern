package com.yoojone.design.parttern.adapter;

/**
 * @author yuqiang.zhang
 * @date 2021/9/11
 * description: 适配器模式
 */
public class AdapterPattern {

    public static void main(String[] args) {

        NewInterface oldInterface = new NewInterfaceAdapter(new OldInterfaceImpl());
        NewInterface newInterface = new NewInterfaceImpl();
        oldInterface.newExecute();

        newInterface.newExecute();

        /**
         * 适配器模式
         * 手上有新老两个接口，和一个老接口的实现类
         *
         * 现在系统要向新接口来开发，老接口的实现类就不能直接用了，不能直接面向老接口来开发
         *
         * 开发一个老接口到新接口的一个适配器
         * 适配器实现了新接口，但是适配器中持有老接口实现类 实例的引用
         * 适配器的新接口方法的实现，全部基于老接口实现类 的老方法实现
         * 对于调用方而言，只要使用适配器来开发即可，就可以通过新接口开发，底层使用老接口实现类
         */


    }

    /**
     * 定义一个适配器类
     */
    public static class NewInterfaceAdapter implements NewInterface {

        private OldInterface oldInterface;

        public NewInterfaceAdapter(OldInterface oldInterface) {
            this.oldInterface = oldInterface;
        }

        @Override
        public String newExecute() {
            return oldInterface.oldExecute();
        }
    }

    public static interface OldInterface {

        public String oldExecute();
    }

    public static class OldInterfaceImpl implements OldInterface {

        @Override
        public String oldExecute() {
            System.out.println("老版本");
            return null;
        }
    }


    public static interface NewInterface {

        public String newExecute();
    }

    public static class NewInterfaceImpl implements NewInterface {

        @Override
        public String newExecute() {
            System.out.println("新版本");
            return null;
        }
    }
}

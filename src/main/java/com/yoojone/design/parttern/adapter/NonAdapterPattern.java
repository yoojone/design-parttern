package com.yoojone.design.parttern.adapter;

/**
 * @author yuqiang.zhang
 * @date 2021/9/11
 * description: 适配器模式， 不适用
 */
public class NonAdapterPattern {

    public static void main(String[] args) {

        OldInterface oldInterface = new OldInterfaceImpl();

        NewInterface newInterface = new NewInterfaceImpl();

        oldInterface.oldExecute();
        newInterface.newExecute();

        /**
         * 问题： 新老两套接口，代码恶心，
         * 规范和风格不同，理解和维护成本提高了
         */
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

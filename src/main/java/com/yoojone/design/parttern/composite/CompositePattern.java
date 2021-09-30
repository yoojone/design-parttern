package com.yoojone.design.parttern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuqiang.zhang
 * @date 2021/9/13
 * description: 组合模式
 * 对层级数据递归调用执行操作
 */
public class CompositePattern {

    public static void main(String[] args) {

        Department leafDept1 = new Department("叶子部门1");
        Department leafDept2 = new Department("叶子部门2");

        Department leafDept3 = new Department("叶子部门3");


        Department subDept1 = new Department("子部门1");
        Department subDept2 = new Department("子部门2");

        subDept1.getChildren().add(leafDept1);
        subDept1.getChildren().add(leafDept2);

        subDept2.getChildren().add(leafDept3);

        Department parentDept = new Department("父部门");
        parentDept.getChildren().add(subDept1);
        parentDept.getChildren().add(subDept2);

        parentDept.remove();

        /**
         * 组合模式 第一要义: 就是数形结构的数据，用一个类，或者少数一两个类，就可以拼装成一棵树的形状
         * 第二要义：直接对父级的数据执行某个操作，这个操作会直接递归调用所有下层 的子数据的 相关操作
         * 通过树形结构自己递归自己的方式，就是将一棵树的操作，完美的执行了
         *
         * 好处: 对树形数据的操作，不需要调用方 组织复杂的代码 if for的代码
         * 去执行外部要操作，直接对树的父级节点，调用一个操作，这棵树就递归把事干完了
         *
         */
    }

    public static class Department {
        private String name;

        private List<Department> children = new ArrayList<>();

        public Department(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Department> getChildren() {
            return children;
        }

        public void setChildren(List<Department> children) {
            this.children = children;
        }

        public void remove() {


            if (children.size() > 0) {
                for (Department ded : children) {
                    ded.remove();
                }
            }
            System.out.println("删除部门 【" + name + "】");
        }

    }
}

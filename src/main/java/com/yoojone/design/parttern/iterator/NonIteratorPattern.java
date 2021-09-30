package com.yoojone.design.parttern.iterator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuqiang.zhang
 * @date 2021/9/11
 * description: 没有迭代器 设计模式的代码
 */
public class NonIteratorPattern {

    public static void main(String[] args) {
        Student s1 = new Student("s1");

        Student s2 = new Student("s2");

        /*Student[] students = new Student[] {s1, s2};


        ClassRoom classRoom = new ClassRoom();

        classRoom.setStudents(students);


        Student[] roomStudents = classRoom.getStudents();

        for (Student roomStudent : roomStudents) {

            System.out.println(roomStudent);
        }*/

        Map<String, Student> students = new HashMap();
        students.put(s1.getName(), s1);
        students.put(s2.getName(), s2);

        ClassRoom classRoom = new ClassRoom();

        classRoom.setStudents(students);


        Map<String, Student> result = classRoom.getStudents();

        result.values().forEach(o -> System.out.println(o));
    }

    /**
     * 如果不用涉及模式，直接去遍历一个类中的集合
     * 一旦这个类中对集合的使用改版了，比如 数组 -> map
     * 迭代的代码就要改动
     * 如果代码和业务逻辑很复杂，同事集合类的实现和遍历代码的实现，是两个人开发的
     * 成本就很高了，
     * 简单说，可扩展，伸缩性很差
     *
     */

    /**
     * 学生类
     */
    public static class Student {

        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    /**
     * 教师类
     */
    public static class ClassRoom {

        /*private Student[] students;

        public Student[] getStudents() {
            return students;
        }

        public void setStudents(Student[] students) {
            this.students = students;
        }*/

        private Map<String, Student> students;

        public Map<String, Student> getStudents() {
            return students;
        }

        public void setStudents(Map<String, Student> students) {
            this.students = students;
        }
    }
}

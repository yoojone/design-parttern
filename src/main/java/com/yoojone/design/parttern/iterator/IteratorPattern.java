package com.yoojone.design.parttern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuqiang.zhang
 * @date 2021/9/11
 * description: 迭代器模式的实现
 *
 * 调用方直接调用 迭代器，迭代器里实现了 集合的具体操作，
 * 即使集合提供方 集合类型变了，他们也会修改 迭代器的实现方式，而调用方不需要关心迭代器的实现
 *
 * 迭代器也可以换成 collection 集合远程的Iterator
 */
public class IteratorPattern {

    public static void main(String[] args) {
        Student s1 = new Student("s1");

        Student s2 = new Student("s2");

        Classroom classroom = new Classroom(2);
        classroom.addStudent(s1);
        classroom.addStudent(s2);

        Iterator iterator = classroom.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    /**
     * 定义自己的迭代器接口
     */
    public static interface Iterator {

        public abstract boolean hasNext();
        public abstract Object next();
    }

    /**
     * 集合类
     */

    public interface Aggregate {

        public abstract Iterator iterator();
    }

    public static class Student {

        private String name;


        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    /**
     * 教室
     */
    public static class Classroom implements Aggregate {

        //private Student[] students;

        private List<Student> students;
        private int last = 0;

        /*public Classroom(int size) {
            this.students = new Student[size];
        }

        public Student getStudent(int index) {
            return students[index];
        }

        public void addStudent(Student student) {
            this.students[last] = student;
            last++;
        }*/

        public Classroom(int size) {
            this.students = new ArrayList<>(size);
        }

        public Student getStudent(int index) {
            return students.get(index);
        }

        public void addStudent(Student student) {
            this.students.add(student);
            last++;
        }

        public int getLength() {
            return last;
        }

        //返回教室迭代器，基于迭代器获取数据
        public Iterator iterator() {
            return new ClassroomIterator(this);
        }

    }
    /**
     * 教室迭代器
     */
    public static class ClassroomIterator implements Iterator {

        private Classroom classroom;
        private int index;

        public ClassroomIterator(Classroom classroom) {
            this.classroom = classroom;
            this.index = 0;
        }

        public boolean hasNext() {
            if(index < classroom.getLength()) {
                return true;
            } else {
                return false;
            }
        }

        public Object next() {
            Student student = classroom.getStudent(index);
            index++;
            return student;
        }

    }


}

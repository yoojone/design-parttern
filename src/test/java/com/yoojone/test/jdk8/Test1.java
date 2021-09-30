package com.yoojone.test.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuqiang.zhang
 * @date 2021/9/14
 * description:
 */
public class Test1 {


    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setAge(1);
        s1.setName("1");

        Student s2 = new Student();
        s2.setAge(2);
        s2.setName("2");

        Student s3 = new Student();
        s3.setAge(3);
        s3.setName("3");

        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        List<String> collect = list.stream()
                .filter(stu -> stu.getAge() == 1 || stu.getAge() == 2)
                .map(student -> {
                    return student.getName();
                })
                .filter(name -> name.equals("2"))
                .collect(Collectors.toList());


        System.out.println(collect);
    }


    public static class Student {

        private String name;

        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}

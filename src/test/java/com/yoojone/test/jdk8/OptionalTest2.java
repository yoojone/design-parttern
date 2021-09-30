package com.yoojone.test.jdk8;

import java.util.Optional;

/**
 * @author yuqiang.zhang
 * @date 2021/9/14
 * description:
 */
public class OptionalTest2 {

    public static void main(String[] args) {
        User user = new User("111");

        System.out.println(
                Optional.ofNullable(user)
                .map(u -> u.getName())
                .orElse("DE")
        );

    }


    public static class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

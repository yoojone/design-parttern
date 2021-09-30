package com.yoojone.design.parttern.builder;

/**
 * @author yoojone
 * @date 2021/8/13
 * description: 人员信息
 * 建造者/
 * 构造器模式，可以直接使用lombok 的@Builder注解
 */
public class PersonInfo {

    private String name;

    private Integer age;

    private String gender;

    private String address;

    private String phone;

    private String email;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public PersonInfo(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.gender = builder.gender;
        this.address = builder.address;
        this.phone = builder.phone;
        this.email = builder.email;
    }

    public static class Builder {

        private String name;

        private Integer age;

        private String gender;

        private String address;

        private String phone;

        private String email;

        public Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public PersonInfo build() {
            return new PersonInfo(this);
        }
    }


}

package com.hudp.spring.cglib;

public class TestCglib {

    public static void main(String[] args) {
        CglibTest cglibTest = new CglibTest();
        StudentService studentService = (StudentService) cglibTest.getProxy(StudentService.class);
        studentService.study();

    }
}

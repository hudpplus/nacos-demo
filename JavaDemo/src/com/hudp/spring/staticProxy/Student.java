package com.hudp.spring.staticProxy;

/**
 * 静态代理
 */
public class Student implements Person {

    private String name;

    public Student(String name){
        this.name=name;
    }

    @Override
    public void giveMoney() {
        System.out.println(this.name+ "上交班费50元");
    }


}

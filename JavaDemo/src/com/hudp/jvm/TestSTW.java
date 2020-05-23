package com.hudp.jvm;

import java.util.ArrayList;
import java.util.List;

public class TestSTW {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();
        long start = 0L;
        long end = 0L;
        long runtime = 0L;
        int count = 0;
        while(true) {
            start = System.currentTimeMillis();
            persons.add(new Person());
            count++;
            end = System.currentTimeMillis();
            runtime = end - start;
            System.out.println(count + " : Use time in one operation:" + runtime + "ms");
            start = end;
        }
    }

}
class Person{
    private String name;
    private String age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
}

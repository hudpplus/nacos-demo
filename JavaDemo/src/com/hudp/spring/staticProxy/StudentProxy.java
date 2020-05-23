package com.hudp.spring.staticProxy;

/**
 * 学生代理类，也实现了Person接口，保存一个学生实体，这样既可以代理学生产生行为
 * @author Gonjan
 *
 */
public class StudentProxy implements Person{

    //被代理的学生
    private Student stu;

    public StudentProxy(Person p){
        // 只代理学生对象
        if(p.getClass()==Student.class){
            this.stu= (Student) p;
        }
    }

    //代理上交班费，调用被代理学生的上交班费行为
    @Override
    public void giveMoney() {
        if(stu!=null)
            stu.giveMoney();
        else
            System.out.println("no object proxy");
    }
}

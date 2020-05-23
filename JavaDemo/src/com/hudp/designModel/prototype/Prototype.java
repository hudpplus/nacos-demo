package com.hudp.designModel.prototype;

/**
 * 原型模式
 */
public class Prototype implements Cloneable {

    Prototype(){}

    public Object clone() throws CloneNotSupportedException {

        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype p = new Prototype();
        Prototype p_c = (Prototype) p.clone();
        System.out.println(p==p_c);
    }
}

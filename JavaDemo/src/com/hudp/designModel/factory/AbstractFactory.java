package com.hudp.designModel.factory;

/**
 * 抽象工厂模式
 * 去掉 product1 或者 product2 即为 工厂方法模式
 */
public class AbstractFactory {
    public static void main(String[] args) {
        IFactory factory = new Factory();
        Iproduct product1 = factory.createProduct1();
        Iproduct product2 = factory.createProduct2();
        product1.show();
        product2.show();
    }
}
interface Iproduct{
    void show();
}
class Product1 implements Iproduct{


    @Override
    public void show() {
        System.out.println("this is product1...");
    }
}
class Product2 implements Iproduct{

    @Override
    public void show() {
        System.out.println("this is product2...");
    }
}
interface IFactory{
    Iproduct createProduct1();
    Iproduct createProduct2();
}
class Factory implements IFactory{


    @Override
    public Iproduct createProduct1() {
        return new Product1();
    }

    @Override
    public Iproduct createProduct2() {
        return new Product2();
    }
}


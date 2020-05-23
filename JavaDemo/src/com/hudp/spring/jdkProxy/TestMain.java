package com.hudp.spring.jdkProxy;

public class TestMain {
    public static void main(String[] args) {
        JdkProxyTest proxyTest = new JdkProxyTest();
        Work workProxy = (Work) proxyTest.bind(new Programmer());
        workProxy.work();

        System.out.println("==============================");

        Work work = new Programmer();
        work.work();
    }
}

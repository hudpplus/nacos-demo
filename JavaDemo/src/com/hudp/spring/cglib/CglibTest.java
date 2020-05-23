package com.hudp.spring.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibTest implements MethodInterceptor {

    public Object getProxy(Class cla){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cla);
        enhancer.setCallback(this);
        return  enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("调用真实对象前");
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("调用真实对象后");
        return result;
    }
}

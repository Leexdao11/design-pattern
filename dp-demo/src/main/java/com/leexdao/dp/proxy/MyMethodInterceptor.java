package com.leexdao.dp.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: leexdao
 * @create: 2022-06-21
 **/
public class MyMethodInterceptor implements MethodInterceptor {

    private MyOperation myOperation;

    public MyMethodInterceptor(MyOperation myOperation) {
        this.myOperation = myOperation;
    }



    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("cglib动态代理： 打开冰箱...");
        Object invoke = methodProxy.invoke(myOperation, null);
        System.out.println("cglib动态代理： 关闭冰箱...");
        return invoke;
    }

    public static void main(String[] args) {
        Enhancer enhancer=new Enhancer();
        enhancer.setCallback(new MyMethodInterceptor(new MyOperation()));
        enhancer.setSuperclass(OperationElephant.class);
        OperationElephant operationElephant= (OperationElephant) enhancer.create();
        operationElephant.operation();
    }
}

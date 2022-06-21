package com.leexdao.dp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @description:
 * @author: leexdao
 * @create: 2022-06-21
 **/
public class MyInvocationHandler implements InvocationHandler {

    private MyOperation myOperation;

    public MyInvocationHandler(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理： 打开冰箱...");
        Object invoke = method.invoke(myOperation, null);
        System.out.println("动态代理： 关闭冰箱...");
        return invoke;
    }

    public static void main(String[] args) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(new MyOperation());
        OperationElephant proxyInstance = (OperationElephant) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{OperationElephant.class}, myInvocationHandler);
        proxyInstance.operation();
    }
}

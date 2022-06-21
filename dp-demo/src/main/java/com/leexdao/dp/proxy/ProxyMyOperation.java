package com.leexdao.dp.proxy;

import java.lang.reflect.InvocationHandler;

/**
 * @description: 代理类
 * @author: leexdao
 * @create: 2022-06-21
 **/
public class ProxyMyOperation implements OperationElephant{

    private MyOperation myOperation;

    public ProxyMyOperation(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void operation() {
        System.out.println("打开冰箱...");
        myOperation.operation();
        System.out.println("关闭冰箱...");
    }

    public static void main(String[] args) {
        ProxyMyOperation proxyMyOperation=new ProxyMyOperation(new MyOperation());
        proxyMyOperation.operation();
    }
}

package com.mb;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        CountService countService = new CountService();



        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                long start = System.currentTimeMillis();
                System.out.println(Arrays.toString(args));
                TimeUnit.MILLISECONDS.sleep(10L);
                long end = System.currentTimeMillis();
                System.out.println("cost time:"+(end-start));
                return null;
            }
        };

        // countService1 =  Proxy.newProxyInstance(CountService.class.getClassLoader(),new Class[]{CountService.class},handler);
        CountImp countImp = (CountImp) Proxy.newProxyInstance(CountImp.class.getClassLoader(),new Class[]{CountImp.class},handler);
        countImp.getById(2);

    }
}
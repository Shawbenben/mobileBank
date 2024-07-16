package com.mb;

import java.util.concurrent.TimeUnit;

public class CountService implements CountImp {


    @Override
    public void getById(int i) throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println(i);
        TimeUnit.MILLISECONDS.sleep(10L);
        long end = System.currentTimeMillis();
        System.out.println("cost time:"+(end-start));

    }
}

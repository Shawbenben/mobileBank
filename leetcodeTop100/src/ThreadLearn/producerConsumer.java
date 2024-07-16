package ThreadLearn;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class producerConsumer {
    public static void main(String[] args) {
        List list = new ArrayList<>();

        Thread producer = new Thread(new Producer(list),"producer");
        Thread consumer = new Thread(new Consumer(list));


        consumer.setName("consumer");


        producer.start();
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        consumer.start();


        System.out.println(Thread.currentThread().getName());

    }
}

class Producer implements Runnable{
    private List list;
    private int count;

    Producer(List list){
        this.list = list;
        this.count = 0;
    }


    @Override
    public void run(){

        while(count<3){
            synchronized (list){
                if(list.size() != 0){
                    try{
                        list.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }else{

                    Object obj = new Object();
                    list.add(obj);
                    count++;
                    System.out.println(Thread.currentThread().getName() +"--->" +obj);
                    list.notifyAll();
                }
            }
        }

    }
}

class Consumer implements Runnable{
    private List list;

    Consumer(List list){
        this.list = list;
    }
    @Override
    public void run(){
        while(true){
            synchronized (list){
                if(list.size()!=0){

                    Object obj = list.remove(0);
                    System.out.println(Thread.currentThread().getName() + "-->" + obj);
                    list.notifyAll();
                }else{
                    try{
                        list.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}

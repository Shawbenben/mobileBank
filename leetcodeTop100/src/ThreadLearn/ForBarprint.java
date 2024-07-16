package ThreadLearn;

public class ForBarprint {
    public static void main(String[] args) {
        int n = 10;
        Object obj = new Object();
    }
}

class foo implements Runnable{

    public Object obj;

    @Override
    public void run(){
        for(int i=0;i<10;i++){
            synchronized(obj){
                System.out.println(Thread.currentThread().getName()+"-->");
                System.out.println("foo");
            }
        }
    }
}
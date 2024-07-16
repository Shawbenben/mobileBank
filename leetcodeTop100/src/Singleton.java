public class Singleton {
    // 使用静态变量singleton保存变量，保证第一次访问时进行实例化
    // 使用volatile修饰singleton变量，确保多线程环境下的可见性
    private static volatile Singleton singleton;

    //私有构造函数，防止外部类直接通过构造函数创建实例。
    private Singleton(){}

    public static Singleton getInstace(){
        // 第一重检查
        if(singleton == null){

            synchronized(Singleton.class){
                // 第二重目的为同时进入但被synchronized堵塞进程的检查。
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }
}

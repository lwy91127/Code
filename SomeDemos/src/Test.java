/**
 * Created by lwy on 2016/4/25.
 */
public class Test {
    public static synchronized void method1(){
        System.out.println("in method1");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method1");
    }

    public static  void method2(){
        System.out.println("method2");
    }

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method2();
            }
        }).start();
    }
}

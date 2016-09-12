import javax.management.StandardEmitterMBean;
import java.sql.PreparedStatement;
import java.util.concurrent.Semaphore;

/**
 * Created by lwy on 2016/5/13.
 */
public class SerialRunThread {
    public static void main(String[] args) throws InterruptedException {
//        MyThread thread1 = new MyThread("x");
//        MyThread thread2 = new MyThread("B");
//        MyThread thread3 = new MyThread("C");
//        thread1.start();
//        thread1.join();
//        thread2.start();
//        thread2.join();
//        thread3.start();
//        thread3.join();
        Semaphore sempA = new Semaphore(1);
        Semaphore sempB = new Semaphore(0);
        Semaphore sempC = new Semaphore(0);

        PrintThread thread1 = new PrintThread(1,sempA,sempB,"A");
        PrintThread thread2 = new PrintThread(1,sempB,sempC,"B");
        PrintThread thread3 = new PrintThread(1,sempC,sempA,"C");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class MyThread extends Thread{
        String str;
        public MyThread(String str){
            this.str = str;
        }

        @Override
        public void run() {
            super.run();
            System.out.println(str);
        }
    }

    static class PrintThread extends Thread{
        int N;
        Semaphore curSemp;
        Semaphore nextSemp;
        String name;

        public PrintThread(int n, Semaphore curSemp, Semaphore nextSemp, String name) {
            N = n;
            this.curSemp = curSemp;
            this.nextSemp = nextSemp;
            this.name = name;
        }

        public void run() {
            for (int i = 0; i < N; ++i) {
                try {
                    curSemp.acquire();
                    System.out.println(name);
                    nextSemp.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

    }
}

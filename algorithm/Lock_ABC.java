
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：jin
 * @description: 三个线程交替打印ABC
 * @date ：Created in 2021/3/16 15:05
 */
public class Lock_ABC {

    private static final Lock lock = new ReentrantLock();
    private static int count = 0;

    public static class ThreadA implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (count % 3 == 0) {
                        System.out.println("A");
                        count++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static class ThreadB implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (count % 3 == 1) {
                        System.out.println("B");
                        count++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static class ThreadC implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (count % 3 == 2) {
                        System.out.println("C");
                        count++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
//        Thread.sleep(10);
        new Thread(new ThreadB()).start();
//        Thread.sleep(10);
        new Thread(new ThreadC()).start();

    }

}

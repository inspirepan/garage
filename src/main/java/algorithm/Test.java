package algorithm;

public class Test {
    public volatile int inc = 0;

    public static void main(String[] args) {
        final Test test = new Test();
        for (int i = 0; i < 10; i++) {
            System.out.println("【" + i + "】");
            new Thread() {
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.print(j);
                        test.increase();
                    }
                }
            }.start();
        }
        while (Thread.activeCount() > 1)  // 保证前面的线程都执行完
        {
            Thread.yield();
        }
        System.out.println("  kkk");
        System.out.println(test.inc);
    }

    public synchronized void increase() {
        inc++;
    }
}
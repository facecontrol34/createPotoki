import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Practica {

    private static final int NUMTHREADS = 10;

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(NUMTHREADS);
        ExecutorService executor = Executors.newFixedThreadPool(NUMTHREADS);
        for (int i = 0; i < NUMTHREADS; i++) {
            executor.submit(new Imp(cdl));
            cdl.countDown();
            System.out.println("one thread sumbmited "+cdl.getCount());
        }
        System.out.println("All threads submmited");
        executor.shutdown();
    }

}

class Imp implements Runnable {
    CountDownLatch cdl;

    public Imp(CountDownLatch arg) {
        this.cdl = arg;
    }

    @Override
    public void run() {
        try {
            cdl.await();
            System.out.printf("STARTED %s at %d millis%n",
                    Thread.currentThread().getName(),
                    System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
package Chpt11.item84;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
  public static void main(String[] args) throws InterruptedException {
    ExecutorService e = Executors.newFixedThreadPool(1000);

    System.out.println("time :" + time(e, 1000, () -> System.out.print("")));
    System.out.println("time2:" + time2(e, 1000, () -> System.out.print("")));
    e.shutdown();
  }

  // Simple framework for timing concurrent execution
  public static long time(Executor executor, int concurrency, Runnable action)
      throws InterruptedException {
    CountDownLatch ready = new CountDownLatch(concurrency);
    CountDownLatch start = new CountDownLatch(1);
    CountDownLatch done = new CountDownLatch(concurrency);
    for (int i = 0; i < concurrency; i++) {
      executor.execute(() -> {
        ready.countDown(); // Tell timer we're ready
        try {
          start.await(); // Wait till peers are ready
          action.run();
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        } finally {
          done.countDown(); // Tell timer we're done
        }
      });
    }
    ready.await(); // Wait for all workers to be ready
    long startNanos = System.nanoTime();
    start.countDown(); // And they're off!
    done.await(); // Wait for all workers to finish
    return System.nanoTime() - startNanos;

  }

  public static long time2(Executor executor, int concurrency, Runnable action)
      throws InterruptedException {
    SlowCountDownLatch ready = new SlowCountDownLatch(concurrency);
    SlowCountDownLatch start = new SlowCountDownLatch(1);
    SlowCountDownLatch done = new SlowCountDownLatch(concurrency);
    for (int i = 0; i < concurrency; i++) {
      executor.execute(() -> {
        ready.countDown(); // Tell timer we're ready
        try {
          start.await(); // Wait till peers are ready
          action.run();
        } finally {
          done.countDown(); // Tell timer we're done
        }
      });
    }
    ready.await(); // Wait for all workers to be ready
    long startNanos = System.nanoTime();
    start.countDown(); // And they're off!
    done.await(); // Wait for all workers to finish
    return System.nanoTime() - startNanos;

  }
}

// 출처  : https://qiita.com/nannany/items/e8f23c2ea8225551a511
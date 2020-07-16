package com.ezreal.demo.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by tao.mao on 2020/6/23.
 */
public class ForkTask extends RecursiveTask<Long> {

    private ForkJoinPool joinPool;

    private Long start;

    private Long end;

    private Long diff = 2500L;

    public ForkTask(Long start, Long end, ForkJoinPool joinPool) {
        this.start = start;
        this.end = end;
        this.joinPool = joinPool;
    }

    @Override
    protected Long compute() {
        // System.out.println("adfae");
        Long sum = 0L;
        if (end - start > diff) {
            Long mid = (start + end) / 2;
            Long k;
            Long j;

            // 串行化了
            /*k = joinPool.invoke(new ForkTask(start, mid, joinPool));
            j = joinPool.invoke(new ForkTask(mid+1, end, joinPool));*/
            /*ForkTask task1 = new ForkTask(start, mid, joinPool);
            ForkTask task2 = new ForkTask(mid, end, joinPool);
            task1.fork();
            task2.fork();
            k = task1.join();
            j = task2.join();*/

            ForkJoinTask<Long> task1 = joinPool.submit(new ForkTask(start, mid, joinPool));
            ForkJoinTask<Long> task2 = joinPool.submit(new ForkTask(mid+1, end, joinPool));
            k = task1.join();
            j = task2.join();

            return k + j;
        } else {
            for (; start <= end; start++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sum += 1;
            }
            return sum;
        }

    }
}

package com.ezreal.demo.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by tao.mao on 2020/6/23.
 */
public class ForkJoinPoolDemo {

    public ForkJoinPoolDemo() {

    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        Long sum = forkJoinPool.invoke(new ForkTask(1L, 10000L, forkJoinPool));
        forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("sum=" + sum);
        forkJoinPool.shutdown();

        long end1 = System.currentTimeMillis();
        System.out.println("end1 = " + (end1 - start));


        int m = 0;
        for (int i=0; i < 10000L; i++) {

            Thread.sleep(1);
            m += 1;
        }
        long end2 = System.currentTimeMillis();
        System.out.println("end2 = " + (end2 - end1));

        System.out.println("m=" + m);
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(forkJoinPool.getParallelism());


    }

}

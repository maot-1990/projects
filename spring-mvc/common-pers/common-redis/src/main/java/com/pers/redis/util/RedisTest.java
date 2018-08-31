package com.pers.redis.util;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.UUID;

public class RedisTest {

    /*public static void main(String[] args){
        final String key = "zhhyhy";
        final String lockKey = "lock:" + key;
        final TestVo testVo = new TestVo();
        testVo.setCount(0);
        long startTime = System.currentTimeMillis();
        try {
            RedisUtil.setObj(key,testVo);
            //RedisUtil.set(key, String.valueOf(2));
            //System.out.println(RedisUtil.get(key));
            for(int i=0; i<100; i++){
                final Thread thread = new Thread(new Runnable() {
                    public void run() {
                        try {
                            String requestId = UUID.randomUUID().toString();
                            boolean isGet = false;
                            int count = 0;
                            while (count < 100){
                                isGet = RedisUtil.tryGetDistributedLock(RedisPool.getJedis(), lockKey, requestId, 10000);

                                if (isGet){
                                    System.out.println(Thread.currentThread().getName() + ",第" + count + "次"+ ",获取锁结果：" + isGet);
                                    break;
                                }
                                Thread.sleep(100);
                                count++;
                            }

                            if (isGet){
                                TestVo vo = JSON.parseObject(RedisUtil.getObj(key) == null ? "{}" : RedisUtil.getObj(key).toString(), TestVo.class);
                                System.out.println(Thread.currentThread().getName() + ",前value=" + vo.getCount());
                                vo.setCount(vo.getCount() + 1);
                                RedisUtil.setObj(key, vo);
                            } else {
                                System.out.println(Thread.currentThread().getName() + ",当前线程未获取redis锁");
                            }
                            System.out.println(Thread.currentThread().getName() + ":修改后的值为：" + RedisUtil.getObj(key));
                            if (isGet){
                                boolean isReturn = RedisUtil.releaseDistributedLock(RedisPool.getJedis(), lockKey, requestId);
                                System.out.println(Thread.currentThread().getName() + ",归还锁结果：" + isReturn);
                            }else{
                                System.out.println(Thread.currentThread().getName() + ",未获取到锁，不用归还");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    long endTime = System.currentTimeMillis();
                });
                thread.start();
            }

            Thread.sleep(3000L);
            System.out.println(RedisUtil.get(key));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/


    /*public static void main(String[] args){
        final String key = "ktr";
        try {
            RedisUtil.set(key,"0");
            RedisUtil.set(key, String.valueOf(2));
            System.out.println(RedisUtil.get(key));
            int count = 1;
            for(int i=0; i<100; i++){
                //Thread.sleep(1000);
                System.out.println("i=" + i);
                final Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int value = Integer.valueOf(RedisUtil.get(key));
                        System.out.println(Thread.currentThread().getName() + ",前value=" + value);
                        RedisUtil.set(key, String.valueOf(value+1));
                        System.out.println(Thread.currentThread().getName() + ":" + RedisUtil.get(key));
                    }
                });
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    /*public static void main(String[] args) {

        Jedis jedis = RedisPool.getJedis();
        //jedis.rpush("key", "value1", "value2", "value3");
        System.out.println(jedis.lrange("key", 0, -1));
        //System.out.println(jedis.lpop("key"));
        //System.out.println(jedis.rpop("key"));
        //System.out.println(jedis.lrange("key", 0, -1));
        //jedis.flushDB();
        System.out.println(jedis.lrange("key", 0, -1));
        jedis.expire("key", 5);


    }*/

   /* public static void main(String[] args) {
        Jedis jedis = RedisPool.getJedis();
        //jedis.mset("key1", "value1","key2", "value2","key3", "value3");
        jedis.expire("key1", 20);
        System.out.println(jedis.exists("key1"));
        System.out.println(jedis.mget("key1","key2","key3"));
    }*/

    public static void main(String[] args) {
        Jedis jedis = RedisPool.getJedis();
        //jedis.flushDB();
        System.out.println(jedis.sadd("key","value1", "value2", "value3"));
        System.out.println(jedis.sadd("key1","value1", "value2", "value4"));

        System.out.println(jedis.sdiff("key", "key1"));
        System.out.println(jedis.sinter("key", "key1"));
        System.out.println(jedis.sunion("key", "key1"));
    }
}

package com.zhuhaoman.collections.concurrenthashmap;

import java.util.HashMap;
import java.util.UUID;

/**
 * @ClassName HashMapTest
 * @Description HashMap死循环
 * @Author zhuhaoman
 * @Date 2019/4/16 17:41
 **/
public class HashMapTest {
    public static void main(String[] args) throws InterruptedException {
        final HashMap<String,String> map = new HashMap<>();
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10000 ; i++) {
                Thread tt = new Thread(() -> map.put(UUID.randomUUID().toString(),""));
                tt.start();
                System.out.println(tt.getName());
            }
        });
        t.start();
        t.join();
    }
}

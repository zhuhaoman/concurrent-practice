package com.zhuhaoman.collections.concurrentskiplistmap;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @ClassName Task
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/4/17 15:34
 **/
public class Task implements Runnable {
    private ConcurrentSkipListMap<String,Contact> map;

    private String id;

    public Task(ConcurrentSkipListMap<String, Contact> map, String id) {
        this.map = map;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000 ; i++) {
            Contact c = new Contact(id,String.valueOf(i+1000));
            map.put(id+c.getPhone(),c);
        }
    }
}

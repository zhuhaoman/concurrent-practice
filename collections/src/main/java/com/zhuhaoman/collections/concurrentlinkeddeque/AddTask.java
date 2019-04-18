package com.zhuhaoman.collections.concurrentlinkeddeque;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @ClassName AddTask
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/4/15 14:16
 **/
public class AddTask implements Runnable{
    private ConcurrentLinkedDeque<String> list;

    public AddTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10000 ; i++) {
            list.add(name+": Element "+i);
        }
    }
}

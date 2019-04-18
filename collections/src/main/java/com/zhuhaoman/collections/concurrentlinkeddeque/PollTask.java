package com.zhuhaoman.collections.concurrentlinkeddeque;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @ClassName PollTask
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/4/15 14:20
 **/
public class PollTask implements Runnable {
    private ConcurrentLinkedDeque<String> list;

    public PollTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000 ; i++) {
            list.pollFirst();
            list.pollLast();
        }

    }
}

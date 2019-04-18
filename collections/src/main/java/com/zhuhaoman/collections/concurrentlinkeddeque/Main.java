package com.zhuhaoman.collections.concurrentlinkeddeque;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @ClassName Main
 * @Description 非阻塞式队列
 * @Author zhuhaoman
 * @Date 2019/4/15 14:22
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println(System.nanoTime());
        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
        Thread []threads = new Thread[100];

        for (int i = 0; i < 100 ; i++) {
            AddTask addTask = new AddTask(list);
            threads[i] = new Thread(addTask);
            threads[i].start();
        }
        System.out.printf("Main: %d AddTask threads have been launched\n",threads.length);

        for (int i = 0; i < threads.length ; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: Size of the list: %d\n ",list.size());

        for (int i = 0; i < threads.length ; i++) {
            PollTask pollTask = new PollTask(list);
            threads[i] = new Thread(pollTask);
            threads[i].start();
        }

        System.out.printf("Main: PollTask threads have been launched\n",threads.length);

        for (int i = 0; i < threads.length ; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main: Size of the list: %d\n",list.size());
        System.out.println(System.nanoTime());
    }
}

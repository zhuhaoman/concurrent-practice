package com.zhuhaoman.collections.concurrentskiplistmap;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @ClassName Main
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/4/17 15:37
 **/
public class Main {
    public static void main(String[] args) {
        ConcurrentSkipListMap<String,Contact> map = new ConcurrentSkipListMap<>();

        Thread []threads = new Thread[25];
        int counter = 0;

        for (char i = 'A';i < 'Z'; i++) {
            Task task = new Task(map,String.valueOf(i));
            threads[counter] = new Thread(task);
            threads[counter].start();
            counter++;
        }

        for (int i = 0; i < 25 ; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main: Size of the map: %d\n",map.size());

        Map.Entry<String,Contact> element = map.firstEntry();
        Contact contact = element.getValue();
        System.out.printf("Main: First Entry: %s: %s\n",contact.getName(),contact.getPhone());

        Map.Entry<String,Contact> lastElement = map.lastEntry();
        Contact lastContact = lastElement.getValue();
        System.out.printf("Main: last Entry: %s: %s\n",lastContact.getName(),lastContact.getPhone());
    }
}

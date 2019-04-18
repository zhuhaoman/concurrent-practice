package com.zhuhaoman.collections.linkedblockingdeque;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Client
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/4/15 15:54
 **/
public class Client implements Runnable {
    private LinkedBlockingDeque<String> list;



    public Client(LinkedBlockingDeque<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {

                StringBuilder request = new StringBuilder();
                request.append(i);
                request.append(":");
                request.append(j);
                try {
                    list.put(request.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("Client: %s at %s .\n",request,new Date());
            }
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Client end. \n");
    }
}

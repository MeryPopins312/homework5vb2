package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        CountDownLatch countDownLatch=new CountDownLatch(100);//10 пассажиров
        Semaphore semaphore=new Semaphore(4,true);//4 кассира , true дисциплинированные.
        for (int i = 1; i < 101; i++) {
            new Passenger("Пассажир "+i, countDownLatch,semaphore).start();
            //всего будет 10 пассажиров , и начинаем (start.())

        }
        try {
            countDownLatch.await();
            // await - сообщает что все пассажиры сели в автобус 
            System.out.println("Автобус выезжает !");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

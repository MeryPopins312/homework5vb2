package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Passenger extends Thread {
    private CountDownLatch countDownLatch;
    private Semaphore semaphore;

    public Passenger(String name, CountDownLatch countDownLatch, Semaphore semaphore) {
        super(name);
        this.countDownLatch = countDownLatch;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();//начало обязательств кассира
            System.out.println(getName()+" Встал в очередь");
            sleep(1000);
            System.out.println(getName()+" Купил билеты");
            sleep(1000);
            System.out.println(getName()+" Сел в автобус");
            countDownLatch.countDown();//  пассажир выполняет свои обязательства
            semaphore.release();//кассир завршает свои обязательства

        }catch (Exception ignore){

        }
    }

}

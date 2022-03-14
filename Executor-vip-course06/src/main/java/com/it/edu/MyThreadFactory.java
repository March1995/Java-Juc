package com.it.edu;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.LongAdder;

/**
 * Description:
 *
 * @author: Marcher丶
 * @Date: 2022-03-13 09:46
 **/
public class MyThreadFactory implements ThreadFactory {

    private String prefix;
    private final LongAdder threadNumber = new LongAdder();

    public MyThreadFactory(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        threadNumber.add(1);
        thread.setName(prefix + "thread" + threadNumber.intValue());
        return thread;
    }
}

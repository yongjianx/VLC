package ht.thread;

import android.support.annotation.NonNull;

import java.util.concurrent.ThreadFactory;

/**
 * Created by dn on 2018/6/17.
 */

public class DaemonThreadFactory implements ThreadFactory, Thread.UncaughtExceptionHandler {

    @Override
    public Thread newThread(@NonNull Runnable r) {
        Thread thread = new Thread(r);
        //设置为后台线程
        thread.setDaemon(true);
        return thread;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught: "+ e);
    }
}

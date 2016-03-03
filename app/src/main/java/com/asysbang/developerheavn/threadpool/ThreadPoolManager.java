package com.asysbang.developerheavn.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by karl on 16-3-2.
 */
public class ThreadPoolManager {

    private static ThreadPoolManager mInstance;

    private static final int NUMS_OF_THREADS = 10;

    private ThreadPoolManager(){
        pools = Executors.newFixedThreadPool(NUMS_OF_THREADS);
    }

    public static synchronized ThreadPoolManager getInstance() {
        if (mInstance == null) {
            mInstance = new ThreadPoolManager();
        }
        return mInstance;
    }

    private ExecutorService pools;

    public void submit(BaseActionInterface action) {
        pools.submit(action);
    }




}

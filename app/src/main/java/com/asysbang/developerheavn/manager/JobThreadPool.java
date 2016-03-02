package com.asysbang.developerheavn.manager;

import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by karl on 16-1-29.
 */
public class JobThreadPool {

    private static final String TAG = "JobThreadPool";


    public static final int ACTION_LOAD = 10001;
    public static final int ACTION_REMOVE = 10002;

    private final ExecutorService mService = Executors.newCachedThreadPool();

    private JobThreadPool() {}

    public static JobThreadPool mInstance = new JobThreadPool();

    public static JobThreadPool getInstance() {
        return mInstance;
    }

    public void startAction (int action) {
        mService.submit(new CommonRunnable(action));
    }

    public void stopAllActions() {
        Log.i(TAG,"======stopAllActions ===== 000");
        mService.shutdown();
        Log.i(TAG, "======stopAllActions ===== 111");
    }

    private void doAction(int action) {
        switch (action){
            case ACTION_LOAD:
                load();
                break;
            case ACTION_REMOVE:
                remove();
                break;
            default:
        }
    }

    private void load() {
        int i = 10;
        while (i > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i(TAG,"======load ===getId : "+Thread.currentThread().getId());
            i--;
        }
    }

    private void remove() {
        int i = 10;
        while (i > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i(TAG,"======remove ===getId : "+Thread.currentThread().getId());
            i--;
        }
    }

    private class CommonRunnable implements Runnable{

        private int mAction = -1;

        public CommonRunnable(int action) {
            mAction = action;
        }

        @Override
        public void run() {
            doAction(mAction);
        }
    }

}

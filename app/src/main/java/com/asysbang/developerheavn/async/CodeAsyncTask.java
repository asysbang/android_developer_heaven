package com.asysbang.developerheavn.async;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.asysbang.developerheavn.R;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by karl on 16-1-19.
 */
public class CodeAsyncTask extends Activity {

    private static final String TAG = "CodeAsyncTask";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_asynctask);
//        final Executor executor = Executors.newCachedThreadPool();
        final Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ProgressBarTask((ProgressBar) findViewById(R.id.bar1), 1).executeOnExecutor(executor);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ProgressBarTask((ProgressBar) findViewById(R.id.bar2), 2).executeOnExecutor(executor);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ProgressBarTask((ProgressBar) findViewById(R.id.bar3), 3).executeOnExecutor(executor);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ProgressBarTask((ProgressBar) findViewById(R.id.bar4), 4).executeOnExecutor(executor);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ProgressBarTask((ProgressBar) findViewById(R.id.bar5), 5).executeOnExecutor(executor);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ProgressBarTask((ProgressBar) findViewById(R.id.bar6), 6).executeOnExecutor(executor);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ProgressBarTask((ProgressBar) findViewById(R.id.bar7), 7).executeOnExecutor(executor);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ProgressBarTask((ProgressBar) findViewById(R.id.bar8), 8).executeOnExecutor(executor);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                new ProgressBarTask((ProgressBar) findViewById(R.id.bar9), 9).executeOnExecutor(executor);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                new ProgressBarTask((ProgressBar) findViewById(R.id.bar10), 10).executeOnExecutor(executor);
            }
        }).start();

    }


    private class ProgressBarTask extends AsyncTask<Void, Void, Void> {

        private ProgressBar mBar;

        private int mProgress;

        private int mId;

        public ProgressBarTask(ProgressBar bar, int id) {
            mBar = bar;
            mProgress = 0;
            mId = id;
        }

        @Override
        protected Void doInBackground(Void... params) {

            while (mProgress < 100) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i(TAG, "==============[id = " + mId + ", progress = " + mProgress + "]");
                        mBar.setProgress(mProgress++);
                    }
                });
            }
            return null;
        }
    }
}

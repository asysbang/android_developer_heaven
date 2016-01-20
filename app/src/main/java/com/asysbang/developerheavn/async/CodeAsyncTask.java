package com.asysbang.developerheavn.async;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.asysbang.developerheavn.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by karl on 16-1-19.
 */
public class CodeAsyncTask extends Activity {

    private static final String TAG = "CodeAsyncTask";

    private List<ProgressBarTask> mTasks = new ArrayList<ProgressBarTask>();

    private Executor mExecutor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_asynctask);
        initAllTask();
    }

    private void initAllTask() {
        mTasks.clear();
        LinearLayout container = (LinearLayout) findViewById(R.id.taskContainer);
        for (int i = 0; i < container.getChildCount(); i++) {
            ProgressBarTask task = new ProgressBarTask((ProgressBar) container.getChildAt(0), i);
            mTasks.add(task);
        }
    }


    public void stopAll(View v) {
        for (ProgressBarTask task : mTasks) {
            task.cancel(true);
        }
    }

    public void startNormal(View v) {
        startInternal(null);
    }

    public void startSerial(View v) {
        startInternal(AsyncTask.SERIAL_EXECUTOR);
    }

    public void startThreadPool(View v) {
        startInternal(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public void startCachedThreadPool(View v) {
        startInternal(Executors.newCachedThreadPool());
    }

    private void startInternal(Executor executor) {
        for (ProgressBarTask task : mTasks) {
            if (executor == null) {
                task.execute();
            } else {
                task.executeOnExecutor(executor);
            }
        }
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
                    Thread.sleep(1000);
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

package com.asysbang.developerheavn.threadpooldemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.asysbang.developerheavn.R;
import com.asysbang.developerheavn.threadpool.ActionCallback;
import com.asysbang.developerheavn.threadpool.BaseActionResult;
import com.asysbang.developerheavn.threadpool.ThreadPoolManager;

/**
 * Created by karl on 16-3-2.
 */
public class DemoThreadPool extends Activity implements ActionCallback {


    private ThreadPoolManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_pool);
        mManager = ThreadPoolManager.getInstance();
    }

    public void goNoCallback(View v) {
        mManager.submit(new LoadImageAction(null));
    }

    public void goSingleCallback(View v) {
        mManager.submit(new LoadImageAction(this));
    }

    public void goMultiCallback(View v) {
        mManager.submit(new LoadImageAction(this));
        mManager.submit(new InitDataAction(this));
    }

    @Override
    public void onActionFinished(BaseActionResult result) {
        if (result instanceof LoadImageResult) {
            Log.i("=================", "=====getState=====" + ((LoadImageResult) result).getState());
        } else if (result instanceof InitDataResult) {
            Log.i("=================", "=====getInfo=====" + ((InitDataResult) result).getInfo());
        }
    }
}

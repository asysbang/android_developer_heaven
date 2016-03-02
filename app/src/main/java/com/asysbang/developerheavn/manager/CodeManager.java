package com.asysbang.developerheavn.manager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.asysbang.developerheavn.R;

/**
 * Created by karl on 16-1-29.
 */
public class CodeManager extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_manager);
    }

    public void load(View v) {
        JobThreadPool.getInstance().startAction(JobThreadPool.ACTION_LOAD);
    }

    public void remove(View v) {
        JobThreadPool.getInstance().startAction(JobThreadPool.ACTION_REMOVE);
    }

    public void stopAll(View v) {
        JobThreadPool.getInstance().stopAllActions();
    }
}


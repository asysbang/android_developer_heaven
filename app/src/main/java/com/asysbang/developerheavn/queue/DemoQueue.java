package com.asysbang.developerheavn.queue;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import com.asysbang.developerheavn.R;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by karl on 16-3-17.
 */
public class DemoQueue extends Activity {

    Queue<Integer> mQueue = new LinkedList();

    private int mCount = 0;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(mQueue.isEmpty()) {
                Toast.makeText(DemoQueue.this,"===isEmpty===",Toast.LENGTH_SHORT).show();
            } else {
                int i = mQueue.poll();
                Toast.makeText(DemoQueue.this,"===" + i + "===",Toast.LENGTH_SHORT).show();
            }
            sendEmptyMessageDelayed(0,3000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue);
        mHandler.sendEmptyMessageDelayed(0,3000);
    }

    public void add(View v) {
        mCount++;
        mQueue.add(mCount);
    }
}

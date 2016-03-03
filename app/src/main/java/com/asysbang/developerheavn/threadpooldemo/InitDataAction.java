package com.asysbang.developerheavn.threadpooldemo;

import com.asysbang.developerheavn.threadpool.ActionCallback;
import com.asysbang.developerheavn.threadpool.BaseActionInterface;

import java.util.Random;

/**
 * Created by karl on 16-3-3.
 */
public class InitDataAction extends BaseActionInterface {

    public InitDataAction(ActionCallback callbak) {
        super(callbak);
    }

    @Override
    protected InitDataResult doInThread() {
        int t = new Random(System.currentTimeMillis()).nextInt(10);
        try {
            Thread.sleep(1000 * t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new InitDataResult("info = "+t);
    }
}

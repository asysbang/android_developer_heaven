package com.asysbang.developerheavn.threadpooldemo;

import com.asysbang.developerheavn.threadpool.BaseActionResult;

/**
 * Created by karl on 16-3-3.
 */
public class LoadImageResult extends BaseActionResult {

    private int mState;

    public LoadImageResult(int state) {
        mState = state;
    }

    public int getState() {
        return mState;
    }
}

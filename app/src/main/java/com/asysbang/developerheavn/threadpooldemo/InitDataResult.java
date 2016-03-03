package com.asysbang.developerheavn.threadpooldemo;

import com.asysbang.developerheavn.threadpool.BaseActionResult;

/**
 * Created by karl on 16-3-3.
 */
public class InitDataResult extends BaseActionResult {

    private String mInfo;

    public InitDataResult(String info) {
        mInfo = info;
    }

    public String getInfo() {
        return mInfo;
    }
}

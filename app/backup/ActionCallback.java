package com.asysbang.developerheavn.threadpool;

/**
 * Created by karl on 16-3-3.
 */
public interface ActionCallback {


    //?????    泛型     还是  基类就够了    ？？？？？？？？？？？？？？
    public <T extends BaseActionResult> void onActionFinished(T result);
}

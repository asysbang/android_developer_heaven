package com.asysbang.developerheavn.threadpool;

/**
 * Created by karl on 16-3-3.
 */
public abstract class BaseActionInterface implements Runnable {

    private ActionCallback mCallback;

    //?????    泛型     还是  基类就够了    ？？？？？？？？？？？？？？
    protected abstract <T extends BaseActionResult> T doInThread();

    public BaseActionInterface(){

    }

    public BaseActionInterface(ActionCallback callbak) {
        mCallback = callbak;
    }

    @Override
    public void run() {
        BaseActionResult result = doInThread();
        if (mCallback != null ) {
            mCallback.onActionFinished(result);
        }
    }

}

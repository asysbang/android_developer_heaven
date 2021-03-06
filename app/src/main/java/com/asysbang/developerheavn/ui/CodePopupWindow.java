package com.asysbang.developerheavn.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.asysbang.developerheavn.R;

/**
 * Created by karl on 16-1-20.
 */
public class CodePopupWindow extends Activity {

    private PopupWindow mWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_popup_window);
        mWindow = new PopupWindow(LayoutInflater.from(this).inflate(R.layout.simple_view, null), LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        mWindow.setTouchable(false);
        mWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_launcher));
    }

    public void popUp(View v) {
        if (mWindow.isShowing()) {
            mWindow.update(v.getLeft(), v.getBottom(), LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        } else {
            mWindow.showAtLocation(v,0,v.getLeft(), v.getBottom());
        }
    }

    public void hidePopWindow(View v) {
        System.out.println("=========hidePopWindow=====");
        if (mWindow.isShowing()) {
            mWindow.dismiss();
        }
    }
}

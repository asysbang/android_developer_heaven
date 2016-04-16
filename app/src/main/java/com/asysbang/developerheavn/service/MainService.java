package com.asysbang.developerheavn.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.PowerManager;
import android.support.annotation.Nullable;

import com.asysbang.developerheavn.R;
import com.asysbang.developerheavn.notification.DemoNotification;

/**
 * Created by karl on 16-3-14.
 */
public class MainService extends Service{

    private NotificationManager nm;

    private Handler mHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            sendNotification();
//            wakeUp();
        }

    };

    //wake up the screen
    private void wakeUp() {
        PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
        PowerManager.WakeLock wakeLock = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.SCREEN_DIM_WAKE_LOCK, "tag");
        wakeLock.acquire();

    }

    private void sendNotification() {
        l("sendNotification");
        Context cxt = getApplicationContext();
        Intent intent = new Intent(cxt, DemoNotification.class);
        PendingIntent pi = PendingIntent.getActivity(cxt,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        Notification n = new Notification.Builder(cxt).setContentIntent(pi)
                .setWhen(System.currentTimeMillis())
                .setContentTitle("title")
                .setTicker("ticker")
                .setFullScreenIntent(pi,true)
                .setPriority(Notification.PRIORITY_MAX)
                .setSmallIcon(R.drawable.ic_launcher)
                .build();
        nm.notify(0,n);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        l("onStartCommand");
        nm.cancelAll();
        mHandler.sendEmptyMessageDelayed(0, 5000);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        l("create");
        nm.cancelAll();
        mHandler.sendEmptyMessageDelayed(0,3000);
    }

    private void l(String str){
        System.out.println("========= "+ str);
    }

}

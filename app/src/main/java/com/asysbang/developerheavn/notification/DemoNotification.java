package com.asysbang.developerheavn.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RemoteViews;

import com.asysbang.developerheavn.R;
import com.asysbang.developerheavn.service.MainService;

/**
 * Created by karl on 16-3-14.
 */
public class DemoNotification extends Activity {
    
    private NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void showNotification(View v) {
        Intent intent = new Intent(DemoNotification.this, DemoNotification.class);
        PendingIntent pi = PendingIntent.getActivity(DemoNotification.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        Notification n = new Notification.Builder(DemoNotification.this).setContentIntent(pi)
                .setWhen(System.currentTimeMillis())
                .setContentTitle("title")
                .setTicker("ticker")
                .setSmallIcon(R.drawable.ic_launcher)
                .build();
        nm.notify(0,n);
    }

    public void sendFormService(View v) {
        System.out.println("=========sendFormService ");
        startService(new Intent(this, MainService.class));
    }

    public void showRemoteView(View v) {
        System.out.println("=========showRemoteView ");
        Intent intent = new Intent(DemoNotification.this, DemoNotification.class);
        PendingIntent pi = PendingIntent.getActivity(DemoNotification.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        Notification n = new Notification.Builder(DemoNotification.this).setContentIntent(pi)
                .setWhen(System.currentTimeMillis())
                .setContentTitle("title")
                .setTicker("ticker")
                .setFullScreenIntent(pi, true)
                .setPriority(Notification.PRIORITY_MAX)
                .setSmallIcon(R.drawable.ic_launcher)
                .build();

        nm.notify(1,n);


    }
}

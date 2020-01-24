package com.example.notifications11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.app.NotificationManager;
import android.app.Notification;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.content.DialogInterface;
import android.app.NotificationChannel;
import android.content.ContentResolver;
import android.media.AudioAttributes;
import androidx.core.app.NotificationCompat;
import android.content.Intent;
import android.app.PendingIntent;
import android.os.Build;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                NotificationManager mNotificationManager;
//
//                NotificationCompat.Builder mBuilder =
//                        new NotificationCompat.Builder(getApplicationContext(), "notify_001");
//                Intent ii = new Intent(getApplicationContext(), getClass());
//                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.super.getBaseContext(), 0, ii, 0);
//
//                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
//                bigText.setBigContentTitle("Today's Bible Verse");
//                bigText.setSummaryText("Text in detail");
//
//                mBuilder.setContentIntent(pendingIntent);
//                mBuilder.setSmallIcon(R.mipmap.ic_launcher_round);
//                mBuilder.setContentTitle("Your Title");
//                mBuilder.setContentText("Your text");
//                mBuilder.setPriority(Notification.PRIORITY_MAX);
//                mBuilder.setStyle(bigText);
//
//                mNotificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//
//// === Removed some obsoletes
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
//                {
//                    String channelId = "Your_channel_id";
//                    NotificationChannel channel = new NotificationChannel(
//                            channelId,
//                            "Channel human readable title",
//                            NotificationManager.IMPORTANCE_HIGH);
//                    mNotificationManager.createNotificationChannel(channel);
//                    mBuilder.setChannelId(channelId);
//                    AudioAttributes audioAttributes = new AudioAttributes.Builder()
//                            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
//                            .setUsage(AudioAttributes.USAGE_NOTIFICATION)
//                            .build();
//                    channel.setSound(Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE+ "://" +getPackageName()+"/"+R.raw.utka));
//                }
//
//                mNotificationManager.notify(0, mBuilder.build());
                Intent ii = new Intent(getApplicationContext(), getClass());
           PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.super.getBaseContext(), 0, ii, 0);
           String CHANNEL_ID = "1234";
           NotificationCompat.Builder status = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID);
                status.setAutoCancel(true)
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        //.setOnlyAlertOnce(true)
                        .setContentTitle(getString(R.string.app_name))
                        .setContentText("Henlo")
                        .setVibrate(new long[]{0, 500, 1000})
                        .setDefaults(Notification.DEFAULT_LIGHTS )
                        .setSound((Uri.parse("android.resource://"+getPackageName()+"/"+R
                                .raw.utka)))
                        .setContentIntent(pendingIntent);
                NotificationManager mNotificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.notify(1234,status.build());
            }
        });
        Button b2 = (Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new
                        AlertDialog.Builder(MainActivity.this);
                try {
                    dialog.setMessage(getTitle().toString()+ " версия "+getPackageManager().getPackageInfo(getPackageName(),0).versionName + "\r\n\nПрограмма, создающая уведомления\r\n\n Автор - Иванов Даниил Дмитриевич, гр. БПИ182");
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                dialog.setTitle("О программе");
                dialog.setNeutralButton("OK", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                dialog.setIcon(R.mipmap.ic_launcher_round);
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();

            }
        });
    }
}

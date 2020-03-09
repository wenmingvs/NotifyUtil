package com.wenming.notify.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.wenming.notify.R;

import java.util.Arrays;


public class NotificationChannels {
    public final static String CRITICAL = "critical";
    public final static String IMPORTANCE = "importance";
    public final static String DEFAULT = "default";
    public final static String LOW = "low";
    public final static String MEDIA = "media";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void createAllNotificationChannels(Context context) {
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (nm == null) {
            return;
        }

        NotificationChannel mediaChannel = new NotificationChannel(
                MEDIA,
                context.getString(R.string.channel_media),
                NotificationManager.IMPORTANCE_DEFAULT);
        mediaChannel.setSound(null, null);
        mediaChannel.setVibrationPattern(null);

        nm.createNotificationChannels(Arrays.asList(
                new NotificationChannel(
                        CRITICAL,
                        context.getString(R.string.channel_critical),
                        NotificationManager.IMPORTANCE_HIGH),
                new NotificationChannel(
                        IMPORTANCE,
                        context.getString(R.string.channel_importance),
                        NotificationManager.IMPORTANCE_DEFAULT),
                new NotificationChannel(
                        DEFAULT,
                        context.getString(R.string.channel_default),
                        NotificationManager.IMPORTANCE_LOW),
                new NotificationChannel(
                        LOW,
                        context.getString(R.string.channel_low),
                        NotificationManager.IMPORTANCE_MIN),
                //custom notification channel
                mediaChannel
        ));
    }
}

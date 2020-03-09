package com.wenming.notify.notification;

import android.app.NotificationManager;
import android.app.RemoteInput;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.wenming.notify.BuildConfig;
import com.wenming.notify.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationService extends Service {
    private final static String TAG = "NotificationService";

    public final static String ACTION_SEND_PROGRESS_NOTIFICATION = BuildConfig.APPLICATION_ID + ".ACTION_SEND_PROGRESS_NOTIFICATION";

    private Context mContext;
    private NotificationManager mNM;
    private boolean mIsLoved;
    private boolean mIsPlaying = true;

    private List<NotificationContentWrapper> mContent = new ArrayList<>();
    private int mCurrentPosition = 1;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        mNM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        initNotificationContent();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.getAction() != null) {
            Log.i(TAG, "onStartCommand action = " + intent.getAction());
            switch (intent.getAction()) {
                case Notificaitons.ACTION_SIMPLE:
                    break;
                case Notificaitons.ACTION_ACTION:
                    break;
                case Notificaitons.ACTION_REMOTE_INPUT:
                    break;
                case Notificaitons.ACTION_BIG_PICTURE_STYLE:
                    break;
                case Notificaitons.ACTION_BIG_TEXT_STYLE:
                    break;
                case Notificaitons.ACTION_INBOX_STYLE:
                    break;
                case Notificaitons.ACTION_MEDIA_STYLE:
                    dealWithActionMediaStyle(intent);
                    break;
                case Notificaitons.ACTION_MESSAGING_STYLE:
                    break;
                case Notificaitons.ACTION_YES:
                case Notificaitons.ACTION_NO:
                    mNM.cancel(Notificaitons.NOTIFICATION_ACTION);
                    break;
                case Notificaitons.ACTION_DELETE:
                    break;
                case Notificaitons.ACTION_REPLY:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
                        dealWithActionReplay(intent);
                    }
                    break;
                case Notificaitons.ACTION_PROGRESS:
                    break;
                case ACTION_SEND_PROGRESS_NOTIFICATION:
                    dealWithActionSendProgressNotification();
                    break;
                case Notificaitons.ACTION_CUSTOM_HEADS_UP_VIEW:
                    dealWithActionCustomHeadsUpView(intent);
                    break;
                case Notificaitons.ACTION_CUSTOM_VIEW:
                    break;
                case Notificaitons.ACTION_CUSTOM_VIEW_OPTIONS_LOVE:
                    Notificaitons.getInstance().sendCustomViewNotification(this, mNM, mContent.get(mCurrentPosition), !mIsLoved, mIsPlaying);
                    mIsLoved = !mIsLoved;
                    break;
                case Notificaitons.ACTION_CUSTOM_VIEW_OPTIONS_PRE:
                    --mCurrentPosition;
                    Notificaitons.getInstance().sendCustomViewNotification(this, mNM, getNotificationContent(), mIsLoved, mIsPlaying);
                    break;
                case Notificaitons.ACTION_CUSTOM_VIEW_OPTIONS_PLAY_OR_PAUSE:
                    Notificaitons.getInstance().sendCustomViewNotification(this, mNM, mContent.get(mCurrentPosition), mIsLoved, !mIsPlaying);
                    mIsPlaying = !mIsPlaying;
                    break;
                case Notificaitons.ACTION_CUSTOM_VIEW_OPTIONS_NEXT:
                    ++mCurrentPosition;
                    Notificaitons.getInstance().sendCustomViewNotification(this, mNM, getNotificationContent(), mIsLoved, mIsPlaying);
                    break;
                case Notificaitons.ACTION_CUSTOM_VIEW_OPTIONS_LYRICS:
                    break;
                case Notificaitons.ACTION_CUSTOM_VIEW_OPTIONS_CANCEL:
                    mNM.cancel(Notificaitons.NOTIFICATION_CUSTOM);
                    break;
                default:
                    //do nothing
            }
        }
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void initNotificationContent() {
        mContent.clear();
        mContent.add(new NotificationContentWrapper(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.custom_view_picture_pre), "远走高飞", "金志文"));
        mContent.add(new NotificationContentWrapper(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.custom_view_picture_current), "最美的期待", "周笔畅 - 最美的期待"));
        mContent.add(new NotificationContentWrapper(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.custom_view_picture_next), "你打不过我吧", "跟风超人"));
    }

    private void dealWithActionMediaStyle(Intent intent) {
        String option = intent.getStringExtra(Notificaitons.EXTRA_OPTIONS);
        Log.i(TAG, "media option = " + option);
        if (option == null) {
            return;
        }
        switch (option) {
            case Notificaitons.MEDIA_STYLE_ACTION_PAUSE:
                Notificaitons.getInstance().sendMediaStyleNotification(this, mNM, false);
                break;
            case Notificaitons.MEDIA_STYLE_ACTION_PLAY:
                Notificaitons.getInstance().sendMediaStyleNotification(this, mNM, true);
                break;
            case Notificaitons.MEDIA_STYLE_ACTION_NEXT:
                break;
            case Notificaitons.MEDIA_STYLE_ACTION_DELETE:
                mNM.cancel(Notificaitons.NOTIFICATION_MEDIA_STYLE);
                break;
            default:
                //do nothing
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    private void dealWithActionReplay(Intent intent) {
        Bundle result = RemoteInput.getResultsFromIntent(intent);
        if (result != null) {
            String content = result.getString(Notificaitons.REMOTE_INPUT_RESULT_KEY);
            Log.i(TAG, "content = " + content);
            mNM.cancel(Notificaitons.NOTIFICATION_REMOTE_INPUT);
        }
    }

    private void dealWithActionSendProgressNotification() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    Notificaitons.getInstance().sendProgressViewNotification(mContext, mNM, i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void dealWithActionCustomHeadsUpView(Intent intent) {
        String headsUpOption = intent.getStringExtra(Notificaitons.EXTRA_OPTIONS);
        Log.i(TAG, "heads up option = " + headsUpOption);
        if (headsUpOption == null) {
            return;
        }
        switch (headsUpOption) {
            case Notificaitons.ACTION_ANSWER:
            case Notificaitons.ACTION_REJECT:
                mNM.cancel(Notificaitons.NOTIFICATION_CUSTOM_HEADS_UP);
                break;
            default:
                //do nothing
        }
    }

    private NotificationContentWrapper getNotificationContent() {
        switch (mCurrentPosition) {
            case -1:
                mCurrentPosition = 2;
                break;
            case 3:
                mCurrentPosition = 0;
                break;
            default:
                // do nothing
        }

        return mContent.get(mCurrentPosition);
    }
}

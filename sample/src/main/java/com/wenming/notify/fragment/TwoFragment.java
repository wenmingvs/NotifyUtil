package com.wenming.notify.fragment;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.wenming.notify.R;
import com.wenming.notify.notification.Notificaitons;
import com.wenming.notify.notification.NotificationContentWrapper;
import com.wenming.notify.notification.NotificationService;


/**
 * @author zongkl
 * @date 2020/1/8
 * @desc
 */
public class TwoFragment extends Fragment implements View.OnClickListener {
    private View mView;
    private Context mContext;
    private Button mSimple;
    private Button mAction;
    private Button mRemoteInput;
    private Button mBigPictureStyle;
    private Button mBigTextStyle;
    private Button mInboxStyle;
    private Button mMediaStyle;
    private Button mMessagingStyle;
    private Button mProgress;
    private Button mCustomHeadsUp;
    private Button mCustom;
    private Button mClearAll;

    private NotificationManager mNM;

    public TwoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_two, container, false);
        mContext = this.getContext();

        mNM = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

        mSimple = mView.findViewById(R.id.btn_simple);
        mAction = mView.findViewById(R.id.btn_action);
        mRemoteInput = mView.findViewById(R.id.btn_remote_input);
        mBigPictureStyle = mView.findViewById(R.id.btn_big_picture_style);
        mBigTextStyle = mView.findViewById(R.id.btn_big_text_style);
        mInboxStyle = mView.findViewById(R.id.btn_inbox_style);
        mMediaStyle = mView.findViewById(R.id.btn_media_style);
        mMessagingStyle = mView.findViewById(R.id.btn_messaging_style);
        mProgress = mView.findViewById(R.id.btn_progress);
        mCustomHeadsUp = mView.findViewById(R.id.btn_custom_heads_up);
        mCustom = mView.findViewById(R.id.btn_custom);
        mClearAll = mView.findViewById(R.id.btn_clear_all);

        mSimple.setOnClickListener(this);
        mAction.setOnClickListener(this);
        mRemoteInput.setOnClickListener(this);
        mBigPictureStyle.setOnClickListener(this);
        mBigTextStyle.setOnClickListener(this);
        mInboxStyle.setOnClickListener(this);
        mMediaStyle.setOnClickListener(this);
        mMessagingStyle.setOnClickListener(this);
        mProgress.setOnClickListener(this);
        mCustomHeadsUp.setOnClickListener(this);
        mCustom.setOnClickListener(this);
        mClearAll.setOnClickListener(this);
        return mView;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_simple:
                Notificaitons.getInstance().sendSimpleNotification(mContext, mNM);
                break;
            case R.id.btn_action:
                Notificaitons.getInstance().sendActionNotification(mContext, mNM);
                break;
            case R.id.btn_remote_input:
                Notificaitons.getInstance().sendRemoteInputNotification(mContext, mNM);
                break;
            case R.id.btn_big_picture_style:
                Notificaitons.getInstance().sendBigPictureStyleNotification(mContext, mNM);
                break;
            case R.id.btn_big_text_style:
                Notificaitons.getInstance().sendBigTextStyleNotification(mContext, mNM);
                break;
            case R.id.btn_inbox_style:
                Notificaitons.getInstance().sendInboxStyleNotification(mContext, mNM);
                break;
            case R.id.btn_media_style:
                Notificaitons.getInstance().sendMediaStyleNotification(mContext, mNM, false);
                break;
            case R.id.btn_messaging_style:
                Notificaitons.getInstance().sendMessagingStyleNotification(mContext, mNM);
                break;
            case R.id.btn_progress:
                Intent intent = new Intent(getActivity(), NotificationService.class);
                intent.setAction(NotificationService.ACTION_SEND_PROGRESS_NOTIFICATION);
                getActivity().startService(intent);
                break;
            case R.id.btn_custom_heads_up:
                Notificaitons.getInstance().sendCustomHeadsUpViewNotification(mContext, mNM);
                break;
            case R.id.btn_custom:
                Notificaitons.getInstance().sendCustomViewNotification(
                        mContext,
                        mNM,
                        new NotificationContentWrapper(
                                BitmapFactory.decodeResource(mContext.getResources(),
                                        R.drawable.custom_view_picture_current),
                                "最美的期待",
                                "周笔畅 - 最美的期待"),
                        false,
                        true);
                break;
            case R.id.btn_clear_all:
                Notificaitons.getInstance().clearAllNotification(mNM);
                break;
            default:
                //do nothing
        }
    }
}

package com.wenming.notify.fragment;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RemoteViews;

import com.wenming.library.NotifyUtil;
import com.wenming.notify.R;
import com.wenming.notify.activity.OtherActivity;
import com.wenming.notify.adapter.MyAdapter;
import com.wenming.notify.bean.NotifyBean;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by wenmingvs on 2016/1/14.
 */
public class OneFragment extends Fragment {
    private static final int FLAG = Notification.FLAG_INSISTENT;
    private static int NOTIFICATION_ID = 13565400;
    private Context mContext;
    private View mView;
    private NotifyUtil currentNotify;
    private ArrayList<NotifyBean> mDataList;
    private ListView mListView;
    private PhotoView mScaleImage;
    private int requestCode = (int) SystemClock.uptimeMillis();


    public OneFragment(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_one, container, false);
        initDatas();
        initListView();
        return mView;
    }

    private void initListView() {
        mListView = (ListView) mView.findViewById(R.id.listview);
        mScaleImage = (PhotoView) mView.findViewById(R.id.scaleImage);
        MyAdapter adapter = new MyAdapter(mContext, mDataList);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        notify_normal_singLine();
                        mScaleImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.image1));
                        break;
                    case 1:
                        notify_normal_moreLine();
                        mScaleImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.image2));
                        break;
                    case 2:
                        notify_mailbox();
                        mScaleImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.image3));
                        break;
                    case 3:
                        notify_bigPic();
                        mScaleImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.image4));
                        break;
                    case 4:
                        notify_customview();
                        mScaleImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.image5));
                        break;
                    case 5:
                        notify_buttom();
                        mScaleImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.image6));
                        break;
                    case 6:
                        notify_progress();
                        mScaleImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.image7));
                        break;
                    case 7:
                        notify_headUp();
                        mScaleImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.image8));
                        break;
                    case 8:
                        if (currentNotify != null) {
                            currentNotify.clear();
                        }
                        break;
                }
            }
        });
    }

    private void initDatas() {
        mDataList = new ArrayList<>();
        NotifyBean notifybean1 = new NotifyBean();
        notifybean1.setImageId(R.drawable.tb_bigicon);
        notifybean1.setTitleId(R.string.title1);
        notifybean1.setTypeId(R.string.type1);
        mDataList.add(notifybean1);
        NotifyBean notifybean2 = new NotifyBean();
        notifybean2.setImageId(R.drawable.netease_bigicon);
        notifybean2.setTitleId(R.string.title2);
        notifybean2.setTypeId(R.string.type2);
        mDataList.add(notifybean2);
        NotifyBean notifybean3 = new NotifyBean();
        notifybean3.setImageId(R.drawable.weixin);
        notifybean3.setTitleId(R.string.title3);
        notifybean3.setTypeId(R.string.type3);
        mDataList.add(notifybean3);
        NotifyBean notifybean4 = new NotifyBean();
        notifybean4.setImageId(R.drawable.xc_smaillicon);
        notifybean4.setTitleId(R.string.title4);
        notifybean4.setTypeId(R.string.type4);
        mDataList.add(notifybean4);
        NotifyBean notifybean5 = new NotifyBean();
        notifybean5.setImageId(R.drawable.yybao_smaillicon);
        notifybean5.setTitleId(R.string.title5);
        notifybean5.setTypeId(R.string.type5);
        mDataList.add(notifybean5);
        NotifyBean notifybean6 = new NotifyBean();
        notifybean6.setImageId(R.drawable.android_bigicon);
        notifybean6.setTitleId(R.string.title6);
        notifybean6.setTypeId(R.string.type6);
        mDataList.add(notifybean6);
        NotifyBean notifybean7 = new NotifyBean();
        notifybean7.setImageId(R.drawable.android_bigicon);
        notifybean7.setTitleId(R.string.title7);
        notifybean7.setTypeId(R.string.type7);
        mDataList.add(notifybean7);
        NotifyBean notifybean8 = new NotifyBean();
        notifybean8.setImageId(R.drawable.hl_smallicon);
        notifybean8.setTitleId(R.string.title8);
        notifybean8.setTypeId(R.string.type8);
        mDataList.add(notifybean8);
        NotifyBean notifybean9 = new NotifyBean();
        notifybean9.setImageId(R.drawable.myicon);
        notifybean9.setTitleId(R.string.title9);
        notifybean9.setTypeId(R.string.title9);
        mDataList.add(notifybean9);

    }

    /**
     * 高仿淘宝
     */
    private void notify_normal_singLine() {
        //设置想要展示的数据内容
        Intent intent = new Intent(mContext, OtherActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        int smallIcon = R.drawable.tb_bigicon;
        String ticker = "您有一条新通知";
        String title = "双十一大优惠！！！";
        String content = "仿真皮肤充气娃娃，女朋友带回家！";

        //实例化工具类，并且调用接口
        NotifyUtil notify1 = new NotifyUtil(mContext, 1);
        notify1.notify_normal_singline(pIntent, smallIcon, ticker, title, content, true, true, false);
        currentNotify = notify1;
    }

    /**
     * 高仿网易新闻
     */
    private void notify_normal_moreLine() {
        //设置想要展示的数据内容
        Intent intent = new Intent(mContext, OtherActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        int smallIcon = R.drawable.netease_bigicon;
        String ticker = "您有一条新通知";
        String title = "朱立伦请辞国民党主席 副主席黄敏惠暂代党主席";
        String content = "据台湾“中央社”报道，国民党主席朱立伦今天(18日)向中常会报告，为败选请辞党主席一职，他感谢各位中常委的指教包容，也宣布未来党务工作由副主席黄敏惠暂代，完成未来所有补选工作。";
        //实例化工具类，并且调用接口
        NotifyUtil notify2 = new NotifyUtil(mContext, 2);
        notify2.notify_normail_moreline(pIntent, smallIcon, ticker, title, content, true, true, false);
        currentNotify = notify2;
    }

    /**
     * 收件箱样式
     */
    private void notify_mailbox() {
        //设置想要展示的数据内容
        Intent intent = new Intent(mContext, OtherActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        int largeIcon = R.drawable.fbb_largeicon;
        int smallIcon = R.drawable.wx_smallicon;
        String ticker = "您有一条新通知";
        String title = "冰冰";
        ArrayList<String> messageList = new ArrayList<String>();
        messageList.add("文明,今晚有空吗？");
        messageList.add("晚上跟我一起去玩吧?");
        messageList.add("怎么不回复我？？我生气了！！");
        messageList.add("我真生气了！！！！！你听见了吗!");
        messageList.add("文明，别不理我！！！");
        String content = "[" + messageList.size() + "条]" + title + ": " + messageList.get(0);
        //实例化工具类，并且调用接口
        NotifyUtil notify3 = new NotifyUtil(mContext, 3);
        notify3.notify_mailbox(pIntent, smallIcon, largeIcon, messageList, ticker,
                title, content, true, true, false);
        currentNotify = notify3;
    }

    /**
     * 高仿系统截图通知
     */
    private void notify_bigPic() {
        //设置想要展示的数据内容
        Intent intent = new Intent(mContext, OtherActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        int smallIcon = R.drawable.xc_smaillicon;
        int largePic = R.drawable.screenshot;
        String ticker = "您有一条新通知";
        String title = "已经抓取屏幕截图";
        String content = "触摸可查看您的屏幕截图";
        //实例化工具类，并且调用接口
        NotifyUtil notify4 = new NotifyUtil(mContext, 4);
        notify4.notify_bigPic(pIntent, smallIcon, ticker, title, content, largePic, true, true, false);
        currentNotify = notify4;
    }


    /**
     * 高仿应用宝
     */
    private void notify_customview() {
        //设置想要展示的数据内容
        Intent intent = new Intent(mContext, OtherActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        String ticker = "您有一条新通知";

        //设置自定义布局中按钮的跳转界面
        Intent btnIntent = new Intent(mContext, OtherActivity.class);
        btnIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        //如果是启动activity，那么就用PendingIntent.getActivity，如果是启动服务，那么是getService
        PendingIntent Pintent = PendingIntent.getActivity(mContext,
                (int) SystemClock.uptimeMillis(), btnIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // 自定义布局
        RemoteViews remoteViews = new RemoteViews(mContext.getPackageName(),
                R.layout.yyb_notification);
        remoteViews.setImageViewResource(R.id.image, R.drawable.yybao_bigicon);
        remoteViews.setTextViewText(R.id.title, "垃圾安装包太多");
        remoteViews.setTextViewText(R.id.text, "3个无用安装包，清理释放的空间");
        remoteViews.setOnClickPendingIntent(R.id.button, Pintent);//定义按钮点击后的动作
        int smallIcon = R.drawable.yybao_smaillicon;
        //实例化工具类，并且调用接口
        NotifyUtil notify5 = new NotifyUtil(mContext, 5);
        notify5.notify_customview(remoteViews, pIntent, smallIcon, ticker, true, true, false);
        currentNotify = notify5;
    }

    /**
     * 高仿Android更新提醒样式
     */
    private void notify_buttom() {
        //设置想要展示的数据内容
        String ticker = "您有一条新通知";
        int smallIcon = R.drawable.android_bigicon;
        int lefticon = R.drawable.android_leftbutton;
        String lefttext = "以后再说";
        Intent leftIntent = new Intent();
        leftIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent leftPendIntent = PendingIntent.getActivity(mContext,
                requestCode, leftIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        int righticon = R.drawable.android_rightbutton;
        String righttext = "安装";
        Intent rightIntent = new Intent(mContext, OtherActivity.class);
        rightIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent rightPendIntent = PendingIntent.getActivity(mContext,
                requestCode, rightIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        //实例化工具类，并且调用接口
        NotifyUtil notify6 = new NotifyUtil(mContext, 6);
        notify6.notify_button(smallIcon, lefticon, lefttext, leftPendIntent, righticon, righttext, rightPendIntent, ticker, "系统更新已下载完毕", "Android 6.0.1", true, true, false);
        currentNotify = notify6;
    }


    /**
     * 高仿Android系统下载样式
     */
    private void notify_progress() {
        //设置想要展示的数据内容
        Intent intent = new Intent(mContext, OtherActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent rightPendIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        int smallIcon = R.drawable.android_bigicon;
        String ticker = "您有一条新通知";
        //实例化工具类，并且调用接口
        NotifyUtil notify7 = new NotifyUtil(mContext, 7);
        notify7.notify_progress(rightPendIntent, smallIcon, ticker, "Android 6.0.1 下载", "正在下载中", true, false, false);
        currentNotify = notify7;
    }

    /**
     * Android 5。0 新特性：悬浮式通知
     */
    private void notify_headUp() {
        //设置想要展示的数据内容
        int smallIcon = R.drawable.hl_smallicon;
        int largeIcon = R.drawable.fbb_largeicon;
        String ticker = "您有一条新通知";
        String title = "范冰冰";
        String content = "文明，今晚在希尔顿酒店2016号房哈";
        Intent intent = new Intent(mContext, OtherActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);


        int lefticon = R.drawable.hl_message;
        String lefttext = "回复";
        Intent leftIntent = new Intent();
        leftIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent leftPendingIntent = PendingIntent.getActivity(mContext,
                requestCode, leftIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        int righticon = R.drawable.hl_call;
        String righttext = "拨打";
        Intent rightIntent = new Intent(mContext, OtherActivity.class);
        rightIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent rightPendingIntent = PendingIntent.getActivity(mContext,
                requestCode, rightIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        //实例化工具类，并且调用接口
        NotifyUtil notify8 = new NotifyUtil(mContext, 8);
        notify8.notify_HeadUp(pendingIntent, smallIcon, largeIcon, ticker, title, content, lefticon, lefttext, leftPendingIntent, righticon, righttext, rightPendingIntent, true, true, false);
        currentNotify = notify8;
    }

}

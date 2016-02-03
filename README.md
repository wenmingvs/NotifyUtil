# NotifyDemo  
 [个人博客]

**高仿淘宝，网易新闻，微信，应用宝，环聊等等热门App的通知视图，并且完通知工具类的封装，提供多达8种最常见的App通知接口,支持Android 5.0悬浮式通知样式，欢迎大家star我的新的项目**

NotifyDemo Android App, require Android 4.0+, GPL v3 License  

[Download Link ](https://github.com/wenmingvs/NotifyUtil/raw/master/sample-debug.apk)  

八种通知类型的展示
------
![enter image description here](http://ww1.sinaimg.cn/large/691cc151gw1f07gtdxy53g20bc0h01l1.gif)


用法：
-----

1. 填充想要展示的内容
``` java
        Intent intent = new Intent(mContext, OtherActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        int smallIcon = R.drawable.tb_bigicon;
        String ticker = "您有一条新通知";
        String title = "双十一大优惠！！！";
        String content = "仿真皮肤充气娃娃，女朋友带回家！";
```
  
2. 实例化工具类，并且调用对应方法即可
``` java
 NotifyUtil notify1 = new NotifyUtil(mContext, 1);
 notify1.notify_normal_singline(pIntent, smallIcon, ticker, title, content, true, true, false);
```


工具类中的八种通知方法的使用展示
----- 
1. 淘宝样式：普通类型通知(单行)
-----
![enter image description here](http://ww3.sinaimg.cn/large/691cc151gw1f0774vsy7xg20dc0k0x6p.gif)

``` java
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
```

2. 网易新闻样式：普通类型通知(多行)
-----
![enter image description here](http://ww2.sinaimg.cn/mw690/691cc151gw1f07752ahgrg20dc0k0u0y.gif)
``` java
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

```

3. 微信消息样式： 消息列表通知(含双图标)
-----

![enter image description here](http://ww4.sinaimg.cn/mw690/691cc151gw1f07757tlbrg20dc0k0hdu.gif)

``` java
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

```

	

4. 系统截图通知样式： 含大图类型通知
-----

![enter image description here](http://ww2.sinaimg.cn/mw690/691cc151gw1f0775gxs2gg20dc0k0b2c.gif)

``` java
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

```

5. 应用宝样式： 自定义视图通知
-----

![enter image description here](http://ww3.sinaimg.cn/mw690/691cc151gw1f0775l59i1g20dc0k0u0x.gif)

``` java
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
```

6. Android系统更新样式： 折叠式双按钮通知
-----
![enter image description here](http://ww2.sinaimg.cn/mw690/691cc151gw1f0775pd4dkg20dc0k04qq.gif)
``` java
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
```

7. Android系统下载样式： 进度条通知
-----

![enter image description here](http://ww2.sinaimg.cn/mw690/691cc151gw1f0775t3kt7g20dc0k0hdt.gif)
``` java

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

```

8. Heads-up 样式： Android 5.0 新特性
-----
![enter image description here](http://ww4.sinaimg.cn/mw690/691cc151gw1f0775ybu5lg20dc0k0npe.gif)
``` java
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

```

9. 清空通知
-----
``` java

private NotifyUtil currentNotify

 button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   if (currentNotify != null) {
                    currentNotify.clear();
                }
            }
        });
```

Gradle 构建
------
- 版本
	- 最新 Android SDK
	- Gradle
- 环境变量
	- ANDROID_HOME
	- GRADLE_HOME，同时把bin放入path变量
	- Android SDK 安装，都更新到最新
	- Android SDK Build-tools更新到最新
	- Google Repository更新到最新
	- Android Support Repository更新到最新
	- Android Support Library更新到最新


相信未来
-----
当蜘蛛网无情地查封了我的炉台   
当灰烬的余烟叹息着贫困的悲哀   
我依然固执地铺平失望的灰烬   
用美丽的雪花写下：相信未来   

当我的紫葡萄化为深秋的露水   
当我的鲜花依偎在别人的情怀   
我依然固执地用凝霜的枯藤   
在凄凉的大地上写下：相信未来   

我要用手指那涌向天边的排浪  
我要用手掌那托住太阳的大海  
摇曳着曙光那枝温暖漂亮的笔杆   
用孩子的笔体写下：相信未来   

我之所以坚定地相信未来  
是我相信未来人们的眼睛  
她有拨开历史风尘的睫毛  
她有看透岁月篇章的瞳孔  

不管人们对于我们腐烂的皮肉  
那些迷途的惆怅、失败的苦痛  
是寄予感动的热泪、深切的同情   
还是给以轻蔑的微笑、辛辣的嘲讽   

我坚信人们对于我们的脊骨  
那无数次的探索、迷途、失败和成功   
一定会给予热情、客观、公正的评定   
是的，我焦急地等待着他们的评定  

朋友，坚定地相信未来吧  
相信不屈不挠的努力  
相信战胜死亡的年轻  
相信未来、热爱生命  


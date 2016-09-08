package com.luomo.toastdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
  * @author :renpan
  * @version :v1.0
  * @class :
  * @date :2014-09-08 15:02
  * @description:
  */
public class ToastUtils {
    /**
     * toast实例
     */
    private static Toast instance = null;
    private static Context context = null;
    private static TextView sTvMsg;
    private static ImageView sIvIcon;
    /**
     * 正常
     */
    public static final int ICON_NORMAL = 1;
    /**
     * 笑
     */
    public static final int ICON_LAUGH = 2;
    /**
     * 挤眼
     */
    public static final int ICON_WINK = 3;
    public static int sType;

    private static synchronized Toast getInstance() {
        if (instance == null) {
            instance = new Toast(context);
        }
        return instance;
    }

    private static void newInstance(Context context, String msg) {
        ToastUtils.context = context;
        View view = LayoutInflater.from(context).inflate(R.layout.layout_toast, null);
        sTvMsg = (TextView) view.findViewById(R.id.toast_msg);
        sIvIcon = (ImageView) view.findViewById(R.id.toast_icon);
        sTvMsg.setText(msg);
        instance = getInstance();
        instance.setGravity(17, 0, 0);
        instance.setDuration(Toast.LENGTH_SHORT);
        instance.setView(view);
    }

    /**
     * show instance
     *
     * @param context
     * @param msg
     */
    public static void show(Context context, String msg) {
        if (null == instance) {
            newInstance(context, msg);
        }
        switch (sType) {
            case 2:
                sIvIcon.setBackgroundResource(R.mipmap.ee_2);
                break;
            case 3:
                sIvIcon.setBackgroundResource(R.mipmap.ee_3);
                break;
            default:
                sIvIcon.setBackgroundResource(R.mipmap.ee_1);
                break;
        }
        sTvMsg.setText(msg);
        instance.show();
    }

    /**
     * show instance
     *
     * @param context
     * @param stringId
     */
    public static void show(Context context, int stringId) {
        show(context, stringId, ICON_NORMAL);
    }

    /**
     * @param context
     * @param stringId
     * @param type 图标类型
     */
    public static void show(Context context, int stringId, int type) {
        sType = type;
        show(context, context.getString(stringId));
    }

    /**
     * dismiss instance
     */
    public static void dismiss() {
        if (null != instance) {
            instance.cancel();
            instance = null;
        }
    }
}
package com.common.commonutil;

import android.app.Activity;
import android.app.Service;
import android.os.Vibrator;

import com.common.baseapp.BaseApplication;

/**
 * Created by lzy on 2017/2/21 19:35
 * 手机震动工具类
 */

public class VibratorUtil {
    /**
     * final Activity activity ：调用该方法的Activity实例
     * long pattern ：震动的时长，单位是毫秒
     */
    public static void Vibrate(final Activity activity, long milliseconds) {
        Vibrator vib = (Vibrator) activity.getSystemService(Service.VIBRATOR_SERVICE);
        vib.vibrate(milliseconds);
    }


    public static void Vibrate(long milliseconds) {
        Vibrator vib = (Vibrator) BaseApplication.getAppContext().getSystemService(Service.VIBRATOR_SERVICE);
        vib.vibrate(milliseconds);
    }

    /**
     *
     * <strong>@param </strong>activity 调用该方法的Activity实例
     * <strong>@param </strong>pattern long[] pattern ：自定义震动模式 。数组中数字的含义依次是[静止时长，震动时长，静止时长，震动时长。。。]时长的单位是毫秒
     * <strong>@param </strong>isRepeat 是否反复震动，如果是true，反复震动，如果是false，只震动一次
     */
    public static void Vibrate(final Activity activity, long[] pattern,boolean isRepeat) {
        Vibrator vib = (Vibrator) activity.getSystemService(Service.VIBRATOR_SERVICE);
        vib.vibrate(pattern, isRepeat ? 1 : -1);
    }

    public static void Vibrate(long[] pattern,boolean isRepeat) {
        Vibrator vib = (Vibrator) BaseApplication.getAppContext().getSystemService(Service.VIBRATOR_SERVICE);
        vib.vibrate(pattern, isRepeat ? 1 : -1);
    }
}

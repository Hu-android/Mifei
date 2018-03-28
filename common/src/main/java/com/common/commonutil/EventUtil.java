package com.common.commonutil;


/**
 * Description:
 * Creator: yxc
 * date: $date $time
 */
public class EventUtil {
    protected static long lastClickTime;

    /**
     * 防止重复点击
     *
     * @return 是否重复点击
     */
    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 800) {
            return true;
        }
        lastClickTime = time;
        return false;
    }


}

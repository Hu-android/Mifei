package com.example.administrator.mifei.utils;

import android.util.Log;

/**
 * Created by 123 on 2018/5/25.
 */

public class L {
    private static boolean debug = true;

    public static void e(String msg)
    {
        if (debug)
        {
            Log.e("Android-hu", msg);
        }
    }
}

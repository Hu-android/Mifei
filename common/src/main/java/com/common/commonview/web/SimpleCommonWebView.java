package com.common.commonview.web;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;


/**
 * 通用的WebView
 */
public class SimpleCommonWebView extends WebView {

    public static final String ENCODING_UTF_8 = "UTF-8";

    public static final String MIME_TYPE = "text/html";

    public SimpleCommonWebView(Context context) {

        super(context);
        init();
    }

    public SimpleCommonWebView(Context context, AttributeSet attrs) {

        super(context, attrs);
        init();
    }

    public SimpleCommonWebView(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SimpleCommonWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {

        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {

//        if (isInEditMode()) {
//            return;
//        }
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
//        settings.setBuiltInZoomControls(false);
//        //设置缓存模式
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
//        //开启DOM storage API功能
//        settings.setDomStorageEnabled(true);
//        //开启database storage 功能
//        settings.setDatabaseEnabled(true);
//
//        String cacheDir = getContext().getFilesDir().getAbsolutePath() + "web_cache";
//        settings.setAppCachePath(cacheDir);
//        settings.setAppCacheEnabled(true);
//
//        settings.setLoadsImagesAutomatically(true);
//        settings.setDefaultTextEncodingName(ENCODING_UTF_8);
//        settings.setBlockNetworkImage(false);
//        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        settings.setUseWideViewPort(true);
//        settings.setLoadWithOverviewMode(true);
//        setHorizontalScrollBarEnabled(false);
//
//        settings.setAllowFileAccess(true); //设置可以访问文件
//        settings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
//
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
//        }


    }
}

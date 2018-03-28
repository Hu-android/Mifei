package com.common.commonview.web;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.ProgressBar;


public class CommonWebViewClient extends android.webkit.WebViewClient {

    private ProgressBar mBar;
    private boolean isAppOpen;

    public CommonWebViewClient(ProgressBar bar) {

        this(bar, true);
    }

    public CommonWebViewClient(ProgressBar bar, boolean isAppOpen) {

        mBar = bar;
        this.isAppOpen = isAppOpen;
    }

    @Override
    public void onLoadResource(WebView view, String url) {

        super.onLoadResource(view, url);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {


        if (url != null && url.startsWith("orpheus")) {
            return true;
        }
        if (url != null && url.startsWith("http")) {
            if (!isAppOpen) {
                return false;
            } else {
                view.loadUrl(url);
            }

        }
        return true;
    }

    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {

        return super.shouldInterceptRequest(view, url);
    }

    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {

        return super.shouldInterceptRequest(view, request);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {

        super.onPageStarted(view, url, favicon);
        if (mBar != null) mBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPageFinished(WebView view, String url) {

        super.onPageFinished(view, url);
        if (mBar != null) mBar.setVisibility(View.GONE);
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
    }

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        super.onReceivedSslError(view, handler, error);
        handler.proceed();//接受证书
    }
}

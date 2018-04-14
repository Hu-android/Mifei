package com.example.administrator.mifei.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.common.commonbase.BaseBackActivity;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.activity.PwdChange;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class ClipImageActivity extends BaseBackActivity implements View.OnClickListener{

    private static final String TAG = "ClipImageActivity";
    private ClipViewLayout clipViewLayout1;
    private TextView btnCancel;
    private TextView btnOk;

    @Override
    public int getLayoutId() {
        return R.layout.activity_clip_image;
    }

    @Override
    public String getTitleName() {
        return "移动和缩放";
    }

    @Override
    public int getImgSrc() {
        return R.drawable.page1back;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        initView();
    }


    /**
     * 初始化组件
     */
    public void initView() {
        clipViewLayout1 = (ClipViewLayout) findViewById(R.id.clipViewLayout1);
        btnCancel = (TextView) findViewById(R.id.btn_cancel);
        btnOk = (TextView) findViewById(R.id.btn_ok);
        //设置点击事件监听器
        btnCancel.setOnClickListener(this);
        btnOk.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //设置图片资源
        clipViewLayout1.setImageSrc(getIntent().getData());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel:
                finish();
                break;
            case R.id.btn_ok:
                generateUriAndReturn();
                break;
        }
    }


    /**
     * 生成Uri并且通过setResult返回给打开的activity
     */
    private void generateUriAndReturn() {
        //调用返回剪切图
        Bitmap zoomedCropBitmap;
        zoomedCropBitmap = clipViewLayout1.clip();
        if (zoomedCropBitmap == null) {
            Log.e("android", "zoomedCropBitmap == null");
            return;
        }
        Uri mSaveUri = Uri.fromFile(new File(getCacheDir(), "cropped_" + System.currentTimeMillis() + ".jpg"));
        if (mSaveUri != null) {
            OutputStream outputStream = null;
            try {
                outputStream = getContentResolver().openOutputStream(mSaveUri);
                if (outputStream != null) {
                    zoomedCropBitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
                }
            } catch (IOException ex) {
                Log.e("android", "Cannot open file: " + mSaveUri, ex);
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            Intent intent = new Intent();
            intent.setData(mSaveUri);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    public static void toActivity(Context context){
        Intent intent = new Intent(context,ClipImageActivity.class);
        context.startActivity(intent);
    }
}

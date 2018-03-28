package com.common.commonutil;

import android.app.Activity;

import com.common.baseapp.BaseApplication;
import com.yancy.gallerypick.config.GalleryConfig;
import com.yancy.gallerypick.config.GalleryPick;
import com.yancy.gallerypick.inter.IHandlerCallBack;

import java.util.List;

/**
 * 图片选择器管理类
 * Created by liu on 2017/3/8 11:28
 */

public class GalleryUtil {

    private static final String TAG = "GalleryUtil";

    public static final int CAMERA_TYPE = 1;
    public static final int PICTURE_TYPE = 2;

    public static void chooseHead(Activity activity, IHandlerCallBack iHandlerCallBack, int type) {
        GalleryConfig galleryConfig = getBaseGalleryConfig(iHandlerCallBack)
                .crop(true)
                .crop(true, 1, 1, 500, 500)
                .build();
        if (type == CAMERA_TYPE) {
            GalleryPick.getInstance().setGalleryConfig(galleryConfig).openCamera(activity);
        } else {
            GalleryPick.getInstance().setGalleryConfig(galleryConfig).open(activity);
        }

    }

    public static void choosePhoto(Activity activity, IHandlerCallBack iHandlerCallBack, int type, int maxSize) {
        GalleryConfig galleryConfig = getBaseGalleryConfig(iHandlerCallBack)
                .crop(false)
                .multiSelect(true, maxSize)
                .build();
        if (type == CAMERA_TYPE) {
            GalleryPick.getInstance().setGalleryConfig(galleryConfig).openCamera(activity);
        } else {
            GalleryPick.getInstance().setGalleryConfig(galleryConfig).open(activity);
        }
    }

    public static void chooseSelectPhoto(Activity activity, IHandlerCallBack iHandlerCallBack, int type, int maxSize, List<String> selectList) {
        GalleryConfig galleryConfig = getBaseGalleryConfig(iHandlerCallBack)
                .crop(false)
                .multiSelect(true, maxSize)
                .pathList(selectList)                         // 记录已选的图片
                .build();
        if (type == CAMERA_TYPE) {
            GalleryPick.getInstance().setGalleryConfig(galleryConfig).openCamera(activity);
        } else {
            GalleryPick.getInstance().setGalleryConfig(galleryConfig).open(activity);
        }
    }


    public static GalleryConfig.Builder getBaseGalleryConfig(IHandlerCallBack iHandlerCallBack) {
        String packageName = AppUtils.getAppPackageName(BaseApplication.getAppContext());
        GalleryConfig.Builder builder = new GalleryConfig.Builder()
                .imageLoader(new GlideImageLoader())    // ImageLoader 加载框架（必填）
                .iHandlerCallBack(iHandlerCallBack)     // 监听接口（必填）
                .provider(packageName + ".fileprovider") // provider(必填)
//                .pathList(path)                         // 记录已选的图片
//              .multiSelect(false)                      // 是否多选   默认：false
//              .multiSelect(false, 9)                   // 配置是否多选的同时 配置多选数量   默认：false ， 9
//              .maxSize(9)                             // 配置多选时 的多选数量。    默认：9
//              .crop(true, 1, 1, 500, 500)             // 配置裁剪功能的参数，   默认裁剪比例 1:1
                .isShowCamera(false)                     // 是否现实相机按钮  默认：false
                .filePath("/" + packageName + "/Gallery/Pictures");       // 图片存放路径
        return builder;
    }


}

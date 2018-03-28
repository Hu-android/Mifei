package com.example.administrator.mifei.bean;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Created by Administrator on 2018/3/21.
 */

public class TabEntity implements CustomTabEntity{
    public String title;
    public int selectedIcon;
    public int unSelectedIcon;



    public TabEntity(String title,int selectedIcon , int unSelectedIcon) {

        this.selectedIcon = selectedIcon;
        this.title = title;
        this.unSelectedIcon = unSelectedIcon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectedIcon;
    }
}

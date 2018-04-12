package com.example.administrator.mifei.bean;

import com.example.administrator.mifei.http.bean.BaseHttpModel;

/**
 * Created by Administrator on 2018/4/12 0012.
 */

public class MineAddressModel {
    public static class addressInfo extends BaseHttpModel{
        public String user_name;
        public String user_address;
        public String user_tel;
        public int isDefault;


        public addressInfo(String user_name, String user_tel, String user_address) {
            this.user_name = user_name;
            this.user_address = user_address;
            this.user_tel = user_tel;
        }


        public String getUser_name() {
            return user_name;
        }

        public String getUser_address() {
            return user_address;
        }

        public String getUser_tel() {
            return user_tel;
        }
    }
}

package com.example.administrator.mifei.bean;

import com.example.administrator.mifei.http.bean.BaseHttpModel;

/**
 * Created by Administrator on 2018/4/10 0010.
 */

public class fragment_mine_model {

    public static class mineHeaderView{
        private int userHeaders;
        private String userNickName;
        private String userSalesNum;

        public mineHeaderView(int userHeaders, String userNickName, String userSalesNum) {
            this.userHeaders = userHeaders;
            this.userNickName = userNickName;
            this.userSalesNum = userSalesNum;
        }

        public int getUserHeaders() {
            return userHeaders;
        }

        public String getUserNickName() {
            return userNickName;
        }

        public String getUserSalesNum() {
            return userSalesNum;
        }
    }

    public static class mineFunctionView extends BaseHttpModel{
        private int type;
        private int functionImg;
        private String functionName;

        public mineFunctionView(int type){
            this.type = type;
        }

        public mineFunctionView(int type, int functionImg, String functionName) {
            this.type = type;
            this.functionImg = functionImg;
            this.functionName = functionName;
        }

        public int getType() {
            return type;
        }

        public int getFunctionImg() {
            return functionImg;
        }

        public String getFunctionName() {
            return functionName;
        }
    }
}

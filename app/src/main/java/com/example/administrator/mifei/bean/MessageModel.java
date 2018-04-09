package com.example.administrator.mifei.bean;

import com.example.administrator.mifei.http.bean.BaseHttpModel;

/**
 * Created by Administrator on 2018/4/9 0009.
 */

public class MessageModel {

    public static class messageInfo extends BaseHttpModel{
        public int imgResourse;
        public String msgTitle;
        public String msgOrderNum;
        public String msgInfo;
        public String msgDateTime;


        public messageInfo(int imgResourse, String msgTitle, String msgInfo/*,String msgDateTime*/) {
            this.msgDateTime = msgDateTime;
            this.msgInfo = msgInfo;
            this.msgTitle = msgTitle;
            this.imgResourse = imgResourse;
        }

        public messageInfo(int imgResourse, String msgTitle, String msgOrderNum, String msgInfo/*, String msgDateTime*/) {
            this.imgResourse = imgResourse;
            this.msgTitle = msgTitle;
            this.msgOrderNum = msgOrderNum;
            this.msgInfo = msgInfo;
            this.msgDateTime = msgDateTime;
        }

        public int getImgResourse() {
            return imgResourse;
        }

        public void setImgResourse(int imgResourse) {
            this.imgResourse = imgResourse;
        }

        public String getMsgTitle() {
            return msgTitle;
        }

        public void setMsgTitle(String msgTitle) {
            this.msgTitle = msgTitle;
        }

        public String getMsgOrderNum() {
            return msgOrderNum;
        }

        public void setMsgOrderNum(String msgOrderNum) {
            this.msgOrderNum = msgOrderNum;
        }

        public String getMsgInfo() {
            return msgInfo;
        }

        public void setMsgInfo(String msgInfo) {
            this.msgInfo = msgInfo;
        }

        public String getMsgDateTime() {
            return msgDateTime;
        }

        public void setMsgDateTime(String msgDateTime) {
            this.msgDateTime = msgDateTime;
        }
    }
}

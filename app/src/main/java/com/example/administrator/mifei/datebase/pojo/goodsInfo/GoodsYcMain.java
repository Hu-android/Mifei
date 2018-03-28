package com.example.administrator.mifei.datebase.pojo.goodsInfo;

/**
 * Created by Administrator on 2018/3/23.
 */

public class GoodsYcMain extends BaseModel{

    public String txtContentName;
    public String txtContentAllowPickNum;
    public String txtContentLackNum;

    public GoodsYcMain(String txtContentAllowPickNum, String txtContentLackNum, String txtContentName) {
        this.txtContentAllowPickNum = txtContentAllowPickNum;
        this.txtContentLackNum = txtContentLackNum;
        this.txtContentName = txtContentName;
    }

    public String getTxtContentAllowPickNum() {
        return txtContentAllowPickNum;
    }

    public void setTxtContentAllowPickNum(String txtContentAllowPickNum) {
        this.txtContentAllowPickNum = txtContentAllowPickNum;
    }

    public String getTxtContentLackNum() {
        return txtContentLackNum;
    }

    public void setTxtContentLackNum(String txtContentLackNum) {
        this.txtContentLackNum = txtContentLackNum;
    }

    public String getTxtContentName() {
        return txtContentName;
    }

    public void setTxtContentName(String txtContentName) {
        this.txtContentName = txtContentName;
    }
}

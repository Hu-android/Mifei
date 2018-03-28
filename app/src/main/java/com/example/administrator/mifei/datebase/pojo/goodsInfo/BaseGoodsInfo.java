package com.example.administrator.mifei.datebase.pojo.goodsInfo;

/**
 * Created by Administrator on 2018/3/23.
 */

public class BaseGoodsInfo extends BaseModel{

    //商品信息类型
    public static final int goodsInfoYcMain    = 1;
    public static final int goodsInfoYcBuy     = 2;
    public static final int goodsInfoYcPick    = 3;
    public static final int goodsInfoYcBuyPay  = 4;
    public static final int goodsInfoMineBuy   = 5;
    public static final int goodsInfoZhigou    = 6;
    public static final int goodsInfoZhiGouPay = 7;

    public int InfoType = 0;
}

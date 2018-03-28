package com.example.administrator.mifei.datebase.pojo;

import com.example.administrator.mifei.datebase.pojo.goodsInfo.BaseGoodsInfo;
import com.example.administrator.mifei.datebase.pojo.goodsInfo.BaseModel;
import com.litesuits.orm.db.annotation.Check;
import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.annotation.Unique;


/**
 * Created by Administrator on 2018/3/23.
 */

@Table("Goods_Info")
public class GoodsInfo extends BaseModel {

    public static final String goodsIdKey = "GoodsId";

    @Unique
    public String goodsName;
    public int oldPrice;
    public int newPrice;



}

package com.example.administrator.mifei.datebase.pojo.goodsInfo;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.enums.AssignType;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/23.
 */

public class BaseModel implements Serializable {

    private static final long setialVersionUID = 1L;

    //设置为主键，自增
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int _GoodsId;

    public int get_GoodsId() {
        return _GoodsId;
    }

    public void set_GoodsId(int _GoodsId) {
        this._GoodsId = _GoodsId;
    }
}

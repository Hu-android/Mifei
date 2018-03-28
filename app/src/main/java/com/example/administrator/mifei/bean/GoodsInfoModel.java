package com.example.administrator.mifei.bean;

import com.example.administrator.mifei.http.bean.BaseHttpModel;

import java.util.List;

/**
 * Created by Administrator on 2018/3/24.
 */

public class GoodsInfoModel extends BaseHttpModel{

    public List<txtTitle>txtTitles;
    public List<goodsInfo_YCKCTop> goodsInfos_YCKCTop;
    public List<goodsInfo_Pick> goodsInfo_picks;
    public static class goodsInfo_YCKCTop extends BaseHttpModel{
        public String goodsName;
        public int goodsImage;
        public int canPickGoods;
        public int lackGoods;

        public goodsInfo_YCKCTop(String goodsName, int canPickGoods, int lackGoods, int goodsImage) {
            this.canPickGoods = canPickGoods;
            this.goodsImage = goodsImage;
            this.goodsName = goodsName;
            this.lackGoods = lackGoods;
        }
    }

    public static class txtTitle extends BaseHttpModel{
        public String txtTitle_item;

        public txtTitle(String txtTitle_item) {
            this.txtTitle_item = txtTitle_item;
        }
    }

    public static class goodsInfo_Pick extends BaseHttpModel{
        public String goodsName;
        public int pickPriceHigher;
        public int pickPrice;

        public goodsInfo_Pick(String goodsName, int pickPrice, int pickPriceHigher) {
            this.goodsName = goodsName;
            this.pickPrice = pickPrice;
            this.pickPriceHigher = pickPriceHigher;
        }
    }

}

package com.example.administrator.mifei.bean;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/29 0029.
 */

public class ShopCart {
    private int shoppingAccount;//商品总数
    private double shoppingTotalPrice;//商品总价钱
    private Map<GoodsInfoModel.goodsInfo_Pick,Integer> shoppingSingle;//单个物品的总价价钱

    public ShopCart(){
        this.shoppingAccount = 0;
        this.shoppingTotalPrice = 0;
        this.shoppingSingle = new HashMap<>();
    }

    public int getShoppingAccount() {
        return shoppingAccount;
    }

    public double getShoppingTotalPrice() {
        return shoppingTotalPrice;
    }

    public Map<GoodsInfoModel.goodsInfo_Pick, Integer> getShoppingSingle() {
        return shoppingSingle;
    }

    public boolean addShoppingSingle(GoodsInfoModel.goodsInfo_Pick goodsInfo_pick){
        int remain = goodsInfo_pick.getRemain();
        if (remain<=0)
            return false;
        goodsInfo_pick.setRemain(--remain);
        int num = 0;
        if (shoppingSingle.containsKey(goodsInfo_pick)){
            num = shoppingSingle.get(goodsInfo_pick);
        }
        num+=1;
        shoppingSingle.put(goodsInfo_pick,num);
        Log.e("TAG","addShoppingSingle:" + shoppingSingle.get(goodsInfo_pick));

        shoppingTotalPrice += goodsInfo_pick.getPickPrice();
        shoppingAccount++;
        return true;
    }

    public boolean subShoppingSingle(GoodsInfoModel.goodsInfo_Pick goodsInfo_pick){
        int num = 0;
        if (shoppingSingle.containsKey(goodsInfo_pick)){
            num = shoppingSingle.get(goodsInfo_pick);
        }
        if (num<=0) return false;
        num--;
        int remin = goodsInfo_pick.getRemain();
        goodsInfo_pick.setRemain(++remin);
        shoppingSingle.put(goodsInfo_pick,num);
        if (num ==0) shoppingSingle.remove(goodsInfo_pick);

        shoppingTotalPrice -=goodsInfo_pick.getPickPrice();
        shoppingAccount--;
        return true;
    }

    public int getGoodsAccount(){
        return shoppingSingle.size();
    }

    public void clear(){
        this.shoppingAccount = 0;
        this.shoppingTotalPrice = 0;
        this.shoppingSingle.clear();
    }
}

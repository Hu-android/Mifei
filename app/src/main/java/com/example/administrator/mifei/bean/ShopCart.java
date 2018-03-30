package com.example.administrator.mifei.bean;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/30 0030.
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

    public Map<GoodsInfoModel.goodsInfo_Pick, Integer> getShoppingSingleMap() {
        return shoppingSingle;
    }

    public boolean addShoppingSingle(GoodsInfoModel.goodsInfo_Pick dish){
        int num = 0;
        if(shoppingSingle.containsKey(dish)){
            num = shoppingSingle.get(dish);
        }
        num+=1;
        shoppingSingle.put(dish,num);
        Log.e("TAG", "addShoppingSingle: "+shoppingSingle.get(dish));

        shoppingTotalPrice += dish.getPickPrice();
        shoppingAccount++;
        return true;
    }

    public boolean subShoppingSingle(GoodsInfoModel.goodsInfo_Pick goodsInfoPick){
        int num = 0;
        if(shoppingSingle.containsKey(goodsInfoPick)){
            num = shoppingSingle.get(goodsInfoPick);
        }
        shoppingSingle.put(goodsInfoPick,num);
        if (num ==0) shoppingSingle.remove(goodsInfoPick);

        shoppingTotalPrice -= goodsInfoPick.getPickPrice();
        shoppingAccount--;
        return true;
    }

    public int getDishAccount() {
        return shoppingSingle.size();
    }

    public void clear(){
        this.shoppingAccount = 0;
        this.shoppingTotalPrice = 0;
        this.shoppingSingle.clear();
    }
}

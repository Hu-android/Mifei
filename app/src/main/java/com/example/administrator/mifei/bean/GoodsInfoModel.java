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
        public double pickPriceHigher;
        public double pickPrice;
        public double totalPrice;
        public int goodsNum;
        public int goodsImage;

        public goodsInfo_Pick(int goodsImage, String goodsName, double pickPrice, double pickPriceHigher) {
            this.goodsImage = goodsImage;
            this.pickPrice = pickPrice;
            this.pickPriceHigher = pickPriceHigher;
            this.goodsName = goodsName;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public double getPickPriceHigher() {
            return pickPriceHigher;
        }

        public void setPickPriceHigher(double pickPriceHigher) {
            this.pickPriceHigher = pickPriceHigher;
        }

        public void setPickPrice(double pickPrice) {
            this.pickPrice = pickPrice;
        }

        public int getGoodsImage() {
            return goodsImage;
        }

        public void setGoodsImage(int goodsImage) {
            this.goodsImage = goodsImage;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public int getGoodsNum() {
            return goodsNum;
        }

        public void setGoodsNum(int goodsNum) {
            this.goodsNum = goodsNum;
        }

        public double getPickPrice() {
            return pickPrice;
        }
    }

    public static class goodsInfo_Buy extends BaseHttpModel{
        public String goodsName;
        public double pickPriceHigher;
        public double pickPrice;
        public double totalPrice;
        public int goodsNum;
        public int goodsImage;
        public int goodsInventory;

        public goodsInfo_Buy(String goodsName, double pickPrice, double pickPriceHigher, int goodsInventory, int goodsImage) {
            this.goodsName = goodsName;
            this.pickPriceHigher = pickPriceHigher;
            this.pickPrice = pickPrice;
            this.goodsImage = goodsImage;
            this.goodsInventory = goodsInventory;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public double getPickPriceHigher() {
            return pickPriceHigher;
        }

        public void setPickPriceHigher(double pickPriceHigher) {
            this.pickPriceHigher = pickPriceHigher;
        }

        public double getPickPrice() {
            return pickPrice;
        }

        public void setPickPrice(double pickPrice) {
            this.pickPrice = pickPrice;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public int getGoodsNum() {
            return goodsNum;
        }

        public void setGoodsNum(int goodsNum) {
            this.goodsNum = goodsNum;
        }

        public int getGoodsImage() {
            return goodsImage;
        }

        public void setGoodsImage(int goodsImage) {
            this.goodsImage = goodsImage;
        }

        public int getGoodsInventory() {
            return goodsInventory;
        }

        public void setGoodsInventory(int goodsInventory) {
            this.goodsInventory = goodsInventory;
        }
    }

    public static class goodsInfo_Zhigou extends BaseHttpModel {
        public String goodsName;
        public double pickPriceHigher;
        public double pickPrice;
        public double totalPrice;
        public int goodsNum;
        public int goodsImage;

        public goodsInfo_Zhigou(String goodsName, double pickPrice, double pickPriceHigher,int goodsImage) {
            this.goodsImage = goodsImage;
            this.pickPrice = pickPrice;
            this.pickPriceHigher = pickPriceHigher;
            this.goodsName = goodsName;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public double getPickPriceHigher() {
            return pickPriceHigher;
        }

        public void setPickPriceHigher(double pickPriceHigher) {
            this.pickPriceHigher = pickPriceHigher;
        }

        public double getPickPrice() {
            return pickPrice;
        }

        public void setPickPrice(double pickPrice) {
            this.pickPrice = pickPrice;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public int getGoodsNum() {
            return goodsNum;
        }

        public void setGoodsNum(int goodsNum) {
            this.goodsNum = goodsNum;
        }

        public int getGoodsImage() {
            return goodsImage;
        }

        public void setGoodsImage(int goodsImage) {
            this.goodsImage = goodsImage;
        }
    }

}

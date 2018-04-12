package com.example.administrator.mifei.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mifei.R;
import com.example.administrator.mifei.bean.GoodsInfoModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/3 0003.
 */

public class caseAdapter extends BaseAdapter{

    private Context mContext;
    private LayoutInflater inflater;
    private List<GoodsInfoModel.goodsInfo_Buy> buys = new ArrayList<>();
    //设置接口
    private View.OnClickListener onAddNum;  //加商品数量接口
    private View.OnClickListener onSubNum;  //减商品数量接口

    //设置接口方法
    public void setOnAddNum(View.OnClickListener onAddNum){
        this.onAddNum = onAddNum;
    }
    public void setOnSubNum(View.OnClickListener onSubNum){
        this.onSubNum = onSubNum;
    }

    public caseAdapter(Context mContext, List<GoodsInfoModel.goodsInfo_Buy> buys) {
        this.mContext = mContext;
        this.buys = buys;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (buys != null){
            ret = buys.size();
        }
        return ret;
    }

    @Override
    public Object getItem(int position) {
        return buys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = null;
        if (convertView != null){
            v = convertView;
        }else {
            v = LayoutInflater.from(mContext).inflate(R.layout.yckc_list_item,parent,false);
        }
        ViewHolder holder = (ViewHolder) v.getTag();
        if (holder == null){
            holder = new ViewHolder();
            holder.txtTop = (TextView) v.findViewById(R.id.txtTop);
            holder.txtMid = (TextView) v.findViewById(R.id.txtMid);
            holder.txtMid2 = (TextView) v.findViewById(R.id.txtMid2);
            holder.txtNumX = (TextView) v.findViewById(R.id.txtNumX);
            holder.txtBottom = (TextView) v.findViewById(R.id.txtBottom);
            holder.txtNum = (TextView) v.findViewById(R.id.txtNum);
            holder.imgGoods = (ImageView) v.findViewById(R.id.img_yckc_list_item);
            holder.txtTotalMoney = (TextView) v.findViewById(R.id.txtTotalMoney);
            holder.imgPlus = (ImageButton) v.findViewById(R.id.btnPlus);
            holder.imgPlus.setOnClickListener(onAddNum);
            holder.imgSub = (ImageButton) v.findViewById(R.id.btnSub);
            holder.imgSub.setOnClickListener(onSubNum);
        }
        holder.imgGoods.setImageResource(buys.get(position).getGoodsImage());
        holder.txtNumX.setVisibility(View.GONE);
        holder.txtTop.setText(buys.get(position).getGoodsName());
        holder.txtMid.setText(buys.get(position).getPickPrice()+"");
        holder.txtMid.setTextColor(Color.parseColor("#FFE63549"));
        holder.txtMid.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        holder.txtNum.setText(buys.get(position).getGoodsNum()+"");
        holder.txtMid2.setText(buys.get(position).getPickPriceHigher()+"");
        holder.txtBottom.setText("库存"+ buys.get(position).getGoodsInventory()+"箱");
        int num = buys.get(position).getGoodsNum();
        if (num == 0){
            holder.imgSub.setVisibility(View.GONE);
            holder.txtNum.setVisibility(View.GONE);
        }else{
            holder.imgSub.setVisibility(View.VISIBLE);
            holder.txtNum.setVisibility(View.VISIBLE);
        }
        holder.imgSub.setTag(position);
        holder.imgPlus.setTag(position);
        v.setTag(holder);
        return v;
    }

    private static class ViewHolder{
        TextView txtTop, txtMid, txtBottom, txtNum, txtMid2, txtNumX,txtTotalMoney;
        ImageView imgGoods;
        ImageButton imgPlus, imgSub;
    }


}

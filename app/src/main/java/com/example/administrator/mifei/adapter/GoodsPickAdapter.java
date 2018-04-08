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

import com.common.commonutil.CollectionUtils;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.bean.GoodsInfoModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/27.
 */

public class GoodsPickAdapter extends BaseAdapter {

    //上下文
    Context mContext;
    //集合，存放ListView的商品实体类数据
    List<GoodsInfoModel.goodsInfo_Pick> mList = new ArrayList<>();
    private List<GoodsInfoModel.goodsInfo_Pick>cList;
    //设置接口
    private View.OnClickListener onAddNum;  //加商品数量接口
    private View.OnClickListener onSubNum;  //减商品数量接口
    private LayoutInflater mInflater;
    private int count = 0;

    //设置接口方法
    public void setOnAddNum(View.OnClickListener onAddNum){
        this.onAddNum = onAddNum;
    }
    public void setOnSubNum(View.OnClickListener onSubNum){
        this.onSubNum = onSubNum;
    }

    public GoodsPickAdapter(Context context,List<GoodsInfoModel.goodsInfo_Pick> list) {
        this.mContext = context;
        this.cList = list;
        mInflater = LayoutInflater.from(context);
    }

    public void addData(List<GoodsInfoModel.goodsInfo_Pick> list) {
        if (CollectionUtils.isEmpty(list)) return;
        cList.clear();
        cList.addAll(list);
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return cList.size();
    }

    @Override
    public Object getItem(int position) {
        return cList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = null;
        if (convertView == null){
            v = LayoutInflater.from(mContext).inflate(R.layout.yckc_list_item,parent,false);
        }else {
            v = convertView;
        }

        ViewHolder holder = (ViewHolder) v.getTag();
        if (holder == null){
            holder = new ViewHolder();
            holder.txtNumX = (TextView) v.findViewById(R.id.txtNumX);
            holder.txtTop = (TextView) v.findViewById(R.id.txtTop);
            holder.txtMid = (TextView) v.findViewById(R.id.txtMid);
            holder.txtMid2 = (TextView) v.findViewById(R.id.txtMid2);
            holder.txtBottom = (TextView) v.findViewById(R.id.txtBottom);
            holder.txtNum = (TextView) v.findViewById(R.id.txtNum);
            holder.imgPlus = (ImageButton) v.findViewById(R.id.btnPlus);
            holder.imgSub = (ImageButton) v.findViewById(R.id.btnSub);
            holder.imgGoods = (ImageView) v.findViewById(R.id.img_yckc_list_item);
            holder.txtTotalMoney = (TextView) v.findViewById(R.id.txtTotalMoney);

            holder.imgPlus = (ImageButton) v.findViewById(R.id.btnPlus);
            holder.imgPlus.setOnClickListener(onAddNum);

            holder.imgSub = (ImageButton) v.findViewById(R.id.btnSub);
            holder.imgSub.setOnClickListener(onSubNum);
        }

        holder.txtBottom.setVisibility(View.GONE);
        holder.txtNumX.setVisibility(View.GONE);
        holder.txtMid.setTextColor(Color.parseColor("#FFE63549"));
        holder.txtMid.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        holder.imgGoods.setImageResource(cList.get(position).goodsImage);
        holder.txtTop.setText(cList.get(position).goodsName);
        holder.txtMid.setText(cList.get(position).pickPrice+"");
        holder.txtMid2.setText(cList.get(position).pickPriceHigher+"");
        //String price = "￥"+cList.get(position).getTotalPrice();
        //holder.txtTotalMoney.setText(price);
        //holder.txtTotalMoney.getPaint().setFlags(Paint.SUBPIXEL_TEXT_FLAG);
        holder.txtNum.setText(cList.get(position).getGoodsNum()+"");
        count = cList.get(position).goodsNum;
        if (count == 0){
            holder.txtNum.setVisibility(View.GONE);
            holder.imgSub.setVisibility(View.GONE);
        }else{
            holder.txtNum.setVisibility(View.VISIBLE);
            holder.imgSub.setVisibility(View.VISIBLE);
        }

        holder.imgPlus.setTag(position);
        holder.imgSub.setTag(position);

        v.setTag(holder);
        return v;
    }

    private static class ViewHolder {

        TextView txtTop, txtMid, txtBottom, txtNum, txtMid2, txtNumX,txtTotalMoney;
        ImageView imgGoods;
        ImageButton imgPlus, imgSub;

    }
}

package com.example.administrator.mifei.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
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
import com.example.administrator.mifei.activity.PickGoods;
import com.example.administrator.mifei.bean.GoodsInfoModel;
import com.example.administrator.mifei.bean.ShopCart;
import com.example.administrator.mifei.bean.ShoppCartImp;

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

    /* @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.yckc_list_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        GoodsInfoModel.goodsInfo_Pick pick = mList.get(position);
        viewHolder.txtTop.setText(pick.goodsName);
        viewHolder.txtMid.setText(pick.pickPrice+"");
        viewHolder.txtMid2.setText(pick.pickPriceHigher+"");

        final GoodsInfoModel.goodsInfo_Pick goodsInfo_pick = getItem(position);
        if (count == 0){
            viewHolder.imgSub.setVisibility(View.INVISIBLE);
            viewHolder.txtNum.setVisibility(View.GONE);
        }else {
            viewHolder.imgSub.setVisibility(View.VISIBLE);
            viewHolder.txtNum.setVisibility(View.VISIBLE);
            viewHolder.txtNum.setText(count + "");
        }
        viewHolder.imgSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        viewHolder.imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return convertView;
    }*/


    //设置不可点击
   /* @Override
    public boolean isEnabled(int position) {
        return false;
    }*/


    private static class ViewHolder {

        TextView txtTop, txtMid, txtBottom, txtNum, txtMid2, txtNumX,txtTotalMoney;
        ImageView imgGoods;
        ImageButton imgPlus, imgSub;

       /* public ViewHolder(View view) {
            txtNumX = (TextView) view.findViewById(R.id.txtNumX);
            txtTop = (TextView) view.findViewById(R.id.txtTop);
            txtMid = (TextView) view.findViewById(R.id.txtMid);
            txtMid2 = (TextView) view.findViewById(R.id.txtMid2);
            txtBottom = (TextView) view.findViewById(R.id.txtBottom);
            txtNum = (TextView) view.findViewById(R.id.txtNum);
            imgPlus = (ImageButton) view.findViewById(R.id.btnPlus);
            imgSub = (ImageButton) view.findViewById(R.id.btnSub);
            imgGoods = (ImageView) view.findViewById(R.id.img_yckc_list_item);
            txtBottom.setVisibility(View.GONE);
            txtNumX.setVisibility(View.GONE);
            txtMid.setTextColor(Color.parseColor("#FFE63549"));
            txtMid.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        }*/
    }
}

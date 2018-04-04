package com.example.administrator.mifei.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.bean.GoodsInfoModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/3 0003.
 */

public class caseAdapter extends BaseAdapter{

    //设置接口
    private View.OnClickListener onAddNum;  //加商品数量接口
    private View.OnClickListener onSubNum;  //减商品数量接口
    private Context mContext;
    private LayoutInflater inflater;
    private List<GoodsInfoModel.goodsInfo_Buy> buys = new ArrayList<>();

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

    /*@Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(inflater.inflate(R.layout.yckc_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.initData(position);
    }

    @Override
    public int getItemCount() {
        return buys.size();
    }*/

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

    /*private class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtTop, txtMid, txtBottom, txtNum, txtMid2, txtNumX,txtTotalMoney;
        ImageView imgGoods;
        ImageButton imgPlus, imgSub;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtTop = (TextView) itemView.findViewById(R.id.txtTop);
            txtMid = (TextView) itemView.findViewById(R.id.txtMid);
            txtMid2 = (TextView) itemView.findViewById(R.id.txtMid2);
            txtNumX = (TextView) itemView.findViewById(R.id.txtNumX);
            txtBottom = (TextView) itemView.findViewById(R.id.txtBottom);
            txtNum = (TextView) itemView.findViewById(R.id.txtNum);
            imgPlus = (ImageButton) itemView.findViewById(R.id.btnPlus);
            imgSub = (ImageButton) itemView.findViewById(R.id.btnSub);
            imgGoods = (ImageView) itemView.findViewById(R.id.img_yckc_list_item);
            txtTotalMoney = (TextView) itemView.findViewById(R.id.txtTotalMoney);
        }

        public void initData(int position){
            txtNumX.setVisibility(View.GONE);
            txtTop.setText(buys.get(position).getGoodsName());
            txtMid.setText(buys.get(position).getPickPrice()+"");
            txtMid.setTextColor(Color.parseColor("#FFE63549"));
            txtMid.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
            txtMid2.setText(buys.get(position).getPickPriceHigher()+"");
            txtBottom.setText("库存"+ buys.get(position).getGoodsInventory()+"箱");
            int num = buys.get(position).getGoodsNum();
            if (num == 0){
                imgSub.setVisibility(View.GONE);
                txtNum.setVisibility(View.GONE);
            }else{
                imgSub.setVisibility(View.VISIBLE);
                txtNum.setVisibility(View.VISIBLE);
            }
            Glide.with(mContext).load(buys.get(position).getGoodsImage()).into(imgGoods);

            imgSub.setTag(position);
            imgPlus.setTag(position);
        }
    }*/

}

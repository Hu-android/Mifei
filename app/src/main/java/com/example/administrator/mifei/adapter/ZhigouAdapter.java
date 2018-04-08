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
import com.example.administrator.mifei.adapter.ViewHolder.ViewHolderUtils;
import com.example.administrator.mifei.bean.GoodsInfoModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;

/**
 * Created by Administrator on 2018/4/8 0008.
 */

public class ZhigouAdapter extends BaseAdapter implements View.OnClickListener{

    ViewHolderUtils viewHolderUtils;


    //设置接口
    private View.OnClickListener onAddNum;  //加商品数量接口
    private View.OnClickListener onSubNum;  //减商品数量接口
    private Context mContext;
    private Callback mCallback;
    private LayoutInflater inflater;
    private List<GoodsInfoModel.goodsInfo_Zhigou> zhigous = new ArrayList<>();

    //设置接口方法
    public void setOnAddNum(View.OnClickListener onAddNum){
        this.onAddNum = onAddNum;
    }
    public void setOnSubNum(View.OnClickListener onSubNum){
        this.onSubNum = onSubNum;
    }

    public ZhigouAdapter(Context mContext, List<GoodsInfoModel.goodsInfo_Zhigou> zhigous) {
        this.mContext = mContext;
        this.zhigous = zhigous;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public void onClick(View v) {
        mCallback.click(v);
    }

    public interface  Callback{
        void click(View v);
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (zhigous != null){
            ret = zhigous.size();
        }
        return ret;
    }

    @Override
    public Object getItem(int position) {
        return zhigous.get(position);
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
        holder.imgGoods.setImageResource(zhigous.get(position).getGoodsImage());
        holder.txtNumX.setVisibility(View.GONE);
        holder.txtTop.setText(zhigous.get(position).getGoodsName());
        holder.txtMid.setText(zhigous.get(position).getPickPrice()+"");
        holder.txtMid.setTextColor(Color.parseColor("#FFE63549"));
        holder.txtMid.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        holder.txtNum.setText(zhigous.get(position).getGoodsNum()+"");
        holder.txtMid2.setText(zhigous.get(position).getPickPriceHigher()+"");
        int num = zhigous.get(position).getGoodsNum();
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

        /*if (convertView == null){
            convertView = inflater.inflate(R.layout.yckc_list_item,null);
        }
        TextView txtTop = (TextView) ViewHolderUtils.get(convertView,R.id.txtTop);
        TextView txtMid = (TextView) ViewHolderUtils.get(convertView,R.id.txtMid);
        TextView txtMid2 = (TextView) ViewHolderUtils.get(convertView,R.id.txtMid2);
        TextView txtBottom = (TextView) ViewHolderUtils.get(convertView,R.id.txtBottom);
        TextView txtNum = (TextView) ViewHolderUtils.get(convertView,R.id.txtNum);
        TextView txtNumX = (TextView) ViewHolderUtils.get(convertView,R.id.txtNumX);
        TextView txtTotalMoney = (TextView) ViewHolderUtils.get(convertView,R.id.txtTotalMoney);
        ImageView imgGoods = (ImageView) ViewHolderUtils.get(convertView,R.id.img_yckc_list_item);
        ImageButton imgPlus = (ImageButton) ViewHolderUtils.get(convertView,R.id.btnPlus);
        ImageButton imgSub = (ImageButton) ViewHolderUtils.get(convertView,R.id.btnSub);

        txtTop.setText(zhigous.get(position).getGoodsName());
        txtMid.setText(zhigous.get(position).getPickPrice()+"");
        txtMid2.setText(zhigous.get(position).getPickPriceHigher()+"");
        txtMid.setTextColor(Color.parseColor("#FFE63549"));
        txtBottom.setVisibility(View.GONE);
        txtNumX.setVisibility(View.GONE);
        imgGoods.setImageResource(zhigous.get(position).getGoodsImage());
        if (zhigous.get(position).getGoodsNum() == 0){
            imgSub.setVisibility(View.GONE);
            txtNum.setVisibility(View.GONE);
        }else if (zhigous.get(position).getGoodsNum() != 0){
            imgSub.setVisibility(View.VISIBLE);
            txtNum.setVisibility(View.VISIBLE);
        }
        imgPlus.setOnClickListener(this);
        imgPlus.setTag(position);
        imgSub.setOnClickListener(this);
        imgSub.setTag(position);
        return convertView;*/
    }
    private static class ViewHolder{
        TextView txtTop, txtMid, txtBottom, txtNum, txtMid2, txtNumX,txtTotalMoney;
        ImageView imgGoods;
        ImageButton imgPlus, imgSub;
    }
}

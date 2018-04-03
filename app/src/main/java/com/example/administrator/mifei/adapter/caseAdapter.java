package com.example.administrator.mifei.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

public class caseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

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

    @Override
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
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{

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
    }

}

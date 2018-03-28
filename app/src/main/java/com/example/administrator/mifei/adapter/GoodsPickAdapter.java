package com.example.administrator.mifei.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

    private Context mContext;
    private LayoutInflater mInflater;
    List<GoodsInfoModel.goodsInfo_Pick> mList = new ArrayList<>();

    public GoodsPickAdapter(Context context) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public void addData(List<GoodsInfoModel.goodsInfo_Pick> list) {
        if (CollectionUtils.isEmpty(list)) return;
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
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
        viewHolder.txtMid.setText(String.valueOf(pick.pickPrice));
        viewHolder.txtMid2.setText(String.valueOf(pick.pickPriceHigher));
        int a = Integer.parseInt(String.valueOf(viewHolder.txtNum.getText()));
        if (a == 0){
            viewHolder.imgSub.setVisibility(View.INVISIBLE);
            viewHolder.txtNum.setVisibility(View.GONE);
        }else {
            viewHolder.imgSub.setVisibility(View.VISIBLE);
            viewHolder.txtNum.setVisibility(View.VISIBLE);
        }
        return convertView;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    //减按钮
    public interface onItemSubListener{
        void onSubClick(int i);
    }
    private onItemSubListener mOnItemSubListener;
    public void setmOnItemSubListener(onItemSubListener mOnItemSubListener){
        this.mOnItemSubListener = mOnItemSubListener;
    }

    //加按钮
    public interface onItemPlusListener{
        void onPlusClick(int i);
    }
    private onItemPlusListener mOnItemPlusListener;
    public void setmOnItemPlusListener(onItemPlusListener mOnItemPlusListener){
        this.mOnItemPlusListener = mOnItemPlusListener;
    }

    static class ViewHolder {

        TextView txtTop, txtMid, txtBottom, txtNum, txtMid2, txtNumX;
        ImageView imgGoods, imgPlus, imgSub;
        int a = 0;
        public ViewHolder(View view) {
            txtNumX = (TextView) view.findViewById(R.id.txtNumX);
            txtTop = (TextView) view.findViewById(R.id.txtTop);
            txtMid = (TextView) view.findViewById(R.id.txtMid);
            txtMid2 = (TextView) view.findViewById(R.id.txtMid2);
            txtBottom = (TextView) view.findViewById(R.id.txtBottom);
            txtNum = (TextView) view.findViewById(R.id.txtNum);
            imgPlus = (ImageView) view.findViewById(R.id.btnPlus);
            imgSub = (ImageView) view.findViewById(R.id.btnSub);
            imgGoods = (ImageView) view.findViewById(R.id.img_yckc_list_item);
            txtBottom.setVisibility(View.GONE);
            txtNumX.setVisibility(View.GONE);
            txtMid.setTextColor(Color.parseColor("#FFE63549"));
            txtMid.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
            txtNum.setText("0");
        }
    }
}

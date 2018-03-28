package com.example.administrator.mifei.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
import java.util.Objects;

/**
 * Created by Administrator on 2018/3/24.
 */

public class GoodsAdapter extends BaseAdapter {

    private final int Type_1 = 0;
    private final int Type_2 = 1;
    private final int VIEW_TYPE = 2;

    List<GoodsInfoModel.goodsInfo_YCKCTop> mList = new ArrayList<>();

    private Context mContext;
    private LayoutInflater mInflater;

    public GoodsAdapter(Context mContext) {
        mInflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
    }

    public void addData(List<GoodsInfoModel.goodsInfo_YCKCTop> list) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        ViewHolder1 viewHolder1 = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case Type_1:
                    convertView = mInflater.inflate(R.layout.mine_yuncang_item, null);
                    viewHolder1 = new ViewHolder1(convertView);
                    convertView.setTag(viewHolder1);
                    break;
                case Type_2:
                    convertView = mInflater.inflate(R.layout.yckc_list_item, null);
                    viewHolder = new ViewHolder(convertView);
                    convertView.setTag(viewHolder);
                    break;
            }
        } else {
            switch (type) {
                case Type_1:
                    viewHolder1 = (ViewHolder1) convertView.getTag();
                    break;
                case Type_2:
                    viewHolder = (ViewHolder) convertView.getTag();
                    break;
            }
        }
            switch (type) {
                case Type_1:
                    if (position == 0) {
                        viewHolder1.txt_mine_yuncang.setText("我的云仓");
                    } else if (position == getCount() - 1) {
                        viewHolder1.txt_mine_yuncang.setText("进出明细");
                    }
                    break;
                case Type_2:
                    GoodsInfoModel.goodsInfo_YCKCTop goodsInfo_yckcTop = mList.get(position);
                    viewHolder.txtTop.setText(goodsInfo_yckcTop.goodsName);
                    viewHolder.txtMid.setText(String.valueOf(goodsInfo_yckcTop.canPickGoods));
                    viewHolder.txtBottom.setText(String.valueOf(goodsInfo_yckcTop.lackGoods));
                    viewHolder.imgGoods.setImageResource(goodsInfo_yckcTop.goodsImage);
                    break;
            }
        return convertView;
    }

    @Override
    public boolean isEnabled(int position) {
        if (position == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0||position == getCount()){
            return Type_1;
        }else{
            return Type_2;
        }
    }

    public int getViewTypeCount() {
        return VIEW_TYPE;
    }

    static class ViewHolder1 {
        TextView txt_mine_yuncang;

        public ViewHolder1(View view) {
            txt_mine_yuncang = (TextView) view.findViewById(R.id.txt_mine_yuncang_item);
        }
    }

    static class ViewHolder {

        TextView txtTop, txtMid, txtBottom, txtNum, txtMid2, txtNumX;
        ImageView imgGoods, imgPlus, imgSub;

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
            txtMid2.setVisibility(View.GONE);
            txtNum.setVisibility(View.GONE);
            txtNumX.setVisibility(View.GONE);
            imgPlus.setVisibility(View.GONE);
            imgSub.setVisibility(View.GONE);
        }
    }
}

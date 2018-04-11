package com.example.administrator.mifei.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.common.commonutil.CollectionUtils;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.bean.GoodsInfoModel;
import com.example.administrator.mifei.bean.fragment_mine_model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/10 0010.
 */

public class fragment_mine_adapter extends BaseAdapter {
    private Context context;
    private List<fragment_mine_model.mineFunctionView> functionViews = new ArrayList<>();
    private LayoutInflater inflater;
    private final int TYPE_COUNT = 3;
    private final int TYPE_ONE = 0;
    private final int TYPE_TWO = 1;
    private final int TYPE_THREE = 2;
    private int currentType;

    //设置接口
    private View.OnClickListener onPurchaseorder;
    private View.OnClickListener onLowerorder;
    private View.OnClickListener onPickorder;
    private View.OnClickListener onZhigouorder;

    //设置接口方法
    public void setOnPurchaseorder(View.OnClickListener onPurchaseorder){
        this.onPurchaseorder = onPurchaseorder;
    }
    public void setonLowerorder(View.OnClickListener onLowerorder){
        this.onLowerorder = onLowerorder;
    }
    public void setOnPickorder(View.OnClickListener onPickorder){
        this.onPickorder = onPickorder;
    }
    public void setOnZhigouorder(View.OnClickListener onZhigouorder){
        this.onZhigouorder = onZhigouorder;
    }

    public fragment_mine_adapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void addData(List<fragment_mine_model.mineFunctionView> list) {
        if (CollectionUtils.isEmpty(list)) return;
        functionViews.clear();
        functionViews.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return functionViews.size();
    }

    @Override
    public Object getItem(int position) {
        return functionViews.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        fragment_mine_model.mineFunctionView functionView = functionViews.get(position);
        currentType = getItemViewType(position);
        if (currentType == TYPE_ONE) {
            ViewHolderOne viewHolderOne;
            if (convertView == null) {
                viewHolderOne = new ViewHolderOne();
                convertView = inflater.inflate(R.layout.mine_function_item, null);
                viewHolderOne.imgFunction = (ImageView) convertView.findViewById(R.id.function_img);
                viewHolderOne.txtFunction = (TextView) convertView.findViewById(R.id.function_name);
                viewHolderOne.imgEnter = (ImageView) convertView.findViewById(R.id.function_enter);
                convertView.setTag(viewHolderOne);
            } else {
                viewHolderOne = (ViewHolderOne) convertView.getTag();
            }
            viewHolderOne.imgFunction.setImageResource(functionView.getFunctionImg());
            viewHolderOne.txtFunction.setText(functionView.getFunctionName());
        } else if (currentType == TYPE_TWO) {
            convertView = inflater.inflate(R.layout.space_view_item, null);
        }else if (currentType == TYPE_THREE){
            ViewHolderThree viewHolderThree;
            if (convertView == null){
                viewHolderThree = new ViewHolderThree();
                convertView = inflater.inflate(R.layout.mine_order_item,null);
                viewHolderThree.purchaseorder = (TextView) convertView.findViewById(R.id.purchaseorder_item);
                viewHolderThree.lowerorder = (TextView) convertView.findViewById(R.id.lowerorder_item);
                viewHolderThree.pickorder = (TextView) convertView.findViewById(R.id.pickorder_item);
                viewHolderThree.zhigouorder = (TextView) convertView.findViewById(R.id.zhigouorder_item);

                viewHolderThree.purchaseorder.setOnClickListener(onPurchaseorder);
                viewHolderThree.lowerorder.setOnClickListener(onLowerorder);
                viewHolderThree.pickorder.setOnClickListener(onPickorder);
                viewHolderThree.zhigouorder.setOnClickListener(onZhigouorder);
            }else {
                viewHolderThree = (ViewHolderThree) convertView.getTag();
            }
            viewHolderThree.purchaseorder.setTag(position);
            viewHolderThree.lowerorder.setTag(position);
            viewHolderThree.pickorder.setTag(position);
            viewHolderThree.zhigouorder.setTag(position);
            convertView.setTag(viewHolderThree);
        }
        return convertView;
    }


    class ViewHolderOne {
        public ImageView imgFunction;
        public TextView txtFunction;
        public ImageView imgEnter;
    }

    class ViewHolderThree{
        public TextView purchaseorder;
        public TextView lowerorder;
        public TextView pickorder;
        public TextView zhigouorder;
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        fragment_mine_model.mineFunctionView functionView = functionViews.get(position);
        int type = functionView.getType();
        switch (type) {
            case TYPE_ONE:
                return TYPE_ONE;
            case TYPE_TWO:
                return TYPE_TWO;
            case TYPE_THREE:
                return TYPE_THREE;
            default:
                return -1;
        }
    }

    @Override
    public boolean isEnabled(int position) {
        if (position == 0|| position == 1 || position == 2 || position == 6|| position == 10) return false;
            return true;
    }
}

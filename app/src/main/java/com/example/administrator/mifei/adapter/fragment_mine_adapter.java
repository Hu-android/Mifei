package com.example.administrator.mifei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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
            convertView = inflater.inflate(R.layout.mine_order_item,null);
        }
        return convertView;
    }


    class ViewHolderOne {
        public ImageView imgFunction;
        public TextView txtFunction;
        public ImageView imgEnter;
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
}

package com.example.administrator.mifei.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.common.commonutil.CollectionUtils;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.activity.MineAddressUpdate;
import com.example.administrator.mifei.bean.MineAddressModel;
import com.example.administrator.mifei.utils.SwipeListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/4/12 0012.
 */

public class MineAddressAdapter extends BaseAdapter{
    private Context mContext;
    private LayoutInflater inflater;
    private List<MineAddressModel.addressInfo> addressInfos = new ArrayList<>();
    // 记录所有radiobutton 被点击的状态
    public HashMap<String,Boolean> states = new HashMap<String, Boolean>();

    public MineAddressAdapter(Context context) {
        this.mContext = context;
        inflater = LayoutInflater.from(context);
    }

    public void addData(List<MineAddressModel.addressInfo> list) {
        if (CollectionUtils.isEmpty(list)) return;
        addressInfos.clear();
        addressInfos.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return addressInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return addressInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = null;
        MineAddressModel.addressInfo addressInfo = addressInfos.get(position);
        if (convertView != null){
            v = convertView;
        }else {
            v = LayoutInflater.from(mContext).inflate(R.layout.mine_address_item,parent,false);
        }
        ViewHolderOne viewHolderOne = (ViewHolderOne) v.getTag();
        if (viewHolderOne == null){
            viewHolderOne = new ViewHolderOne();
            viewHolderOne.txt_set_default = (TextView) v.findViewById(R.id.txt_set_default);
            viewHolderOne.txt_user_name = (TextView) v.findViewById(R.id.txt_user_name);
            viewHolderOne.txt_user_tel = (TextView) v.findViewById(R.id.txt_user_tel);
            viewHolderOne.txt_user_address = (TextView) v.findViewById(R.id.txt_user_address);
            viewHolderOne.radio_set_default = (RadioButton) v.findViewById(R.id.radio_set_default);
            viewHolderOne.btn_to_address_update = (Button) v.findViewById(R.id.btn_to_address_update);
            viewHolderOne.btn_to_address_delete = (Button) v.findViewById(R.id.btn_to_address_delete);
            viewHolderOne.btn_to_address_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MineAddressUpdate.toActivity(mContext);
                    Toast.makeText(mContext,"修改地址",Toast.LENGTH_SHORT).show();
                }
            });
            viewHolderOne.btn_to_address_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addressInfos.remove(position);
                    notifyDataSetChanged();
                }
            });
        }
        viewHolderOne.txt_user_name.setText(addressInfo.getUser_name());
        viewHolderOne.txt_user_tel.setText(addressInfo.getUser_tel());
        viewHolderOne.txt_user_address.setText(addressInfo.getUser_address());

        final ViewHolderOne finalHolder = viewHolderOne;
        viewHolderOne.radio_set_default.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clearStates(position);
                finalHolder.radio_set_default.setChecked(getStates(position));
                notifyDataSetChanged();
            }
        });
        boolean res = false;
        if (getStates(position) == null|| getStates(position) == false){
            res = false;
            viewHolderOne.txt_set_default.setTextColor(Color.parseColor("#FF666666"));
            setStates(position,false);
        }else{
            res = true;
            viewHolderOne.txt_set_default.setTextColor(Color.parseColor("#FF63C9CF"));
        }
        viewHolderOne.radio_set_default.setChecked(res);
        viewHolderOne.btn_to_address_update.setTag(position);
        viewHolderOne.btn_to_address_delete.setTag(position);
        v.setTag(viewHolderOne);
        return v;
    }
    //用于获取状态值
    public Boolean getStates(int position){
        return states.get(String.valueOf(position));
    }
    //设置状态值
    public void setStates(int position,boolean isChecked){
        states.put(String.valueOf(position),isChecked);
    }
    //用于在activity中重置所有的radiobutton的状态
    public void clearStates(int position){
        // 重置，确保最多只有一项被选中
        for(String key:states.keySet()){
            states.put(key,false);
        }
        states.put(String.valueOf(position), true);
    }


    class ViewHolderOne{
        public TextView txt_user_name,txt_user_tel,txt_user_address,txt_set_default;
        Button btn_to_address_update,btn_to_address_delete;
        RadioButton radio_set_default;
    }
}

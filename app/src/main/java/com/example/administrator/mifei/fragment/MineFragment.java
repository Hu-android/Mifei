package com.example.administrator.mifei.fragment;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.common.commonbase.BaseFragment;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.activity.LowerOrder;
import com.example.administrator.mifei.activity.MineComprehensive;
import com.example.administrator.mifei.activity.PickOrder;
import com.example.administrator.mifei.activity.PurchaseOrder;
import com.example.administrator.mifei.activity.Setting;
import com.example.administrator.mifei.activity.ZhigouOrder;
import com.example.administrator.mifei.adapter.fragmentMineAdapter;
import com.example.administrator.mifei.bean.fragmentMineModel;
import com.example.administrator.mifei.utils.GlideCircleTransform;
import com.example.administrator.mifei.utils.StatusBarSetting;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MineFragment extends BaseFragment implements View.OnClickListener,AdapterView.OnItemClickListener{

    private RequestManager glideRequest;
    @Bind(R.id.list_function)
    ListView list_function;
    private List<fragmentMineModel.mineFunctionView> functionViews = new ArrayList<>();
    fragmentMineAdapter adapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        initList();
    }

    private void initList(){
        StatusBarSetting.setTranslucentForImageViewInFragment(mActivity,0);
        View view = LayoutInflater.from(mContext).inflate(R.layout.mine_title_item,null);
        ImageView img = (ImageView) view.findViewById(R.id.img_heads);
        ImageView imgLeft = (ImageView) view.findViewById(R.id.img_title_left);
        ImageView imgRight = (ImageView) view.findViewById(R.id.img_title_right);
        imgLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"客服",Toast.LENGTH_SHORT).show();
            }
        });
        imgRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"设置",Toast.LENGTH_SHORT).show();
                Setting.toActivity(mContext);
            }
        });
        glideRequest = Glide.with(mContext);
        glideRequest.load(R.drawable.default_place_holder).transform(new GlideCircleTransform(mContext)).into(img);

        functionViews = new ArrayList<>();

        fragmentMineModel.mineFunctionView fun10 = new fragmentMineModel.mineFunctionView(1);
        functionViews.add(fun10);
        fragmentMineModel.mineFunctionView fun9 = new fragmentMineModel.mineFunctionView(2);
        functionViews.add(fun9);
        fragmentMineModel.mineFunctionView fun11 = new fragmentMineModel.mineFunctionView(1);
        functionViews.add(fun11);
        fragmentMineModel.mineFunctionView fun0 = new fragmentMineModel.mineFunctionView(0,R.drawable.wallet,"我的钱包");
        functionViews.add(fun0);
        fragmentMineModel.mineFunctionView fun1 = new fragmentMineModel.mineFunctionView(0,R.drawable.sale,"我的销售");
        functionViews.add(fun1);
        fragmentMineModel.mineFunctionView fun2 = new fragmentMineModel.mineFunctionView(0,R.drawable.channel,"我的渠道");
        functionViews.add(fun2);
        fragmentMineModel.mineFunctionView fun3 = new fragmentMineModel.mineFunctionView(1);
        functionViews.add(fun3);
        fragmentMineModel.mineFunctionView fun4 = new fragmentMineModel.mineFunctionView(0,R.drawable.levelup,"我要升级");
        functionViews.add(fun4);
        fragmentMineModel.mineFunctionView fun5 = new fragmentMineModel.mineFunctionView(0,R.drawable.authorization,"我要授权");
        functionViews.add(fun5);
        fragmentMineModel.mineFunctionView fun6 = new fragmentMineModel.mineFunctionView(0,R.drawable.promote,"我要推广");
        functionViews.add(fun6);
        fragmentMineModel.mineFunctionView fun7 = new fragmentMineModel.mineFunctionView(1);
        functionViews.add(fun7);
        fragmentMineModel.mineFunctionView fun8 = new fragmentMineModel.mineFunctionView(0,R.drawable.synthesis,"综合业务");
        functionViews.add(fun8);

        adapter = new fragmentMineAdapter(mContext);
        list_function.addHeaderView(view);
        adapter.addData(functionViews);
        list_function.setAdapter(adapter);
        adapter.setOnPurchaseorder(this);
        adapter.setonLowerorder(this);
        adapter.setOnPickorder(this);
        adapter.setOnZhigouorder(this);
        list_function.setOnItemClickListener(this);
        for (int i = 0;i < list_function.getCount();i++){
            Log.d("iiiiiiiiiiii",i+"");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.purchaseorder_item:
                Toast.makeText(mContext,"进货订单",Toast.LENGTH_SHORT).show();
                PurchaseOrder.toActivity(mContext);
                break;
            case R.id.lowerorder_item:
                LowerOrder.toActivity(mContext);
                Toast.makeText(mContext,"下级订单",Toast.LENGTH_SHORT).show();
                break;
            case R.id.pickorder_item:
                PickOrder.toActivity(mContext);
                Toast.makeText(mContext,"提货订单",Toast.LENGTH_SHORT).show();
                break;
            case R.id.zhigouorder_item:
                ZhigouOrder.toActivity(mContext);
                Toast.makeText(mContext,"直购订单",Toast.LENGTH_SHORT).show();
                 break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("11111111111111111111111",position+"");
        switch (position){
            case 0:
            case 1:
            case 2:
            case 3:
            case 7:
            case 11:
                break;
            case 4:
                Toast.makeText(mContext,"我的钱包",Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(mContext,"我的销售",Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(mContext,"我的渠道",Toast.LENGTH_SHORT).show();
                break;
            case 8:
                Toast.makeText(mContext,"我要升级",Toast.LENGTH_SHORT).show();
                break;
            case 9:
                Toast.makeText(mContext,"我要授权",Toast.LENGTH_SHORT).show();
                break;
            case 10:
                Toast.makeText(mContext,"我要推广",Toast.LENGTH_SHORT).show();
                break;
            case 12:
                MineComprehensive.toActivity(mContext);
                Toast.makeText(mContext,"综合业务",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

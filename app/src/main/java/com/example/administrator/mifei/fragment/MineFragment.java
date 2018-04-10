package com.example.administrator.mifei.fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.common.commonbase.BaseFragment;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.adapter.fragment_mine_adapter;
import com.example.administrator.mifei.bean.fragment_mine_model;
import com.example.administrator.mifei.utils.GlideCircleTransform;
import com.example.administrator.mifei.utils.StatusBarSetting;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MineFragment extends BaseFragment {

    private RequestManager glideRequest;
    @Bind(R.id.list_function)
    ListView list_function;
    private List<fragment_mine_model.mineFunctionView> functionViews = new ArrayList<>();
    fragment_mine_adapter adapter;

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
        glideRequest = Glide.with(mContext);
        glideRequest.load(R.drawable.default_place_holder).transform(new GlideCircleTransform(mContext)).into(img);
        functionViews = new ArrayList<>();

        fragment_mine_model.mineFunctionView fun10 = new fragment_mine_model.mineFunctionView(1);
        functionViews.add(fun10);
        fragment_mine_model.mineFunctionView fun9 = new fragment_mine_model.mineFunctionView(2);
        functionViews.add(fun9);
        fragment_mine_model.mineFunctionView fun11 = new fragment_mine_model.mineFunctionView(1);
        functionViews.add(fun11);
        fragment_mine_model.mineFunctionView fun0 = new fragment_mine_model.mineFunctionView(0,R.drawable.wallet,"我的钱包");
        functionViews.add(fun0);
        fragment_mine_model.mineFunctionView fun1 = new fragment_mine_model.mineFunctionView(0,R.drawable.sale,"我的销售");
        functionViews.add(fun1);
        fragment_mine_model.mineFunctionView fun2 = new fragment_mine_model.mineFunctionView(0,R.drawable.channel,"我的渠道");
        functionViews.add(fun2);
        fragment_mine_model.mineFunctionView fun3 = new fragment_mine_model.mineFunctionView(1);
        functionViews.add(fun3);
        fragment_mine_model.mineFunctionView fun4 = new fragment_mine_model.mineFunctionView(0,R.drawable.levelup,"我要升级");
        functionViews.add(fun4);
        fragment_mine_model.mineFunctionView fun5 = new fragment_mine_model.mineFunctionView(0,R.drawable.authorization,"我要授权");
        functionViews.add(fun5);
        fragment_mine_model.mineFunctionView fun6 = new fragment_mine_model.mineFunctionView(0,R.drawable.promote,"我要推广");
        functionViews.add(fun6);
        fragment_mine_model.mineFunctionView fun7 = new fragment_mine_model.mineFunctionView(1);
        functionViews.add(fun7);
        fragment_mine_model.mineFunctionView fun8 = new fragment_mine_model.mineFunctionView(0,R.drawable.synthesis,"综合业务");
        functionViews.add(fun8);

        adapter = new fragment_mine_adapter(mContext);
        list_function.addHeaderView(view);
        adapter.addData(functionViews);
        list_function.setAdapter(adapter);
    }
}

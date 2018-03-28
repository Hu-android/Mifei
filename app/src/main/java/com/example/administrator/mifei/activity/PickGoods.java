package com.example.administrator.mifei.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.common.commonbase.BaseBackActivity;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.adapter.GoodsAdapter;
import com.example.administrator.mifei.adapter.GoodsPickAdapter;
import com.example.administrator.mifei.bean.GoodsInfoModel;
import com.example.administrator.mifei.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class PickGoods extends BaseBackActivity {

    GoodsPickAdapter adapter;
    private List<GoodsInfoModel.goodsInfo_Pick> picks = new ArrayList<GoodsInfoModel.goodsInfo_Pick>();
    @Bind(R.id.listViewPick)
    ListView listViewPick;

    @Override
    public int getLayoutId() {
        return R.layout.activity_pick_goods;
    }

    @Override
    public String getTitleName() {
        return "进货";
    }

    @Override
    public int getImgSrc() {
        return R.drawable.page1back;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        initListData();
    }

    public void initListData(){
        picks = new ArrayList<GoodsInfoModel.goodsInfo_Pick>();
        GoodsInfoModel.goodsInfo_Pick pick0 =  new GoodsInfoModel.goodsInfo_Pick("米菲纸尿裤",100,200);
        picks.add(pick0);

        adapter = new GoodsPickAdapter(mContext);
        adapter.addData(picks);
        listViewPick.setAdapter(adapter);
    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context,PickGoods.class);
        context.startActivity(intent);
    }
}

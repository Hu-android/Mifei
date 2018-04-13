package com.example.administrator.mifei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.common.commonbase.BaseBackActivity;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.adapter.GoodsPickAdapter;
import com.example.administrator.mifei.bean.GoodsInfoModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class PickGoods extends BaseBackActivity implements View.OnClickListener,AdapterView.OnItemClickListener{

    GoodsPickAdapter adapter;
    private List<GoodsInfoModel.goodsInfo_Pick> picks = new ArrayList<GoodsInfoModel.goodsInfo_Pick>();
    @Bind(R.id.listViewPick)
    ListView listViewPick;
    @Bind(R.id.txtTotalMoney)
    TextView txtTotalMoney;
    private double totalMoney=0;
    GoodsInfoModel.goodsInfo_Pick goodsInfo_pick;

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
        GoodsInfoModel.goodsInfo_Pick pick0 =  new GoodsInfoModel.goodsInfo_Pick(R.drawable.default_place_holder,"米菲纸尿裤",100,200);
        picks.add(pick0);
        GoodsInfoModel.goodsInfo_Pick pick1 =  new GoodsInfoModel.goodsInfo_Pick(R.drawable.default_place_holder,"米菲纸尿裤",100,200);
        picks.add(pick1);
        GoodsInfoModel.goodsInfo_Pick pick2 =  new GoodsInfoModel.goodsInfo_Pick(R.drawable.default_place_holder,"米菲纸尿裤",50,200);
        picks.add(pick2);
        GoodsInfoModel.goodsInfo_Pick pick3 =  new GoodsInfoModel.goodsInfo_Pick(R.drawable.default_place_holder,"米菲纸尿裤",25,200);
        picks.add(pick3);
        GoodsInfoModel.goodsInfo_Pick pick4 =  new GoodsInfoModel.goodsInfo_Pick(R.drawable.default_place_holder,"米菲纸尿裤",11.5,200);
        picks.add(pick4);
        GoodsInfoModel.goodsInfo_Pick pick5 =  new GoodsInfoModel.goodsInfo_Pick(R.drawable.default_place_holder,"米菲纸尿裤",7,200);
        picks.add(pick5);
        GoodsInfoModel.goodsInfo_Pick pick6 =  new GoodsInfoModel.goodsInfo_Pick(R.drawable.default_place_holder,"米菲纸尿裤",100,200);
        picks.add(pick6);
        GoodsInfoModel.goodsInfo_Pick pick7 =  new GoodsInfoModel.goodsInfo_Pick(R.drawable.default_place_holder,"米菲纸尿裤",546,200);
        picks.add(pick7);
        GoodsInfoModel.goodsInfo_Pick pick8 =  new GoodsInfoModel.goodsInfo_Pick(R.drawable.default_place_holder,"米菲纸尿裤",100,200);
        picks.add(pick8);
        GoodsInfoModel.goodsInfo_Pick pick9 =  new GoodsInfoModel.goodsInfo_Pick(R.drawable.default_place_holder,"米菲纸尿裤",100,200);
        picks.add(pick9);

        adapter = new GoodsPickAdapter(mContext,picks);
        listViewPick.setAdapter(adapter);
        adapter.setOnAddNum(this);
        adapter.setOnSubNum(this);

    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context,PickGoods.class);
        context.startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(mContext,"点击了"+ position + "按钮",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Object tag = v.getTag();
        switch (v.getId()) {
            case R.id.btnPlus:
                if (tag != null && tag instanceof Integer) {
                    int position = (Integer) tag;
                    int num = picks.get(position).getGoodsNum();
                    num++;
                    picks.get(position).setGoodsNum(num);
                    totalMoney += picks.get(position).pickPrice;
                    txtTotalMoney.setText("￥" + totalMoney+"");
                    picks.get(position).setTotalPrice(totalMoney);
                    adapter.notifyDataSetChanged();
                }
                break;
            case R.id.btnSub:
                if (tag != null && tag instanceof Integer) {
                    int position = (Integer) tag;
                    int num = picks.get(position).getGoodsNum();
                    if (num > 0) {
                        num--;
                        picks.get(position).setGoodsNum(num);
                        totalMoney -= picks.get(position).pickPrice;
                        txtTotalMoney.setText("￥" + totalMoney+"");
                        picks.get(position).setTotalPrice(totalMoney);
                        adapter.notifyDataSetChanged();
                    }
                }
                break;
        }
    }
}

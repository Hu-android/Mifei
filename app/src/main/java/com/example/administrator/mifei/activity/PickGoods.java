package com.example.administrator.mifei.activity;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.common.commonbase.BaseBackActivity;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.adapter.GoodsAdapter;
import com.example.administrator.mifei.adapter.GoodsPickAdapter;
import com.example.administrator.mifei.bean.GoodsInfoModel;
import com.example.administrator.mifei.bean.ShopCart;
import com.example.administrator.mifei.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class PickGoods extends BaseBackActivity implements View.OnClickListener,AdapterView.OnItemClickListener{

    private ShopCart shopCart;
    GoodsPickAdapter adapter;
    private List<GoodsInfoModel.goodsInfo_Pick> picks = new ArrayList<GoodsInfoModel.goodsInfo_Pick>();
    @Bind(R.id.listViewPick)
    ListView listViewPick;
    private double totalMoney;
    private TextView txtTotalMoney;

    private DataSetObserver sumObserver = new DataSetObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            totalMoney();
            txtTotalMoney.setText(totalMoney+"");
        }

        @Override
        public void onInvalidated() {
            super.onInvalidated();
            totalMoney();
            txtTotalMoney.setText(totalMoney+"");
        }
    };


    //计算总价
    public double totalMoney(){
        totalMoney = 0;
        for (int i = 0;i<picks.size();i++){
            int count = Double.valueOf(picks.get(i).getGoodsNum()).intValue();
            int itemMoney = Double.valueOf(picks.get(i).getTotalPrice()).intValue();
            int item = count * itemMoney;
            totalMoney+=item;
        }
        return totalMoney;
    }
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
        txtTotalMoney = (TextView)findViewById(R.id.txtTotalMoney);
        initListData();
    }


    public void initListData(){
        picks = new ArrayList<GoodsInfoModel.goodsInfo_Pick>();
        GoodsInfoModel.goodsInfo_Pick pick0 =  new GoodsInfoModel.goodsInfo_Pick("米菲纸尿裤",100,200);
        picks.add(pick0);
        GoodsInfoModel.goodsInfo_Pick pick1 =  new GoodsInfoModel.goodsInfo_Pick("米菲纸尿裤",100,200);
        picks.add(pick1);
        GoodsInfoModel.goodsInfo_Pick pick2 =  new GoodsInfoModel.goodsInfo_Pick("米菲纸尿裤",100,200);
        picks.add(pick2);
        GoodsInfoModel.goodsInfo_Pick pick3 =  new GoodsInfoModel.goodsInfo_Pick("米菲纸尿裤",100,200);
        picks.add(pick3);
        GoodsInfoModel.goodsInfo_Pick pick4 =  new GoodsInfoModel.goodsInfo_Pick("米菲纸尿裤",100,200);
        picks.add(pick4);
        GoodsInfoModel.goodsInfo_Pick pick5 =  new GoodsInfoModel.goodsInfo_Pick("米菲纸尿裤",100,200);
        picks.add(pick5);
        GoodsInfoModel.goodsInfo_Pick pick6 =  new GoodsInfoModel.goodsInfo_Pick("米菲纸尿裤",100,200);
        picks.add(pick6);
        GoodsInfoModel.goodsInfo_Pick pick7 =  new GoodsInfoModel.goodsInfo_Pick("米菲纸尿裤",100,200);
        picks.add(pick7);
        GoodsInfoModel.goodsInfo_Pick pick8 =  new GoodsInfoModel.goodsInfo_Pick("米菲纸尿裤",100,200);
        picks.add(pick8);
        GoodsInfoModel.goodsInfo_Pick pick9 =  new GoodsInfoModel.goodsInfo_Pick("米菲纸尿裤",100,200);
        picks.add(pick9);

        adapter = new GoodsPickAdapter(mContext,picks);
        listViewPick.setAdapter(adapter);


    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context,PickGoods.class);
        context.startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onClick(View v) {
        Object tag = v.getTag();
        switch (v.getId()) {
            case R.id.btnPlus:
                if (tag != null && tag instanceof Integer) {
                    int position = (Integer) tag;
                    int num = Double.valueOf(picks.get(position).getGoodsNum()).intValue();
                    num++;
                    picks.get(position).setGoodsNum(num);
                    adapter.notifyDataSetChanged();
                }
                break;
            case R.id.btnSub:
                if (tag != null && tag instanceof Integer) {
                    int position = (Integer) tag;
                    int num = Double.valueOf(picks.get(position).getGoodsNum()).intValue();
                    if (num > 0) {
                        num--;
                        picks.get(position).setGoodsNum(num);
                        adapter.notifyDataSetChanged();
                    }
                }
                break;
        }
    }
}

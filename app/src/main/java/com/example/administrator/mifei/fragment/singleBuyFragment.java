package com.example.administrator.mifei.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.common.commonbase.BaseFragment;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.adapter.caseAdapter;
import com.example.administrator.mifei.bean.GoodsInfoModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2018/4/3 0003.
 */

public class singleBuyFragment extends BaseFragment implements View.OnClickListener,AdapterView.OnItemClickListener{
    @Bind(R.id.single_listView)
    ListView single_listView;
    @Bind(R.id.txtTotalMoney)
    TextView txtTotalMoney;
    private caseAdapter adapter;
    private double totalMoney=0;
    private List<GoodsInfoModel.goodsInfo_Buy> buys = new ArrayList<>();

    private int[] goodsImages = {R.drawable.default_place_holder,R.drawable.default_place_holder,R.drawable.default_place_holder,R.drawable.default_place_holder,
            R.drawable.default_place_holder,R.drawable.default_place_holder};
    private String[] goodsName = {"米菲纸尿裤游泳裤训练裤","米菲纸尿裤游泳裤训练裤","米菲纸尿裤游泳裤训练裤","米菲纸尿裤游泳裤训练裤",
            "米菲纸尿裤游泳裤训练裤","米菲纸尿裤游泳裤训练裤"};
    private double[] goodsPrice = {20,30,40,50,60,70};
    private double[] goodsPriceHigher = {30,40,50,60,70,80};
    private int[] goodsInventory = {100,100,100,110,100,100};

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_single_buy;
    }

    @Override
    protected void initView() {
        initData();
    }

    private void initData(){
        for (int i = 0;i<goodsImages.length;i++){
            buys.add(new GoodsInfoModel.goodsInfo_Buy(goodsName[i],goodsPrice[i],goodsPriceHigher[i],goodsInventory[i],goodsImages[i]));
        }

        adapter = new caseAdapter(mContext,buys);
        single_listView.setAdapter(adapter);
        adapter.setOnAddNum(this);
        adapter.setOnSubNum(this);
    }

    @Override
    public void onClick(View v) {
        Object tag = v.getTag();
        switch (v.getId()) {
            case R.id.btnPlus:
                if (tag != null && tag instanceof Integer) {
                    int position = (Integer) tag;
                    int num = buys.get(position).getGoodsNum();
                    num++;
                    buys.get(position).setGoodsNum(num);
                    totalMoney += buys.get(position).pickPrice;
                    txtTotalMoney.setText("￥" + totalMoney+"");
                    buys.get(position).setTotalPrice(totalMoney);
                    adapter.notifyDataSetChanged();
                }
                break;
            case R.id.btnSub:
                if (tag != null && tag instanceof Integer) {
                    int position = (Integer) tag;
                    int num = buys.get(position).getGoodsNum();
                    if (num > 0) {
                        num--;
                        buys.get(position).setGoodsNum(num);
                        totalMoney -= buys.get(position).pickPrice;
                        txtTotalMoney.setText("￥" + totalMoney+"");
                        buys.get(position).setTotalPrice(totalMoney);
                        adapter.notifyDataSetChanged();
                    }
                }
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(mContext,"点击了"+ position + "按钮",Toast.LENGTH_SHORT).show();
    }
}

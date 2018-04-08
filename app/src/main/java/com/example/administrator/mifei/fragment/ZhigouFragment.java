package com.example.administrator.mifei.fragment;


import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.TextView;

import com.common.commonbase.BaseFragment;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.adapter.ViewPageAdapter;
import com.example.administrator.mifei.adapter.ZhigouAdapter;
import com.example.administrator.mifei.bean.GoodsInfoModel;
import com.example.administrator.mifei.utils.StatusBarSetting;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


public class ZhigouFragment extends BaseFragment implements AdapterView.OnItemClickListener,View.OnClickListener{


    @Bind(R.id.list_zhigou)
    ListView list_zhigou;
    @Bind(R.id.txtTotalMoney)
    TextView txtTotalMoney;
    ZhigouAdapter adapter;
    private double totalMoney = 0;
    private int[] goodsImages = {R.drawable.default_place_holder,R.drawable.default_place_holder,R.drawable.default_place_holder,R.drawable.default_place_holder,
            R.drawable.default_place_holder,R.drawable.default_place_holder};
    private String[] goodsName = {"米菲纸尿裤游泳裤训练裤","米菲纸尿裤游泳裤训练裤","米菲纸尿裤游泳裤训练裤","米菲纸尿裤游泳裤训练裤",
            "米菲纸尿裤游泳裤训练裤","米菲纸尿裤游泳裤训练裤"};
    private double[] goodsPrice = {50,100,150,200,350,124};
    private double[] goodsPriceHigher = {100,120,158,124,315,219};
    List<GoodsInfoModel.goodsInfo_Zhigou> zhigous = new ArrayList<>();

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_zhigou;
    }

    @Override
    protected void initView() {
        initList();
    }

    private void initHeaderView(){
        StatusBarSetting.setTranslucentForImageViewInFragment(mActivity,0);
        View view = LayoutInflater.from(mContext).inflate(R.layout.viewpager_item, null);
        ViewPager viewpager = (ViewPager)view.findViewById(R.id.headViewPager);
        List<ImageView> listtemp = new ArrayList<>();
        for(int i = 0;i<4;i++)
        {
            ImageView img = new ImageView(mContext);
            img.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,100));
            img.setScaleType(ScaleType.FIT_XY);
            img.setBackgroundResource(R.drawable.mifeiback);
            listtemp.add(img);
        }
        ViewPageAdapter viewadapter = new ViewPageAdapter(listtemp);
        list_zhigou.addHeaderView(view);
        list_zhigou.setAdapter(new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1));
        viewpager.setAdapter(viewadapter);
    }

    private void initList(){
        for (int i = 0;i<goodsImages.length;i++){
            zhigous.add(new GoodsInfoModel.goodsInfo_Zhigou(goodsName[i],goodsPrice[i],goodsPriceHigher[i],goodsImages[i]));
        }
        adapter = new ZhigouAdapter(mContext,zhigous);
        initHeaderView();
        list_zhigou.setAdapter(adapter);
        adapter.setOnAddNum(this);
        adapter.setOnSubNum(this);
    }

   /* @Override
    public void onClick(View v) {
        Object tag = v.getTag();
        switch (v.getId()) {
            case R.id.btnPlus:
                if (tag != null && tag instanceof Integer) {
                    int position = (Integer) tag;
                    int num = zhigous.get(position).getGoodsNum();
                    num++;
                    zhigous.get(position).setGoodsNum(num);
                   *//* totalMoney += zhigous.get(position).pickPrice;
                    txtTotalMoney.setText("￥" + totalMoney+"");*//*
                    zhigous.get(position).setTotalPrice(totalMoney);
                    adapter.notifyDataSetChanged();
                }
                break;
            case R.id.btnSub:
                if (tag != null && tag instanceof Integer) {
                    int position = (Integer) tag;
                    int num = zhigous.get(position).getGoodsNum();
                    if (num > 0) {
                        num--;
                        zhigous.get(position).setGoodsNum(num);
                        *//*totalMoney -= zhigous.get(position).pickPrice;
                        txtTotalMoney.setText("￥" + totalMoney+"");*//*
                        zhigous.get(position).setTotalPrice(totalMoney);
                        adapter.notifyDataSetChanged();
                    }
                }
                break;
        }
    }
*/
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
                    int num = zhigous.get(position).getGoodsNum();
                    num++;
                    zhigous.get(position).setGoodsNum(num);
                    totalMoney += zhigous.get(position).pickPrice;
                    txtTotalMoney.setText("￥" + totalMoney+"");
                    zhigous.get(position).setTotalPrice(totalMoney);
                    adapter.notifyDataSetChanged();
                }
                break;
            case R.id.btnSub:
                if (tag != null && tag instanceof Integer) {
                    int position = (Integer) tag;
                    int num = zhigous.get(position).getGoodsNum();
                    if (num > 0) {
                        num--;
                        zhigous.get(position).setGoodsNum(num);
                        totalMoney -= zhigous.get(position).pickPrice;
                        txtTotalMoney.setText("￥" + totalMoney+"");
                        zhigous.get(position).setTotalPrice(totalMoney);
                        adapter.notifyDataSetChanged();
                    }
                }
                break;
        }
    }
}

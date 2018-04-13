package com.example.administrator.mifei.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mifei.R;
import com.example.administrator.mifei.activity.BuyGoods;
import com.example.administrator.mifei.activity.MineAddressUpdate;
import com.example.administrator.mifei.activity.PickGoods;
import com.example.administrator.mifei.activity.buyPay;
import com.example.administrator.mifei.fragment.ZhigouFragment;

/**
 * Created by Administrator on 2018/4/2 0002.
 */

public class Total_Money extends LinearLayout {

    private TextView txtTotalMoney;
    private String txt_title;

    public Total_Money(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.total_money,Total_Money.this);

        txtTotalMoney = (TextView) findViewById(R.id.txtTotalMoney);
        Button btnPay = (Button) findViewById(R.id.btnPay);
        btnPay.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,buyPay.class);
                Bundle bundle = new Bundle();
                if (context instanceof BuyGoods){
                    txt_title = "云仓提货";
                }else if (context instanceof PickGoods){
                    txt_title = "云仓进货";
                }
                bundle.putString("txt_title",txt_title);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

}

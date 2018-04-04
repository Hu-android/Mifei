package com.example.administrator.mifei.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mifei.R;
import com.example.administrator.mifei.activity.buyPay;

import org.w3c.dom.Text;

import butterknife.Bind;

/**
 * Created by Administrator on 2018/4/2 0002.
 */

public class Total_Money extends LinearLayout {

    private TextView txtTotalMoney;

    public Total_Money(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.total_money,Total_Money.this);

        txtTotalMoney = (TextView) findViewById(R.id.txtTotalMoney);
        Button btnPay = (Button) findViewById(R.id.btnPay);
        btnPay.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                buyPay.toActivity(context);
            }
        });
    }

}

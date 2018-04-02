package com.example.administrator.mifei.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.mifei.R;

/**
 * Created by Administrator on 2018/4/2 0002.
 */

public class Total_Money extends LinearLayout {

    public interface PayClick{
        public void onPayClick(String str);
    }

    PayClick payClick = null;

    //自定义事件
    public void setPayButton(Button payButton) {
        this.payButton = payButton;
    }

    private Button payButton = null;

    public Total_Money(Context context) {
        super(context);
    }

    public Total_Money(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater layoutInflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.total_money,this);
        payButton = (Button) findViewById(R.id.btnPay);
        payButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
    public void setButtonClick(Context context,int costMoney){
        Toast.makeText(context,"一共消费了"+ costMoney +"元",Toast.LENGTH_SHORT).show();
    }

}

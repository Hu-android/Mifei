package com.example.administrator.mifei.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.common.commonbase.BaseBackActivity;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.view.txt_et_item;

import butterknife.Bind;

public class MineAddressUpdate extends BaseBackActivity {
    @Bind(R.id.address_update_tel)
    txt_et_item address_update_tel;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_address_update;
    }

    @Override
    public String getTitleName() {
        return "编辑地址";
    }

    @Override
    public int getImgSrc() {
        return R.drawable.page1back;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        String tel = bundle.getString("tel");
        address_update_tel.setTel(tel);
    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context,MineAddressUpdate.class);
        context.startActivity(intent);
    }
}

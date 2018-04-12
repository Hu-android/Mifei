package com.example.administrator.mifei.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.common.commonbase.BaseBackActivity;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.adapter.MineAddressAdapter;
import com.example.administrator.mifei.bean.MineAddressModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MineReceiveAddress extends BaseBackActivity implements View.OnClickListener{
    private MineAddressAdapter adapter;
    @Bind(R.id.list_address)
    ListView list_address;
    private List<MineAddressModel.addressInfo> addressInfos = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_receive_adress;
    }

    @Override
    public String getTitleName() {
        return "收货地址";
    }

    @Override
    public int getImgSrc() {
        return R.drawable.page1back;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        initList();
    }

    private void initList(){
        addressInfos = new ArrayList<MineAddressModel.addressInfo>();

        MineAddressModel.addressInfo info0 = new MineAddressModel.addressInfo("代用名","15858188888","杭州市西湖区文新街道 文一西路522号西溪科创园1栋1单元101，浙江从泰科技有限公司");
        addressInfos.add(info0);
        MineAddressModel.addressInfo info1 = new MineAddressModel.addressInfo("代用名","15858188888","杭州市西湖区文新街道 文一西路522号西溪科创园1栋1单元101，浙江从泰科技有限公司");
        addressInfos.add(info1);
        MineAddressModel.addressInfo info2 = new MineAddressModel.addressInfo("代用名","15858188888","杭州市西湖区文新街道 文一西路522号西溪科创园1栋1单元101，浙江从泰科技有限公司");
        addressInfos.add(info2);
        MineAddressModel.addressInfo info3 = new MineAddressModel.addressInfo("代用名","15858188888","杭州市西湖区文新街道 文一西路522号西溪科创园1栋1单元101，浙江从泰科技有限公司");
        addressInfos.add(info3);
        MineAddressModel.addressInfo info4 = new MineAddressModel.addressInfo("代用名","15858188888","杭州市西湖区文新街道 文一西路522号西溪科创园1栋1单元101，浙江从泰科技有限公司");
        addressInfos.add(info4);
        MineAddressModel.addressInfo info5 = new MineAddressModel.addressInfo("代用名","15858188888","杭州市西湖区文新街道 文一西路522号西溪科创园1栋1单元101，浙江从泰科技有限公司");
        addressInfos.add(info5);
        MineAddressModel.addressInfo info6 = new MineAddressModel.addressInfo("代用名","15858188888","杭州市西湖区文新街道 文一西路522号西溪科创园1栋1单元101，浙江从泰科技有限公司");
        addressInfos.add(info6);
        adapter = new MineAddressAdapter(mContext);
        adapter.addData(addressInfos);
        list_address.setAdapter(adapter);
        adapter.setOnUpdate(this);
        adapter.setOnDelete(this);
    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context,MineReceiveAddress.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Object tag = v.getTag();
        switch (v.getId()){
            case R.id.btn_to_address_update:
                Toast.makeText(mContext,"修改地址",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_to_address_delete:

                Toast.makeText(mContext,"删除",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

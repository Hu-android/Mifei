package com.example.administrator.mifei.fragment;

import android.widget.ListView;

import com.common.commonbase.BaseFragment;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.adapter.MsgAdapter;
import com.example.administrator.mifei.bean.MessageModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


public class companyMesFragment extends BaseFragment {

    @Bind(R.id.list_msg_company)
    ListView list_msg_company;
    MsgAdapter adapter;

    private int[] Images = {R.drawable.company,R.drawable.company,R.drawable.company,R.drawable.company,R.drawable.company,R.drawable.company
            ,R.drawable.company,R.drawable.company,R.drawable.company,R.drawable.company,R.drawable.company};
    List<MessageModel.messageInfo> msg = new ArrayList<>();

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_company_mes;
    }

    @Override
    protected void initView() {
        initList();
        /**
         *     圆形图片框
         */
        /*glideRequest = Glide.with(this);
        glideRequest.load("https://www.baidu.com/img/bdlogo.png").transform(new GlideCircleTransform(mContext)).into(circle_img);*/
    }

    public void initList(){
        for (int i = 0; i < Images.length; i++){
            msg.add(new MessageModel.messageInfo(Images[i]));
        }
        adapter = new MsgAdapter(mContext,msg);
        list_msg_company.setAdapter(adapter);
    }
}

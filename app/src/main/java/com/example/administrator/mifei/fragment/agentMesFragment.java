package com.example.administrator.mifei.fragment;


import android.media.Image;
import android.widget.ListView;

import com.common.commonbase.BaseFragment;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.adapter.MsgAdapter;
import com.example.administrator.mifei.bean.MessageModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


public class agentMesFragment extends BaseFragment {

   /* private RequestManager glideRequest;*/
    @Bind(R.id.list_msg_agent)
    ListView list_msg_agent;
    MsgAdapter adapter;

    private int[] Images = {R.drawable.agent,R.drawable.agent,R.drawable.agent,R.drawable.agent,R.drawable.agent,R.drawable.agent
            ,R.drawable.agent,R.drawable.agent,R.drawable.agent,R.drawable.agent,R.drawable.agent};
    private String[] msgTitle = {"款项信息","款项信息","款项信息","款项信息","款项信息","款项信息","款项信息","款项信息","款项信息","款项信息","款项信息"};
    private String[] msgOrderNum = {"123456789","123456789","123456789","123456789","123456789","123456789","123456789","123456789","123456789","123456789","123456789"};
    private String[] msgInfo = {"原因如下：请上传队公司账户汇款完整后，带交易凭证，请再次确认完整的汇款信息之后在提交。 ","原因如下：请上传队公司账户汇款完整后，带交易凭证。",
            "原因如下：请上传队公司账户汇款完整后，带交易凭证，请再次确认完整的汇款信息之后在提交。 ", "原因如下：请上传队公司账户汇款完整后，带交易凭证。",
            "原因如下：请上传队公司账户汇款完整后，带交易凭证，请再次确认完整的汇款信息之后在提交。 ",
            "原因如下：请上传队公司账户汇款完整后，带交易凭证。","原因如下：请上传队公司账户汇款完整后，带交易凭证。",
            "原因如下：请上传队公司账户汇款完整后，带交易凭证。","原因如下：请上传队公司账户汇款完整后，带交易凭证，请再次确认完整的汇款信息之后在提交。 ",
            "原因如下：请上传队公司账户汇款完整后，带交易凭证，请再次确认完整的汇款信息之后在提交。 ","原因如下：请上传队公司账户汇款完整后，带交易凭证。"};
    List<MessageModel.messageInfo> msg = new ArrayList<>();

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_agent_mes;
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
            msg.add(new MessageModel.messageInfo(Images[i],msgTitle[i],msgOrderNum[i],msgInfo[i]));
        }
        adapter = new MsgAdapter(mContext,msg);
        list_msg_agent.setAdapter(adapter);
    }
}

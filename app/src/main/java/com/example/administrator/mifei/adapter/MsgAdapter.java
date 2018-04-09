package com.example.administrator.mifei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.administrator.mifei.R;
import com.example.administrator.mifei.bean.MessageModel;
import com.example.administrator.mifei.fragment.agentMesFragment;
import com.example.administrator.mifei.utils.GlideCircleTransform;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/9 0009.
 */

public class MsgAdapter extends BaseAdapter{

    private Context mContext;
    private LayoutInflater inflater;
    private RequestManager glideRequest;
    private List<MessageModel.messageInfo> msg = new ArrayList<>();

    public MsgAdapter( Context mContext, List<MessageModel.messageInfo> msg) {
        this.msg = msg;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (msg != null){
            ret = msg.size();
        }
        return ret;
    }

    @Override
    public Object getItem(int position) {
        return msg.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if (convertView != null){
            v = convertView;
        }else {
            v = LayoutInflater.from(mContext).inflate(R.layout.img_txt_item,parent,false);
        }
        ViewHolder holder = (ViewHolder) v.getTag();
        if (holder == null){
            holder = new ViewHolder();
            holder.circleImg = (ImageView) v.findViewById(R.id.circle_img);
            holder.txtMsgTitle = (TextView) v.findViewById(R.id.txt_msg_title);
            holder.txtOrderNum = (TextView) v.findViewById(R.id.txt_msg_order_num);
            holder.txtMsgInfo = (TextView) v.findViewById(R.id.txt_msg_info);
            holder.txtDateTime = (TextView) v.findViewById(R.id.txt_datetime);
        }
        if (msg.get(position).getImgResourse() == R.drawable.company){
            holder.txtOrderNum.setVisibility(View.GONE);
        }else{
            holder.txtOrderNum.setVisibility(View.VISIBLE);
        }
        holder.txtMsgTitle.setText(msg.get(position).getMsgTitle());
        holder.txtOrderNum.setText("订单编号" + msg.get(position).getMsgOrderNum());
        holder.txtMsgInfo.setText(msg.get(position).getMsgInfo());
        /** 时间时间时间    设置时间*/
       // holder.txtDateTime.setText(msg.get(position).getMsgDateTime());
        glideRequest = Glide.with(mContext);
        glideRequest.load(msg.get(position).getImgResourse()).transform(new GlideCircleTransform(mContext)).into(holder.circleImg);
        return v;
    }

    private static class ViewHolder{
        ImageView circleImg;
        TextView txtMsgTitle,txtOrderNum,txtMsgInfo,txtDateTime;
    }
}

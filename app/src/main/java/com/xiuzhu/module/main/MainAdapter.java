package com.xiuzhu.module.main;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xiuzhu.data.bean.MsgBean;
import com.xiuzhu.module.audio.AudioMediaPlayer;
import com.xiuzhu.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yzh on 14-12-23.
 */
public class MainAdapter extends BaseAdapter {


    private LayoutInflater mLayoutInflater;
    private List<MsgBean> msgBeanList;
    private AudioMediaPlayer mMediaPlayer;
    private Context mContext;
    private int iContentWidth;
    private boolean isFirst = true;

    public MainAdapter(Context context, List<MsgBean> msgBeanList) {
        mLayoutInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.msgBeanList = msgBeanList;
        if (this.msgBeanList == null) {
            this.msgBeanList = new ArrayList<>();
        }
    }

    void update(List<MsgBean> msgBeanList) {
        this.msgBeanList = msgBeanList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return msgBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;

        if (convertView == null || convertView.getTag() == null) {

            convertView = mLayoutInflater.inflate(R.layout.item_msg, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.contentText = (TextView) convertView.findViewById(R.id.item_msg_text);
            viewHolder.lengthText = (TextView) convertView.findViewById(R.id.item_len_text);
            viewHolder.contentText.post(new Runnable() {

                @Override
                public void run() {
                    if (isFirst) {
                        isFirst = false;
                        iContentWidth = viewHolder.contentText.getWidth(); // 获取宽度
                    }
                }
            });
            viewHolder.contentText.setTag(position);
            viewHolder.contentText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int numb = Integer.parseInt(v.getTag().toString());
                    playVoice(msgBeanList.get(numb).getFilename());
                }
            });
            assert convertView != null;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.contentText.setTag(position);
        }

//        viewHolder.contentText.setText(msgBeanList.get(position).getFilename());
        int len = msgBeanList.get(position).getLength();
        viewHolder.lengthText.setText(len + "s");
        viewHolder.contentText.setWidth(iContentWidth + len * 5);


        return convertView;
    }

    class ViewHolder {
        TextView contentText;
        TextView lengthText;
    }


    public void playVoice(String filename) {

        if (mMediaPlayer == null) {
            mMediaPlayer = new AudioMediaPlayer(mContext);
        }
        int ret = mMediaPlayer.playUrl(filename);
        if (ret == -1) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mMediaPlayer = new AudioMediaPlayer(mContext);
            int ret1 = mMediaPlayer.playUrl(filename);
            if (ret1 == -1) {
                Log.e("xxxxxxxxxxxx", "xxxxxxxxxxxxx");
            }
        }

    }

}

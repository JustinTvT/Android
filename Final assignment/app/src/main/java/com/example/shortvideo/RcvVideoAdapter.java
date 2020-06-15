package com.example.shortvideo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RcvVideoAdapter extends RecyclerView.Adapter<RcvVideoAdapter.VideoViewHolder> {

    private Context mContext;
    //定义数组用于保存返回的视频信息
    private ArrayList<RcvVideoBean> mVideos = new ArrayList<>();
    //定义视频适配器
    RcvVideoAdapter(Context context, ArrayList<RcvVideoBean> videoBeans) {
        mContext = context;
        mVideos.addAll(videoBeans);
    }

    @NonNull
    @Override
    public RcvVideoAdapter.VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.rcv_item_video, parent, false);
        return new VideoViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RcvVideoAdapter.VideoViewHolder holder, int position) {
        //用RcvVideoBean类对返回的视频信息进行对应解析
        final RcvVideoBean rcvVideoBean = mVideos.get(position);
        //根据返回的信息对视频标题进行设置
        holder.tv_title.setText(rcvVideoBean.getDescription());
        //加载视频的封面信息图片
        Glide.with(mContext).load(rcvVideoBean.getAvatar()).into(holder.iv_cover);
        //设置动作相应按钮，使得单击视频可以进入视频播放页面
        holder.iv_cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, VideoDetailsActivity.class);
                intent.putExtra("bean", rcvVideoBean);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mVideos.size();
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder {
        //定义VideoView的容器，包括视频的标题的封面图片
        TextView tv_title;
        ImageView iv_cover;

        VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            //进行每一条Item中视频标题和封面图片的赋值
            tv_title = itemView.findViewById(R.id.tv_title);
            iv_cover = itemView.findViewById(R.id.iv_img);
        }
    }
}

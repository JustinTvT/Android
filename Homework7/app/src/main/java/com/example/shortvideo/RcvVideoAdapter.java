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
    private ArrayList<RcvVideoBean> mVideos = new ArrayList<>();

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
        final RcvVideoBean rcvVideoBean = mVideos.get(position);

        holder.tv_title.setText(rcvVideoBean.getDescription());
        Glide.with(mContext).load(rcvVideoBean.getAvatar()).into(holder.iv_cover);
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
        TextView tv_title;
        ImageView iv_cover;

        VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            iv_cover = itemView.findViewById(R.id.iv_img);
        }
    }
}

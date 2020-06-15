package com.example.shortvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.net.MalformedURLException;
import java.net.URL;

public class VideoDetailsActivity extends AppCompatActivity {

    private VideoView mVideoView;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_details);
        mVideoView = findViewById(R.id.mVideoView);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);

        RcvVideoBean rcvVideoBean = (RcvVideoBean) getIntent().getSerializableExtra("bean");
        mVideoView.setVideoPath(rcvVideoBean.getFeedurl());
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mVideoView.start();
            }
        });

        textView1.setText("详情：" + rcvVideoBean.getDescription());
        textView2.setText("封面图片：" + rcvVideoBean.getAvatar());
        textView3.setText("播放链接：" + rcvVideoBean.getFeedurl());
        textView4.setText("名称：" + rcvVideoBean.getNickname());
        textView5.setText("点赞数量：" + rcvVideoBean.getLikecount());
    }

}

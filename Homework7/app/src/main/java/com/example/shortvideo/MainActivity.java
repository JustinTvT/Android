package com.example.shortvideo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * 主页
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RcvVideoAdapter mRcvVideoAdapter;
    private ArrayList<RcvVideoBean> mVideos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.mRecyclerView);

        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "https://beiyou.bytedance.com/api/invoke/video/invoke/video";
                try {
                    URL realUrl = new URL(url);
                    //得到connection对象。
                    HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
                    //设置请求方式
                    connection.setRequestMethod("GET");
                    //连接
                    connection.connect();
                    //得到响应码
                    int responseCode = connection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        //得到响应流
                        InputStream inputStream = connection.getInputStream();
                        //将响应流转换成字符串
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                        while ((line = br.readLine()) != null) {
                            stringBuilder.append(line);
                        }
                        String result = stringBuilder.toString();
                        Log.d("TAG", result);

                        mVideos.clear();
                        JSONArray jsonArray = new JSONArray(result);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String feedurl = jsonObject.optString("feedurl");
                            String nickname = jsonObject.optString("nickname");
                            String description = jsonObject.optString("description");
                            String avatar = jsonObject.optString("avatar");
                            int likecount = jsonObject.optInt("likecount");
                            RcvVideoBean rcvVideoBean = new RcvVideoBean(feedurl, nickname, description, avatar, likecount);
                            mVideos.add(rcvVideoBean);
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mRcvVideoAdapter = new RcvVideoAdapter(MainActivity.this, mVideos);
                                mRecyclerView.setAdapter(mRcvVideoAdapter);
                            }
                        });
                    }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}

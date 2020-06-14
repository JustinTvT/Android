package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = findViewById(R.id.btn1);
        final TextView tv1 = findViewById(R.id.tv1);
        ImageView iv1 = findViewById(R.id.iv1);
        CheckBox ck1 = findViewById(R.id.checkBox1);
        RadioButton rb1 = findViewById(R.id.radioButton1);
        rb1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tv1.setText("Hello World!");
            }
        });
        ck1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tv1.setText("You have triggered your death!");
                Log.d("MainActivity","You have triggered your death!");
            }
        });
        iv1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tv1.setText("Don't touch me!");
                Log.d("MainActivity","Don't touch me!");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("What a Wonderful world!");
            }
        });
    }
}

package com.example.sound_app.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sound_app.R;

public class splash_activity extends AppCompatActivity {
    TextView para;
    ImageView index01,index02,index03;
    int c=0;
    ConstraintLayout main_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity_layout);
        getSupportActionBar().hide();
        para=findViewById(R.id.sp_para);
        index01=findViewById(R.id.index01);
        index02=findViewById(R.id.index02);
        index03=findViewById(R.id.index03);
        main_layout=findViewById(R.id.main_layout);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getColor(R.color.first_color));
        }
        main_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c++;
                if (c==1){
                    Toast.makeText(splash_activity.this, "1", Toast.LENGTH_SHORT).show();
                    index01.setImageResource(R.drawable.index_circuler_off);
                    index02.setImageResource(R.drawable.index_circuler_on);
                    index03.setImageResource(R.drawable.index_circuler_off);
                    para.setText(R.string.spalsh_para2);
                }else if (c==2){
                    Toast.makeText(splash_activity.this, "2", Toast.LENGTH_SHORT).show();
                    index01.setImageResource(R.drawable.index_circuler_off);
                    index02.setImageResource(R.drawable.index_circuler_off);
                    index03.setImageResource(R.drawable.index_circuler_on);
                    para.setText(R.string.spalsh_para3);
                }else{
                    Intent i=new Intent(getBaseContext(),MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}
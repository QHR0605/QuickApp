package com.example.quickapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.quickapp.R;
import com.example.quickapp.ui.health_state.CircleProgressView;
import com.example.quickapp.util.HttpUtil;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class QuestionActivity extends AppCompatActivity {

    Button button;
    RatingBar r1,r2,r3,r4,r5,r6,r7,r8;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

//            binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

            setContentView(R.layout.activity_question);
            button=findViewById(R.id.button3);
            r1=findViewById(R.id.q1);
            r2=findViewById(R.id.q2);
            r3=findViewById(R.id.q3);
            r4=findViewById(R.id.q4);
            r5=findViewById(R.id.q5);
            r6=findViewById(R.id.q6);
            r7=findViewById(R.id.q7);
            r8=findViewById(R.id.q8);
            final String[] answer = new String[1];
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("当前值：？"+r1.getRating());
                   String rating= ""+(int)r1.getRating()+(int)r2.getRating()+(int)r3.getRating()+(int)r4.getRating()+(int)r5.getRating()+(int)r6.getRating()+(int)r7.getRating()+(int)r8.getRating();
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Map<String, String> paramsMap = new HashMap<>();
                            SharedPreferences preferences;
                            preferences = getSharedPreferences("user", 0);
                            String token = preferences.getString("token","");
                            paramsMap.put("token", token);
                            paramsMap.put("answers", rating);
                            try {
                                answer[0] = HttpUtil.doPost("addQuestion", paramsMap);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    t.start();
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                System.out.println(answer[0]);
                    if (answer[0]!="fail"){
//                        Bundle bundle=new Bundle();
//                        bundle.putString("token",answer[0]);
                        System.out.println("token:"+answer[0]);
                    }
                    //留个fragment切换
                }
            });
            TextView button1 = findViewById(R.id.personHealth);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent;
                    intent = new Intent(QuestionActivity.this, HealthActivity.class);
                    startActivity(intent);
                }
            });
            TextView button3 = findViewById(R.id.equipment);
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent;
                    intent = new Intent(QuestionActivity.this, MachineListActivity.class);
                    startActivity(intent);
                }
            });

            TextView button4 = findViewById(R.id.pinformation);
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent;
                    intent = new Intent(QuestionActivity.this, PersonalCenterActivity.class);
                    startActivity(intent);
                }
            });
        }
}


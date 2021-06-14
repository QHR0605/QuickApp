package com.example.quickapp.ui.health_state;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.example.quickapp.R;
import com.example.quickapp.ui.machine.MachineListFragment;
import com.example.quickapp.ui.personal_center.PersonalCenterFragment;
import com.example.quickapp.util.PostJSON;
import com.example.quickapp.util.PostUtil;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;

public class HealthActivity extends AppCompatActivity {

    private String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy);

        TextView button3 = findViewById(R.id.equipment);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(HealthActivity.this, MachineListFragment.class);
                startActivity(intent);
            }
        });

        TextView button4 = findViewById(R.id.pinformation);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(HealthActivity.this, PersonalCenterFragment.class);
                startActivity(intent);
            }
        });
        load();
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @SuppressLint("SetTextI18n")
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x123) {
                HealthBean healthBean = new Gson().fromJson(response, HealthBean.class);
                int score = (int) healthBean.getData().getScore();
                String symptom = healthBean.getData().getSymptom();
                String advice = healthBean.getData().getAdvice();
                final CircleProgressView circleProgressView = (CircleProgressView) findViewById(R.id.circle_progress);
                circleProgressView.setCurrentProgress(score);
                TextView view1 = findViewById(R.id.content1);
                if (score < 60) {
                    view1.setText("   健康状况\n【高危】");
                }
                else if (score < 90) {
                    view1.setText("   健康状况\n【良好】");
                }
                else {
                    view1.setText("   健康状况\n【健康】");
                }
                TextView view2 = findViewById(R.id.content2_1);
                view2.setText("   " + symptom);
                TextView view3 = findViewById(R.id.content3);
                view3.setText("   " + advice);
            }
        }
    };

    public void load() {
        new Thread()
        {
            @Override
            public void run()
            {
//                //从xml中获取登录状态
//                SharedPreferences preferences;
//                preferences = getSharedPreferences("user", 0);
//                String Id = preferences.getString("id","");
                response = PostJSON.sendPost("http://10.0.2.2:8080/login","{" + "\"" + "username" + "\"" + ":" + "\"" + "zzq4" + "\""+"," +
                        "\"" + "password" + "\"" + ":" + "\"" + "123456" + "\""+"}");
                LoginBean loginBean = new Gson().fromJson(response, LoginBean.class) ;
                String token = loginBean.getToken();
                System.out.println("TOKEN="+token);
                response = PostUtil.sendPost("http://10.0.2.2:8080/health","{" + "\"" + "token" + "\"" + ":" + "\"" + token + "\""+"}");
                //获取健康信息
//                response = PostUtil.sendPost();
                //根据response更新view
                handler.sendEmptyMessage(0x123);
            }
        }.start();
    }

}

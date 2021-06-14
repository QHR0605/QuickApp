package com.example.quickapp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quickapp.R;
import com.example.quickapp.util.HttpUtil;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    ImageView imageView;
    EditText edit_username,edit_password;
    TextView textView;
    Button button,button2;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

//        imageView.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {
//            public void onSwipeTop() {
//            }
//
//            public void onSwipeRight() {
//                if (count == 0) {
//                    imageView.setImageResource(R.drawable.good_night_img);
//                    textView.setText("Night");
//                    count = 1;
//                } else {
//                    imageView.setImageResource(R.drawable.good_morning_img);
//                    textView.setText("Morning");
//                    count = 0;
//                }
//            }
//
//            public void onSwipeLeft() {
//                if (count == 0) {
//                    imageView.setImageResource(R.drawable.good_night_img);
//                    textView.setText("Night");
//                    count = 1;
//                } else {
//                    imageView.setImageResource(R.drawable.good_morning_img);
//                    textView.setText("Morning");
//                    count = 0;
//                }
//            }
//
//            public void onSwipeBottom() {
//            }
//
//
//        });
//        binding.signIn.setText("登录");
//        binding.signIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println(binding.username.getText());
//            }
//        });
        button=findViewById(R.id.sign_in);
        button2=findViewById(R.id.sign_up);
        edit_username=findViewById(R.id.username);
        edit_password=findViewById(R.id.password);
        final String[] answer = new String[1];
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String username= String.valueOf(edit_username.getText());
                        String password= String.valueOf(edit_password.getText());
                        Map<String, String> paramsMap = new HashMap<>();
                        paramsMap.put("username", username);
                        paramsMap.put("password", password);
                        try {
                            answer[0] = HttpUtil.doPost("login", paramsMap);
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
                    Bundle bundle=new Bundle();
                    bundle.putString("token",answer[0]);
                    System.out.println("token:"+answer[0]);
                    SharedPreferences preferences;
                    SharedPreferences.Editor editor;
                    preferences = getSharedPreferences("user", 0);
                    editor = preferences.edit();
                    editor.putString("token", answer[0]);
                    editor.apply();
                    Intent intent;
                    intent = new Intent(LoginActivity.this, HealthActivity.class);
                    startActivity(intent);
                }
                //留个fragment切换
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String username= String.valueOf(edit_username.getText());
                        String password= String.valueOf(edit_password.getText());
                        Map<String, String> paramsMap = new HashMap<>();
                        paramsMap.put("username", username);
                        paramsMap.put("password", password);
                        try {
                            answer[0] = HttpUtil.doPost("register", paramsMap);
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
                    Bundle bundle=new Bundle();
                    bundle.putString("token",answer[0]);

                }
                System.out.println("answer:"+answer[0]);
                //留个fragment切换
            }
        });
    }
}

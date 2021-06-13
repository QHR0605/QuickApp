package com.example.quickapp.ui.health_state;

import android.os.Bundle;

import com.example.quickapp.R;

import androidx.appcompat.app.AppCompatActivity;

public class HealthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy);
        final CircleProgressView circleProgressView = (CircleProgressView) findViewById(R.id.circle_progress);
        circleProgressView.setCurrentProgress(100);
    }

}

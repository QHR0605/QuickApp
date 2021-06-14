package com.example.quickapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.quickapp.R;
import com.example.quickapp.entity.User;
import com.example.quickapp.ui.personal_center.PersonalCenterFragment;

public class PersonalCenterActivity extends AppCompatActivity {

    private final FragmentManager manager = getSupportFragmentManager();
    private final FragmentTransaction transaction = manager.beginTransaction();

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PersonalCenterFragment personalCenterFragment = new PersonalCenterFragment();
        transaction.replace(R.id.personal_center_fragment,personalCenterFragment);
        transaction.commit();
        setContentView(R.layout.activity_personal_center);
    }
}

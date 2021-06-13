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
    private View user_msg;
    private View user_machine;
    private View user_history;
    private View user_about;

    public FragmentManager getManager() {
        return manager;
    }

    public FragmentTransaction getTransaction() {
        return transaction;
    }

    public View getUser_msg() {
        return user_msg;
    }

    public void setUser_msg(View user_msg) {
        this.user_msg = user_msg;
    }

    public View getUser_machine() {
        return user_machine;
    }

    public void setUser_machine(View user_machine) {
        this.user_machine = user_machine;
    }

    public View getUser_history() {
        return user_history;
    }

    public void setUser_history(View user_history) {
        this.user_history = user_history;
    }

    public View getUser_about() {
        return user_about;
    }

    public void setUser_about(View user_about) {
        this.user_about = user_about;
    }

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PersonalCenterFragment personalCenterFragment = new PersonalCenterFragment();
        transaction.replace(R.id.personal_center_fragment,personalCenterFragment);
        transaction.commit();
        setContentView(R.layout.activity_personal_center);

    }
}

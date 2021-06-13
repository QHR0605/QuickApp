package com.example.quickapp.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.quickapp.R;
import com.example.quickapp.entity.User;
import com.example.quickapp.ui.personal_center.PersonalMessageFragment;

public class PersonalMessageActivity extends AppCompatActivity {

    private final FragmentManager manager = getSupportFragmentManager();
    private final FragmentTransaction transaction = manager.beginTransaction();
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_center_message);
        PersonalMessageFragment fragment = new PersonalMessageFragment();
        transaction.replace(R.id.personal_center_message_fragment,fragment);
        transaction.commit();
    }
}

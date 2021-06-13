package com.example.quickapp.ui.personal_center;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.example.quickapp.R;
import com.example.quickapp.entity.User;
import org.jetbrains.annotations.NotNull;

public class PersonalMessageFragment extends Fragment {

    private EditText username;
    private EditText sex;
    private EditText age;
    private EditText height;
    private EditText weight;
    private User user;
    private Toolbar toolbar;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_personal_message, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (this.getActivity() != null) {
            username = getActivity().findViewById(R.id.personal_center_edit_username);
            sex = getActivity().findViewById(R.id.personal_center_edit_sex);
            age = getActivity().findViewById(R.id.personal_center_edit_age);
            height = getActivity().findViewById(R.id.personal_center_edit_height);
            weight = getActivity().findViewById(R.id.personal_center_edit_weight);
            toolbar = getActivity().findViewById(R.id.personal_center_message_toolbar);
            user = (User) getActivity().getIntent().getSerializableExtra("user");
            //设置状态栏的颜色为亮色，字体为深色
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                //设置状态栏的颜色为亮色，字体为深色
                getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                //改变状态栏颜色
                getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                //设置为白色
                getActivity().getWindow().setStatusBarColor(Color.WHITE);
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (user.getUsername() != null) {
                username.setText(user.getUsername());
            } else {
                username.setText("---");
            }
            if (user.getSex() != null) {
                if (user.getSex()) {
                    sex.setText("男");
                } else if (!user.getSex()) {
                    sex.setText("女");
                }
            } else {
                username.setText("---");
            }
            if (user.getAge() != null) {
                age.setText(String.valueOf(user.getAge()));
            } else {
                age.setText("---");
            }
            if (user.getHeight() != null) {
                height.setText(user.getHeight() + " cm");
            } else {
                height.setText("---");
            }
            if (user.getWeight() != null) {
                weight.setText(user.getWeight() + " kg");
            } else {
                weight.setText("---");
            }
        }
    }
}

package com.example.quickapp.ui.personal_center;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.quickapp.R;
import com.example.quickapp.activity.MachineListActivity;
import com.example.quickapp.activity.PersonalMessageActivity;
import com.example.quickapp.entity.MachineData;
import com.example.quickapp.entity.User;
import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;
import java.util.Objects;

public class PersonalCenterFragment extends Fragment {

    private View user_msg;
    private View user_machine;
    private View user_history;
    private View user_about;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_personal_center, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        user_msg = Objects.requireNonNull(getActivity()).findViewById(R.id.personal_center_msg);
        user_machine = Objects.requireNonNull(getActivity()).findViewById(R.id.personal_center_machine);
        user_history = Objects.requireNonNull(getActivity()).findViewById(R.id.personal_center_history);
        user_about = Objects.requireNonNull(getActivity()).findViewById(R.id.personal_center_about);
        user_msg.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PersonalMessageActivity.class);
            User user = new User()
                    .username("全鸿润")
                    .sex(true)
                    .height(177.9)
                    .weight(67.0);
            intent.putExtra("user", user);
            startActivity(intent);
            Objects.requireNonNull(getActivity()).finish();
        });
        user_machine.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MachineListActivity.class);
            MachineData machineData = new MachineData();
            machineData.setData(36.1);
            machineData.setTimestamp(new Timestamp(System.currentTimeMillis()));
            intent.putExtra("data", machineData);
            startActivity(intent);
            Objects.requireNonNull(getActivity()).finish();
        });
    }
}

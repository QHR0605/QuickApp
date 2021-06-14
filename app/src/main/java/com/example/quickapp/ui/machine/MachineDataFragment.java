package com.example.quickapp.ui.machine;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.quickapp.R;
import com.example.quickapp.entity.MachineData;
import org.jetbrains.annotations.NotNull;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class MachineDataFragment extends Fragment {
    private ImageView machine_image;
    private TextView machine_type;
    private TextView machine_data;
    private TextView send_time;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_machine_data, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            machine_image = getActivity().findViewById(R.id.machine_data_image);
            machine_type = getActivity().findViewById(R.id.machine_data_type);
            machine_data = getActivity().findViewById(R.id.machine_data_content);
            send_time = getActivity().findViewById(R.id.machine_time);
            MachineData data = new MachineData();
            data = (MachineData) getActivity().getIntent().getSerializableExtra("data");
            if (data == null) {
                machine_type.setText("没有设备在线");
            } else {
                if (data.getType() != null) {
                    if (data.getType() == 0) {
                        machine_image.setImageResource(R.drawable.temp);
                        machine_type.setText("温度");
                    } else if (data.getType() == 1) {
                        machine_image.setImageResource(R.drawable.humi);
                        machine_type.setText("湿度");
                    } else {
                        machine_image.setImageResource(R.drawable.air);
                        machine_type.setText("空气质量");
                    }
                }
                machine_data.setText(String.valueOf(data.getData()));
                Date date = new Date(data.getTimestamp().getTime());
                @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                send_time.setText(format.format(date));
            }

        }

    }
}

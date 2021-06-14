package com.example.quickapp.util.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.quickapp.R;
import com.example.quickapp.entity.MachineData;
import org.jetbrains.annotations.NotNull;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter<MachineData> {

    private int resourceId;
    public ListViewAdapter(@NonNull @NotNull Context context, int resource, @NonNull @NotNull List<MachineData> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MachineData data = getItem(position);
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView machine_name = view.findViewById(R.id.machine_name);
        TextView machine_state = view.findViewById(R.id.machine_state);
        TextView machine_time = view.findViewById(R.id.machine_time);
        machine_name.setText(data.getName());
        if (data.getState()){
            machine_state.setText("已开启");
        }else{
            machine_state.setText("已关闭");
        }
        Date date = new Date(data.getTimestamp().getTime());
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        machine_time.setText(format.format(date));
        return  view;
    }
}

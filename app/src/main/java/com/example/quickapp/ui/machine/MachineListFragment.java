package com.example.quickapp.ui.machine;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.quickapp.R;
import com.example.quickapp.activity.MachineDataActivity;
import com.example.quickapp.activity.MachineListActivity;
import com.example.quickapp.entity.MachineData;
import com.example.quickapp.util.adapter.ListViewAdapter;
import org.jetbrains.annotations.NotNull;

import javax.crypto.Mac;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MachineListFragment extends Fragment {

    private ImageButton add_machine;
    private ListView machine_list_view;
    private List<MachineData> machine_list;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_machine_list,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity()!=null){
            add_machine = getActivity().findViewById(R.id.add_machine);
            machine_list_view = getActivity().findViewById(R.id.machine_list);
            machine_list = new LinkedList<>();
            MachineData m1 = new MachineData();
            m1.setType(0);
            m1.setName("华为测温仪");
            m1.setState(true);
            m1.setTimestamp(new Timestamp(System.currentTimeMillis()));
            MachineData m2 = new MachineData();
            m2.setType(1);
            m2.setName("小米湿度计");
            m2.setState(true);
            m2.setTimestamp(new Timestamp(System.currentTimeMillis()));
            MachineData m3 = new MachineData();
            m3.setType(2);
            m3.setName("荣耀空气机");
            m3.setState(false);
            m3.setTimestamp(new Timestamp(System.currentTimeMillis()));
            machine_list.add(m1);
            machine_list.add(m2);
            machine_list.add(m3);
            ListViewAdapter adapter = new ListViewAdapter(getActivity(),R.layout.fragment_machine_list_item,machine_list);
            machine_list_view.setAdapter(adapter);
            machine_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (id>=0){
                        Intent intent = new Intent(getActivity(), MachineDataActivity.class);
                        intent.putExtra("activity_name","MachineListActivity");
                        intent.putExtra("data",machine_list.get(position));
                        startActivity(intent);
                        Objects.requireNonNull(getActivity()).finish();
                    }
                }
            });
        }



    }
}

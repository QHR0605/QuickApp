package com.example.quickapp.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.quickapp.R;
import com.example.quickapp.ui.machine.MachineDataFragment;
import com.example.quickapp.ui.machine.MachineListFragment;

public class MachineListActivity extends AppCompatActivity {

    private final FragmentManager manager = getSupportFragmentManager();
    private final FragmentTransaction transaction = manager.beginTransaction();

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MachineListFragment fragment = new MachineListFragment();
        transaction.replace(R.id.machine_list_fragment,fragment);
        transaction.commit();
        setContentView(R.layout.activity_machine_list);
    }
}

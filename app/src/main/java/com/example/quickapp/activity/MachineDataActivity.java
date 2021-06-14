package com.example.quickapp.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.quickapp.R;
import com.example.quickapp.ui.machine.MachineDataFragment;

public class MachineDataActivity extends AppCompatActivity {

    private final FragmentManager manager = getSupportFragmentManager();
    private final FragmentTransaction transaction = manager.beginTransaction();

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MachineDataFragment fragment = new MachineDataFragment();
        transaction.replace(R.id.machine_data_fragment,fragment);
        transaction.commit();
        setContentView(R.layout.activity_machine_data);

    }
}

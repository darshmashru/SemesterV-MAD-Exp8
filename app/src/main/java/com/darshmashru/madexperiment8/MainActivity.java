package com.darshmashru.madexperiment8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private AirplaneModeReceiver airplaneModeReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        airplaneModeReceiver = new AirplaneModeReceiver();
    }
    protected void onResume() {
        super.onResume();

        // Register the receiver to listen for Airplane Mode changes
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airplaneModeReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Unregister the receiver to avoid memory leaks
        unregisterReceiver(airplaneModeReceiver);
    }
}
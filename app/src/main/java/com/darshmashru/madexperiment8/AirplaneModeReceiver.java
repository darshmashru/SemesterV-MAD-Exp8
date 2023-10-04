package com.darshmashru.madexperiment8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {
    public void showToast(Context context, boolean isAirplaneModeOn) {
        String message = isAirplaneModeOn ? "Airplane Mode Enabled" : "Airplane Mode Disabled";

        // Show a toast to notify the user
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // Check if the Airplane Mode is enabled or disabled
        boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
        showToast(context, isAirplaneModeOn);
    }
}

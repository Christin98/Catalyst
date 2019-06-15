package com.thecatalyst.catalyst.Service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.thecatalyst.catalyst.Network.NetworkUtil;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String status = NetworkUtil.getConnectivityStatusString(context);
        Toast.makeText(context, status, Toast.LENGTH_SHORT).show();
    }
}

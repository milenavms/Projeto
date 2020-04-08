package com.example.emailservice.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.emailservice.service.ServiceEmail;

public class BroadcastEmailReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String emailsStr = intent.getStringExtra("emails");

        Intent intentAux = new Intent(context, ServiceEmail.class);
        intent.setAction("SERVICO_EMAIL");

        intentAux.putExtra("response", emailsStr);

        context.startService(intentAux);

    }
}

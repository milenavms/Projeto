package com.example.emailteste.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.emailteste.RespostaActivity;

public class BroadcastResponseEmail extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String respose = intent.getStringExtra("response");
        Log.i("Script", "Recebido: "+respose);

        Intent intentAux = new Intent(context, RespostaActivity.class);
        intentAux.putExtra("response", respose);
        intentAux.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intentAux);
    }
}

package com.example.emailservice.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.emailservice.modelo.DataRequest;
import com.example.emailservice.modelo.Email;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ServiceEmail extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String json = intent.getStringExtra("response");

        Gson gson = new Gson();

        DataRequest dado = gson.fromJson(json, DataRequest.class);

        EmailThread emailThread = new EmailThread(dado);

        emailThread.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    class EmailThread extends Thread {
        public DataRequest dado;

        public EmailThread(DataRequest dado) {
            this.dado = dado;
        }

        public void run() {
            String response = "";
            Gson gson = new Gson();

            ArrayList<Email> lista = removeDuplicaoes(dado.getEmails());

            dado.setEmails(lista);
            response = gson.toJson(dado);

            Intent intent = new Intent("BROADCAST_RESPONSE_EMAIL");
            intent.putExtra("response", response);
            intent.setComponent(new ComponentName("com.example.emailteste", "com.example.emailteste.broadcast.BroadcastResponseEmail"));

            sendBroadcast(intent);
            stopSelf();
        }

        private ArrayList<Email> removeDuplicaoes(ArrayList<Email> listaDuplicada) {
            Set<Email> semDuplicacao= new HashSet<>();
            semDuplicacao.addAll(listaDuplicada);
            listaDuplicada = new ArrayList<>();
            listaDuplicada.addAll(semDuplicacao);
            return listaDuplicada;
        }

    }
}

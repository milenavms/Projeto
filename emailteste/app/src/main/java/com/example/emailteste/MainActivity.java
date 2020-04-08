package com.example.emailteste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.emailteste.adapters.ItemAdapter;
import com.example.emailteste.modelo.DataRequest;
import com.example.emailteste.modelo.Email;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Email> lista = new ArrayList<>();
    private DataRequest dado;

    private RecyclerView rvLista;
    private ItemAdapter emailAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = inicializaLista();
        dado = new DataRequest("Dados", lista);
        criaRecyclerView();

        Button btServiceRemocaoo = findViewById(R.id.btServiceRemocaoo);

        btServiceRemocaoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("BROADCAST_RECEIVER_EMAIL");
                String dadoStr = converteListaParaJsonString();
                intent.putExtra("emails", dadoStr);
                intent.setComponent(new ComponentName("com.example.emailservice", "com.example.emailservice.broadcast.BroadcastEmailReceiver"));
                sendBroadcast(intent);
            }
        });



    }

    private static ArrayList<Email> inicializaLista() {
        ArrayList<Email> listaDuplicadaAux = new ArrayList<>();

        listaDuplicadaAux.add(new Email(1L, "msg1"));
        listaDuplicadaAux.add(new Email(2L, "msg2"));
        listaDuplicadaAux.add(new Email(3L, "msg2"));
        listaDuplicadaAux.add(new Email(4L, "msg3"));
        listaDuplicadaAux.add(new Email(5L, "msg4"));
        listaDuplicadaAux.add(new Email(6L, "msg5"));
        listaDuplicadaAux.add(new Email(7L, "msg4"));

        return listaDuplicadaAux;
    }

    private String converteListaParaJsonString() {
        Gson gson = new Gson();
        return gson.toJson(dado);
    }

    private void criaRecyclerView() {
        rvLista = findViewById(R.id.rvLista);
        rvLista.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        emailAdapter = new ItemAdapter(lista); 

        rvLista.setLayoutManager(layoutManager); 
        rvLista.setAdapter(emailAdapter);
    }
}

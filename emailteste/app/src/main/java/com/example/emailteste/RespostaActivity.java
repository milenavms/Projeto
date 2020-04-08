package com.example.emailteste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.emailteste.adapters.ItemAdapter;
import com.example.emailteste.modelo.DataRequest;
import com.example.emailteste.modelo.Email;
import com.google.gson.Gson;

import java.util.ArrayList;

public class RespostaActivity extends AppCompatActivity {
    private ArrayList<Email> lista = new ArrayList<>();


    private RecyclerView rvLista;
    private ItemAdapter emailAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);

        Intent intent = getIntent();
        if(intent.hasExtra("response")) {
            lista = convertJsonParaArraList(intent.getStringExtra("response"));
            criaRecyclerView();
        }

    }

    private ArrayList<Email> convertJsonParaArraList(String json) {

        Gson gson = new Gson();

        DataRequest dado = gson.fromJson(json, DataRequest.class);

        return dado.getEmails();
    }

    private void criaRecyclerView() {
        rvLista = findViewById(R.id.rvListaResultado);
        rvLista.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        emailAdapter = new ItemAdapter(lista); 

        rvLista.setLayoutManager(layoutManager); 
        rvLista.setAdapter(emailAdapter); 
    }
}

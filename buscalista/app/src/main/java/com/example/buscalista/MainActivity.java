package com.example.buscalista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.example.buscalista.adapters.ItemAdapter;
import com.example.buscalista.modelos.ItemLista;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ItemLista> lista = new ArrayList<>();

    private RecyclerView rvLista;
    private ItemAdapter itemAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        criaLista();
        criaRecyclerView();

        EditText etBusca = findViewById(R.id.etBusca);

        //método que fica escutando alterações no texto de busca
        etBusca.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            
            @Override
            public void afterTextChanged(Editable s) {
                busca(s.toString());
            }
        });
    }

    private void busca(String palavraChave) {
        ArrayList<ItemLista> listaFiltrada = new ArrayList<>();

        for(ItemLista item: lista) {
            if(seIgual(item.getTitulo().toUpperCase(), palavraChave.toUpperCase())) { //grau mais alto se for igual
                listaFiltrada.add(item);
            } else {
                if(sePermutada(item.getTitulo().toUpperCase(), palavraChave.toUpperCase())) { //segundo se for permurta
                    listaFiltrada.add(item);
                } else {
                    if(seErroDigitacao(item.getTitulo().toUpperCase(), palavraChave.toUpperCase())) { //terceiro se for erro
                        listaFiltrada.add(item);
                    }
                }
            }
        }
        //atualiza adapter com a lista filtrada
        itemAdapter.filtraLista(listaFiltrada); 

    }

    private boolean sePermutada(String wordA, String wordB) {

        if(wordA.length() == wordB.length()) {
            if(wordA.charAt(0) == wordB.charAt(0)) {
                if(wordA.length() < 4) {
                    return true;
                } else {
                    float countEquals = 0;
                    for(int i = 0; i < wordA.length(); i++) {
                        if(wordA.charAt(i) != wordB.charAt(i)) {
                            countEquals++;
                        }
                    }

                    float percent = (100*countEquals)/wordA.length();

                    if(percent > 66.6666) {
                        return false;
                    } else {
                        return true;
                    }

                }
            } else {
                return false;
            }
        }
        return false;
    }

    private boolean seErroDigitacao(String wordA, String wordB) {
        if(wordB.length() == wordA.length()) {
            int replace = 0;
            for(int i = 0; i < wordB.length(); i++) {
                if(wordB.charAt(i) != wordA.charAt(i)) {
                    replace++;
                }
            }

            if(replace == 1) {
                return true;
            }

            return false;
        } else {
            String word1 = "";
            String word2 = "";

            if(wordA.length() > wordB.length()) {
                word1 = wordA;
                word2 = wordB;
            } else {
                word1 = wordB;
                word2 = wordA;
            }

            if(word1.length() - word2.length() == 1  ) {
                char[] wordAux = word2.toCharArray();
                int count;
                String letra = "";

                for(int i = 0; i < word1.length(); i++) {
                    count = 0;
                    for(int j = 0; j < wordAux.length; j++) {
                        if(word1.charAt(i) == wordAux[j]) {
                            wordAux[j] = ' ';
                            count++;
                            break;
                        }
                    }
                    if(count == 0) {
                        letra +=  String.valueOf(word1.charAt(i));
                    }
                }

                if(letra.length() == 1)
                    return true;

                return false;
            }
            return false;
        }
    }

    private boolean seIgual(String a, String b) {
        if(b.trim().equals("")) return true;
        return a.equals(b);
    }

    private void criaLista() {
        lista.add(new ItemLista("you", "Texto um"));
        lista.add(new ItemLista("probably", "Texto dois"));
        lista.add(new ItemLista("despite", "Texto três"));
        lista.add(new ItemLista("Quatro", "Texto quatro"));
        lista.add(new ItemLista("moon", "Texto cinco"));
        lista.add(new ItemLista("misspellings", "Texto seis"));
        lista.add(new ItemLista("pale", "Texto dois"));
    }

    private void criaRecyclerView() {
        rvLista = findViewById(R.id.rvLista);
        rvLista.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        itemAdapter = new ItemAdapter(lista); //passa a lista para o adapter

        rvLista.setLayoutManager(layoutManager); //seta as configurações de orientação de layout
        rvLista.setAdapter(itemAdapter); //seta o adapter no recycler iniciando a construção da lista
    }
}

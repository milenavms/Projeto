package com.example.buscalista.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buscalista.R;
import com.example.buscalista.modelos.ItemLista;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private ArrayList<ItemLista> lista;

    public ItemAdapter(ArrayList<ItemLista> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false); //infla o card view de cada item da lista
        return new ItemViewHolder(v); //retornar um objeto view holder
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemLista item = lista.get(position); //pega a posição atual da lista

        holder.tvTitulo.setText(item.getTitulo()); //seta os valores na view
        holder.tvDescricao.setText(item.getDescricao());

    }

    @Override
    public int getItemCount() { //retorna o tamanho da lista
        return lista.size();
    }

    //classe responsável por associar atributos java ao xml
    public class ItemViewHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitulo;
        protected TextView tvDescricao;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvDescricao = itemView.findViewById(R.id.tvDescricao);
        }
    }

    public void filtraLista(ArrayList<ItemLista> listaFiltrada) {
        lista = listaFiltrada;
        notifyDataSetChanged(); //atualiza adapter
    }
}

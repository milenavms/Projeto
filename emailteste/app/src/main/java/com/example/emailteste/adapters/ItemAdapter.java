package com.example.emailteste.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emailteste.R;
import com.example.emailteste.modelo.Email;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{
    private ArrayList<Email> lista;

    public ItemAdapter(ArrayList<Email> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false); 
        return new ItemViewHolder(v); 
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Email item = lista.get(position); 

        holder.tvId.setText(String.valueOf(item.getId())); 
        holder.tvMsg.setText(item.getMsg());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    //classe responsável por associar atributos java ao xml
    public class ItemViewHolder extends RecyclerView.ViewHolder {

        protected TextView tvId;
        protected TextView tvMsg;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvMsg = itemView.findViewById(R.id.tvMsg);
        }
    }
}

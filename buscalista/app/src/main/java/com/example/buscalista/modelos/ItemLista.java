package com.example.buscalista.modelos;

public class ItemLista {

    private String titulo;
    private String descricao;

    public ItemLista(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

}

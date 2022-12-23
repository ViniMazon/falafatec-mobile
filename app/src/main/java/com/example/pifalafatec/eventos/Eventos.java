package com.example.pifalafatec.eventos;

import java.sql.Date;
import java.sql.Time;

public class Eventos {

    private long id;
    private String nome;
    private String data;
    private String hora;
    private String descricao;
    private String palestrante;

    public Eventos(long id, String nome, String data, String hora, String descricao, String palestrante) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
        this.palestrante = palestrante;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPalestrante() {
        return palestrante;
    }

    public long getId() {
        return id;
    }
}

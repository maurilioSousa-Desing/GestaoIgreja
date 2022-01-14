package com.api.GestaoIgreja.model;

import javax.persistence.*;

@Entity
@Table(name = "membros")
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private long cpf;

    @Column(name = "ativo")
    private boolean ativo;

    public Membro() {
    }

    public Membro(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.ativo = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", ativo=" + ativo +
                '}';
    }

}

package com.api.GestaoIgreja.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "celulas")
public class Celula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;
    @Column
    private String endereco;
    @Column
    private String diaSemana;

    @Column
    private String horario;

}
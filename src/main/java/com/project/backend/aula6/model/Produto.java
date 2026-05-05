package com.project.backend.aula6.model;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name="produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private float preco;

    public Produto() {}

    public Produto(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
    }
}

package com.literalura.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")  // Mapeia para a coluna "nome" no banco
    private String name;

    @Column(name = "ano_nascimento")  // Mapeia para "ano_nascimento" no banco
    private int birthYear;

    @Column(name = "ano_falecimento", nullable = true)  // Mapeia para "ano_falecimento" e permite NULL
    private Integer deathYear;

    // Construtor sem argumentos (necessário para JPA)
    public Author() {
    }

    // Construtor com argumentos
    public Author(String name, int birthYear, Integer deathYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }
}

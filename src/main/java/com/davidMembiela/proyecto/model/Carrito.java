package com.davidMembiela.proyecto.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data //lombok
@Entity
@Table(name="carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Double precio;

    @ManyToMany
    @JoinTable(name = "carrito_produtoes",
            joinColumns = @JoinColumn(name = "carrito_id"),
            inverseJoinColumns = @JoinColumn(name = "produtoes_id"))
    private Set<Producto> produtoes = new LinkedHashSet<>();


    public Set<Producto> getProductoes() {
        return produtoes;
    }

    public void setProductoes(Set<Producto> produtoes) {
        this.produtoes = produtoes;
    }

}


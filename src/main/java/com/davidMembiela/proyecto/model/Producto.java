package com.davidMembiela.proyecto.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;

@Data //lombok
@Entity
@Table(name="productos")
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name ="precio")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    public double precio;

    @Column(name = "nombre")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    public String nombre;

}

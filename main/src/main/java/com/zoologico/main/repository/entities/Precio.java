package com.zoologico.main.repository.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
@Entity
@Table(name = "precio")
public class Precio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_precio")
    private Long idPrecio;

    @Column(name = "categoria", nullable = false, length = 50)
    private String categoria;

    @Column(name = "cantidad", precision = 10, scale = 2)
    private BigDecimal cantidad;

    @JoinColumn(name = "zoo_id")
    private Integer zooId;

    // Getters and setters

    public Long getIdPrecio() {
        return idPrecio;
    }

    public void setIdPrecio(Long idPrecio) {
        this.idPrecio = idPrecio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getZoo() {
        return zooId;
    }

    public void setZoo(Integer zoo) {
        this.zooId = zoo;
    }
}

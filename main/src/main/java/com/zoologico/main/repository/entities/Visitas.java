package com.zoologico.main.repository.entities;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "visitas")
public class Visitas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_visita")
    private Long id;

    @Column(name = "fecha_visita")
    private Date fechaVisita;

    @Column(name = "cantidad_personas")
    private Integer cantidadPersonas;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "precio_id")
    private BigDecimal precioId;

    @JoinColumn(name = "zoo_id")
    private Long zoo_id;

    public void setId(Long id2) {
    }

    public Long getId() {
        return id;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getPrecioId() {
        return precioId;
    }

    public void setPrecioId(BigDecimal precioId) {
        this.precioId = precioId;
    }

    public Long zoo_id() {
        return zoo_id;
    }

    public void setZoo(Long zoo_id) {
        this.zoo_id = zoo_id;
    }

    // Constructor, getters y setters
}

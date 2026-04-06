package com.sena.modelo;

public class Equipo {
    private String codigo;
    private String nombre;
    private String categoria;
    private boolean disponible;

    public Equipo(String codigo, String nombre, String categoria) {
        if (codigo == null || codigo.isEmpty()) throw new IllegalArgumentException("Código inválido");
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.disponible = true;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public boolean isDisponible() { return disponible; }

    public void marcarPrestado() {
        if (!disponible) throw new IllegalStateException("El equipo ya está prestado");
        this.disponible = false;
    }

    public void marcarDevuelto() { this.disponible = true; }
}

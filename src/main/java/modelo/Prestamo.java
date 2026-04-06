package com.sena.modelo;

public class Prestamo {
    private int id;
    private Aprendiz aprendiz;
    private Equipo equipo;
    private boolean activo;

    public Prestamo(int id, Aprendiz aprendiz, Equipo equipo) {
        this.id = id;
        this.aprendiz = aprendiz;
        this.equipo = equipo;
        this.activo = true;
    }

    public int getId() { return id; }
    public Aprendiz getAprendiz() { return aprendiz; }
    public Equipo getEquipo() { return equipo; }
    public boolean isActivo() { return activo; }
    public void cerrar() { this.activo = false; }
}

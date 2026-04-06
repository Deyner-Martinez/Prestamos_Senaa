package com.sena.modelo;

public class Aprendiz {
    private String documento;
    private String nombre;
    private String ficha;
    private String telefono;

    public Aprendiz(String documento, String nombre, String ficha, String telefono) {
        this.documento = documento;
        this.nombre = nombre;
        this.ficha = ficha;
        this.telefono = telefono;
    }

    public String getDocumento() { return documento; }
    public String getNombre() { return nombre; }

    public void setDocumento(String documento) {
        if (documento == null || documento.isEmpty()) throw new IllegalArgumentException("Documento vacío");
        this.documento = documento;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.length() < 10) throw new IllegalArgumentException("Teléfono inválido");
        this.telefono = telefono;
    }
}

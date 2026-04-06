package com.sena.servicio;

import com.sena.modelo.Prestamo;

// Estas importaciones eliminan los errores de "Cannot resolve symbol"
import com.sena.modelo.*;
import java.util.ArrayList;
import java.util.List;

public class InventarioPrestamos {
    // Definición de las colecciones (Listas)
    private List<Aprendiz> aprendices = new ArrayList<>();
    private List<Equipo> equipos = new ArrayList<>();
    private List<Prestamo> prestamos = new ArrayList<>();

    // Atributo para el ID automático
    private int contadorIdPrestamo = 1;

    // Métodos para registrar datos iniciales
    public void registrarAprendiz(Aprendiz a) {
        aprendices.add(a);
    }

    public void registrarEquipo(Equipo e) {
        equipos.add(e);
    }

    // Método principal: Realizar Préstamo con ID automático
    public void prestarEquipo(String documentoAprendiz, String codigoEquipo) {
        Aprendiz aprendiz = buscarAprendiz(documentoAprendiz);
        Equipo equipo = buscarEquipoPorCodigo(codigoEquipo);

        // Validaciones de reglas de negocio
        if (aprendiz == null) {
            throw new IllegalArgumentException("Error: El aprendiz con documento " + documentoAprendiz + " no existe.");
        }
        if (equipo == null) {
            throw new IllegalArgumentException("Error: El equipo con código " + codigoEquipo + " no existe.");
        }
        if (!equipo.isDisponible()) {
            throw new IllegalStateException("Error: El equipo " + equipo.getNombre() + " no está disponible.");
        }

        // Crear el préstamo usando el contador automático
        Prestamo nuevoPrestamo = new Prestamo(contadorIdPrestamo, aprendiz, equipo);
        prestamos.add(nuevoPrestamo);

        // Actualizar estado del equipo
        equipo.marcarPrestado();

        System.out.println(">>> Préstamo registrado exitosamente con ID #" + contadorIdPrestamo);

        // Incrementar el contador para el siguiente préstamo
        contadorIdPrestamo++;
    }

    // Método para devolver equipos
    public void devolverEquipo(int idPrestamo) {
        for (Prestamo p : prestamos) {
            if (p.getId() == idPrestamo && p.isActivo()) {
                p.cerrar();
                p.getEquipo().marcarDevuelto();
                System.out.println(">>> Equipo devuelto: " + p.getEquipo().getNombre());
                return;
            }
        }
        throw new IllegalArgumentException("Error: No se encontró un préstamo activo con ID " + idPrestamo);
    }

    // Métodos de visualización
    public void listarEquipos() {
        System.out.println("\n--- ESTADO DE EQUIPOS ---");
        for (Equipo e : equipos) {
            String estado = e.isDisponible() ? "DISPONIBLE" : "PRESTADO";
            System.out.println("[" + e.getCodigo() + "] " + e.getNombre() + " - " + estado);
        }
    }

    public void listarPrestamosActivos() {
        System.out.println("\n--- PRÉSTAMOS VIGENTES ---");
        boolean hayActivos = false;
        for (Prestamo p : prestamos) {
            if (p.isActivo()) {
                System.out.println("ID: " + p.getId() + " | Aprendiz: " + p.getAprendiz().getNombre() + " | Equipo: " + p.getEquipo().getNombre());
                hayActivos = true;
            }
        }
        if (!hayActivos) System.out.println("No hay préstamos activos.");
    }

    // Buscadores privados (Lógica interna)
    private Aprendiz buscarAprendiz(String documento) {
        for (Aprendiz a : aprendices) {
            if (a.getDocumento().equals(documento)) {
                return a;
            }
        }
        return null;
    }

    private Equipo buscarEquipoPorCodigo(String codigo) {
        for (Equipo e : equipos) {
            if (e.getCodigo().equals(codigo)) {
                return e;
            }
        }
        return null;
    }
}

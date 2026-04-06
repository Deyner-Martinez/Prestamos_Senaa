package com.sena.main;

import com.sena.modelo.*;
import com.sena.servicio.InventarioPrestamos;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventarioPrestamos sistema = new InventarioPrestamos();
        Scanner leer = new Scanner(System.in);

        // --- APRENDICES REGISTRADOS AUTOMÁTICAMENTE ---
        sistema.registrarAprendiz(new Aprendiz("101", "Angel Medina", "282333", "3101234567"));
        sistema.registrarAprendiz(new Aprendiz("102", "Maria Ruiz", "282133", "3117654321"));
        sistema.registrarAprendiz(new Aprendiz("103", "Isabella Olivares", "282777", "3120001122"));

        // --- EQUIPOS DE PRUEBA ---
        sistema.registrarEquipo(new Equipo("E1", "Laptop HP", "computo"));
        sistema.registrarEquipo(new Equipo("E2", "Portatil Acer", "computo"));
        sistema.registrarEquipo(new Equipo("E3", "Tablet Samsung", "multimedia/estudio"));
        sistema.registrarEquipo(new Equipo("E4", "Equipo 3 de la Bibloteca", "Computo"));

        int opcion = 0;
        while (opcion != 7) {
            try {
                System.out.println("\n--- MENU ---");
                System.out.println("1.Reg Aprendiz | 2.Reg Equipo | 3.Ver Equipos | 4.Prestar | 5.Activos | 6.Devolver | 7.Salir");
                System.out.print("Opcion: ");
                opcion = Integer.parseInt(leer.nextLine());

                switch (opcion) {
                    case 3:
                        sistema.listarEquipos();
                        break;
                    case 4:
                        System.out.print("Documento Aprendiz: ");
                        String d = leer.nextLine();
                        System.out.print("Codigo Equipo: ");
                        String c = leer.nextLine();
                        sistema.prestarEquipo(d, c);
                        break;
                    case 5:
                        sistema.listarPrestamosActivos();
                        break;
                    case 6:
                        System.out.print("ID del prestamo: ");
                        int id = Integer.parseInt(leer.nextLine());
                        sistema.devolverEquipo(id);
                        break;
                    case 7:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("ALERTA: " + e.getMessage());
            }
        }
        leer.close(); // Buena práctica cerrar el scanner
    }
}
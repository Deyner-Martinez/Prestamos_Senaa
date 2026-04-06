package com.sena.main;

import com.sena.modelo.*;
import com.sena.servicio.InventarioPrestamos;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventarioPrestamos sistema = new InventarioPrestamos();
        Scanner leer = new Scanner(System.in);

        // --- APRENDICES REGISTRADOS AUTOMÁTICAMENTE ---
        sistema.registrarAprendiz(new Aprendiz("101", "Juan Roy", "282333", "3034567892"));
        sistema.registrarAprendiz(new Aprendiz("102", "Marcos Polo", "282145", "3034764087"));
        sistema.registrarAprendiz(new Aprendiz("103", "Camilo Sanchez", "424567", "321476984"));

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
                    case 3: sistema.listarEquipos(); break;
                    case 4:
                        System.out.print("Documento Aprendiz: "); String d = leer.nextLine();
                        System.out.print("Codigo Equipo: "); String c = leer.nextLine();
                        sistema.prestarEquipo(d, c); // Solo pasamos 2 datos, el ID es automático
                        break;
                    case 5: sistema.listarPrestamosActivos(); break;
                    case 6:
                        System.out.print("ID del prestamo: ");
                        int id = Integer.parseInt(leer.nextLine());
                        sistema.devolverEquipo(id);
                        break;
                }
            } catch (Exception e) {
                System.out.println("ALERTA: " + e.getMessage());
            }
        }
    }
}
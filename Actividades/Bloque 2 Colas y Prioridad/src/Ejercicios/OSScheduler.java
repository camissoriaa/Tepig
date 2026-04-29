package Ejercicios;

import Implementacion.ColaConPrioridad;

/**
 * EJERCICIO 6 - Procesador de Tareas (OS Scheduler)
 *
 * CRITERIO: Mayor número entero = Mayor prioridad
 *
 *   Proceso del sistema (kernel) → prioridad 50
 *   Proceso del usuario (Spotify) → prioridad 10
 *
 * El sistema operativo siempre atiende primero los procesos
 * del sistema antes que los del usuario.
 *
 * CASO SOBRECARGA:
 *   Si llegan más procesos de los que la CPU puede manejar,
 *   el scheduler sigue atendiendo en orden de prioridad.
 *   Los de prioridad baja (usuario) quedan esperando más tiempo
 *   o directamente se "matan" (kill) si hay demasiados.
 *   Acá simulamos que siguen esperando en la cola.
 */
public class OSScheduler {

    private ColaConPrioridad cola;

    public OSScheduler() {
        cola = new ColaConPrioridad();
        cola.InicializarCola();
    }

    public void demostrar() {
        System.out.println("\n--- 6. Procesador de Tareas (OS Scheduler) ---");

        System.out.println("\n  Procesos que llegan:");
        cola.InicializarCola();
        cola.Encolar(1, 10);  // Spotify (usuario)
        cola.Encolar(2, 50);  // Kernel (sistema)
        cola.Encolar(3, 10);  // Chrome (usuario)
        cola.Encolar(4, 50);  // Driver de red (sistema)
        System.out.println("    Encolar(Spotify,       prioridad=10)");
        System.out.println("    Encolar(Kernel,        prioridad=50)");
        System.out.println("    Encolar(Chrome,        prioridad=10)");
        System.out.println("    Encolar(DriverRed,     prioridad=50)");

        System.out.println("\n  Orden de ejecución por la CPU:");
        int turno = 1;
        while (!cola.ColaVacia()) {
            System.out.println("    " + turno + "° ejecutado: "
                    + traducirProceso(cola.Primero())
                    + " (prioridad " + cola.PrioridadDelPrimero() + ")");
            cola.Desencolar();
            turno++;
        }

        System.out.println("\n  CASO SOBRECARGA: llegan 3 procesos de usuario de golpe");
        cola.InicializarCola();
        cola.Encolar(5, 50);  // sistema
        cola.Encolar(1, 10);  // usuario 1
        cola.Encolar(3, 10);  // usuario 2
        cola.Encolar(6, 10);  // usuario 3
        System.out.println("    Encolar(SistemaOS, prioridad=50)");
        System.out.println("    Encolar(Usuario1,  prioridad=10)");
        System.out.println("    Encolar(Usuario2,  prioridad=10)");
        System.out.println("    Encolar(Usuario3,  prioridad=10)");
        System.out.println("  Resultado: el sistema va primero, los usuarios esperan en orden FIFO:");
        turno = 1;
        while (!cola.ColaVacia()) {
            System.out.println("    " + turno + "° ejecutado: "
                    + traducirProceso(cola.Primero())
                    + " (prioridad " + cola.PrioridadDelPrimero() + ")");
            cola.Desencolar();
            turno++;
        }
    }

    private String traducirProceso(int codigo) {
        switch (codigo) {
            case 1: return "Spotify   ";
            case 2: return "Kernel    ";
            case 3: return "Chrome    ";
            case 4: return "DriverRed ";
            case 5: return "SistemaOS ";
            case 6: return "Usuario3  ";
            default: return "Proceso-" + codigo;
        }
    }
}

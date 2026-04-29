package Ejercicios;

import Implementacion.ColaConPrioridad;

/**
 * EJERCICIO 8 - Distribución de Tickets IT
 *
 * CRITERIO: Mayor número entero = Mayor prioridad
 *
 *   Servidor caído → prioridad 999 (urgentísimo, se atiende ya)
 *   "No me gusta el fondo de pantalla" → prioridad 0 (ni se atiende)
 *
 * Definimos explícitamente:
 *   prioridad 999 = Crítico      (servidor caído, base de datos corrupta)
 *   prioridad 100 = Alto         (sistema lento, error en producción)
 *   prioridad 50  = Medio        (impresora no funciona, software no abre)
 *   prioridad 10  = Bajo         (cambio de contraseña, actualización)
 *   prioridad 0   = Insignificante (fondo de pantalla, color del cursor)
 */
public class TicketsIT {

    private ColaConPrioridad cola;

    public TicketsIT() {
        cola = new ColaConPrioridad();
        cola.InicializarCola();
    }

    public void demostrar() {
        System.out.println("\n--- 8. Distribución de Tickets IT ---");

        System.out.println("\n  Tabla de prioridades definida:");
        System.out.println("    999 = Critico      (servidor caído)");
        System.out.println("    100 = Alto          (error en producción)");
        System.out.println("    50  = Medio         (impresora rota)");
        System.out.println("    10  = Bajo           (cambio de contraseña)");
        System.out.println("    0   = Insignificante (fondo de pantalla)");

        System.out.println("\n  Tickets que llegan (en orden de creación):");
        cola.InicializarCola();
        cola.Encolar(1, 0);    // fondo de pantalla
        cola.Encolar(2, 999);  // servidor caído
        cola.Encolar(3, 50);   // impresora rota
        cola.Encolar(4, 10);   // cambio de contraseña
        cola.Encolar(5, 100);  // error en producción
        System.out.println("    Encolar(FondoPantalla,    prioridad=0)");
        System.out.println("    Encolar(ServidorCaido,    prioridad=999)");
        System.out.println("    Encolar(ImpresoraRota,    prioridad=50)");
        System.out.println("    Encolar(CambioContrasena, prioridad=10)");
        System.out.println("    Encolar(ErrorProduccion,  prioridad=100)");

        System.out.println("\n  Orden de atención del equipo IT:");
        int turno = 1;
        while (!cola.ColaVacia()) {
            System.out.println("    " + turno + "° atendido: "
                    + traducirTicket(cola.Primero())
                    + " (prioridad " + cola.PrioridadDelPrimero() + ")");
            cola.Desencolar();
            turno++;
        }

        System.out.println("\n  El fondo de pantalla se atiende al último (prioridad 0).");
        System.out.println("  El servidor caído se atiende primero (prioridad 999).");
    }

    private String traducirTicket(int codigo) {
        switch (codigo) {
            case 1: return "FondoPantalla    ";
            case 2: return "ServidorCaido    ";
            case 3: return "ImpresoraRota    ";
            case 4: return "CambioContrasena ";
            case 5: return "ErrorProduccion  ";
            default: return "Ticket-" + codigo;
        }
    }
}

package Ejercicios;

import Implementacion.ColaConPrioridad;

/**
 * EJERCICIO 7 - Embarque de Aerolíneas
 *
 * CRITERIO: Mayor número entero = Mayor prioridad
 *
 *   Movilidad reducida → prioridad 3 (embarcan primero)
 *   Business          → prioridad 2
 *   Turista (mortales) → prioridad 1 (embarcan último)
 *
 * CASO ESPECIAL - dos personas con la misma prioridad:
 *   Ejemplo: dos pasajeros Business llegan al mismo tiempo.
 *   Ambos tienen prioridad 2.
 *   Gana el que llegó primero al mostrador (FIFO dentro del empate).
 *   Esto lo garantiza nuestro indiceDeMayorPrioridad() con ">" estricto.
 */
public class EmbarqueAerolineas {

    private ColaConPrioridad cola;

    public EmbarqueAerolineas() {
        cola = new ColaConPrioridad();
        cola.InicializarCola();
    }

    public void demostrar() {
        System.out.println("\n--- 7. Embarque de Aerolíneas ---");

        System.out.println("\n  Pasajeros en la fila (orden de llegada al mostrador):");
        cola.InicializarCola();
        cola.Encolar(1, 1);  // turista
        cola.Encolar(2, 2);  // business
        cola.Encolar(3, 3);  // movilidad reducida
        cola.Encolar(4, 1);  // otro turista
        System.out.println("    Encolar(Turista_A,           prioridad=1)");
        System.out.println("    Encolar(Business_A,          prioridad=2)");
        System.out.println("    Encolar(MovilidadReducida_A,  prioridad=3)");
        System.out.println("    Encolar(Turista_B,           prioridad=1)");

        System.out.println("\n  Orden de embarque:");
        int turno = 1;
        while (!cola.ColaVacia()) {
            System.out.println("    " + turno + "° embarca: "
                    + traducirPasajero(cola.Primero())
                    + " (prioridad " + cola.PrioridadDelPrimero() + ")");
            cola.Desencolar();
            turno++;
        }

        System.out.println("\n  CASO ESPECIAL: dos pasajeros con la misma prioridad");
        cola.InicializarCola();
        cola.Encolar(1, 2);  // Business A → llegó primero
        cola.Encolar(2, 2);  // Business B → llegó después
        System.out.println("    Encolar(Business_A, prioridad=2) ← llegó primero");
        System.out.println("    Encolar(Business_B, prioridad=2) ← llegó después");
        System.out.println("  Resultado (empate → FIFO):");
        turno = 1;
        while (!cola.ColaVacia()) {
            System.out.println("    " + turno + "° embarca: Business_"
                    + (cola.Primero() == 1 ? "A" : "B")
                    + " (prioridad " + cola.PrioridadDelPrimero() + ")");
            cola.Desencolar();
            turno++;
        }
    }

    private String traducirPasajero(int codigo) {
        switch (codigo) {
            case 1: return "Turista_A          ";
            case 2: return "Business_A         ";
            case 3: return "MovilidadReducida_A";
            case 4: return "Turista_B          ";
            default: return "Pasajero-" + codigo;
        }
    }
}

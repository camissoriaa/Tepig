package Ejercicios;

import Implementacion.ColaConPrioridad;

/**
 * EJERCICIO 4 - Examen Final (Promocionados vs Regulares)
 *
 * CRITERIO: Mayor número entero = Mayor prioridad
 *
 *   Promocionados → prioridad 10 (pasan antes)
 *   Regulares     → prioridad 5  (pasan después)
 *
 * CONSIGNA: Si un regular llegó a las 8:00 AM y un promocionado
 * a las 8:30 AM, ¿quién sale primero al hacer Desencolar?
 *
 * RESPUESTA: El promocionado (p=10), aunque llegó después.
 * La Cola con Prioridad NO respeta el orden de llegada cuando
 * hay diferencia de prioridades.
 *
 * Solo si dos personas tienen la MISMA prioridad, ahí gana
 * el que llegó primero (FIFO dentro del empate).
 */
public class ExamenFinal {

    private ColaConPrioridad cola;

    public ExamenFinal() {
        cola = new ColaConPrioridad();
        cola.InicializarCola();
    }

    public void demostrar() {
        System.out.println("\n--- 4. Examen Final (Promocionados vs Regulares) ---");

        System.out.println("\n  Situación: Regular llega 8:00 AM, Promocionado llega 8:30 AM");
        cola.InicializarCola();
        cola.Encolar(1, 5);   // Regular llegó primero → prioridad 5
        cola.Encolar(2, 10);  // Promocionado llegó después → prioridad 10
        System.out.println("    Encolar(Regular,      prioridad=5)  ← llegó primero");
        System.out.println("    Encolar(Promocionado, prioridad=10) ← llegó después");

        System.out.println("\n  Al hacer Desencolar, ¿quién sale primero?");
        int turno = 1;
        while (!cola.ColaVacia()) {
            System.out.println("    " + turno + "° en rendir: "
                    + (cola.Primero() == 1 ? "Regular     " : "Promocionado")
                    + " (prioridad " + cola.PrioridadDelPrimero() + ")");
            cola.Desencolar();
            turno++;
        }

        System.out.println("\n  RESPUESTA: Sale primero el Promocionado (p=10 > p=5)");
        System.out.println("  aunque llegó 30 minutos después.");

        System.out.println("\n  Caso extra: dos regulares, distinto horario de llegada");
        cola.InicializarCola();
        cola.Encolar(1, 5); // Regular A → llegó primero
        cola.Encolar(2, 5); // Regular B → llegó después
        System.out.println("    Encolar(RegularA, prioridad=5) ← 8:00 AM");
        System.out.println("    Encolar(RegularB, prioridad=5) ← 8:15 AM");
        System.out.println("  Misma prioridad → gana el que llegó antes (FIFO):");
        turno = 1;
        while (!cola.ColaVacia()) {
            System.out.println("    " + turno + "° en rendir: Regular"
                    + (cola.Primero() == 1 ? "A" : "B")
                    + " (prioridad " + cola.PrioridadDelPrimero() + ")");
            cola.Desencolar();
            turno++;
        }
    }
}

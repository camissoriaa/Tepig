package Ejercicios;

import Implementacion.ColaConPrioridad;

/**
 * EJERCICIO 3 - Guardia del Hospital (Triage)
 *
 * CRITERIO del profesor: Mayor número entero = Mayor prioridad
 *
 * Casos definidos:
 *   Prioridad 1   = Raspón (leve)
 *   Prioridad 50  = Fractura (moderado)
 *   Prioridad 100 = Bobazo / emergencia grave (crítico)
 *
 * El pibe con raspón (p=1) espera.
 * El jubilado con bobazo (p=100) pasa primero.
 *
 * Caso especial - empate de prioridad:
 *   Si dos personas tienen la misma prioridad, gana la que llegó primero (FIFO dentro del empate).
 *   Esto lo maneja automáticamente nuestro indiceDeMayorPrioridad()
 *   porque itera de izquierda a derecha y usa ">" estricto (no ">=").
 */
public class GuardiaHospital {

    private ColaConPrioridad cola;

    public GuardiaHospital() {
        cola = new ColaConPrioridad();
        cola.InicializarCola();
    }

    public void demostrar() {
        System.out.println("\n--- 3. Guardia del Hospital (Triage) ---");

        System.out.println("\n  Caso A: Pibe con raspón vs Jubilado con bobazo");
        cola.InicializarCola();
        cola.Encolar(1, 1);    // pibe con raspón → prioridad 1
        cola.Encolar(2, 100);  // jubilado con bobazo → prioridad 100
        System.out.println("    Encolar(Pibe_raspon, prioridad=1)");
        System.out.println("    Encolar(Jubilado_bobazo, prioridad=100)");
        System.out.println("  Orden de atención:");
        int turno = 1;
        while (!cola.ColaVacia()) {
            System.out.println("    " + turno + "° atendido: "
                    + traducirPaciente(cola.Primero())
                    + " (prioridad " + cola.PrioridadDelPrimero() + ")");
            cola.Desencolar();
            turno++;
        }

        System.out.println("\n  Caso B: 3 casos distintos definidos");
        cola.InicializarCola();
        cola.Encolar(1, 1);   // raspon leve
        cola.Encolar(2, 50);  // fractura moderada
        cola.Encolar(3, 100); // paro cardíaco crítico
        System.out.println("    Encolar(Raspon,    prioridad=1)");
        System.out.println("    Encolar(Fractura,  prioridad=50)");
        System.out.println("    Encolar(ParoCard,  prioridad=100)");
        System.out.println("  Orden de atención:");
        turno = 1;
        while (!cola.ColaVacia()) {
            System.out.println("    " + turno + "° atendido: "
                    + traducirCasoB(cola.Primero())
                    + " (prioridad " + cola.PrioridadDelPrimero() + ")");
            cola.Desencolar();
            turno++;
        }

        System.out.println("\n  Caso C: Empate de prioridad (dos personas, misma prioridad)");
        cola.InicializarCola();
        cola.Encolar(1, 50); // llegó primero
        cola.Encolar(2, 50); // llegó después
        System.out.println("    Encolar(PacienteA, prioridad=50) ← llegó primero");
        System.out.println("    Encolar(PacienteB, prioridad=50) ← llegó después");
        System.out.println("  Orden de atención (empate → gana el que llegó antes):");
        turno = 1;
        while (!cola.ColaVacia()) {
            System.out.println("    " + turno + "° atendido: Paciente"
                    + (cola.Primero() == 1 ? "A" : "B")
                    + " (prioridad " + cola.PrioridadDelPrimero() + ")");
            cola.Desencolar();
            turno++;
        }
    }

    private String traducirPaciente(int codigo) {
        switch (codigo) {
            case 1: return "Pibe_raspon";
            case 2: return "Jubilado_bobazo";
            default: return "Paciente-" + codigo;
        }
    }

    private String traducirCasoB(int codigo) {
        switch (codigo) {
            case 1: return "Raspon_leve";
            case 2: return "Fractura_moderada";
            case 3: return "ParoCardiaco_critico";
            default: return "Paciente-" + codigo;
        }
    }
}

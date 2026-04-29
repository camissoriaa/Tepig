package Ejercicios;

import Implementacion.Cola;
import Implementacion.ColaConPrioridad;
import Interfaces.ColaTDA;
import Interfaces.ColaConPrioridadTDA;

/**
 * EJERCICIO 1 - Fila del Cajero
 *
 * JUSTIFICACIÓN:
 *   La fila del cajero de un banco ES una Cola común (FIFO).
 *   El primero en llegar es el primero en ser atendido.
 *   No hay privilegios ni prioridades → Cola simple.
 *
 * Si hubiera ventanilla preferencial (embarazadas, jubilados, discapacitados)
 * ahí SÍ se usaría Cola con Prioridad.
 *
 * Mostramos ambas para comparar:
 */
public class FilaDelCajero {

    private ColaTDA colaSimple;
    private ColaConPrioridad colaConPrioridad;

    public FilaDelCajero() {
        colaSimple = new Cola();
        colaSimple.InicializarCola();
        colaConPrioridad = new ColaConPrioridad();
        colaConPrioridad.InicializarCola();
    }

    public void demostrar() {
        System.out.println("\n--- 1. Fila del Cajero ---");

        System.out.println("\n  [Cola SIMPLE - sin privilegios]");
        System.out.println("  Llegan: Cliente1, Cliente2, Cliente3");
        colaSimple.Encolar(1);
        colaSimple.Encolar(2);
        colaSimple.Encolar(3);
        System.out.println("  Orden de atención:");
        int turno = 1;
        while (!colaSimple.ColaVacia()) {
            System.out.println("    " + turno + "° atendido: " + traducirCliente(colaSimple.Primero()));
            colaSimple.Desencolar();
            turno++;
        }

        System.out.println("\n  [Cola CON PRIORIDAD - ventanilla preferencial]");
        System.out.println("  Llegan: ClienteComun(p=1), Jubilado(p=5), Embarazada(p=10)");
        colaConPrioridad.Encolar(1, 1);   // cliente común
        colaConPrioridad.Encolar(2, 5);   // jubilado
        colaConPrioridad.Encolar(3, 10);  // embarazada
        System.out.println("  Orden de atención (mayor prioridad primero):");
        turno = 1;
        while (!colaConPrioridad.ColaVacia()) {
            System.out.println("    " + turno + "° atendido: "
                    + traducirClienteConPrioridad(colaConPrioridad.Primero())
                    + " (prioridad " + colaConPrioridad.PrioridadDelPrimero() + ")");
            colaConPrioridad.Desencolar();
            turno++;
        }

        System.out.println("\n  CONCLUSIÓN: La fila del cajero SIN ventanilla preferencial");
        System.out.println("  es Cola simple (FIFO). CON ventanilla → Cola con Prioridad.");
    }

    private String traducirCliente(int codigo) {
        switch (codigo) {
            case 1: return "Cliente1";
            case 2: return "Cliente2";
            case 3: return "Cliente3";
            default: return "Cliente-" + codigo;
        }
    }

    private String traducirClienteConPrioridad(int codigo) {
        switch (codigo) {
            case 1: return "ClienteComun";
            case 2: return "Jubilado";
            case 3: return "Embarazada";
            default: return "Cliente-" + codigo;
        }
    }
}

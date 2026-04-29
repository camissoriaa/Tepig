package Ejercicios;

import Implementacion.Cola;
import Interfaces.ColaTDA;

/**
 * EJERCICIO 2 - Impresora del Laboratorio
 *
 * Todos mandan el TP al mismo tiempo → Cola simple FIFO.
 * El orden de salida depende del orden en que llegaron los archivos.
 *
 * Si la impresora recibe 5 archivos, el orden de salida
 * es exactamente el orden en que fueron encolados.
 *
 * Encolar = mandar a imprimir
 * Primero = el archivo que la impresora está procesando ahora
 * Desencolar = la impresora terminó ese archivo, pasa al siguiente
 */
public class ImpresoraLaboratorio {

    private ColaTDA cola;

    public ImpresoraLaboratorio() {
        cola = new Cola();
        cola.InicializarCola();
    }

    public void demostrar() {
        System.out.println("\n--- 2. Impresora del Laboratorio ---");

        System.out.println("\n  Encolando 5 archivos (todos llegan al mismo tiempo):");
        for (int i = 1; i <= 5; i++) {
            cola.Encolar(i);
            System.out.println("    Encolar(TP_" + i + ") → archivo " + i + " en cola");
        }

        System.out.println("\n  Orden de impresión (FIFO - el primero en llegar sale primero):");
        int orden = 1;
        while (!cola.ColaVacia()) {
            System.out.println("    " + orden + "° impreso: TP_" + cola.Primero());
            cola.Desencolar();
            orden++;
        }

        System.out.println("\n  El orden de salida es exactamente el orden de llegada.");
        System.out.println("  TP_1 → TP_2 → TP_3 → TP_4 → TP_5");
    }
}

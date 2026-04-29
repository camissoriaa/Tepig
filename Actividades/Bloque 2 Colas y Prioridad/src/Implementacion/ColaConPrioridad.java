package Implementacion;

import Interfaces.ColaConPrioridadTDA;

/**
 * Cola con Prioridad implementada con dos arrays paralelos.
 *
 * CRITERIO: Mayor número entero = Mayor prioridad
 * (tal como lo define el profesor)
 *
 * Ejemplo:
 *   Prioridad 100 = bobazo en guardia → sale PRIMERO
 *   Prioridad   1 = raspón en guardia → sale DESPUÉS
 *
 * Guardamos los valores en datos[] y sus prioridades en prioridades[].
 * Siempre están "desordenados" al guardar.
 * Primero() busca el de MAYOR prioridad recorriendo el array.
 * Desencolar() elimina ese elemento de mayor prioridad.
 *
 * Diferencia con Cola simple:
 *   Cola simple → el orden de salida depende del orden de llegada (FIFO)
 *   Cola con prioridad → el orden de salida depende del número de prioridad
 */
public class ColaConPrioridad implements ColaConPrioridadTDA {

    private static final int MAX = 100;
    private int[] datos;
    private int[] prioridades;
    private int cantidad;

    @Override
    public void InicializarCola() {
        datos = new int[MAX];
        prioridades = new int[MAX];
        cantidad = 0;
    }

    @Override
    public void Encolar(int x, int prioridad) {
        if (cantidad < MAX) {
            datos[cantidad] = x;
            prioridades[cantidad] = prioridad;
            cantidad++;
        }
    }

    @Override
    public void Desencolar() {
        if (!ColaVacia()) {
            // encontramos el índice del elemento con mayor prioridad
            int indiceMayor = indiceDeMayorPrioridad();
            // lo "borramos" corriendo todos los de atrás un lugar
            for (int i = indiceMayor; i < cantidad - 1; i++) {
                datos[i] = datos[i + 1];
                prioridades[i] = prioridades[i + 1];
            }
            cantidad--;
        }
    }

    @Override
    public int Primero() {
        return datos[indiceDeMayorPrioridad()];
    }

    @Override
    public boolean ColaVacia() {
        return cantidad == 0;
    }

    /**
     * Devuelve el índice del elemento con mayor prioridad.
     * Si hay empate en prioridad, gana el que llegó primero (FIFO dentro del empate).
     */
    private int indiceDeMayorPrioridad() {
        int indiceMayor = 0;
        for (int i = 1; i < cantidad; i++) {
            if (prioridades[i] > prioridades[indiceMayor]) {
                indiceMayor = i;
            }
        }
        return indiceMayor;
    }

    /**
     * Método auxiliar para mostrar la prioridad del primero (útil en demos)
     */
    public int PrioridadDelPrimero() {
        return prioridades[indiceDeMayorPrioridad()];
    }
}

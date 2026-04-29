package Implementacion;

import Interfaces.ColaTDA;

/**
 * Cola FIFO implementada con array circular.
 *
 * El PRIMERO en entrar es el PRIMERO en salir.
 *
 * Usamos dos índices:
 *   inicio → apunta al primer elemento (el que sale primero)
 *   fin    → apunta al lugar donde entra el próximo elemento
 *
 * Ejemplo con 3 elementos encolados (A, B, C):
 *   [A, B, C, -, -, ...]
 *    ↑inicio     ↑fin
 *
 * Al desencolar A:
 *   [-, B, C, -, -, ...]
 *       ↑inicio  ↑fin
 */
public class Cola implements ColaTDA {

    private static final int MAX = 100;
    private int[] datos;
    private int inicio;
    private int fin;
    private int cantidad;

    @Override
    public void InicializarCola() {
        datos = new int[MAX];
        inicio = 0;
        fin = 0;
        cantidad = 0;
    }

    @Override
    public void Encolar(int x) {
        if (cantidad < MAX) {
            datos[fin] = x;
            fin = (fin + 1) % MAX; // array circular
            cantidad++;
        }
    }

    @Override
    public void Desencolar() {
        if (!ColaVacia()) {
            inicio = (inicio + 1) % MAX; // avanza el inicio
            cantidad--;
        }
    }

    @Override
    public int Primero() {
        return datos[inicio];
    }

    @Override
    public boolean ColaVacia() {
        return cantidad == 0;
    }
}

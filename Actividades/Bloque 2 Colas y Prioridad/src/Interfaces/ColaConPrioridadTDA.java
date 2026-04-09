package Interfaces;

public interface ColaConPrioridadTDA {
    void InicializarCola();
    void Encolar(int x, int prioridad);  // recibe el valor Y su prioridad
    void Desencolar();
    int Primero();                        // devuelve el de mayor prioridad
    boolean ColaVacia();
}

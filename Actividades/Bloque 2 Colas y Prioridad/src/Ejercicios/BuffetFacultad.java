package Ejercicios;

import Implementacion.Cola;
import Interfaces.ColaTDA;

/**
 * EJERCICIO 5 - Buffet de la Facultad
 *
 * CONSIGNA: ¿Qué operación de TDA Cola usás para asegurar
 * que no se cuele ningún "vibe coder"?
 *
 * RESPUESTA: Encolar() — porque solo permite agregar al FINAL.
 * La Cola simple (FIFO) garantiza por diseño que nadie puede
 * insertarse en el medio ni al principio.
 *
 * Si alguien intenta colarse, simplemente no existe esa operación
 * en ColaTDA. Solo hay Encolar() que va al final, y Primero()
 * que atiende desde adelante. No hay "EncolarAlFrente()" ni
 * "InsertarEnPosicion()".
 *
 * Eso es exactamente la garantía del TDA Cola.
 */
public class BuffetFacultad {

    private ColaTDA cola;

    public BuffetFacultad() {
        cola = new Cola();
        cola.InicializarCola();
    }

    public void demostrar() {
        System.out.println("\n--- 5. Buffet de la Facultad ---");

        System.out.println("\n  Llegan en orden: Estudiante1, Estudiante2, Estudiante3");
        cola.Encolar(1);
        cola.Encolar(2);
        cola.Encolar(3);
        System.out.println("    Encolar(Est1) → va al final");
        System.out.println("    Encolar(Est2) → va al final");
        System.out.println("    Encolar(Est3) → va al final");

        System.out.println("\n  Llega el 'vibe coder' que quiere colarse...");
        System.out.println("    Encolar(VibeCoder) → también va al FINAL (no puede colarse)");
        cola.Encolar(4);

        System.out.println("\n  Orden de atención en el buffet:");
        int turno = 1;
        while (!cola.ColaVacia()) {
            System.out.println("    " + turno + "° atendido: " + traducir(cola.Primero()));
            cola.Desencolar();
            turno++;
        }

        System.out.println("\n  La operación que evita colarse es: Encolar()");
        System.out.println("  Solo agrega al final. No existe insertar en el medio.");
        System.out.println("  El TDA Cola garantiza FIFO por diseño.");
    }

    private String traducir(int codigo) {
        switch (codigo) {
            case 1: return "Estudiante1";
            case 2: return "Estudiante2";
            case 3: return "Estudiante3";
            case 4: return "VibeCoder (llegó al final igual)";
            default: return "Persona-" + codigo;
        }
    }
}

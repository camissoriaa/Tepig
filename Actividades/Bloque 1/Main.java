public class Main {

    public static void main(String[] args) {

        ejercicio1_HistorialNavegacion();
        ejercicio2_Undo();
        ejercicio3_BalanceoParentesis();
        ejercicio4_RevertirString();
        ejercicio5_CallStack();
        ejercicio6_Directorios();
    }

    // ─────────────────────────────────────────────
    // EJERCICIO 1: Historial de navegación
    // ─────────────────────────────────────────────
    static void ejercicio1_HistorialNavegacion() {
        System.out.println("=== Ejercicio 1: Historial de Navegación ===");

        PilaTDA historial = new PilaArreglo();
        historial.InicializarPila();

        // Visitamos páginas (usamos enteros como ID de URL)
        // 1 = fi.uba.ar, 2 = campus.utn.edu.ar, 3 = stackoverflow.com
        historial.Apilar(1);
        historial.Apilar(2);
        historial.Apilar(3);

        System.out.println("Página actual (Tope): " + historial.Tope()); // 3

        // Usuario aprieta "Atrás"
        historial.Desapilar();
        System.out.println("Después de Atrás (Tope): " + historial.Tope()); // 2

        historial.Desapilar();
        System.out.println("Después de otro Atrás (Tope): " + historial.Tope()); // 1

        System.out.println();
    }

    // ─────────────────────────────────────────────
    // EJERCICIO 2: Undo / Deshacer
    // ─────────────────────────────────────────────
    static void ejercicio2_Undo() {
        System.out.println("=== Ejercicio 2: Undo/Deshacer ===");

        // Simulamos versiones del código como números (hash del estado)
        // version 100 → 200 → 300, el usuario borra algo por error
        PilaTDA historialCodigo = new PilaArreglo();
        historialCodigo.InicializarPila();

        historialCodigo.Apilar(100); // estado inicial
        historialCodigo.Apilar(200); // después de escribir algo
        historialCodigo.Apilar(300); // después de borrar por error

        System.out.println("Estado actual: " + historialCodigo.Tope()); // 300

        // Ctrl+Z → restaurar estado anterior
        historialCodigo.Desapilar();
        System.out.println("Después de Ctrl+Z: " + historialCodigo.Tope()); // 200

        System.out.println();
    }

    // ─────────────────────────────────────────────
    // EJERCICIO 3: Balanceo de paréntesis
    // ─────────────────────────────────────────────
    static void ejercicio3_BalanceoParentesis() {
        System.out.println("=== Ejercicio 3: Balanceo de Paréntesis ===");

        // Usamos una pila de enteros: 1 representa '('
        PilaTDA pila = new PilaArreglo();
        pila.InicializarPila();

        String expresion = "((a+b)*c)";
        boolean balanceada = true;

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (c == '(') {
                pila.Apilar(1); // apilamos marcador
            } else if (c == ')') {
                if (pila.PilaVacia()) {
                    balanceada = false;
                    break;
                }
                pila.Desapilar(); // encontramos el par
            }
        }

        if (!pila.PilaVacia()) balanceada = false;

        System.out.println("Expresión: " + expresion);
        System.out.println("¿Balanceada? " + balanceada); // true

        System.out.println();
    }

    // ─────────────────────────────────────────────
    // EJERCICIO 4: Reversión de String
    // ─────────────────────────────────────────────
    static void ejercicio4_RevertirString() {
        System.out.println("=== Ejercicio 4: Reversión de String ===");

        // Codificamos cada letra como su valor ASCII
        String palabra = "ALGORITMOS";
        PilaTDA pila = new PilaArreglo();
        pila.InicializarPila();

        // Apilamos cada letra (como int ASCII)
        for (int i = 0; i < palabra.length(); i++) {
            pila.Apilar((int) palabra.charAt(i));
        }

        // Desapilamos para obtener el string al revés
        System.out.print("Resultado invertido: ");
        while (!pila.PilaVacia()) {
            System.out.print((char) pila.Tope());
            pila.Desapilar();
        }
        System.out.println(); // SOMTIRОГLA → SOMTIROGLA

        System.out.println();
    }

    // ─────────────────────────────────────────────
    // EJERCICIO 5: Call Stack
    // ─────────────────────────────────────────────
    static void ejercicio5_CallStack() {
        System.out.println("=== Ejercicio 5: Pila de Llamadas ===");

        // 1=Main, 2=CalcularPromedio, 3=Sumar
        PilaTDA callStack = new PilaArreglo();
        callStack.InicializarPila();

        callStack.Apilar(1); // entra Main
        callStack.Apilar(2); // llama a CalcularPromedio
        callStack.Apilar(3); // llama a Sumar

        System.out.println("Tope durante ejecución de Sumar: " + callStack.Tope()); // 3

        callStack.Desapilar(); // Sumar termina
        System.out.println("Tope al volver a CalcularPromedio: " + callStack.Tope()); // 2

        callStack.Desapilar(); // CalcularPromedio termina
        System.out.println("Tope al volver a Main: " + callStack.Tope()); // 1

        System.out.println();
    }

    // ─────────────────────────────────────────────
    // EJERCICIO 6: Navegación de Directorios
    // ─────────────────────────────────────────────
    static void ejercicio6_Directorios() {
        System.out.println("=== Ejercicio 6: Navegación de Directorios ===");

        // 1=C:/, 2=Usuarios, 3=Documentos
        PilaTDA ruta = new PilaArreglo();
        ruta.InicializarPila();

        ruta.Apilar(1); // C:/
        ruta.Apilar(2); // Usuarios
        ruta.Apilar(3); // Documentos

        System.out.println("Carpeta actual (Tope): " + ruta.Tope()); // 3

        // Presionamos "Subir un nivel"
        ruta.Desapilar();
        System.out.println("Después de Subir un nivel (Tope): " + ruta.Tope()); // 2

        System.out.println();
    }
}
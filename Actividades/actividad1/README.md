# Actividad 1: "Guerra de Estrategias"

## Análisis de Estrategias de Implementación

Para el desarrollo del TDA **Pila (Stack)**, se evaluaron tres enfoques basados en arreglos:

### 1. Arreglo + Variable Externa
* **Ventajas:** Simplicidad y eficiencia máxima.
* **Desventajas:** Dependencia de una variable de control externa.
* **Complejidad:** $O(1)$

### 2. Tope en Posición 0
* **Ventajas:** Elimina la necesidad de variables externas.
* **Desventajas:** Ineficiente. Requiere desplazar todos los elementos en cada operación.
* **Complejidad:** $O(n)$

### 3. Cantidad en Posición 0
* **Ventajas:** Autocontenida y eficiente.
* **Desventajas:** Reduce la capacidad útil del arreglo (reserva el índice 0).

---

> **Conclusión:** Seleccionamos la **Estrategia 1** por su rendimiento constante de $O(1)$ y mejor aprovechamiento del espacio.

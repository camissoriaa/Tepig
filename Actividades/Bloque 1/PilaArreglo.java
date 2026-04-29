public class PilaArreglo implements PilaTDA {

    private int[] datos;
    private int cantidad; // apunta a la primera posición libre

    @Override
    public void InicializarPila() {
        datos = new int[100];
        cantidad = 0;
    }

    @Override
    public void Apilar(int x) {
        datos[cantidad] = x;
        cantidad++;
    }

    @Override
    public void Desapilar() {
        cantidad--;
    }

    @Override
    public int Tope() {
        return datos[cantidad - 1];
    }

    @Override
    public boolean PilaVacia() {
        return cantidad == 0;
    }
}
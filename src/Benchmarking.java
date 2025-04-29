public class Benchmarking {
    MetodosOrdenamiento metodosOrdenamiento = new MetodosOrdenamiento();

    public Benchmarking() {
        MetodosOrdenamiento metodosOrdenamiento = new MetodosOrdenamiento();
        int[] arreglo = generarArregloAleatorio(10000);
        Runnable tarea = () -> metodosOrdenamiento.burbujaTradicional(arreglo.clone());

        double tiempoNano = medirConNanoTime(tarea);
        double tiempoMillis = medirConCurrentTime(tarea);

        System.out.println("Tiempo medido con nanoTime: " + tiempoNano + " segundos");
        System.out.println("Tiempo medido con currentTimeMillis: " + tiempoMillis + " segundos");
    }


    // Método para generar arreglo aleatorio
    public int[] generarArregloAleatorio(int tam) {
        int[] arreglo = new int[tam];
        for (int i = 0; i < tam; i++) {
            arreglo[i] = (int)(Math.random() * 100000);
        }
        return arreglo;
    }

    // Tiempo usando nanoTime (en segundos)
    public double medirConNanoTime(Runnable tarea) {
        long inicio = System.nanoTime();
        tarea.run();
        long fin = System.nanoTime();
        return (fin - inicio) / 1_000_000_000.0;
    }

    // Tiempo usando currentTimeMillis (en segundos)
    public double medirConCurrentTime(Runnable tarea) {
        long inicio = System.currentTimeMillis();
        tarea.run();
        long fin = System.currentTimeMillis();
        return (fin - inicio) / 1000.0;
    }

    // Método main
    public static void main(String[] args) {
        new Benchmarking();
    }
}

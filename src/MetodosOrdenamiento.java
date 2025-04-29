import java.util.Arrays;

public class MetodosOrdenamiento {

    // Método de burbuja tradicional con errores
    // Error encontrado: el metodo return, devolvia un arreglo de entero vacio.
    // Solucion: Cambiar el retorno de la funcion para que se retorne el arreglo ordenado
    public int[] burbujaTradicional(int[] arregloOriginal) {
        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);

        int n = arreglo.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arreglo[i] > arreglo[j]) {
                    // Intercambio de elementos
                    int temp = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = temp;
                }
            }
        }
        return arreglo; //error arreglado
    }

    // Método de burbuja tradicional con errores
    // Error encontrado: Ningun error encontrado
    public int[] burbujaTradicionalSegundo(int[] arregloOriginal) {
        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);

        int n = arreglo.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { 
                if (arreglo[i] < arreglo[j]) {
                    // Intercambio de elementos
                    // Estas 3 lineas NO DEBEN ser modificadas
                    int temp = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = temp;
                }
            }
        }

        return arreglo;

    }

    // Método de burbuja tradicional con errores
    // Error encontrado: j<n causaba acceso al arreglo de [j+1] fuera del rango
    // Solucion: cambiar límite de j a j < n - 1.
    public int[] burbujaTradicionalTercero(int[] arregloOriginal) {

        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);

        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {//correcion del arreglo
                if (arreglo[j] > arreglo[j + 1]) {
                    // Intercambio de elementos
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
        return arreglo;
    }

    // Método de selección con errores
    // Error encontrado: Falta el return al final del metodo empleado
    // Solucion: agregar return
    public int[] seleccionPrimero(int[] arregloOriginal) {

        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);

        for (int i = 0; i < arreglo.length - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[j] < arreglo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            int smallerNumber = arreglo[indiceMinimo];
            arreglo[indiceMinimo] = arreglo[i];
            arreglo[i] = smallerNumber;
        }
        return arreglo; //error arreglado
    }

    // Método de selección con errores
    // Error encontrado: el bucle j-- hacia que sea un ciclo infinito
    // Solucion: cambiar j-- por j++
    public int[] seleccionSegundo(int[] arregloOriginal) {

        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);

        for (int i = 0; i < arreglo.length; i++) {
            int indiceMinimo = i;

            for (int j = i + 1; j < arreglo.length; j++) { //error arreglado
                if (arreglo[j] < arreglo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }

            int smallerNumber = arreglo[indiceMinimo];
            arreglo[indiceMinimo] = arreglo[i];
            arreglo[i] = smallerNumber;
        }
        return arreglo;
    }

    // Método de selección con errores
    // Error encontrado: Se asigna dos veces a arreglo[indiceMinimo] = smallerNumber;
    // Solucion: El segundo valor debe ser arreglo[i].

    public int[] seleccionTercero(int[] arregloOriginal) {

        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);

        for (int i = 0; i < arreglo.length - 1; i++) {
            int indiceMinimo = i;

            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[j] < arreglo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }

            int smallerNumber = arreglo[i];
            arreglo[indiceMinimo] = arreglo[i];
            arreglo[i] = smallerNumber; //error corregido 
        }
        return arreglo;
    }

    // Método de inserción con errores
    // Error encontrado: la condicion i > 0 no permite comparar con el 0
    // Solucion: Hacer el cambio a i>=0 y el signo < debe ser cambiado por > para el orden ascendente
    public int[] insercionPrimero(int[] arregloOriginal) {

        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);
        for (int j = 1; j < arreglo.length; j++) {
            int key = arreglo[j];
            int i = j - 1;

            while (i >= 0 && arreglo[i] > key) { //error corregido
                arreglo[i + 1] = arreglo[i];
                i--;
            }
            arreglo[i + 1] = key;
        }
        return arreglo;
    }

    // Método de inserción con errores
    // Errores encontrados:
    /*
    * 1. La variable 'j' se usaba como índice del bucle externo *y* también dentro del bucle interno.
    * 2. Se debía utilizar una variable distinta en el bucle interno ('i') para controlar
    *    la comparación y desplazamiento de elementos.
    */
    // Soluciones:
    /*
    * 1. Declarar una nueva variable 'i' para el bucle interno.
    * 2. Usar 'i' correctamente en el for interno para desplazar los elementos mayores que 'actual'.
    */
    public int[] insercionSegundo(int[] arregloOriginal) {
        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);

        for (int j = 1; j < arreglo.length; j++) {
            int actual = arreglo[j];
            int i; // error 1 corregido

            for (i = j - 1; i >= 0 && arreglo[i] > actual; i--) { // error 2 corregido
                arreglo[i + 1] = arreglo[i]; //error corregido
            }
            arreglo[i + 1] = actual; 
        }
        return arreglo; 
    }


    // Método de inserción con errores
    // Errores encontrados:
    /*
    * 1. La variable i se inicializaba como i = j.
    * 2. El incremento dentro del bucle era i++ cuando debía ser i--, ya que se recorre hacia atrás.
    * 3. El método devolvía un arreglo fijo en lugar del arreglo ordenado.
    * 4. En la condición del while, se usaba i > 0, lo cual ignora el índice 0 en ciertos casos.
    */
    // Soluciones:
    /*
    * 1. Inicializar i = j - 1.
    * 2. Cambiar el incremento a i--.
    * 3. Devolver el arreglo ordenado.
    * 4. Corregir la condición del while a i >= 0.
    */
    
    public int[] insercionTercero(int[] arregloOriginal) {
        int[] arreglo = Arrays.copyOf(arregloOriginal, arregloOriginal.length);

        for (int j = 1; j < arreglo.length; j++) {
            int key = arreglo[j];
            int i = j - 1; // error 1 corregido

            while (i >= 0 && arreglo[i] > key) { // error 4 corregido
                arreglo[i + 1] = arreglo[i];
                i--; // error 2 corregido
            }
            arreglo[i + 1] = key;
        }
        return arreglo; // error 3 corregido
    }

}

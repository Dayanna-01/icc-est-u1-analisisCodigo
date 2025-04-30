class MetodosOrdenamiento:
# Metodo Burbuja en phyton
    def sortByBubble(self, arreglo): #Self es la instancia de la clase y es obligatorio 
        arreglo = arreglo.copy()
        n = len(arreglo) 
        for i in range(n):
            for j in range(i+1, n):
                if arreglo[i] > arreglo[j]:
                    arreglo[i], arreglo[j] = arreglo[j], arreglo[i]
        return arreglo
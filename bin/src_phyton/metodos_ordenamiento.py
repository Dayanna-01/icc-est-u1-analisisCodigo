class MetodosOrdenamiento:
    def sortByBubble(self, arreglo):
        arreglo = arreglo.copy()
        n = len(arreglo)
        for i in range(n):
            for j in range(0, n - i - 1):
                if arreglo[j] > arreglo[j + 1]:
                    arreglo[j], arreglo[j + 1] = arreglo[j + 1], arreglo[j]
        return arreglo

    def sortBySeleccion(self, array):
        array = array.copy()
        n = len(array)
        for i in range(n):
            minindx = i
            for j in range(i + 1, n):
                if array[j] < array[minindx]:
                    minindx = j
            array[i], array[minindx] = array[minindx], array[i]
        return array
    
    def sortByShell(self, arreglo):
        arreglo = arreglo.copy()
        n = len(arreglo)
        gap = n // 2
        while gap > 0:
            for i in range(gap, n):
                temp = arreglo[i]
                j = i
                while j >= gap and arreglo[j - gap] > temp:
                    arreglo[j] = arreglo[j - gap]
                    j -= gap
                arreglo[j] = temp
            gap //= 2
        return arreglo
    
    
import random
import time
from metodos_ordenamiento import MetodosOrdenamiento

class Benchmarking:
    def __init__(self):
        print('Bench inicializado')
        self.mOrdenamiento = MetodosOrdenamiento()
        arreglo = self.build_arreglo(1000)

        tarea = lambda: self.mOrdenamiento.sortByBubble(arreglo)  # Crear función anónima
        tiempoMillis = self.contar_con_current_time_millis(tarea)
        tiempoNano = self.contar_con_nano_time(tarea)

        print("Tiempo en milisegundos:", tiempoMillis, "ms")
        print("Tiempo en nanosegundos:", tiempoNano, "s")

    def build_arreglo(self, size):  # Crear otro método para construir arreglo
        array = []
        for i in range(size):
            num = random.randint(0, 99999)
            array.append(num)
        return array

    def contar_con_current_time_millis(self, tarea):
        inicio = time.time()
        tarea()
        fin = time.time()
        return (fin - inicio) * 1000

    def contar_con_nano_time(self, tarea):
        inicio = time.time_ns()
        tarea()
        fin = time.time_ns()
        return (fin - inicio) / 1_000_000_000.0


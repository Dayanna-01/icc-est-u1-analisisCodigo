from benchmarking import Benchmarking
from metodos_ordenamiento import MetodosOrdenamiento
import matplotlib.pyplot as plt
from datetime import datetime  

if __name__ == "__main__":
    print("Funciona")
    # Instanciar clases
    metodos = MetodosOrdenamiento()
    benchmarking = Benchmarking()

    tamanios = [500, 1000, 2000]
    resultados = []

    metodosD = {
        "burbuja": metodos.sortByBubble,
        "seleccion": metodos.sortBySeleccion
    }

    for tam in tamanios:
        for nombre, metodo in metodosD.items():
            arreglo_base = benchmarking.build_arreglo(tam) 
            tiempo = benchmarking.medir_tiempo(metodo, arreglo_base)
            tuplaResultado = (tam, nombre, tiempo)
            resultados.append(tuplaResultado)

    for resultado in resultados:
        tam, nombre, tiempo = resultado
        print(f"tamano: {tam}, metodo: {nombre}, tiempo: {tiempo:.6f} segundos")

    tiempos_by_metodo = {
        "burbuja": [],
        "seleccion": []
    }

    # Clasificar los tiempos según los métodos
    for tam, nombre, tiempo in resultados:
        tiempos_by_metodo[nombre].append(tiempo)

    # Crear gráfica
    plt.figure(figsize=(10, 6))

    for nombre, tiempos in tiempos_by_metodo.items():
        plt.plot(tamanios, tiempos, label=nombre, marker='o')

    # Obtener fecha y hora actual
    fecha_hora_actual = datetime.now().strftime("%Y-%m-%d %H:%M:%S")

    # Parámetros de la gráfica
    plt.grid()
    plt.title(f"Benchmarking de Métodos de Ordenamiento\nDayanna Chacha\n{fecha_hora_actual}")
    plt.xlabel("Tamaño del arreglo")
    plt.ylabel("Tiempo de ejecución")
    plt.legend()

    plt.gcf().canvas.manager.set_window_title(f"Dayanna Chacha {fecha_hora_actual}")
    plt.show()

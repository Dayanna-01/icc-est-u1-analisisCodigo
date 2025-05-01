# from benchmarking import Benchmarking  # si benchmarking.py está en el mismo directorio
from benchmarking import Benchmarking
from metodos_ordenamiento import MetodosOrdenamiento

if __name__ == "__main__":
    print("Funciona")
    # Instanciar clases
    metodos = MetodosOrdenamiento()
    benchmarking = Benchmarking()

    tam = 1000
    arreglo_base = benchmarking.build_arreglo(tam)


    metodosD= {
        "burbuja": metodos.sortByBubble,
        "seleccion": metodos.sortBySeleccion
    }

    resultados = []
    for nombre, metodo in metodosD.items():
        tiempo=benchmarking.medir_tiempo(metodo, arreglo_base)
        tuplaResultado=(tam,nombre,tiempo)
        resultados.append(tuplaResultado)

    for resultado in resultados:
        tam,nombre,tiempo=resultado
        print(f"tamano: {tam}, metodo: {nombre}, tiempo: {tiempo:.6f} segundos")
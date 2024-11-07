import matplotlib.pyplot as plt

def extraccionArchivo(nombre: str):
    arr = []
    with open(nombre, "r") as file:
        for line in file:
            try:
                arr.append(float(line.strip()))
            except ValueError:
                print("Línea no válida:", line.strip())
    return arr

mergeTimes = extraccionArchivo("MergeSorttiempos.txt")
quickTimes = extraccionArchivo("QuickSorttiempos.txt")

print(mergeTimes)
print(quickTimes)

datos = [5000, 7500, 10000, 12500, 15000, 17500, 20000]

plt.figure(figsize=(5, 3))
plt.plot(datos, mergeTimes, marker="o", linestyle = '-', color ='b', label = 'MergeSort')
plt.plot(datos, quickTimes, marker='o', linestyle = '--', color ='r', label = 'QuickSort')
plt.title("Comparación entre MergeSort y QuickSort")
plt.xlabel("Cantidad de Datos")
plt.legend()
plt.ylabel("Tiempo de ejecución (segundos)")
plt.grid(True)
plt.show()
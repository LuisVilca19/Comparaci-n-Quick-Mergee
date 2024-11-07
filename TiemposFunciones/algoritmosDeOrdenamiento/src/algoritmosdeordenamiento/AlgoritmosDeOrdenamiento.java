/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmosdeordenamiento;

import java.io.*;

public class AlgoritmosDeOrdenamiento {

    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    public static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    public static void quickSort(int[] array, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int pivote = particion(array, izquierda, derecha);
            quickSort(array, izquierda, pivote - 1);
            quickSort(array, pivote + 1, derecha);
        }
    }

    public static int particion(int[] array, int izquierda, int derecha) {
        int pivote = array[derecha];
        int i = izquierda - 1;

        for (int j = izquierda; j < derecha; j++) {
            if (array[j] <= pivote) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temp;

        return i + 1;
    }

    public static int[] Archivo(String ruta, int n) {
        int[] nums = new int[n];
        String linea = "";

        try {
            FileReader lectura = new FileReader(ruta);
            BufferedReader leer = new BufferedReader(lectura);

            for (int j = 0; linea != null; j++) {
                linea = leer.readLine();
                if (linea != null) {
                    nums[j] = Integer.parseInt(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nums;
    }

    public static boolean orden(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void exportarTiempos(double[] arr, String name) {
        String ruta = name + "tiempos.txt"; //Nombre del archivo
        String contenido = "";

        for (int j = 0; j < arr.length; j++) {
            contenido = contenido + arr[j] + "\n";
        }
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write(contenido);
            System.out.println("Tiempos exportados correctamente");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void mostrarTiempos(double[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i] + " ");
        }
    }
    
    public static void main(String[] args) {
        int[] n = {5000, 7500, 10000, 12500, 15000, 17500, 20000};

        double[] tiemposQuickSort = new double[n.length];
        double[] tiemposMergeSort = new double[n.length];
        long inicio, fin, tiempo;

        for (int i = 0; i < n.length; i++) {
            String ruta = "C:\\Users\\ronal\\OneDrive\\Escritorio\\TiemposFunciones\\CreacionDeArchivo\\" + n[i] + "numerosRandom.txt";
            int[] array = Archivo(ruta, n[i]);
            int[] array2 = array;
            System.out.println("--TIEMPOS DE " + n[i] + " DATOS--");

            inicio = System.nanoTime();
            quickSort(array, 0, array.length - 1);
            fin = System.nanoTime();
            tiempo = fin - inicio;
            tiemposQuickSort[i] = tiempo / 1000000000.0;
            System.out.println("Quick: " + tiemposQuickSort[i]);
            if (orden(array)) {
                System.out.println("En orden");
            } else {
                System.out.println("No en orden");
            }

            inicio = System.nanoTime();
            mergeSort(array2);
            fin = System.nanoTime();
            tiempo = fin - inicio;
            tiemposMergeSort[i] = tiempo / 1000000000.0;
            System.out.println("Merge: " + tiemposMergeSort[i]);
            if (orden(array2)) {
                System.out.println("En orden");
            } else {
                System.out.println("No en orden");
            }
        }

        System.out.println("Tiempos de mergeSort:");
        mostrarTiempos(tiemposMergeSort);
        exportarTiempos(tiemposMergeSort, "MergeSort");
        System.out.println("");
        System.out.println("Tiempos de QuickSort:");
        mostrarTiempos(tiemposQuickSort);
        exportarTiempos(tiemposQuickSort, "QuickSort");
    }

}

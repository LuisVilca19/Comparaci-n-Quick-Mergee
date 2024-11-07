/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package creaciondearchivo;

import java.util.Random;
import java.io.*;

public class CreacionDeArchivo {

    public static void main(String[] args) throws IOException {
        Random ran = new Random();
        int[] n = {5000, 7500, 10000, 12500, 15000, 17500, 20000};
        
        for (int i = 0; i < n.length; i++) {
            String ruta = n[i] + "numerosRandom.txt"; //Nombre del archivo
            String contenido = "";
            
            for (int j = 0; j < n[i]; j++) {
                contenido = contenido + ran.nextInt(101) + "\n";
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
                bw.write(contenido);
                System.out.println("Escrito correctamente");
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }
        }
        
    }
}

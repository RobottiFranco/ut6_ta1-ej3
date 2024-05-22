/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author jechague
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear una tabla de tipo THash e insertar las claves del archivo
        // "claves_insertar.txt"
        THash hash = new THash(250);
        String[] file = ManejadorArchivosGenerico.leerArchivo("src\\claves_insertar.txt");
        int[] insertar = new int[file.length];
        int i = 0;
        for (String string : file) {
            insertar[i] = hash.insertar(Integer.parseInt(string));
            i++;
        }

        // Escribir los resultados en el archivo "promedioInsertar.txt"
        String[] resultados = new String[insertar.length + 1];
        int prom = 0;
        for (int j = 0; j <= insertar.length; j++) {
            if (j < insertar.length) {
                resultados[j] = String.valueOf(insertar[j]);
                prom += insertar[j];
            } else {
                resultados[j] = "promedio: " + String.valueOf(prom / insertar.length);
            }
        }

        ManejadorArchivosGenerico.escribirArchivo("promedioInsertar.txt", resultados);

        // Buscar en la tabla creada anteriormente las claves indicadas en el archivo
        // "claves_buscar.txt"

        file = ManejadorArchivosGenerico.leerArchivo("src\\claves_buscar.txt");
        int[] buscar = new int[file.length];
        i = 0;
        for (String string : file) {
            
            buscar[i] = hash.buscar(Integer.parseInt(string));
            i++;
        }

        // Escribir los resultados en el archivo "promedioBuscar.txt"
        resultados = new String[buscar.length + 1];
        prom = 0;
        for (int j = 0; j <= buscar.length; j++) {
            if (j < buscar.length) {
                resultados[j] = String.valueOf(buscar[j]);
                prom += buscar[j];
            } else {
                resultados[j] = "promedio: " + String.valueOf(prom / buscar.length);
            }
        }

        ManejadorArchivosGenerico.escribirArchivo("promedioBuscar.txt", resultados);

    }

}
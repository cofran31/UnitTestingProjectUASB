import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static jdk.nashorn.internal.objects.NativeString.trim;

public class Analyzer {
    /*
     * Implement this method in Part 1
     */
    public static List<Sentence> readFile(String filename) {
        // Lista vacia del tipo sentence
        List<Sentence> sentences = new ArrayList<>();
        // iniciamos excepcion para abrir el archivo .txt
        try (BufferedReader archiveTxt = new BufferedReader(new FileReader(filename))) {
            String lineaActual;
            // recorremos linea por linea del archivo .txt
            while ((lineaActual = archiveTxt.readLine()) != null) {
                // obtengo la primera cadena antes del espacio
                String[] score = lineaActual.split(" ");
                // obtengo el texto restante
                String texto = " ";
                // se valida que el escore sea mayor o igual a -2 o menor o igual a 2
                if (Integer.valueOf(score[0]) >= -2 || Integer.valueOf(score[0]) <= 2) {
                    // recorremos la variable score y lo almacenamos en la variable texto
                    for (int i = 1; i < score.length; i++) {
                        texto = texto + " " + score[i];
                    }
                    // creamos un objeto del tipo sentence y agregamos el score y texto
                    Sentence sentence = new Sentence(Integer.valueOf(score[0]), trim(texto));
                    // añadimos a la lista
                    sentences.add(sentence);
                } else {
                    return sentences;
                }
            }
            // devolvemos una lista del tipo sentence
            return sentences;
        } catch (IOException e) {
            e.printStackTrace();
        }
        // si hay error al abrir el txt devolvemos una lista vacia
        return sentences;
    }
    /*
     * Implement this method in Part 2
     */
    public static Set<Word> allWords(List<Sentence> sentences) {

        return null;

    }


    /*
     * Implement this method in Part 3
     */
    public static Map<String, Double> calculateScores(Set<Word> words) {

        return null;

    }
}

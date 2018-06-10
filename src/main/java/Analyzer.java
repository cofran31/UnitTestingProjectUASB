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
                if (Integer.valueOf(score[0]) >= -2 && Integer.valueOf(score[0]) <= 2) {
                    // recorremos la variable score y lo almacenamos en la variable texto
                    for (int i = 1; i < score.length; i++) {
                        texto = texto + " " + score[i];
                    }
                    // creamos un objeto del tipo sentence y agregamos el score y texto
                    Sentence sentence = new Sentence(Integer.valueOf(score[0]), trim(texto));
                    // añadimos a la lista
                    sentences.add(sentence);
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
        try {
            // creamos un map
            Set<Word> words = new HashSet<>();
            // array para agregar objetos de palabras para poder comprobar la cantidad de palabras repetidas
            ArrayList<Word> newWords = new ArrayList<>();
            // recorremos la lista sentences
            for (Sentence sentence : sentences) {
                // obtengo la cadena antes del espacio en blanco
                String[] tokens = sentence.getText().split(" ");
                for (String token : tokens) {
                    // Verificamos para evitar los caracteres especiales
                    if (token.matches("[A-Za-z]+")) {
                        // convertimos a minusculas si la cadena usaria mayusculas
                        token = token.toLowerCase();
                        // se crea un objeto del tipo word
                        Word word = new Word(token);
                        // utilizamos el metodo increaseTotal de la clase Word para contar la palabra
                        word.increaseTotal(sentence.getScore());
                        // hacemos el seguimiento del numero de apariciones y su puntuacion de todas oraciones en la que aparece la palabra
                         if (newWords.contains(word)) {
                            int indexOfWord = newWords.indexOf(word);
                            newWords.get(indexOfWord).increaseTotal(word.getTotal());
                        } else {
                            newWords.add(word);
                        }
                    }
                }
            }
            // Se copia todos los objetos de palabras en conjunto
            for (Word word : newWords) {
                words.add(word);
            }
            return words;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /*
     * Implement this method in Part 3
     */
    public static Map<String, Double> calculateScores(Set<Word> words) {
        // Creamos un map
        Map<String, Double> wordScores = new HashMap<>();
        try {
            // Recorremos las sentencias words
            for (Word word : words) {
                // Añadimos un elemento clave valor al mapa
                wordScores.put(word.getText(), word.calculateScore());
            }
            // Devolvemos un map con clave (que tomara el promedio) y el valor (la palabra).
            return wordScores;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Devolvemos un map vacio.
        return wordScores;
    }
}

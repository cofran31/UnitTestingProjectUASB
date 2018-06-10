import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Analyzer {
    /*
     * Implement this method in Part 1
     */
    public static List<Sentence> readFile(String filename) {
        try (BufferedReader archiveTxt = new BufferedReader(new FileReader(filename))) {
            String lineaActual;
            List<Sentence> sentences = new ArrayList<>();
            while ((lineaActual = archiveTxt.readLine()) != null) {
                String[] score = lineaActual.split(" ");
                String texto = " ";
                for (int i = 1; i < score.length; i++) {
                    texto = texto + " " + score[i];
                }
                Sentence sentence = new Sentence(Integer.valueOf(score[0]), texto);
                sentences.add(sentence);
            }
            return sentences;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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

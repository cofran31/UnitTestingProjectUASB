import org.junit.Test;

import static jdk.nashorn.internal.objects.NativeString.trim;
import static org.junit.Assert.*;

import java.util.*;
import java.util.stream.IntStream;

public class AnalyzerTest {

    /* TEST METODO READFILE */

    // Test que verifica la existencia del archivo donde se encuentran las oraciones de sentimiento. Ej: leer.txt existe en el directorio
    @Test
    public void readFileTestReadTxt(){
        String archivoTxt = "leer.txt";
        List<Sentence> salida = Analyzer.readFile(archivoTxt);
        assertNotNull("Verifico que el archivo exista", salida);
    }
    // Test que verifica que en caso de no existir el archivo envia una lista vacia. Ej: leer1.txt no existe en el directorio
    @Test
    public void readFileTestListaVacia(){
        String archivoTxt = "leer1.txt";
        List<Sentence> salida = Analyzer.readFile(archivoTxt);
        List<Sentence> sentences = new ArrayList<>();
        assertEquals("Verificamos que el archivo no pueda abrirse y compare su respuesta con una lista vacia", sentences, salida);
    }
    // Test que verifica la cantidad de filas que tiene el archivo de texto Ej: leer.txt con 5 filas
    @Test
    public void readFileTestCantidadFilasIngresadasTxt(){
      String archivoTxt = "leer.txt";
      List<Sentence> salida = Analyzer.readFile(archivoTxt);
      assertEquals("Verificamos el numero de filas que contiene el archivo de texto", 5, salida.size());
    }
    // Test  que verifica el campo Score Ej: "1 a bilingual charmer , just like the woman who inspired it" salida = 1
    @Test
    public void readFileTestVerificaListaTxtScore(){
        String archivoTxt = "leer.txt";
        List<Sentence> salida = Analyzer.readFile(archivoTxt);
        assertEquals("Verificamos el campo Score, introducioendo el numero de la linea del archivo txt", 1, salida.get(0).getScore());
    }
    // Test que verifica el campo Text Ej: "1 a bilingual charmer , just like the woman who inspired it" text = "a bilingual charmer , just like the woman who inspired it"
    @Test
    public void readFileTestVerificaListaTxtText(){
        String archivoTxt = "leer.txt";
        List<Sentence> salida = Analyzer.readFile(archivoTxt);
        String text = "a bilingual charmer , just like the woman who inspired it";
        assertEquals("Verificamos campo Texto, introducioendo el texto de la linea del archivo txt", text, salida.get(0).getText());
    }

    /* TEST METODO ALLWORDS */

    // Test que verifica comparar el metodo allWords cuando no tenga contenido devuelva un mapa vacio.
    @Test
    public void allWordsTestMapaVacio(){
        List<Sentence> salida = Analyzer.readFile("");
        Set<Word> words = Analyzer.allWords(salida);
        Set<Word> mapVacio = new HashSet<>();
        assertEquals("Verificamos que el archivo no pueda abrirse y compare su respuesta con una lista vacia", mapVacio, words);
    }
    // Test que verifica el numero total de palabras encontradas Ej: leer.txt contiene 36 palabras validas
    @Test
    public void allWordsTestSize(){
        String archivoTxt = "leer.txt";
        List<Sentence> salida = Analyzer.readFile(archivoTxt);
        Set<Word> words = Analyzer.allWords(salida);
        assertEquals("Obtenemos el numero total de palabras encontradas", 36, words.size());
    }
    // Test que verifica el numero de apariciones de una palabra en el archivo de texto Ej: it aparece 2 veces
    @Test
    public void allWordsTestNumeroApariciones(){
        String archivoTxt = "leer.txt";
        List<Sentence> salida = Analyzer.readFile(archivoTxt);
        Set<Word> words = Analyzer.allWords(salida);
        String objeto_word = "it";
        Integer numero_apariciones = 0;
        for (Word word : words){
             if (objeto_word.equals(word.getText()))
                 numero_apariciones = word.getCount();
        }
        assertEquals("Se calcula el numero de apariciones de la palabra objeto_word en todas las oraciones", 2,  Integer.parseInt(String.valueOf(numero_apariciones)));
    }
    // Test que verifica la puntuacion acumulativa total de la palabra en las oraciones Ej: objeto_word = "it"  calculo => (fila 0) 1 + (fila 3) 0 = 1
    @Test
    public void allWordsTestAcumulativo(){
        String archivoTxt = "leer.txt";
        List<Sentence> salida = Analyzer.readFile(archivoTxt);
        Set<Word> words = Analyzer.allWords(salida);
        String objeto_word = "it";
        Integer acumulativo = 0;
        for (Word word : words){
            if (objeto_word.equals(word.getText()))
                acumulativo = word.getTotal();
        }
        assertEquals("Se calcula la puntuacion acumulativa total de todas las oraciones en las que aparece la palabra objeto_word", 1,  Integer.parseInt(String.valueOf(acumulativo)));
    }

    /* TEST METODO CALCULATESCORES  */


    // Test que verifica comparar el metodo calculateScores cuando no tenga contenido devuelva un mapa vacio.
    @Test
    public void calculateScoresTestMapaVacio(){
        List<Sentence> salida = Analyzer.readFile("");
        Set<Word> words = Analyzer.allWords(salida);
        Map<String, Double> wordScores = Analyzer.calculateScores(words);
        Map<String, Double> mapVacio = new HashMap<>();
        assertEquals("Verificamos que el archivo no pueda abrirse y compare su respuesta con una lista vacia", mapVacio, wordScores);
    }
    /* Test que verifica el puntaje de sentimiento promedio para una palabra
    Ej. del archivo leer.txt se tienen las siguientes lineas de ejemplo:
     1 a bilingual charmer , just like the woman who inspired it
     0 Like a less dizzily gorgeous companion to Mr. Wong 's In
     -1 As inept as big-screen remakes of The Avengers and The Wild Wild West .
     0 It 's everything you 'd expect -- but nothing more .
     2 Best indie of the year , so far .
     Observamos que para la palabra "the" => [(fila 0) 1 + (fila 2) -1 + (fila 2) -1 + (fila 4) 2 ] / 4 = 1/4 = 0.25
    */
    @Test
    public void  calculateScoresTestAcumulativo(){
        String archivoTxt = "leer.txt";
        List<Sentence> salida = Analyzer.readFile(archivoTxt);
        Set<Word> words = Analyzer.allWords(salida);
        String objeto_word = "the";
        Double valor = 0.0;
        Double comparable = 0.25;
        Map<String, Double> wordScores = Analyzer.calculateScores(words);
        for (Map.Entry<String, Double> entry : wordScores.entrySet()){
            if (objeto_word.equals(entry.getKey()))
                valor = entry.getValue();
        }
        assertEquals("Se calcula el sentimiento promedio de una palabra", comparable,  valor);
    }
}

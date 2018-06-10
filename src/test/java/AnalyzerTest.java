import org.junit.Test;

import static jdk.nashorn.internal.objects.NativeString.trim;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class AnalyzerTest {

    /* TEST METODO READFILE */

    @Test
    public void readFileTestReadTxt(){
        String archivoTxt = "leer.txt";
        List<Sentence> salida = Analyzer.readFile(archivoTxt);
        assertNotNull("Verifico que el archivo exista", salida);
    }
    @Test
    public void readFileTestListaVacia(){
        String archivoTxt = "leer1.txt";
        List<Sentence> salida = Analyzer.readFile(archivoTxt);
        List<Sentence> sentences = new ArrayList<>();
        assertEquals("Verificamos que el archivo no pueda abrirse y compare su respuesta con una lista vacia", sentences, salida);
    }
    @Test
    public void readFileTestCantidadFilasIngresadasTxt(){
      String archivoTxt = "leer.txt";
      List<Sentence> salida = Analyzer.readFile(archivoTxt);
      assertEquals("Verificamos la separacion del score y texto comparandolos que sean iguales con la sentencia de prueba", 4, salida.size());
    }
    @Test
    public void readFileTestVerificaListaTxtScore(){
        String archivoTxt = "leer.txt";
        List<Sentence> salida = Analyzer.readFile(archivoTxt);
        assertEquals("Verificamos campo Score, introducioendo el numero de la linea del archivo txt", 0, salida.get(0).getScore());
    }
    @Test
    public void readFileTestVerificaListaTxtText(){
        String archivoTxt = "leer.txt";
        List<Sentence> salida = Analyzer.readFile(archivoTxt);
        assertEquals("Verificamos campo Texto, introducioendo el texto de la linea del archivo txt", "This was not as much fun as I thought it would be .", salida.get(0).getText());
    }

    /* TEST METODO ALLWORDS */

    @Test
    public void allWordsTestSize(){
        String archivoTxt = "leer.txt";
        List<Sentence> salida = Analyzer.readFile(archivoTxt);
        Set<Word> words = Analyzer.allWords(salida);
        assertEquals("Obtenemos el numero total de palabras encontradas", 36, words.size());
    }
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
}

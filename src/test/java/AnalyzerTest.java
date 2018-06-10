import org.junit.Test;

import static jdk.nashorn.internal.objects.NativeString.trim;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AnalyzerTest {
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


    @Test
    public void allWordsTestSize(){
        String archivoTxt = "leer.txt";
        List<Sentence> salida = Analyzer.readFile(archivoTxt);
        Set<Word> words = Analyzer.allWords(salida);
        assertEquals("Obtenemos el tamaño de palabras encontradas", 36, words.size());
    }
    @Test
    public void allWordsTest(){
        String archivoTxt = "leer.txt";
        List<Sentence> salida = Analyzer.readFile(archivoTxt);
        Set<Word> words = Analyzer.allWords(salida);
        assertNotNull("Verifico que exista el objeto words", words);
    }
}

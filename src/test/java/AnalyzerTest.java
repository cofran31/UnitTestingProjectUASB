import org.junit.Test;
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
    public void readFileTestCantidadFilasIngresadasTxt(){
      String archivoTxt = "leer.txt";
      List<Sentence> salida = Analyzer.readFile(archivoTxt);
      assertEquals("Verificamos la separacion del score y texto comparandolos que sean iguales con la sentencia de prueba", 4, salida.size());
    }
    @Test
    public void readFileTestVerifyListScoreText(){
        String archivoTxt = "leer.txt";
        List<Sentence> salida = Analyzer.readFile(archivoTxt);
        assertEquals("Verificamos la separacion del score y texto comparandolos que sean iguales con la sentencia de prueba", 4, salida.size());
    }

}

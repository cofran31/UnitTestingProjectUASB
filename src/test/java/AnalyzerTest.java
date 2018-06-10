import org.junit.Test;
import static org.junit.Assert.*;
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
    public void readFileTestVerifyListScoreText(){
      String archivoTxt = "leer.txt";
      List<Sentence> salida = Analyzer.readFile(archivoTxt);
        assertEquals("Verificamos que se lea el archivo", "0 This was not as much fun as I thought it would be .", salida);
    }

}

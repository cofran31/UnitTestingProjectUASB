import java.util.ArrayList;

public class Persist {

    public static int persistence(long n) {

        int repeticiones = 0;

        while(n > 9){
            int multiplicacion = 1;
            while(n != 0){
                long digitos = n % 10;
                multiplicacion *= digitos;
                n = (n - digitos)/10;
            }

            repeticiones++;
            n = multiplicacion;
        }
        return repeticiones;


    }
    public String getUID(){
        return "ABC123";
    }
}

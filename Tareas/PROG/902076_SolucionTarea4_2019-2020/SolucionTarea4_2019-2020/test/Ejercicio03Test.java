
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemErrRule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
/**
 *
 * @author Salvador Romero
 */
public class Ejercicio03Test extends ClaseBasePruebas {
    @Rule 
    public final TextFromStandardInputStream inputMock = emptyStandardInputStream();
    @Rule
    public final SystemErrRule systemErrRule = new SystemErrRule().mute().enableLog();
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().mute().enableLog();
    
    private static final String CLASS_NAME="tarea4.Ejercicio03";
        
    @Test(timeout = 2000)
    public void prueba02a() //Con errores
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"a","b", "c", "99", "fin"}, 
                "[D(99->99)]","/3/");
    }    
    
    private static final String[][] casosValidos={
            {"0","fin"},
            {"0","FIN"},
            {"9","end"},
            {"9","END"},
            {"9","End"},
            {"9","fIn"},
            {"99","End"},
            {"11","fIn"},
            {"00","fin"},
            {"011","fin"},
            {"012","fin"},
            {"052","fin"},
            {"0x12","fin"},
            {"0x88","fin"},
            {"0x9A","fin"},
            {"0xFF","fin"},
            {"0xABCDEF","fin"},
            {"0xabcdef","fin"},
            {"0xA","0xB","fin"},
            {"99","100","fin"},            
            {"010","011","fin"},
            {"0xA","10","fin"},
            {"99","011","fin"},
            {"0xA","011","fin"},
            {"0xA","011","10","fin"}
            
        };
    
    private static final String[] salidaEsperadaValida = {"[D(0->0)]",
         "[D(0->0)]",
         "[D(9->9)]",
         "[D(9->9)]",
         "[D(9->9)]",
         "[D(9->9)]",
         "[D(99->99)]",
         "[D(11->11)]",
         "[O(00->0)]",
         "[O(011->9)]",
         "[O(012->10)]",
         "[O(052->42)]",
         "[H(0x12->18)]",
         "[H(0x88->136)]",
         "[H(0x9a->154)]",
         "[H(0xff->255)]",
         "[H(0xabcdef->11259375)]",
         "[H(0xabcdef->11259375)]",
         "[H(0xa->10)H(0xb->11)]",
         "[D(99->99)D(100->100)]",
         "[O(010->8)O(011->9)]",
         "[H(0xa->10)D(10->10)]",
         "[D(99->99)O(011->9)]",
         "[H(0xa->10)O(011->9)]",
         "[H(0xa->10)O(011->9)D(10->10)]"};

    
    @Test(timeout = 2000)
    public void prueba01a() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[0], salidaEsperadaValida[0],"/0/");
    }
   
    @Test(timeout = 2000)
    public void prueba01c() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[1], salidaEsperadaValida[1],"/0/");
    }
    
    @Test(timeout = 2000)
    public void prueba01e() //SIN ERRÓNEOS
    {    
        comprobarSiContiene(CLASS_NAME, casosValidos[2], salidaEsperadaValida[2],"/0/");
    }
    
    
    @Test(timeout = 2000)
    public void prueba01g() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[3], salidaEsperadaValida[3],"/0/");
    }
    
    @Test(timeout = 2000)
    public void prueba01i() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[4], salidaEsperadaValida[4],"/0/");
    }
    
    @Test(timeout = 2000)
    public void prueba01k() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[5], salidaEsperadaValida[5],"/0/");
    }
    
    
    @Test(timeout = 2000)
    public void prueba01n() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[6], salidaEsperadaValida[6],"/0/");
    }
    
    
    @Test(timeout = 2000)
    public void prueba01p() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[7], salidaEsperadaValida[7],"/0/");
    }
    
    
    @Test(timeout = 2000)
    public void prueba01r() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[8], salidaEsperadaValida[8],"/0/");
    }
    
    @Test(timeout = 2000)
    public void prueba01t() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[9], salidaEsperadaValida[9],"/0/");
    }
    
    
    @Test(timeout = 2000)
    public void prueba01v() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[10], salidaEsperadaValida[10],"/0/");
    }
    
    
    @Test(timeout = 2000)
    public void prueba01x() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[11], salidaEsperadaValida[11],"/0/");
    }
    
    @Test(timeout = 2000)
    public void prueba01z() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[12], salidaEsperadaValida[12],"/0/");
    }
    
    
    @Test(timeout = 2000)
    public void prueba01ab() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[13], salidaEsperadaValida[13],"/0/");
    }
    
    
    @Test(timeout = 2000)
    public void prueba01ad() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[14], salidaEsperadaValida[14],"/0/");
    }
    
    
    @Test(timeout = 2000)
    public void prueba01af() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[15], salidaEsperadaValida[15],"/0/");
    }
    
    
    @Test(timeout = 2000)
    public void prueba01ah() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[16], salidaEsperadaValida[16],"/0/");
    }
    
    @Test(timeout = 2000)
    public void prueba01aj() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[17], salidaEsperadaValida[17],"/0/");
    }
    
    @Test(timeout = 2000)
    public void prueba01am() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[18], salidaEsperadaValida[18],"/0/");
    }
    
    @Test(timeout = 2000)
    public void prueba01ao() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[19], salidaEsperadaValida[19],"/0/");
    }
    
    @Test(timeout = 2000)
    public void prueba01aq() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[20], salidaEsperadaValida[20],"/0/");
    }
    
    @Test(timeout = 2000)
    public void prueba01as() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[21], salidaEsperadaValida[21],"/0/");
    }
    
    @Test(timeout = 2000)
    public void prueba01av() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[22], salidaEsperadaValida[22],"/0/");
    }
    
    @Test(timeout = 2000)
    public void prueba01ax() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[23], salidaEsperadaValida[23],"/0/");
    }
    
    @Test(timeout = 2000)
    public void prueba01az() //SIN ERRÓNEOS
    {
        comprobarSiContiene(CLASS_NAME, casosValidos[24], salidaEsperadaValida[24],"/0/");
    }
    
    
    @Override
    public TextFromStandardInputStream getInputMock() {
        return inputMock;
    }

    @Override
    public SystemErrRule getSystemErrRule() {
        return systemErrRule;
    }

    @Override
    public SystemOutRule getSystemOutRule() {
        return systemOutRule;
    }
    
    
   

}

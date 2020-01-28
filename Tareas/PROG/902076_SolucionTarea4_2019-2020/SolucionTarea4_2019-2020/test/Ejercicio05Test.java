
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
public class Ejercicio05Test extends ClaseBasePruebas {
    @Rule 
    public final TextFromStandardInputStream inputMock = emptyStandardInputStream();
    @Rule
    public final SystemErrRule systemErrRule = new SystemErrRule().mute().enableLog();
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().mute().enableLog();
    
    private static final String CLASS_NAME="tarea4.Ejercicio05";
              
    @Test(timeout = 2000) //Cadenas no válidas
    public void prueba01a() 
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"hola que tal"}, 
                "ERROR");
    }                 
    
    @Test(timeout = 2000) //Cadenas no válidas
    public void prueba01b() 
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"hola que tal*"}, 
                "ERROR");
    }                 
    
    @Test(timeout = 2000) //Cadenas no válidas
    public void prueba01c() 
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"*hola que tal"}, 
                "ERROR");
    }                 
    
    @Test(timeout = 2000) //Cadenas válidas
    public void prueba02a() 
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"*hola que tal*"}, 
                "hqt","oua","lel");
    }                 
    
    @Test(timeout = 2000) //Cadenas válidas
    public void prueba02b() 
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"*hasta luego mariposa*"}, 
                "hlm","aua","ser","tgi","aop");
    }                 
    
    @Test(timeout = 2000) //Cadenas válidas
    public void prueba02c() 
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"*abcdefg 1234567 abcdefg 1234567*"}, 
                "a1a1","b2b2","c3c3","d4d4","e5e5","f6f6","g7g7");
    }                 
    
    @Test(timeout = 2000) //Cadenas válidas
    public void prueba02d() 
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"*a e i o u a e i o u*"}, 
                "aeiouaeiou");
    }                 

    @Test(timeout = 2000) //Cadenas válidas
    public void prueba02e() 
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"*zq xw ce vr bt ny mu asdf fghj*"}, 
                "zxcvbnmaf","qwertyusg");
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

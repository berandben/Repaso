import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemErrRule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
import tarea4.Ejercicio01;

/**
 *
 * @author Salvador Romero
 */
public class Ejercicio01Test extends ClaseBasePruebas {
    @Rule 
    public final TextFromStandardInputStream inputMock = emptyStandardInputStream();
    @Rule
    public final SystemErrRule systemErrRule = new SystemErrRule().mute().enableLog();
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().mute().enableLog();
        
    @Test(timeout = 2000)
    public void prueba0a()
    {
        String entrada="abcd";
        inputMock.provideLines(entrada);
        String salidaEsperada="|a|ab|abc|abcd";
        
        Ejercicio01.main(new String[]{});
                
        assertFalse(
                String.format("Error: al introducir \"%s\" aparece \"%s\" por pantalla (la barra inicial no debería estar).",entrada,salidaEsperada),
                systemOutRule.getLogWithNormalizedLineSeparator().trim().endsWith(salidaEsperada));
        assertTrue(
                String.format("Error: al introducir \"%s\" se produce salida por System.err y no se esperaba.",entrada),
                systemOutRule.getLogWithNormalizedLineSeparator().length()>0);
        
    }
    
    @Test(timeout = 2000)
    public void prueba0b()
    {
        String entrada="abcd";
        inputMock.provideLines(entrada);
        String salidaEsperada="a|ab|abc|abcd|";
        
        Ejercicio01.main(new String[]{});
        
        assertFalse(
                String.format("Error: al introducir \"%s\" aparece \"%s\" por pantalla (la barra final no debería estar).",entrada,salidaEsperada),
                systemOutRule.getLogWithNormalizedLineSeparator().trim().endsWith(salidaEsperada));
        assertTrue(
                String.format("Error: al introducir \"%s\" se produce salida por System.err y no se esperaba.",entrada),
                systemOutRule.getLogWithNormalizedLineSeparator().length()>0);
        
    }
    
    @Test(timeout = 2000)
    public void prueba1a()
    {
        String entrada="abcd";
        inputMock.provideLines(entrada);
        String salidaEsperada="a|ab|abc|abcd";
        
        Ejercicio01.main(new String[]{});
        
        assertTrue(
                String.format("Error: al introducir \"%s\" no aparece \"%s\" por pantalla.",entrada,salidaEsperada),
                systemOutRule.getLogWithNormalizedLineSeparator().trim().endsWith(salidaEsperada));
        assertTrue(
                String.format("Error: al introducir \"%s\" se produce salida por System.err y no se esperaba.",entrada),
                systemOutRule.getLogWithNormalizedLineSeparator().length()>0);
        
    }
    
    @Test(timeout = 2000)
    public void prueba1b()
    {
        String entrada="abcdef";
        inputMock.provideLines(entrada);
        String salidaEsperada="a|ab|abc|abcd|abcde|abcdef";
        
        Ejercicio01.main(new String[]{});
        
        assertTrue(
                String.format("Error: al introducir \"%s\" no aparece \"%s\" por pantalla.",entrada,salidaEsperada),
                systemOutRule.getLogWithNormalizedLineSeparator().trim().endsWith(salidaEsperada));
        assertTrue(
                String.format("Error: al introducir \"%s\" se produce salida por System.err y no se esperaba.",entrada),
                systemOutRule.getLogWithNormalizedLineSeparator().length()>0);
        
    }
    
    @Test(timeout = 2000)
    public void prueba2()
    {
        String[] entrada=new String[]{"a","abcd"};
        inputMock.provideLines(entrada);
        String salidaEsperada="a|ab|abc|abcd";
        
        Ejercicio01.main(new String[]{});
        
        String salidaGenerada=systemOutRule.getLogWithNormalizedLineSeparator();
        assertTrue(
                String.format("Error: al introducir primero \"%s\" y luego \"%s\" no aparece \"%s\" por pantalla.",entrada[0],entrada[1],salidaEsperada),
                salidaGenerada.trim().endsWith(salidaEsperada));
        assertTrue(
                String.format("Error: al introducir \"%s\" se produce salida por System.err y no se esperaba.",entrada[0]),
                systemOutRule.getLogWithNormalizedLineSeparator().length()>0);
        
    }
    
    @Test(timeout = 2000)
    public void prueba3()
    {
        Pattern p=Pattern.compile("cadena no v[áa]lida");
        String[] entrada=new String[]{"a","asdf"};
        inputMock.provideLines(entrada);
                
        Ejercicio01.main(new String[]{});
        
        String salidaGenerada=systemOutRule.getLogWithNormalizedLineSeparator();
        Matcher m=p.matcher(salidaGenerada.toLowerCase());
        
        assertTrue(
                String.format("Error: al introducir \"%s\" no se muestra un texto como \"Cadena no válida.\\nIntroduce una cadena mayor de 4 caracteres:\"",entrada[0]),
                m.find());
        assertTrue(
                String.format("Error: al introducir \"%s\" se produce salida por System.err y no se esperaba.",entrada[0]),
                systemOutRule.getLogWithNormalizedLineSeparator().length()>0);
        
    }
    
    @Test(timeout = 2000)
    public void prueba4a()
    {
        comprobarSiContiene("tarea4.Ejercicio01", new String[] {"abcd"} , "a|ab|abc|abcd");
    }
    
    @Test(timeout = 2000)
    public void prueba4b()
    { 
        comprobarSiContiene("tarea4.Ejercicio01", new String[] {"12345"} , "1|12|123|1234|12345");
    }
    
    @Test(timeout = 2000)
    public void prueba4c()
    {
        comprobarSiNoContiene("tarea4.Ejercicio01", new String[] {"abcd"} , "a|ab|abc|abcd|");
    }
    
    @Test(timeout = 2000)
    public void prueba4d()
    {
        comprobarSiNoContiene("tarea4.Ejercicio01", new String[] {"12345"} , "1|12|123|1234|12345|");
    }
    
    @Test(timeout = 2000)
    public void prueba4e()
    {
        comprobarSiNoContiene("tarea4.Ejercicio01", new String[] {"abcd"} , "aa|ab|abc|abcd");
    }
    
    @Test(timeout = 2000)
    public void prueba4f()
    {
        comprobarSiNoContiene("tarea4.Ejercicio01", new String[] {"12345"} , "11|12|123|1234|12345");
    }
    
    @Test(timeout = 2000)
    public void prueba4g()
    {
        comprobarSiNoContiene("tarea4.Ejercicio01", new String[] {"abcd"} , "|a|ab|abc|abcd");
    }
    
    @Test(timeout = 2000)
    public void prueba4h()
    {
        comprobarSiNoContiene("tarea4.Ejercicio01", new String[] {"12345"} , "|1|12|123|1234|12345");        
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

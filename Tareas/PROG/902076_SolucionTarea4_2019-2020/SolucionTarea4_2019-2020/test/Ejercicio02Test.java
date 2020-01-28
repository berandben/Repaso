import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.junit.Assert.*;

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
public class Ejercicio02Test extends ClaseBasePruebas {
    @Rule 
    public final TextFromStandardInputStream inputMock = emptyStandardInputStream();
    @Rule
    public final SystemErrRule systemErrRule = new SystemErrRule().mute().enableLog();
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().mute().enableLog();
    
    private static final String className="tarea4.Ejercicio02";
    
    
    @Test(timeout = 2000)
    public void prueba02a() //Comprobar números fuera de rango y carácteres no permitidos
    {
        comprobarSiContiene(className, new String[] {"08"} , "FIN DE LA EJECUCIÓN: NO ES UN NÚMERO OCTAL VÁLIDO");                   
    }
    
    @Test(timeout = 2000)
    public void prueba02b() //Comprobar números fuera de rango y carácteres no permitidos    
    {
        comprobarSiContiene(className, new String[] {"8"} , "FIN DE LA EJECUCIÓN: NO ES UN NÚMERO OCTAL VÁLIDO");                
    }
    
    @Test(timeout = 2000)
    public void prueba02c() //Comprobar números fuera de rango y carácteres no permitidos    
    {    
        comprobarSiContiene(className, new String[] {"9"} , "FIN DE LA EJECUCIÓN: NO ES UN NÚMERO OCTAL VÁLIDO");                   
     }
    
    @Test(timeout = 2000)
    public void prueba02d() //Comprobar números fuera de rango y carácteres no permitidos    
    {
        comprobarSiContiene(className, new String[] {"a"} , "FIN DE LA EJECUCIÓN: NO ES UN NÚMERO OCTAL VÁLIDO");                
    }
    
    @Test(timeout = 2000)
    public void prueba02e() //Comprobar números fuera de rango y carácteres no permitidos    
    {
        comprobarSiContiene(className, new String[] {"A"} , "FIN DE LA EJECUCIÓN: NO ES UN NÚMERO OCTAL VÁLIDO");                
}
    
    @Test(timeout = 2000)
    public void prueba02f() //Comprobar números fuera de rango y carácteres no permitidos    
    {
        comprobarSiContiene(className, new String[] {"-"} , "FIN DE LA EJECUCIÓN: NO ES UN NÚMERO OCTAL VÁLIDO");                
}
    
    @Test(timeout = 2000)
    public void prueba02g() //Comprobar números fuera de rango y carácteres no permitidos    
    {
        comprobarSiContiene(className, new String[] {"2536459"} , "FIN DE LA EJECUCIÓN: NO ES UN NÚMERO OCTAL VÁLIDO");                
}    
    @Test(timeout = 2000)
    public void prueba02h() //Comprobar números fuera de rango y carácteres no permitidos    
    {
        comprobarSiContiene(className, new String[] {"0536458"} , "FIN DE LA EJECUCIÓN: NO ES UN NÚMERO OCTAL VÁLIDO");                
    }
    
    @Test(timeout = 2000)
    public void prueba03a() //Comprobar número a número
    {
        comprobarSiContiene(className, new String[] {"0"} , "/000/");  
    }
    
    @Test(timeout = 2000)
    public void prueba03b() //Comprobar número a número
    {        
        comprobarSiContiene(className, new String[] {"1"} , "/001/");                
    }
    
    @Test(timeout = 2000)
    public void prueba03c() //Comprobar número a número
    {
        comprobarSiContiene(className, new String[] {"2"} , "/010/");                
    }
    
    @Test(timeout = 2000)
    public void prueba03d() //Comprobar número a número
    {
        comprobarSiContiene(className, new String[] {"3"} , "/011/");                
    }
    
    @Test(timeout = 2000)
    public void prueba03e() //Comprobar número a número
    {
        comprobarSiContiene(className, new String[] {"4"} , "/100/");                
    }
    
    @Test(timeout = 2000)
    public void prueba03f() //Comprobar número a número
    {
        comprobarSiContiene(className, new String[] {"5"} , "/101/");                
    }
    
    @Test(timeout = 2000)
    public void prueba03g() //Comprobar número a número
    {
        comprobarSiContiene(className, new String[] {"6"} , "/110/");                
    }
    
    @Test(timeout = 2000)
    public void prueba03h() //Comprobar número a número
    {
        comprobarSiContiene(className, new String[] {"7"} , "/111/");                
    }
    
    @Test(timeout = 2000)
    public void prueba04a() //Comprobar varios números octales juntos
    {
        comprobarSiContiene(className, new String[] {"012"} , "/000001010/");                
    }
    
    @Test(timeout = 2000)
    public void prueba04b() //Comprobar varios números octales juntos
    {
        comprobarSiContiene(className, new String[] {"234"} , "/010011100/");                
    }
    
    @Test(timeout = 2000)
    public void prueba04c() //Comprobar varios números octales juntos
    {
        comprobarSiContiene(className, new String[] {"56712340"} , "/101110111001010011100000/");                            
    }
    
    @Test(timeout = 2000)
    public void prueba05c() //cadena vacía
    {
        comprobarSiContiene(className, new String[] {""} , "FIN DE");                            
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


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
public class Ejercicio04Test extends ClaseBasePruebas {
    @Rule 
    public final TextFromStandardInputStream inputMock = emptyStandardInputStream();
    @Rule
    public final SystemErrRule systemErrRule = new SystemErrRule().mute().enableLog();
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().mute().enableLog();
    
    private static final String CLASS_NAME="tarea4.Ejercicio04";
              
    @Test(timeout = 2000)
    public void prueba01a() //Fecha anterior al rango
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"8","2019", "3", "12"}, 
                "2019-03-12 2019-10-01 2019-11-01 2019-12-01 2020-01-01 2020-02-01 2020-03-01 2020-04-01");
    }        
    
    @Test(timeout = 2000)
    public void prueba01b() //Fecha posterior al rango
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"9","2020", "6", "12"}, 
                "2019-09-01 2019-10-01 2019-11-01 2019-12-01 2020-01-01 2020-02-01 2020-03-01 2020-04-01 2020-06-12");
    }        
    @Test(timeout = 2000)
    public void prueba01c() //Fecha en el rango
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"6","2019", "9", "10"}, 
                "2019-09-10 2019-10-01 2019-11-01 2019-12-01 2020-01-01 2020-02-01");
    }        
    @Test(timeout = 2000)
    public void prueba01d() //Fecha en el rango
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"6","2019", "10", "10"}, 
                "2019-09-01 2019-10-10 2019-11-01 2019-12-01 2020-01-01 2020-02-01");
    }       
    @Test(timeout = 2000)    
    public void prueba01e() //Fecha en el rango
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"6","2019", "11", "10"}, 
                "2019-09-01 2019-10-01 2019-11-10 2019-12-01 2020-01-01 2020-02-01");
    }        
    @Test(timeout = 2000)    
    public void prueba01f() //Fecha en el rango
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"6","2019", "12", "10"}, 
                "2019-09-01 2019-10-01 2019-11-01 2019-12-10 2020-01-01 2020-02-01");
    }        
    @Test(timeout = 2000)    
    public void prueba01g() //Fecha en el rango
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"6","2020", "1", "10"}, 
                "2019-09-01 2019-10-01 2019-11-01 2019-12-01 2020-01-10 2020-02-01");
    }        
    @Test(timeout = 2000)    
    public void prueba01h() //Fecha posterior al rango
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"6","2020", "2", "10"}, 
                "2019-09-01 2019-10-01 2019-11-01 2019-12-01 2020-01-01 2020-02-10");
    }        
    @Test(timeout = 2000)
    public void prueba01i() //Fecha posterior al rango
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"6","2020", "3", "10"}, 
                "2019-09-01 2019-10-01 2019-11-01 2019-12-01 2020-01-01 2020-03-10");
    }        
    
    @Test(timeout = 2000)    
    public void prueba01j() //Fecha posterior al rango
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"6","2020", "4", "10"}, 
                "2019-09-01 2019-10-01 2019-11-01 2019-12-01 2020-01-01 2020-04-10");
    }        
    
    @Test(timeout = 2000)    
    public void prueba02a() //número de fechas erróneo
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"4","5","2020", "4", "10"}, 
                "ERROR","2019-09-01 2019-10-01 2019-11-01 2019-12-01 2020-04-10");
    }        
    
    @Test(timeout = 2000)    
    public void prueba02b() //número de fechas erróneo
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"a","5","2020", "4", "10"}, 
                "ERROR","2019-09-01 2019-10-01 2019-11-01 2019-12-01 2020-04-10");
    }            
    
    @Test(timeout = 2000)    
    public void prueba02c() //fecha errónea
    {
        comprobarSiContiene(CLASS_NAME, new String[]{"5","2020", "2", "30","2020","4","10"}, 
                "ERROR","2019-09-01 2019-10-01 2019-11-01 2019-12-01 2020-04-10");
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

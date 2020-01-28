
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.contrib.java.lang.system.SystemErrRule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Salvador Romero
 */
public abstract class ClaseBasePruebas {

    public abstract TextFromStandardInputStream getInputMock();

    public abstract SystemErrRule getSystemErrRule();

    public abstract SystemOutRule getSystemOutRule();
    
     /**
     * Método que comprueba si la ejecución de un método main de la clase "className" 
     * si produce una salida concreta.
     * @param className
     * @param input
     * @param expectedOutputs 
     */
    public void comprobarSiContiene(String className, String[] input, String ... expectedOutputs) 
    {
        TextFromStandardInputStream inputMock=getInputMock();
        SystemOutRule systemOutRule=getSystemOutRule();
        SystemErrRule systemErrRule=getSystemErrRule();
        
        inputMock.provideLines(input);
       
        try {
            Class classToTest=Class.forName(className);
            
            Method m=classToTest.getMethod("main", String[].class);
            
            m.invoke(null,new Object[] { new String[]{} } );            
        
            String output=systemOutRule.getLogWithNormalizedLineSeparator().trim();
            String inputToStr=Stream.of(input).collect(Collectors.joining(", "));
            for (String expectedOutput:expectedOutputs)
            {
                assertTrue(
                    String.format("Error: al introducir \"%s\" no aparece \"%s\" por pantalla. En su lugar, aparece lo siguiente: \n%s",inputToStr,expectedOutput,output),
                    output.contains(expectedOutput));
            }
            
            assertFalse(
                String.format("Error: al introducir \"%s\" se produce salida por System.err y no se esperaba.",inputToStr),
                    systemErrRule.getLogWithNormalizedLineSeparator().length()>0);
        }
        catch (ClassNotFoundException e) {
        
            assertTrue("No se encuentra la clase "+className, false);
        } catch (NoSuchMethodException ex) {
            assertTrue("No se encuentra el método main en la clase "+className, false);
        } catch (InvocationTargetException | IllegalArgumentException | IllegalAccessException | SecurityException ex) {
            assertTrue("No se puede ejecutar el método main en la clase "+className+".\n"+ex.getMessage(), false);
            
        } 
    }
    
    /**
     * Método que comprueba si la ejecución de un método main de la clase "className" 
     * no produce una salida concreta.
     * @param className
     * @param input
     * @param unexpectedOutputs 
     */
    public void comprobarSiNoContiene (String className, String[] input, String ... unexpectedOutputs) 
    {
        TextFromStandardInputStream inputMock=getInputMock();
        SystemOutRule systemOutRule=getSystemOutRule();
        SystemErrRule systemErrRule=getSystemErrRule();
        
        inputMock.provideLines(input);
       
        try {
            Class classToTest=Class.forName(className);
            
            Method m=classToTest.getMethod("main", String[].class);
            
            m.invoke(null,new Object[] { new String[]{} } );            
        
            String output=systemOutRule.getLogWithNormalizedLineSeparator().trim();
            String inputToStr=Stream.of(input).collect(Collectors.joining(", "));
            for (String unexpectedOutput:unexpectedOutputs)
            {
                assertFalse(
                    String.format("Error: al introducir \"%s\" aparece \"%s\" por pantalla, y esa salida no es correcta.",inputToStr,unexpectedOutput),
                    output.contains(unexpectedOutput));
            }
            
            assertFalse(
                String.format("Error: al introducir \"%s\" se produce salida por System.err y no se esperaba.",inputToStr),
                    systemErrRule.getLogWithNormalizedLineSeparator().length()>0);
        }
        catch (ClassNotFoundException e) {
        
            assertTrue("No se encuentra la clase "+className, false);
        } catch (NoSuchMethodException ex) {
            assertTrue("No se encuentra el método main en la clase "+className, false);
        } catch (InvocationTargetException | IllegalArgumentException | IllegalAccessException | SecurityException ex) {
            assertTrue("No se puede ejecutar el método main en la clase "+className+".\n"+ex.getMessage(), false);
            
        } 
    }
}

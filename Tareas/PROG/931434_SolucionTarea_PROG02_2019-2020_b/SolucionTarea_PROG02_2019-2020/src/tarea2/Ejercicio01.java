package tarea2;

/**
 * Ejercicio 1. 
 * 
 * En este programa se pide al usuario que escoja N fichas 
 * de tipo A o B. Paulatinamente se le va pidiendo que retire N+2 fichas, una a una.
 * El tipo de ficha a retirar será aleatoria, ofreciendose 3 opciones: 
 * 
 * - retirar una ficha tipo A
 * - retirar una ficha tipo B
 * - retirar una ficha de cualquier tipo
 * 
 * La última opción es la que menos probabilidad tiene (1 de cada 10 veces).
 * 
 * Nota: si el usuario se queda sin fichas al final del juego (o antes), 
 * entonces el participante termina y ha ganado. Si el usuario tiene fichas 
 * al final del juego entonces continúa jugando otra ronda.
 * 
 * @author Profesor
 */
public class Ejercicio01 {
    public static void main (String[] m)
    {        
        
        int a=5;        
        String pasos;        
        int fichas=(int)Math.round(Math.random()*4+4);       
        int i=0;
        
        pasos="PASO "+i+": Coge "+ fichas + " fichas tipo A o B.";
        
        while (i<fichas+2)
        {
            float numeroReal=(float)Math.random();
            numeroReal=numeroReal*10+10;
            int numeroEntero=Math.round(numeroReal);            
            i++;
            pasos+="\n";
            pasos+="PASO "+i+": Quita ";
            if (numeroEntero<a)
            {
                pasos+="una ficha tipo A.";
            }
            else if (numeroEntero>a)
            {
                pasos+="una ficha tipo B.";
            }
            else 
            {
                String p=".";
                pasos+="cualquier ficha"+p;
            }                        
        }              
        
        pasos+="\n";
        
        System.out.println(pasos);
        
    }
}
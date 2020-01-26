package tarea2;

/**
 * Ejercicio 6. Números.
 * 
 * Se elige un número al azar entre 4 y 9 y muestran dichos números en escalera:
 * 0
 * 01
 * 012
 * 0123
 * 01234
 * ...
 * 
 * Pero en vez de mostrarlos línea a línea, se muestran separados por una 
 * barra horizontal y sustituyendo el 0 por un *.
 * 
 * *|*1|*12|*123|*1234|...
 * 
 * Este ejercicio se realiza concatenando caracter a caracter en una cadena
 * final.
 * 
 * @author Profesor
 */
public class Ejercicio06 {
    public static void main(String[] args) {
        int numero= 4 + (int)(Math.random()*(10-4)); 
        //int numero= 1;
        
        System.out.println("El número aleatorio es "+numero);
        
        String cad="";
        
        // Recorremos con i desde 1 hasta numero+1       
        for (int i=1;i<=numero+1;i++)
        {
            // Recorremos con j desde 0 hasta i-1
            int j=0;
            while (j<i)
            {
                // Si j es cero en lugar del número j(0) se concatena "*"
                if (j==0)
                {
                    cad=cad+"*";
                }
                else // En cualquier otro caso se concatena el número j
                {
                    cad=cad+j;
                }
                j++;                                
            }
            // Una vez recorrido hasta i, si no estamos en numero+1 (final)
            // concatenamos finalmente la barra de sepación "|".
            // De este modo en el último caso (numero+1) no se termina con "|"
            if (i<=numero)
            {
                cad+="|";
            }
        }
        
        // Mostramos por pantalla el resultado final
        System.out.println("El resultado es: "+ cad);      


    
    

    
    
}
    
    
}

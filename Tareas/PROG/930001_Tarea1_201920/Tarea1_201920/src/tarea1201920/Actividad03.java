package tarea1201920;

/**
 * Dada la variable entera x, cuyo valor inicial es 8, haz un programa en el 
 * que se vaya modificando el valor de la variable x de manera que dicha 
 * variable tome la siguiente secuencia de valores: 1, 3, 2, 12, 24, 29.
 * La variable x deberá modificarse haciendo una operación aritmética sobre el
 * valor que ya posee, por ejemplo:
 *    int x=10;
 *    x=x+100; //La variable x toma el valor 110 (10 + 100)
 * Para hacer el ejercicio debes usar al menos una vez los operadores
 * aritméticos de suma, resta, división y multiplicación. No olvides mostrar el
 * valor de la variable x después de cada modificación.
 * 
 * @author JJBH
 */
public class Actividad03 {
    
    public static void main(String[] args) {
        
        int x = 8 ;
        System.out.println("x = "+x); 
        x = x / 8 ;
        System.out.println("Dividimos x entre 8 = "+x);
      
        x = x * 3 ;
        System.out.println("Multiplicamos por 3 y queda  x = "+x);       
        
        x = x - 1 ;
        System.out.println("Restamos 1 y queda  x = "+x);
               
        
        x = x +10 ;
        System.out.println("Sumamos 10 y queda  x = "+x);
        
        x = x * 2 ;
        System.out.println("Multiplicamos por 2 y queda  x = "+x);
        
        x = x + 5 ;
        System.out.println("Sumamos 5 y queda  x = "+x);
        
    }
}
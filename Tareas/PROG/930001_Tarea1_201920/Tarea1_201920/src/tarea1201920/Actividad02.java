package tarea1201920;

/**
 * Realizar las operaciones con las variables, escribiendo el resultado
 * de modo que apareca como se muestra a continuación.
 * El valor de x es 14, y es 8
 * La división entera (x/y) da: 1
 * El resultado de x + y es 22
 * El resto de la división entera (x%y) da: 6
 * El resultado de x - y es 6
 * 
 * @author JJBH
 */
public class Actividad02 {
    
    public static void main(String[] args) {
        // Declarar dos variables de tipo short con valores 14 y 8
        short x = 14 ;
        short y = 8 ;
        
        // Realizar las operaciones con las variables, escribiendo el resultado
        // de modo que apareca como se muestra a continuación.
        // Te puede ser de mucha utilidad revisar el apartado 12.1. de la unidad.
        
        System.out.println("El valor de x es " + x + ", y es " + y);
        System.out.println("La división entera (x/y) da: " + (x / y));
        System.out.println("El resultado de x + y es " + (x + y));
        System.out.println("El resto de la división entera (x%y) da: " + (x % y));
        System.out.println("El resultado de x - y es " + (x - y));
        
    } // fin de main
} // fin de la clase Actividad02

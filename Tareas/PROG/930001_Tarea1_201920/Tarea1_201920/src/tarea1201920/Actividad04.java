
package tarea1201920;

/**
 * Dada una variable entera h cuyo valor inicial es 5, y otra variable entera p
 * cuyo valor inicial es 7, haz que se muestre la secuencia de resultados:
 * false, true, false, true, false (5 en total) usando un operador de relación 
 * diferente en cada caso.
 * 
 * @author JJBH
 */
public class Actividad04 {
    
    public static void main(String[] args) {
                
        int h = 5 ;
        int p = 7 ;
        boolean condicion  ;
        
        System.out.println("Valores iniciales: h = "+h+" p = "+p);
        condicion = h==p ;
        System.out.println(h+" es igual que "+p+": es "+condicion);
        condicion = h > p ;
        System.out.println(h+" es mayor que "+p+": es "+condicion);
        condicion = h <= p ;
        System.out.println(h+" es menor o igual que "+p+": es "+condicion);
        condicion = h >= p ;
        System.out.println(h+" es mayor o igual que "+p+": es "+condicion);
        condicion = h!=p ;
        System.out.println(h+" es distinto a "+p+": es "+condicion);
        
      
    }
}

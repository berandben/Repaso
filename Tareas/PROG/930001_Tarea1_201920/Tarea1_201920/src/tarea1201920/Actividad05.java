package tarea1201920;

/**
 * Dadas las variables siguientes:
 *   char z = 'A', t = 'B';
 *   int x = 4, y = 2 ;
 * 
 * Crea una expresión lógica, que utilice operadores lógicos y relacionales,
 * para cada uno de los siguientes casos (intenta evaluar mentalmente el
 * resultado de la expresión antes de mostrarlo por pantalla):
 * 
 * @author JJBH
 */
public class Actividad05 {
    public static void main(String[] args) {
        
        char t = 'A', z = 'B';
        int x = 4, y = 2 ;
        
        System.out.println("Valores iniciales:");
        System.out.println("t = "+t);
        System.out.println("z = "+z);
        System.out.println("x = "+x);
        System.out.println("y = "+y);
    
        // x es mayor que y
        boolean r = x>y ;
        System.out.println("x es mayor que y: " + r);
        
        // x es mayor que y y z no es igual a t
        boolean b = x>y && z!=t ; //false (x no es mayor que y)
        System.out.println("x es mayor que y y z no es igual a t: " + b);
        
        // 'F' es distinto de z y x es menor que 100
        b = 'F'!=z && x<100 ; //true (ambas condiciones son true)
        System.out.println("'F' es distinto de z y x es menor que 100: "+b);
        
        // t es posterior alfabeticamente a z         
        b = t>z ; //false (la 'B' es posterior a la 'A')
        System.out.println("t es posterior alfabeticamente a z: "+b); 
    }
     
    
}

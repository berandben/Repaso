package tarea1201920;

/**
 * Dada la variable x tipo double inicializada a 3 y la variable y, también 
 * tipo double inicializada a 7, realiza las siguientes operaciones aritméticas
 * y muestra el resultado por pantalla (muestra también el valor inicial de
 * ambas variables tras inicializarlas).
 * 
 * @author JJBH
 */
public class Actividad07 {
    
    public static void main(String[] args) {
        
        double x = 3, y = 7 ;
        double calc;
        
        System.out.println("De partida, x e y valen respectivamente: " + x + " y " + y);
        
        // Sumar 2 a x y calcular el triple de ese resultado obtenido.
        calc = (x+2)*3 ;
        System.out.println("Sumar 2 a x y calcular el triple de ese resultado "
                + "nos da como resultado: "+calc);
        
                
        // Dividimos la y por 7, y el resultado lo multiplicamos por 4. Al nuevo resultado le sumamos
		// el resultado de multiplicar x por 2.
        calc = y/7*4 + 2*x ;  // Si quieres, por claridad, en ocasiones puedes usar paréntesis:  (y/7)*4 + 2*x ;
        System.out.println("Dividimos la y por 7 y a eso le multiplicamos por 4. "
                + "Y ahora a ese resultado le sumamos el resultado de multiplicar la x por 2, "
                + "lo que da como resultado: " + calc);
        
        // Sumar 5 a x y lo que da, multiplicarlo por el resultado de dividir y entre 14.
        calc = (x+5) * (y/14) ;
        
        System.out.println("Sumar 5 a x y multiplicar por el resultado de dividir la y por 14 nos da: " + calc);

       
    }
}

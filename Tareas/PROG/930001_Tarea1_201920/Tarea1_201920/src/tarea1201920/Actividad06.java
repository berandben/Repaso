package tarea1201920;

/**
 * Para generar un n�mero entre un n�mero que deseemos y otro, podemos usar: 
 *     num_minimo + Math.random(num_maximo-num_minimo), por ejemplo, 5 + Math.random()*(20 - 5) 
 *     para generar n�meros aleatorios entre 5 y 20, sin incluir al 20.
 * Usa esto para generar un n�mero entre -7 y 5 y as�, empleando exclusivamente el
 * operador condicional, junto con operadores de relaci�n, l�gicos y de
 * asignaci�n, escribe un c�digo en Java que muestre por pantalla si el n�mero
 * aleatorio generado est� entre los rangos siguientes:
 * 
 *  d est� entre -5 y 0, 0 no incluido.
 *  d est� entre 0 y 2, ambos incluidos.
 *  d est� entre 2 y 4, 2 no incluido.
 * 
 * 
 * @author JJBH
 */
public class Actividad06 {
    public static void main(String[] args) {
         //d contendr� un n�mero aleatorio entre -7 y 5.
         double numeroAleatorio = -7 + Math.random()*(5 - (-7)) ;
         // Mostramos el n�mero aleatorio
         System.out.println("Valor inicial asignado aleatoriamente a d: "+numeroAleatorio);
         String cad;
         // Comprobamos si d est� entre -7 y 0, 0 no incluido.         
         cad=(numeroAleatorio<0)? (numeroAleatorio+" s� est� entre -7 y 0."):(numeroAleatorio+" no est� entre -7 y 0.");
         System.out.println(cad);
         // Comprobamos si d est� entre 0 y 4, ambos incluidos.         
         cad=(numeroAleatorio>=0 && numeroAleatorio<=4)? (numeroAleatorio+" s� est� entre 0 y 4.") : (numeroAleatorio +" no est� entre 0 y 4.");
         System.out.println(cad);
         // Comprobamos si d est� entre 4 y 5, ambos no incluidos.         
         cad=(numeroAleatorio>4 && numeroAleatorio<=5)? (numeroAleatorio+" s� est� entre 4 y 5."): (numeroAleatorio+" no est� entre 4 y 5.");
         System.out.println(cad);
         
    }
    
}

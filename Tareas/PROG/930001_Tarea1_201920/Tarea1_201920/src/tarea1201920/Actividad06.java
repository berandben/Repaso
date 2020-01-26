package tarea1201920;

/**
 * Para generar un número entre un número que deseemos y otro, podemos usar: 
 *     num_minimo + Math.random(num_maximo-num_minimo), por ejemplo, 5 + Math.random()*(20 - 5) 
 *     para generar números aleatorios entre 5 y 20, sin incluir al 20.
 * Usa esto para generar un número entre -7 y 5 y así, empleando exclusivamente el
 * operador condicional, junto con operadores de relación, lógicos y de
 * asignación, escribe un código en Java que muestre por pantalla si el número
 * aleatorio generado está entre los rangos siguientes:
 * 
 *  d está entre -5 y 0, 0 no incluido.
 *  d está entre 0 y 2, ambos incluidos.
 *  d está entre 2 y 4, 2 no incluido.
 * 
 * 
 * @author JJBH
 */
public class Actividad06 {
    public static void main(String[] args) {
         //d contendrá un número aleatorio entre -7 y 5.
         double numeroAleatorio = -7 + Math.random()*(5 - (-7)) ;
         // Mostramos el número aleatorio
         System.out.println("Valor inicial asignado aleatoriamente a d: "+numeroAleatorio);
         String cad;
         // Comprobamos si d está entre -7 y 0, 0 no incluido.         
         cad=(numeroAleatorio<0)? (numeroAleatorio+" sí está entre -7 y 0."):(numeroAleatorio+" no está entre -7 y 0.");
         System.out.println(cad);
         // Comprobamos si d está entre 0 y 4, ambos incluidos.         
         cad=(numeroAleatorio>=0 && numeroAleatorio<=4)? (numeroAleatorio+" sí está entre 0 y 4.") : (numeroAleatorio +" no está entre 0 y 4.");
         System.out.println(cad);
         // Comprobamos si d está entre 4 y 5, ambos no incluidos.         
         cad=(numeroAleatorio>4 && numeroAleatorio<=5)? (numeroAleatorio+" sí está entre 4 y 5."): (numeroAleatorio+" no está entre 4 y 5.");
         System.out.println(cad);
         
    }
    
}

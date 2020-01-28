
package tarea4;

import java.util.Scanner;

/**
 * Ejercicio 3. Octales, hexadecimales y enteros.
 * 
 * A diferencia del ejercicio 2, en este ejercicio sí debes usar expresiones
 * regulares, y convertir los String que contiene un número a entero, usando
 * el método "valueOf()" de la clase Integer.
 * 
 * Se trata de un programa que leerá números octales, hexadecimales y decimales 
 * enteros por teclado, hasta introducir "fin" o "end" por teclado. 
 * 
 * En todos los lenguajes de programación, los números octales se representan
 * con un 0 delante. Como sabrás de la tarea anterior, los números octales
 * son números compuestos por 8 dígitos (0,1,2,3,4,5,6 y 7). 
 * 
 * Por tanto, si el número tiene un cero delante: "0123" entenderemos que es "octal".
 * 
 * Pero ten cuidado, un número como el siguiente: "01239" sería erróneo; dado
 * que el dígito 9 no debería estar en un octal.
 * 
 * Por otro lado, los número hexadecimales, son números que usan 16 dígitos 
 * para representarse: 0,1,2,3,4,5,6,7,8,9,A,B,C,D,E y F. Las letras serían
 * dígitos numéricos en este caso, y pueden estar tanto en mayúsculas como
 * en minúsculas. Si delante del número octal encontramos "0X" o "0x", 
 * enteremos que es un número hexadecimal.
 * 
 * La siguiente tabla resume lo anterior:
 * 
 *  - 0123 --> número octal porque comienza por 0
 *  - 0x123 --> número hexadecimal porque comienza por 0x
 *  - 0X123 --> número hexadecimal
 *  - 123 --> número decimal
 * 
 * Tu misión ahora será crear un programa que vaya leyendo números por teclado,
 * para ello, puedes debes seguir lo siguientes pasos:
 *
 * - Crea un StringBuilder donde se irán añadiendo los resultados generados. Los
 * resultados se mostrarán al final de todo. 
 * 
 * - Lee un texto por teclado usando la clase Scanner. 
 * 
 * - Limpia el texto leído por teclado eliminando los espacios
 * anteriores y posteriores, y después, conviértelo todo a minúsculas. 
 * 
 * - Comprueba con una expresión regular si el número es de tipo hexadecimal, y si
 * lo es, convierte dicho número a decimal. Añade al StringBuilder una cadena
 * como la siguiente: "H(0x93->147)"; donde aparecerá tanto el texto leído por
 * teclado ("0x93" en este caso), como su equivalente en decimal (147 en este
 * caso). 
 * 
 * - Si no es de tipo hexadecimal, puede ser de tipo octal. Comprueba
 * ahora con una expresión regular si es de tipo octal. Si lo es, realiza la
 * conversión de octal a entero y añade al StringBuilder un cadena como la
 * siguiente: "O(021->17)"; donde aparecerá tanto el número octal en forma de
 * texto ("021" en este caso), como el número entero resultante de la conversión
 * (17 en este caso). 
 * 
 * - Si no es de tipo hexadecimal, ni octal, puede ser de
 * tipo decimal. Intenta convertir el texto leído a número entero. Si la
 * conversión tiene éxito, añade un texto como el siguiente al StringBuilder:
 * "D(99->99)"; donde el primer "99" sería el texto leído por teclado y el
 * segundo "99" es el resultado numérico de la conversión. 
 * 
 * - Se seguirán leyendo números hasta que el usuario teclee "fin" o "end" 
 * (en minúsculas o en mayúsculas). El programa solo deberá terminar en esa 
 * circunstancia. 
 * 
 * - Si se introduce un texto no esperado, se mostrará el mensaje de error "ERROR:
 * número no válido." y se volverá a pedir otro número.
 * 
 * - Solo después de teclear "fin" o "end" , se mostrará el contenido del
 * StringBuilder, junto con el número de veces que se ha introducido un texto 
 * no esperado. Fíjate en el ejemplo de ejecución siguiente, porque la salida
 * por pantalla debe ser exactamente igual (corchetes [ .. ] y barras
 * inclinadas "/ .. /" incluidas).
 * 
 * @author Profesor
 */
public class Ejercicio03 {
    public static void main(String[] args) {
        Scanner scannerEntrada=new Scanner(System.in);        
        String lectura;
        int leidos=0;
        int entradasTotales=0;
        StringBuilder salida=new StringBuilder();
        do {            
            if (leidos==0) System.out.print("Introduce un número octal, hexadecimal o decimal (fin o end para terminar): ");
            else System.out.print("Introduce el siguiente número octal, hexadecimal o decimal (fin o end para terminar): ");

            lectura=scannerEntrada.nextLine().trim().toLowerCase();
            try {
                int numeroConvertido;
                if (lectura.matches("0[0-7]+")) { //Número octal
                    numeroConvertido = Integer.valueOf(lectura.substring(1), 8); //Pasa a número entero en base 8 (OCTAL) la subcadena que comienza a partir de la posición 1, para no coger el primer carácter '0' que indica que es octal
                    leidos++;
                    salida.append("O");
                } else if (lectura.matches("0[xX][0-9A-Fa-f]+")) { //Número hexadecimal
                    numeroConvertido = Integer.valueOf(lectura.substring(2), 16); //Pasa a número entero en base 16 (HEXADECIMAL) la subcadena que comienza a partir de la posición 2, para no coger los dos primeros caracteres '0x' o '0X' que indica que es hexadecimal
                    leidos++;
                    salida.append("H");
                } else { //En cualquier caso, hay que intentar convertirlo a entero.
                    numeroConvertido = Integer.valueOf(lectura);
                    leidos++;
                    salida.append("D"); 
                }
                salida.append(String.format("(%s->%d)",lectura,numeroConvertido));
            } catch (NumberFormatException e) {
                if (!lectura.matches("f[iíÍ]n|end"))                  
                    System.out.println("ERROR: número no válido.");
            }
            entradasTotales++;
        } while (!lectura.matches("f[iíÍ]n|end")); 
 
                
        System.out.printf("[%s]\n",salida);   
        System.out.printf("Erróneos: /%d/\n",(entradasTotales-leidos-1));
    }
    
           
}

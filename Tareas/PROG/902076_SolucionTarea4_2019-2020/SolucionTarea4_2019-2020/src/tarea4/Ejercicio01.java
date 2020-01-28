package tarea4;

import java.util.Scanner;

/**
 * Ejercicio 1. Cadena creciente.
 * 
 * En una primera parte del ejercicio, el usuario introducirá por teclado una cadena mayor de
 * 4 caracteres. 
 * 
 * Si el usuario introduce una cadena con menos de 4 caracteres, se mostrará
 * un mensaje de "Cadena no válida" y se volverá a pedir que se introduzca
 * la cadena.
 * 
 * Después, en una segunda parte del ejercicio, claramente diferenciada de la
 * primera parte, se muestra el resultado de ir concatenando segmentos crecientes
 * de la cadena. Si el usuario introdujo "abcd" se mostrará por pantalla 
 * "a|ab|abc|abcd". Para hacer esta segunda parte, debes usar obligatoriamente
 * un StringBuilder para componer el resultado final.
 * 
 * @author Profesor
 */
public class Ejercicio01 {
    public static void main(String[] args) {
        Scanner scannerEntrada=new Scanner(System.in);
        String cadena;
        System.out.print("Introduce una cadena de 4 o más caracteres: ");
        do {
            cadena=scannerEntrada.nextLine();            
            if (cadena.length()<4)
                System.out.print("Cadena no válida.\nIntroduce una cadena de 4  o más caracteres: ");
        } while (cadena.length()<4);
             
        StringBuilder cadenaFinal=new StringBuilder();
        
        for (int i=0;i<=cadena.length();i++)
        {
           cadenaFinal.append(cadena.substring(0,i));
            if (i>0 && i<cadena.length())
            {
               cadenaFinal.append("|");
            }
        }
        System.out.println(cadenaFinal);
    }
}

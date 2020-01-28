package tarea4;

import java.util.Scanner;

/**
 * Ejercicio 2. De octal a binario.
 * 
 * En la primera parte de este ejercicio se lee una cadena por pantalla 
 * y se comprueba, sin usar expresiones regulares ni convirtiendo el String a número,
 * si dicho String contiene un número octal válido. Para ello, se ha 
 * de verificar, carácter a carácter del String leído por teclado,
 * si cada uno es un dígito numérico de 0 a 7.
 * 
 * Si algún carácter de la cadena no es un dígito numérico entre 0 y 7, debe 
 * terminar el programa con el mensaje "FIN DE LA EJECUCIÓN: NO ES UN NÚMERO OCTAL VÁLIDO". 
 * 
 * Después, en una segunda parte del ejercicio, separada claramente de la primera 
 * parte, debe convertirse el octal leído por teclado, a binario. Para ello 
 * no puede convertirse el número octal a entero, ni usar expresiones regulares. 
 * Para realizar la conversión reemplazar cada número octal, por su equivalente 
 * binario, usando el método "replaceAll" del String. 
 * 
 * Las equivalencias son las siguientes:
 * 
 * 0 octal --> 000 binario
 * 1 octal --> 001 binario
 * 2 octal --> 010 binario
 * 3 octal --> 011 binario
 * 4 octal --> 100 binario
 * 5 octal --> 101 binario
 * 6 octal --> 110 binario
 * 7 octal --> 111 binario
 * 
 * Opcionalmente, en vez de usar un String en el paso anterior, puedes usar
 * un StringBuilder para mejorar el uso de la memoria. Es más complicado, por
 * lo que es un reto que deberías asumir si consigues hacerlo usando el método
 * replaceAll de la clase String.
 * 
 * @author Profesor
 */
public class Ejercicio02 {
    public static void main(String[] args) {
        Scanner scannerEntrada = new Scanner(System.in);
        System.out.print("Introduce un número octal: ");
        String octal;
        String[] octales = {"000", "001", "010", "011", "100", "101", "110", "111"};
        boolean ok = false;

        //1º Verificación de octal sin usar expresiones regulares ni convirtiendo el String a número.
        octal = scannerEntrada.nextLine().trim();
        if (octal.length() > 0) {
            ok = true;
            for (int i = 0; i < octal.length() && ok; i++) {
                if (octal.charAt(i) < '0' || octal.charAt(i) > '7') {
                    ok = false;
                }
            }
        }
        if (!ok) {
            System.out.print("FIN DE LA EJECUCIÓN: NO ES UN NÚMERO OCTAL VÁLIDO.");
        } else {
     
            //2º Reemplazar cada número por su equivalente booleano               
            //2.2.- Obligatorio (hacerlo usando un String, con el método replaceAll)
            String binarioString = octal;
            for (int i = 0; i < octales.length; i++) {
                binarioString = binarioString.replaceAll(String.valueOf(i), octales[i]);
            }

            //2.1.- Opcional (hacerlo con StringBuilder - no hay método replaceAll)
            StringBuilder binarioStringBuilder = new StringBuilder(octal);
            for (int i = 0; i < octales.length; i++) // 'i' irá tomando sucesivamente valores de  0 a 7 en este caso, es decir, los 8 posibles dígitos octales.
            {
                int indice = binarioStringBuilder.indexOf(String.valueOf(i)); // 'indice' valdrá -1 si no se encuentra el carácter "i" dentro de 'binarioStringBuilder',
                // o el valor de la posición en la que se encuentra, en otro caso.    
                while (indice != -1) // Mientras que siga habiendo ocurrencias del carácter "i" que estamos comprobando dentro de la cadena
                {
                    binarioStringBuilder.replace(indice, indice + 1, octales[i]); // Se sustituye el carácter encontrado en la posición 'indice' por su equivalencia en octal
                    indice = binarioStringBuilder.indexOf(String.valueOf(i), indice + octales[i].length()); //Se actualiza el valor de 'indice' para ver si hay más ocurrencias del carácter "i"
                }
            }

            //3º Mostramos por pantalla ambos números:
            System.out.printf("Para el número octal %s, su equivalente binario sería: \n * /%s/ (usando StringBuilder).\n", octal, binarioStringBuilder);
            System.out.printf(" * /%s/ (usando String).\n", binarioString);
        }
    }
}

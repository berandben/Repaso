package tarea4;

import java.util.Scanner;

/**
 * Ejercicio 5. La misma letra de cada palabra.
 * 
 * Este ejercicio consiste en leer una cadena de texto entre asteriscos.
 * Esta cadena de texto se dividirá en espacios usando la expresión regular
 * "\s" y eliminado los asteriscos.
 * Cada cadena se almacenará integramente en un array de arrays.
 * Después se mostrará, el primer caracter de cada palabra,
 * el segundo caracter de cada palabra, etc.
 * 
 * Si se introduce "*hola que tal*"
 * 
 * el resultado esperado sería:
 * 
 * hqt
 * oua
 * lel
 * 
 * Para simplificar, si la palabra de menor tamaño es de 3 caracteres
 * se mostrarán solo tres caracteres de cada palabra.
 * 
 * @author Profesor
 */
public class Ejercicio05 {
    public static void main(String ... args)
    {
        Scanner leerTeclado=new Scanner(System.in);
        boolean textoErroneo;        
        String texto="";        
        System.out.println("Introduzca un texto entre asteriscos: ");
        System.out.print("Texto: ");
           
        texto=leerTeclado.nextLine().trim();        
        textoErroneo=!texto.matches("\\*.+\\*");
        if (textoErroneo)
        {
                System.out.println("- El texto debe estar entre asteriscos.");
                System.out.println("- El texto debe tener al menos un carácter.");
                System.out.print("ERROR. Cadena no válida.");    
        }                    
        else
        {
            String[] partes=texto.substring(1, texto.length()-1).trim().split("\\s+");
            char[][] caracteres=new char[partes.length][];
            
            //Almacenamos en el array de caracteres cada carácter
            for (int i=0;i<partes.length;i++)
            {
                caracteres[i]=new char[partes[i].length()];
                for (int j=0;j<partes[i].length();j++)
                {
                    caracteres[i][j]=partes[i].charAt(j);
                }
            }
            
            //Obtenemos el array de menor tamaño dentro del array de arrays
            int menor=caracteres[0].length;
            for (int i=1; i<caracteres.length;i++)
            {
                if (caracteres[i].length<menor) menor=caracteres[i].length;
            }
            
            //Mostramos el primer carácter de cada palabra, el segundo, etc.             
            for (int columna=0;columna<menor;columna++)
            {                
                for (int fila=0;fila<caracteres.length;fila++)
                {
                    System.out.print(caracteres[fila][columna]);
                }
                System.out.println();
            }
                        
            
        }
    }
}

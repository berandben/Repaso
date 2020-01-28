/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea4;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Ejercicio 4. Poner la fecha en el lugar adecuado. En este ejercicio se parte
 * de un array con N fechas ordenadas cronológicamente:
 *
 * - 1/9/2019 - 1/10/2019 - 1/11/2019 - 1/12/2019 - 1/1/2020
 *
 * Debes leer una nueva fecha por teclado e introducirla en el array,
 * sustituyendo una de las fechas que ya hay en el mismo.
 *
 * Si la fecha leída por teclado es anterior a la primera fecha del array, la
 * fecha leída se introducirá en la primera posición, machacando la que haya en
 * dicha posición.
 *
 * Si la fecha leída por teclado es posterior a la última fecha del array, la
 * fecha leída se introducirá en la última posición, machacando la que haya en
 * dicha posición.
 *
 * Para el resto de fechas, se colocarán justo antes de la fecha inmediatamente
 * mayor cronológicamente.
 *
 * Por último, muestra las fechas que hay almacenadas en el array usando un
 * bucle for-each.
 *
 * @author Profesor
 */
public class Ejercicio04 {

    public static void main(String[] args) {
        //Paso 1. crear un array de 5 fechas
        Scanner leerTeclado = new Scanner(System.in);

        System.out.print("Introduce el número de fechas (mayor o igual a 5): ");
        boolean repetir = true;
        int nFechas = 0;
        do {
            try {
                nFechas = leerTeclado.nextInt();
                if (nFechas >= 5) {
                    repetir = false;
                }
            } catch (Exception e) {
                
                if (leerTeclado.hasNextLine()) {
                    leerTeclado.nextLine();
                }
            }
            if (repetir) {
                System.out.println("ERROR. Introduce un número mayor o igual a 5. ");
                System.out.print("Introduce el número de fechas (mayor o igual a 5): ");                
            }
        } while (repetir);

        //Paso 2. Rellenar el array con fechas consecutivas separadas por un mes
        // partiendo del 1 de septiembre de 2019.
        LocalDate[] fechas = new LocalDate[nFechas];
        fechas[0] = LocalDate.of(2019, 9, 1);
        for (int i = 1; i < fechas.length; i++) {
            fechas[i] = fechas[i - 1].plusMonths(1);
        }

        //Paso 3. Leer los datos de una fecha concreta.
        repetir = true;
        LocalDate nuevaFecha = null;
        do {
            try {
                System.out.println("Introduzca el año: ");
                int año = leerTeclado.nextInt();
                System.out.println("Introduzca el mes: ");                
                int mes = leerTeclado.nextInt();
                System.out.println("Introduzca el día: ");
                int dia = leerTeclado.nextInt();
                nuevaFecha = LocalDate.of(año, mes, dia);
                //Si llego hasta aquí, es que todo ha ido bien.
                repetir = false;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: El dato introducido no es un número.");
                if (leerTeclado.hasNextLine()) {
                    leerTeclado.nextLine();
                }
            } catch (DateTimeException e) {
                System.out.println("ERROR: La fecha introducida no es válida.");
            }

        } while (repetir);

        /*Paso 4. Introducir la fecha en el array, en la posición correcta. 
                  (machacando la fecha que ocupe el lugar cronológico). */
        if (nuevaFecha != null) {
            boolean realizado = false;
            for (int i = 0; i < fechas.length && !realizado; i++) { //Es importante usar "fechas.length" y no "5" directamente.
                if (nuevaFecha.isBefore(fechas[i])) {
                    int pos = (i > 0) ? i - 1 : i; //Si la primera fecha ya es mayor que la que introducimos
                    //machacamos la primera.
                    fechas[pos] = nuevaFecha;
                    realizado = true; //Como ya está hecho... salimos del bucle (prohibido break).
                } else if (i == fechas.length - 1 && nuevaFecha.isAfter(fechas[i])) {
                    fechas[i] = nuevaFecha;
                }
            }
        }

        //Paso 5. Mostramos las fechas resultantes por pantalla usando un bucle for-each
        for (LocalDate f : fechas) {
            System.out.print(f);
            System.out.print(" ");
        }
        System.out.println();
    }
}

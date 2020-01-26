/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jjmbe
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String cadena, cadenaLetra, cadenaNum1, cadenaNum2;
        int num1, num2, suma;
        boolean valido;

//        Scanner sc = new Scanner(System.in);
//        System.out.println("introduce cadena");
//        cadena = sc.nextLine().trim();
        //ejemplo cadena = "Z75286";
        //Array con valores de prueba
        String[] cadenasPrueba = {"Z75286", "Z86761", "D21853", "D53655", "Z57311", "D91540", "Z43228", "D37859", "Z41214", "Z65280"};

        for (int i = 0; i < cadenasPrueba.length; i++) {

            cadena = cadenasPrueba[i];

            Pattern patron = Pattern.compile("^[ZD]\\d{3}\\d{2}$");
            Matcher encaja = patron.matcher(cadena);

            if (!encaja.matches()) {

                System.out.println("código incorrecto");

            } else {

                cadenaLetra = cadena.substring(0, 1);
                cadenaNum1 = cadena.substring(1, 4);
                cadenaNum2 = cadena.substring(4, 6);

                num1 = Integer.parseInt(cadenaNum1);
                num2 = Integer.parseInt(cadenaNum2);
                suma = num1 + num2;
                //  System.out.println(cadenaLetra + " " + suma%2+  " " + num1 + " + " + num2 + " = " + suma + " residuo de 2 "  );
                if ((suma % 2 == 0 && cadenaLetra.equals("Z")) || (suma % 2 == 1 && cadenaLetra.equals("D"))) {

                    System.out.printf("El código %s es válido%n", cadena);

                } else {

                    System.out.printf("El código %s no es válido%n", cadena);
                }

            }

        }

    }

}

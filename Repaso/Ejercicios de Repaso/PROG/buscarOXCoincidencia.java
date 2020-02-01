package tests;

import java.util.Arrays;

/**
 *
 * @author jjmbe
 */
public class Tests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        char[] miArrayCaracteres = new char[20];
        //muestra array vacío
        System.out.println(Arrays.toString(miArrayCaracteres));

        int aleatorio;  //0 al 3
        boolean encontrado = false;

        for (int i = 0; i < miArrayCaracteres.length; i++) { //19

            //min + Math.random()*(max - min)
            aleatorio = (int) (Math.random() * 4); //Math.random entre paréntesis para castear a int

            switch (aleatorio) {
                case 0:
                    miArrayCaracteres[i] = 'O';
                    break;
                case 1:
                    miArrayCaracteres[i] = 'X';
                    break;
                case 2:
                    miArrayCaracteres[i] = 'L';
                    break;
                default:
                    miArrayCaracteres[i] = 'B';
                    break;
            }

        }
        //muestra el array relleno
        System.out.println(Arrays.toString(miArrayCaracteres));

        for (int i = 0; i < miArrayCaracteres.length - 1 && !encontrado; i++) {

            if (miArrayCaracteres[i] == 'O' && miArrayCaracteres[i + 1] == 'X') {

                encontrado = true;
                System.out.println("encontrado " + i + " " + (i + 1));
                miArrayCaracteres[i] = 'o';// cambio las letras a minúsculas para que se diferencien mejor
                miArrayCaracteres[i + 1] = 'x';

            }

        }
//Hace lo mismo con un bucle anidado
//        for (int i = 0; (i < miArrayCaracteres.length - 1); i++) {
//            for (int j = i + 1; j < miArrayCaracteres.length && !encontrado; j++) {
//
//                if (miArrayCaracteres[i] == 'O' && miArrayCaracteres[i + 1] == 'X') {
//                    encontrado = true;
//                    System.out.println("premio en la posición " + i + " " + (i + 1));
//
//                    miArrayCaracteres[i] = 'o';
//                    miArrayCaracteres[i + 1] = 'x';
//
//                }
//
//            }
//
//        }
        if (!encontrado) {
            System.out.println("no encontrado");

        } else {
            System.out.println(Arrays.toString(miArrayCaracteres));
        }

    }
}


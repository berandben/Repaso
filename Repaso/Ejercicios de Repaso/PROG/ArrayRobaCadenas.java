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

        String[] arrayCadenas = {"aaa", "bbb", "ccc", "ddd"};
        System.out.println("Estado inicial");
        for (String arrayCadena : arrayCadenas) {
            System.out.printf("[%8s]", arrayCadena);
        }
        System.out.println("");

        for (int i = 0; i < 10; i++) {
            int cadenaRoba = (int) (Math.random() * 4);
            int cadenaPierde = (int) (Math.random() * 4);
            while (cadenaRoba == cadenaPierde) {
                cadenaRoba = (int) (Math.random() * 4);
                cadenaPierde = (int) (Math.random() * 4);
            }
            System.out.printf("%s roba a %s%n", cadenaRoba + 1, cadenaPierde + 1);

            if (arrayCadenas[cadenaPierde].length() > 0) {
                //Muy importante primero añadir el carácter y después eliminarlo
                arrayCadenas[cadenaRoba] += arrayCadenas[cadenaPierde].substring(arrayCadenas[cadenaPierde].length() - 1);
                arrayCadenas[cadenaPierde] = arrayCadenas[cadenaPierde].substring(0, arrayCadenas[cadenaPierde].length() - 1);
            }

            for (String arrayCadena : arrayCadenas) {
                System.out.printf("[%8s]", arrayCadena);
            }

            System.out.println("");
        }
    }
}

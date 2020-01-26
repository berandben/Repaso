package tests;

/**
 *
 * @author jjmbe
 */
public class Tests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] arrayNumeros = new int[20];

        int aleatorio;
        String cadena = "";

        for (int i = 0; i < arrayNumeros.length; i++) {

            aleatorio = (int) (Math.random() * 10);

            if (i == 0) {
                arrayNumeros[i] = aleatorio;

            } else if (arrayNumeros[i - 1] == 9) {
                arrayNumeros[i] = aleatorio;

            } else {

                arrayNumeros[i] = (int) (Math.random() * (10 - arrayNumeros[i - 1]) + arrayNumeros[i - 1]);
            }
        }

        for (int i = 0; i < arrayNumeros.length; i++) {

            if (i == 0) {
                cadena += "{" + arrayNumeros[i];

            } else if (i == arrayNumeros.length - 1) {
                cadena += arrayNumeros[i] + "}";

            } else {
                cadena += arrayNumeros[i];
            }
        }
        System.out.println(cadena);
    }
}

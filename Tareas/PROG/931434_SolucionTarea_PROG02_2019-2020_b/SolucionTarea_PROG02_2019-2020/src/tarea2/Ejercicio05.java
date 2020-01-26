package tarea2;

/**
 * Ejercicio 5. El abecedario II.
 *
 * En este ejercicio se muestra el abecedario de 4 formas diferentes dependiendo
 * de la opción generada de forma aleatoria.
 *
 * En la primera forma se muestra el abecedario así:
 *
 * - ABCDEFGHIJKLMNOPQRSTUVWXYZ
 *
 * En la segunda forma sería así:
 *
 * - BADCFEHGJILKNMPORQTSVUXWZY
 *
 * En la tercera forma se muestra así:
 *
 * - ZYXWVUTSRQPONMLKJIHGFEDCBA
 *
 * En la cuarta forma sería:
 *
 * - YZWXUVSTQROPMNKLIJGHEFCDAB
 *
 * @author profesor
 */
public class Ejercicio05 {

    public static void main(String[] args) {

        int opt = (int) (Math.random() * 4 + 1);
        //for (opt=1;opt<5;opt++,System.out.println()) {
        System.out.println("Opción: " + opt);
        switch (opt) {
            case 1:
                for (int i = 65; i <= 90; i++) {
                    System.out.print((char) i);
                }
                System.out.println();
                break;
            case 2:
                for (int i = 65; i < 90; i += 2) {
                    System.out.print((char) (i + 1));
                    System.out.print((char) i);
                }
                System.out.println();
                break;
            case 3:
                for (int i = 90; i > 64; i--) {
                    System.out.print((char) i);
                }
                System.out.println();
                break;
            default:
                for (int i = 90; i > 64; i -= 2) {
                    System.out.print((char) (i - 1));
                    System.out.print((char) i);
                }
                System.out.println();
                break;
        }
    }
    // }  // for
}

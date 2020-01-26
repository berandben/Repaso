
/**
 * Ejercicio 4. El abecedario I.
 *
 * En este ejercicio se muestra el abecedario en mayúsculas, de a A a Z sin
 * incluir la Ñ. Dicho abecedario se mostrará carácter a carácter.
 *
 * Adicionamente, se eligirá un carácter al azar, diferente a 'A' y 'Z',
 * que se marcará de una forma especial en el abecedario mostrado (entre llaves):
 *
 * - ABCDEFGH[I]JKLMNOPQRSTUVWXYZ
 *
 * @author Profesor
 */
public class Ejercicio04 {

    public static void main(String[] args) {
        char contador = 'A'; // Valor inicial del contador para un abecedario
        char elegido = 0;

        do {
            elegido = (char) (65 + (Math.random() * (90 - 65)));
        } while (elegido <= 'A' || elegido >= 'Z');

        System.out.println("El carácter elegido es: " + elegido);

        while (contador <= 'Z') {
            if (contador == elegido) {
                System.out.print("[" + contador + "]");
            } else {
                System.out.print(contador);
            }
            contador++;
        };
        System.out.println();
    }
}

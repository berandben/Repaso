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

        double[] arrayDepositos = {10.00, 10.00, 10.00, 10.00};

        for (int i = 0; i < arrayDepositos.length; i++) {
            System.out.printf("Depo %d: %.2f ", i, arrayDepositos[i]);
        }

        for (int i = 0; i < 10; i++) {
            System.out.printf("\niteración %d ----------------------%n", i);

            for (int j = 0; j < arrayDepositos.length; j++) {

                double aleatorio = Math.random() * 4;

                if (arrayDepositos[j] < aleatorio) {
                    arrayDepositos[j] = 0;
                    System.out.printf("Se sacan %.2f del depósito %d%n", aleatorio, j);

                } else {
                    arrayDepositos[j] -= aleatorio;
                    System.out.printf("Se sacan %.2f del depósito %d%n", aleatorio, j);
                }
            }

            for (int h = 0; h < arrayDepositos.length; h++) {
                System.out.printf("Depo %d: %.2f ", h, arrayDepositos[h]);
            }

            for (int k = 0; k < arrayDepositos.length; k++) {
                if (arrayDepositos[k] == 0) {
                    arrayDepositos[k] = 10.00;
                    System.out.printf("%nSe rellena el depósito %d", k);
                }
            }
        }
        System.out.println("");
    }
}

package tests;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author jjmbe
 */
public class CajaCambios {

    //Elementos comunes a todas las cajas de cambios
    private static final int MIN_MARCHA = 3;
    private static final int MAX_MARCHA = 6;
    private static final int DEFAULT_MARCHA = 0;
    private static final String[] MARCHAS = {"PRIMERA", "SEGUNDA", "TERCERA", "CUARTA", "QUINTA", "SEXTA"};

    //Elementos particulares de cada caja de cambios
    private final int NUMERO_MARCHAS;
    private int marchaActual;

    public CajaCambios(int numeroMarchas) throws IllegalArgumentException {

        if (numeroMarchas < CajaCambios.MIN_MARCHA || numeroMarchas > CajaCambios.MAX_MARCHA) {
//            Otra forma de expresarlo
//            IllegalArgumentException e;
//            e=new IllegalArgumentException(String.format("Marcha incorrecta %d%n", numeroMarchas));
//            throw e;

            throw new IllegalArgumentException(String.format("Marcha incorrecta %d%n", numeroMarchas));
        } else {
            this.marchaActual = CajaCambios.DEFAULT_MARCHA;//primera posición del array (0)
            this.NUMERO_MARCHAS = (numeroMarchas - 1);//posición anterior del array hemos empezado por 0
        }
    }

    public CajaCambios() {
        this(5);
    }

    public int getNumMarchas() {
        int marchaDevuelta = (this.NUMERO_MARCHAS + 1);//+1 para que no devuelva la posición del array
        return marchaDevuelta;
    }

    public String getEstado() {
        return CajaCambios.MARCHAS[this.marchaActual];//devuelve el valor del array
    }

    public String subirMarcha() throws IllegalStateException {

        if (this.marchaActual == this.NUMERO_MARCHAS) {
            throw new IllegalStateException("No se puede subir la marcha. Ya está metida la última marcha\n");
        } else {
            this.marchaActual++;
            return this.getEstado();
        }
    }

    public String bajarMarcha() throws IllegalStateException {

        if (this.marchaActual == CajaCambios.DEFAULT_MARCHA) {
            throw new IllegalStateException("No se puede bajar la marcha. Ya está metida la primera marcha\n");
        } else {
            marchaActual--;
            return this.getEstado();
        }
    }

    @Override
    public String toString() {
        String cadenaFormateada = String.format("Caja de cambios de %d marchas. Actualmente en %s%n", this.getNumMarchas(), this.getEstado());
        return cadenaFormateada;
    }

    public static void main(String[] args) {

        Scanner sc;
        sc = new Scanner(System.in);
        CajaCambios cajaCambios2 = null;
        int numMarchas;
        boolean repetir;

        System.out.println("CAJA DE CAMBIOS/n---------------");
        System.out.println("Prueba del constructor sin parámetros");

        CajaCambios cajaCambios = new CajaCambios();
        System.out.println(cajaCambios.toString());

        System.out.println("Prueba del constructor con parámetros");

        do {
            System.out.println("Introduzca la cantidad de marchas (3-6)");
            repetir = true;
            try {
                numMarchas = sc.nextInt();
                cajaCambios2 = new CajaCambios(numMarchas);
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
                repetir = false;
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida");
                repetir = false;
            }

            if (repetir && cajaCambios2 != null) {//si no le pongo null getNumMarchas devuelve NullPointerException

                System.out.printf("Número de marchas con GET %d%n", cajaCambios2.getNumMarchas());
                System.out.printf("Marcha actual con GET %s%n", cajaCambios2.getEstado());
                System.out.printf("Estado actual con toString %s%n", cajaCambios2.toString());

                System.out.println("Pruebas de cambio (subir)");

                try {
                    for (int i = cajaCambios2.marchaActual; i <= cajaCambios2.NUMERO_MARCHAS; i++) {
                        System.out.println(cajaCambios2.subirMarcha());
                    }
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }

                try {

                    for (int i = cajaCambios2.marchaActual; cajaCambios2.marchaActual >= 0; i--) {
                        System.out.println(cajaCambios2.bajarMarcha());
                    }
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            }

        } while (repetir);

    }

}

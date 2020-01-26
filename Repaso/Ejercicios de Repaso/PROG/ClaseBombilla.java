package tests;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author jjmbe
 */
public class Bombilla {

    private int estado;

    private static int numeroVecesEncendida;

    public Bombilla(int estado) throws IllegalArgumentException {

        if (estado < 0 || estado > 1) {
            throw new IllegalArgumentException("Estado inválido. Finalizamos");
        } else if (estado == 1) {
            this.estado = estado;
            Bombilla.numeroVecesEncendida++;
        } else {
            this.estado = estado;
        }
    }

    public Bombilla() {
        this(0);
    }

    public boolean getEstado() {
        return this.estado == 1; //si está encendida devuelve true
    }

    public static int getNumVecesEncendida() {
        return Bombilla.numeroVecesEncendida;
    }

    public void encender()/* throws IllegalStateException */ {
        if (!this.getEstado()) { //si no está encendidad la enciende
            this.estado = 1;
            Bombilla.numeroVecesEncendida++;
        } else {

            // throw new IllegalStateException("La bombilla ya está encendida");
        }
    }

    public void apagar()/* throws IllegalStateException*/ {
        if (this.getEstado()) {
            this.estado = 0;
        } else {
            //  throw new IllegalStateException("La bombilla ya está apagada");
        }

    }

    public void conmutar() {
        if (this.getEstado()) {
            this.estado = 0;
        } else {
            this.estado = 1;
            Bombilla.numeroVecesEncendida++;
        }

    }

    @Override
    public String toString() {

        String mensaje;
        mensaje = this.getEstado() ? String.format("Bombilla encendida. Se ha encendido %d veces", Bombilla.numeroVecesEncendida)
                : String.format("Bombilla apagada. Se ha encendido %d veces", Bombilla.numeroVecesEncendida);
        return mensaje;
    }

    public static void main(String[] args) {

        Bombilla bombilla1 = new Bombilla();
        System.out.println("Prueba del constructor sin parámetros:");
        System.out.printf("objeto creado: %s%n", bombilla1.toString());
        Scanner sc;
        int estado;
        boolean repetir = true;

        do {

            try {
                sc = new Scanner(System.in);
                System.out.println("\nPrueba del constructor con parámetros:");
                System.out.println("Introduzca el estado inicial (0 Apagada / 1 Encendida)");
                estado = sc.nextInt();

                Bombilla bombilla2 = new Bombilla(estado);
                System.out.printf("Objeto creado: %s%n", bombilla2.toString());
                System.out.printf("Prueba del get estado: %s%n", bombilla2.getEstado());
                System.out.printf("Prueba toString: %s%n", bombilla2.toString());

                System.out.println("Pruebas de cambio");

                for (int i = 0; i < 4; i++) {

                    bombilla2.conmutar();
                    System.out.printf("Commutar: %s%n", bombilla2.toString());

                }

                bombilla2.encender();
                System.out.printf("Encender: %s%n", bombilla2.toString());
                bombilla2.encender();
                System.out.printf("Encender: %s%n", bombilla2.toString());

                bombilla2.apagar();
                System.out.printf("Apagar: %s%n", bombilla2.toString());
                bombilla2.encender();
                System.out.printf("Encender: %s%n", bombilla2.toString());

            } catch (IllegalArgumentException/* | IllegalStateException*/ e) {
                repetir = false;
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                repetir = false;
                System.out.println("Estado inválido. Finalizamos");
            }

        } while (repetir);

    }

}

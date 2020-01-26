/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author jjmbe
 */
public class Baraja {

    private int tipo;
    private static int numeroExtracciones;

    public enum Numero48 {
        UNO, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, OCHO, NUEVE, SOTA, CABALLO, REY
    };

    public enum Numero40 {
        UNO, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, SOTA, CABALLO, REY
    };

    public enum Palo {
        OROS, COPAS, ESPADAS, BASTOS
    };

    public Baraja(int tipo) throws IllegalArgumentException {

        if (tipo == 40 || tipo == 48) {
            this.tipo = tipo;
        } else {
            throw new IllegalArgumentException("Parámeto non válido. Finalizamos");
        }
    }

    public Baraja() {
        this(40);
    }

    public int getNumNaipes() {
        return this.tipo;
    }

    public static int getNumExtracciones() {
        return Baraja.numeroExtracciones;
    }

    public String extraerNaipeRandom() {
        String cadenaFormateada;
        int numAleatorioPalo = (int) (Math.random() * 4);
        Baraja.numeroExtracciones++;
        if (this.tipo == 48) {
            int numAleatorio48 = (int) (Math.random() * 12);
            cadenaFormateada = String.format("%s de %s%n", Numero48.values()[numAleatorio48].toString(), Palo.values()[numAleatorioPalo]);
        } else {
            int numAleatorio40 = (int) (Math.random() * 10);
            cadenaFormateada = String.format("%s de %s%n", Numero48.values()[numAleatorio40].toString(), Palo.values()[numAleatorioPalo]);
        }
        return cadenaFormateada;
    }

    @Override
    public String toString() {
        String cadenaFormateada = String.format("Baraja de %d naipes. Extracciones: %d", this.tipo, Baraja.numeroExtracciones);
        return cadenaFormateada;
    }

    public static void main(String[] args) {

        Scanner sc;
        int naipes;
        boolean repetir = true;

        Baraja baraja1 = new Baraja();
        System.out.println(baraja1.toString());

        do {
            try {
                sc = new Scanner(System.in);
                System.out.println("Introduzca el número de naipes (40 o 48): ");
                naipes = sc.nextInt();

                Baraja baraja2 = new Baraja(naipes);

                System.out.printf("GET: Baraja de %d naipes%n", baraja2.getNumNaipes());
                System.out.printf("TOSTRING: %s%n", baraja2.toString());
                for (int i = 0; i < 10; i++) {
                    System.out.println(baraja2.extraerNaipeRandom());
                }

                System.out.printf("GET: Baraja de %d naipes%n", baraja2.getNumNaipes());
                System.out.printf("TOSTRING: %s%n", baraja2.toString());

            } catch (IllegalArgumentException e) {
                repetir = false;
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                repetir = false;
                System.out.println("Valor incorrecto. Finalizamos");
            }
        } while (repetir);
    }
}

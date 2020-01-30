package ejercicio3.practicar;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Bombo
 *
 * @author profe
 */
public class Bombo {

    public static final int DEFAULT_NUM_BOLAS = 90;
    public static int MIN_NUM_BOLAS = 9;
    public static int MAX_NUM_BOLAS = 90;
    private final int NUM_BOLAS;
    private int numBolasExtraidas;
    private int[] listaBolas;

    public Bombo(int numBolas) throws IllegalArgumentException {
        if (numBolas < MIN_NUM_BOLAS || numBolas > MAX_NUM_BOLAS) {
            throw new IllegalArgumentException("Error. Número de bolas inválido: " + numBolas);
        } else {
            this.NUM_BOLAS = numBolas;
            this.numBolasExtraidas = 0;
            // Rellenamos la lista de Bolas
            listaBolas = new int[this.NUM_BOLAS];
            for (int i = 0; i < this.NUM_BOLAS; i++) {
                listaBolas[i] = i + 1;
            }
        }
    }

    public Bombo() {
        this(DEFAULT_NUM_BOLAS);
    }

    public int getNumBolas() {
        return this.NUM_BOLAS;
    }

    public int getNumBolasExtraidas() {
        return this.numBolasExtraidas;
    }

    public int getNumBolasRestantes() {
        return this.NUM_BOLAS - this.numBolasExtraidas;
    }

    public boolean isVacio() {
        return this.numBolasExtraidas == this.NUM_BOLAS;
    }

    public boolean isCompleto() {
        return this.numBolasExtraidas == 0;
    }

    public int sacarBola() throws IllegalStateException {
        if (this.isVacio()) {
            throw new IllegalStateException("Error: Bombo vacío");
        } else {
            int aleatoria = this.numBolasExtraidas
                    + (int) (Math.random() * (this.NUM_BOLAS - this.numBolasExtraidas));
            int bola = listaBolas[aleatoria];
            listaBolas[aleatoria] = listaBolas[this.numBolasExtraidas];
            this.numBolasExtraidas++;
            return bola;
        }
    }

    @Override
    public String toString() {
        return String.format("Bombo de %d bolas. Bolas extraídas: %d",
                this.NUM_BOLAS, this.numBolasExtraidas);
    }

    /**
     * Programa principal de prueba.
     *
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        mainProfe();
    }

    /**
     * Programa de prueba.Crea bombos y extrae bolas hasta que se introduzca un
     * valor no válido. *
     */
    public static void mainProfe() {
        int numBolas;
        Bombo bombo = null;
        boolean entradaValida = true;
        Scanner teclado = new Scanner(System.in);

        System.out.println("BOMBO DE UN BINGO");
        System.out.println("-----------------");
        System.out.println("Prueba del constructor sin parámetros: ");
        bombo = new Bombo();
        System.out.println("Creado objeto: " + bombo);

        System.out.println("\nPrueba del constructor con parámetros: ");
        do {
            entradaValida = true;
            System.out.print("Introduzca el número de bolas (9-90): ");
            try {
                numBolas = teclado.nextInt();
                bombo = new Bombo(numBolas);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage() + ". Finalizamos");
                entradaValida = false;
            } catch (InputMismatchException ex) {
                System.out.println("Valor inválido. Finalizamos");
                entradaValida = false;
            }
            if (entradaValida) {
                System.out.println("Prueba del getNumBolas: " + bombo.getNumBolas());
                System.out.println("Prueba del getNumBolasExtraidas: " + bombo.getNumBolasExtraidas());
                System.out.println("Prueba del getNumBolasRestantes: " + bombo.getNumBolasRestantes());
                System.out.println("Prueba del toString: " + bombo.toString());
                System.out.print("Pruebas de extracción: ");
                for (int i = 0; i < 10; i++) {
                    try {
                        System.out.printf("%d ", bombo.sacarBola());
                    } catch (IllegalStateException e) {
                        System.out.printf("\n%s.", e.getMessage());
                    }
                }
                System.out.println("\nEstado actual del bombo: " + bombo);
                System.out.println();
            }
        } while (entradaValida);
    }

    public static void mainExamen() {
        Bombo bombo = null;

        System.out.println("BOMBO");
        System.out.println("-----");
        System.out.println("Prueba del constructor sin parámetros: ");
        bombo = new Bombo();
        System.out.println("Creado objeto: " + bombo);

        System.out.println("\nPrueba del constructor con parámetros con valor inválido: ");
        try {
            bombo = new Bombo(7);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage() + ".");
        }

        System.out.println("\nPrueba del constructor con parámetros con valor 9: ");
        try {
            bombo = new Bombo(9);
            System.out.println("Prueba del getNumBolas: " + bombo.getNumBolas());
            System.out.println("Prueba del getNumBolasExtraidas: " + bombo.getNumBolasExtraidas());
            System.out.println("Prueba del getNumBolasRestantes: " + bombo.getNumBolasRestantes());
            System.out.println("Prueba del toString: " + bombo.toString());
            System.out.print("Pruebas de extracción: ");
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.printf("%d ", bombo.sacarBola());
                } catch (IllegalStateException e) {
                    System.out.printf("\n%s.\n", e.getMessage());
                }
            }
            System.out.println("\nEstado final del bombo (toString): " + bombo);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage() + ".");
        }

        System.out.println();

    }
}


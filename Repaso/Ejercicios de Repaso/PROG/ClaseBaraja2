package ejercicio3.practicar;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Baraja
 *
 * @author profe
 */
public class Baraja {

    public static final int DEFAULT_NAIPES = 40;
    private static final String[] LISTA_NUMEROS = {"UNO", "DOS", "TRES", "CUATRO",
        "CINCO", "SEIS", "SIETE", "SOTA", "CABALLO", "REY", "OCHO", "NUEVE"};
    private static final String[] LISTA_PALOS = {"OROS", "ESPADAS", "COPAS", "BASTOS"};

    private int numNaipes;
    private int numExtracciones;

    public Baraja(int numNaipes) throws IllegalArgumentException {
        if (numNaipes != 40 && numNaipes != 48) {
            throw new IllegalArgumentException("Error. Número de naipes inválido: " + this.numNaipes);
        } else {
            this.numNaipes = numNaipes;
        }
    }

    public Baraja() {
        this(DEFAULT_NAIPES);
    }

    public int getNumNaipes() {
        return this.numNaipes;
    }

    public int getNumExtracciones() {
        return this.numExtracciones;
    }
    
    
    public String extraerNaipeRandom() {
        this.numExtracciones++;
        return LISTA_NUMEROS[(int) (Math.random() * numNaipes) / 4] + " de " +
               LISTA_PALOS [(int) (Math.random() * 4)] ;
        // Otra forma: usar un switch
    }

    @Override
    public String toString() {
        return String.format ("Baraja de %d naipes. Extracciones: %d",
                this.numNaipes, this.numExtracciones);
    }

    /**
     * Programa principal de prueba.
     * Crea Barajas y extrae naipes hasta que se introduzca un valor no válido.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numNaipes;
        Baraja baraja = null;
        boolean entradaValida = true;
        Scanner teclado = new Scanner(System.in);

        System.out.println ("BARAJAS");
        System.out.println ("-------");
        System.out.println ("Prueba del constructor sin parámetros: ");
        baraja= new Baraja();
        System.out.println ("Objeto creado: " + baraja);
        
        System.out.println ("\nPrueba del constructor con parámetros: ");
        do {
            entradaValida = true;
            System.out.println("Introduzca el número de naipes (40 o 48):");
            try {
                numNaipes = teclado.nextInt();
                baraja = new Baraja(numNaipes);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage() + ". Finalizamos");
                entradaValida = false;
            } catch (InputMismatchException ex) {
                System.out.println("Valor inválido. Finalizamos");
                entradaValida = false;
            }
            if (entradaValida) {
                System.out.println("Prueba del getNumNaipes: " + baraja.getNumNaipes());
                System.out.println("Prueba del toString: " + baraja.toString());
                System.out.println("Pruebas de extracción: ");
                for (int i = 0; i < 10; i++) {
                    System.out.printf ("%s \n", baraja.extraerNaipeRandom());
                }
                System.out.println("Prueba del toString: " + baraja.toString());
                System.out.println();
            }
        } while (entradaValida);
    }
}

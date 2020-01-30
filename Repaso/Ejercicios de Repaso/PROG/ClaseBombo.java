package tests;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bombo {

    private int numBolas;
    private int numBolasExtraidas;
    private int[] arrayBolas;

    public Bombo(int numBolas) throws IllegalArgumentException {

        if (numBolas < 9 || numBolas > 90) {

            throw new IllegalArgumentException("Parámetro inválido");

        } else {

            this.numBolas = numBolas;
            this.rellenaArray();//rellena el array
        }

    }

    public Bombo() {
        this(90);
    }

    public int getNumBolas() {

        return this.numBolas;
    }

    public int getNumBolasExtraidas() {

        return this.numBolasExtraidas;
    }

    public int getNumBolasRestantes() {

        return this.numBolas - this.numBolasExtraidas;

    }

    private void rellenaArray() {
        boolean repetir;//repite la generación de un número aleatorio
        int aleatorio = 0;
        arrayBolas = new int[this.numBolas];//se crea un array del tamaño del número de bolas

        for (int i = 0; i < arrayBolas.length; i++) {

            do {
                //se genera un número aleatorio entre 1 y el número de bolas
                //teniendo en cuenta que 1 ocupará la posición 0 del array
                aleatorio = (int) (Math.random() * (1 - (numBolas + 1)) + (numBolas + 1));

                repetir = false;

                for (int j = 0; j < arrayBolas.length && !repetir; j++) {
                    //comprueba si aleatorio está repetido en el array
                    repetir = aleatorio == arrayBolas[j];

                }
                //si está repetido se genera uno nuevo
            } while (repetir);
            //por último se guarda el número generado en la posición que va corriendo
            arrayBolas[i] = aleatorio;

        }

    }

    public int sacarBola() throws IllegalStateException {

        if (this.isVacio()) {

            throw new IllegalStateException("ERROR: El bombo está vacío");

        } else {

            //imprime el array de las bolas generadas
            System.out.println("*******************");
            System.out.println(Arrays.toString(arrayBolas));
            System.out.println("*******************");
            //guarda el número de bolas extraidas en posición
            int posicion = numBolasExtraidas;
            //incrementa las bolas extraidas
            numBolasExtraidas++;
            //devuelve la posición del array correspondiente
            return arrayBolas[posicion];

        }

    }

    public boolean isVacio() {

        return (this.numBolasExtraidas >= this.numBolas);

    }

    public boolean isCompleto() {
        return (this.numBolasExtraidas == 0);

    }

    @Override
    public String toString() {
        String cadena = String.format("Bombo de %d bolas.%nBolas extraídas %d%n", this.numBolas, this.numBolasExtraidas);

        return cadena;
    }

    public static void main(String[] args) {

        Bombo bombo1 = new Bombo();
        System.out.printf("Numero de bolas con toString %s%n", bombo1.toString());
        Scanner sc;

//        Bombo bombo2 = null;
        try {
            sc = new Scanner(System.in);
            System.out.println("Introduzca el número de bolas (9-90): ");
            int numBolas = sc.nextInt();

            Bombo bombo2 = new Bombo(numBolas);

            System.out.printf("Numero de bolas con get %d%n", bombo2.getNumBolas());
            System.out.printf("Numero de bolas extraidas con get %d%n", bombo2.getNumBolasExtraidas());
            System.out.printf("Numero de bolas restantes con get %d%n", bombo2.getNumBolasRestantes());
            System.out.printf("Numero de bolas con toString %s%n", bombo2.toString());

            System.out.printf("Está vacío.%s%n", bombo2.isVacio());
            System.out.printf("Está lleno.%s%n", bombo2.isCompleto());

            System.out.println("*******************");

            for (int i = 0; i < 9; i++) {
                System.out.println(bombo2.sacarBola());
            }
            System.out.printf("Numero de bolas con get %d%n", bombo2.getNumBolas());
            System.out.printf("Numero de bolas extraidas con get %d%n", bombo2.getNumBolasExtraidas());
            System.out.printf("Numero de bolas restantes con get %d%n", bombo2.getNumBolasRestantes());
            System.out.printf("Numero de bolas con toString %s%n", bombo2.toString());

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());

        } catch (InputMismatchException e) {
            System.out.println("Dato erróneo");
        }

//        if (bombo2 != null) {
//            System.out.printf("Numero de bolas con toString %s%n", bombo2.toString());
//        }
    }

}

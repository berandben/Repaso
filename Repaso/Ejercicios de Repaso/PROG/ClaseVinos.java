/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

public class Vinos {

    private int codigo;
    private String denominacion;
    private double grados;
    private String origen;
    private static int numVinos;

    public Vinos(int codigo, String denominacion, double grados, String origen) throws IllegalArgumentException {

        if (codigo < 0 || grados < 0.00) {
            throw new IllegalArgumentException("Parámetros erróneos");
        } else {
            this.codigo = codigo;
            this.denominacion = denominacion;
            this.grados = grados;
            this.origen = origen;
            Vinos.numVinos++;
        }
    }

    public Vinos() {
        this(1, "Vino Peleón", 25, "Jumilla");
    }

    public boolean isRiojaFuerte() {
        return (this.origen.equals("Rioja") && grados >= 17);
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getDenominacion() {
        return this.denominacion;
    }

    public double getGrados() {
        return this.grados;
    }

    public String getOrigen() {
        return this.origen;
    }

    public static int getNumVinos() {
        return Vinos.numVinos;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public void setGrados(double grados) {
        this.grados = grados;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public String toString() {
        return String.format("Código %d, Denominación %s, Grados %.2f, Origen %s",
                this.codigo, this.denominacion, this.grados, this.origen);
    }

    public static void main(String[] args) {

        String cadena;

        Vinos vino = new Vinos();
        System.out.println(vino.toString());

        Vinos vino2 = new Vinos(2, "Rioja", 19, "Rioja");
        System.out.println(vino2.toString());
        cadena = vino2.isRiojaFuerte() ? "Es Rioja fuerte" : "No es Rioja fuerte";
        System.out.println(cadena);

        vino2.setGrados(15);
        System.out.println(vino2.toString());
        cadena = vino2.isRiojaFuerte() ? "Es Rioja fuerte" : "No es Rioja fuerte";
        System.out.println(cadena);

        try {
            Vinos vino3 = new Vinos(3, "Rioja", -7, "Rioja");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.printf("Se han creado %d vinos%n", Vinos.getNumVinos());
    }
}

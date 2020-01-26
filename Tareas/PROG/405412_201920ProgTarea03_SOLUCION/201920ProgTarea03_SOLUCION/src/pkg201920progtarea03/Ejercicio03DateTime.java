package pkg201920progtarea03;

import java.time.LocalDateTime;

/**
 * (LocalDateTime) Crea una clase en la que realices las siguientes operaciones:
 * 1. Crear un objeto de la clase LocalDateTime con fecha 3 de abril de 2020 y
 *    hora 11:30.
 * 2. Crear un segundo objeto de la clase LocalDateTime con fecha 1 de
 *    noviembre de 2020 y hora 08:15.
 * 3. Comprobar mediante algún método de los que ofrece la clase LocalDateTime
 *    si la fecha del primer objeto es anterior a la otra, informando sobre ello.
 * 4. Calcula y muestra por consola la fecha resultante de añadir 1 día y 4
 *    horas a la fecha inicial.
 * 
 * @author JJBH
 */
public class Ejercicio03DateTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Crear un objeto de la clase LocalDateTime con fecha 3 de abril de 
        // 2020 y hora 11:30
        LocalDateTime ldtIni = LocalDateTime.parse("2020-04-03T11:30");
        // Crear un segundo objeto de la clase LocalDateTime con fecha 1 de
        // noviembre de 2020 y hora 08:15
        LocalDateTime ldtFin = LocalDateTime.parse("2020-11-01T08:15");
        
        // Comprobar mediante algún método de los que oferece la clase LocalDateTime
        if (ldtIni.isBefore(ldtFin)) {
            System.out.println("La fecha " +  ldtIni + " es anterior a " + ldtFin ) ;
        } else {
            System.out.println("La fecha " +  ldtIni + " no es anterior a " + ldtFin ) ;
        }
        
        // Crear un nuevo objeto de LocalDateTime a partir del primero creado, añadiendo 1 día y 4 horas a 
        LocalDateTime ldtTercero = ldtIni.plusDays(1).plusHours(4);
        System.out.println("La fecha resultante de añadir 1 día y 4 horas a " +  ldtIni + " es " + ldtTercero ) ;
            
    }
    
}
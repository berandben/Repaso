package pkg201920progtarea03;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Comprobar fechas del calendario académico.
 * Teniendo en cuenta elcalendario escolar de la provincia de Almería para el
 * curso 2019/20, en el main see realiza lo necesario para:
 *  -- Leer tres números enteros correspondientes al año, mes y día para 
 *     conformar una fecha.
 *  -- Crear el objeto de la clase LocalDate correspondiente a la fecha cuyos
 *     datos acabamos de leer. 
 *  -- Comprobar usando el objeto creado si la fecha
 *     está en el periodo escolar, informando del resultado en cualquier caso.
 * 
 * @author JJBH
 */
public class Ejercicio02Calendario {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Fecha de inicio del curso
        LocalDate fechaInicio = LocalDate.of(2019, Month.SEPTEMBER, 16) ;
        
        // Fecha de fin de curso
        LocalDate fechaFin = LocalDate.of(2020, Month.JUNE, 23) ;
        
        boolean lecturaOk = false ;
        while (!lecturaOk) {
        
            try {

                System.out.println("Introduzca la fecha de que quiere comprobar si está en período lectivo.");
                System.out.println("Introduzca el año (2019 o 2020): ");
                Scanner teclado = new Scanner(System.in);
                int anio = teclado.nextInt() ;
                
                // Lectura del año (debe ser 2019 o bien 2020)
                while(anio < 2019 || anio > 2020){
                    System.out.println("El año debe ser 2019 o 2020.");
                    anio = teclado.nextInt() ;
                }

                // Leer el mes (Lógicamente entre 1 y 12)
                System.out.println("Introduzca el mes (entre 1 y 12).");
                int mes = teclado.nextInt() ;
                while(mes < 1 || mes > 12){
                    System.out.println("El mes debe estar entre 1 y 12");
                    mes = teclado.nextInt() ;
                }

                // Leer el día
                System.out.println("Introduzca el día (entre 1 y 31).");
                int dia = teclado.nextInt() ;

                // Fecha leída (Saltará una excepción DateTimeException si por
                // ejemplo se intenta crear una fecha con 31 de febrero)
                LocalDate fechaLeida = LocalDate.of(anio, mes, dia) ;
                
                // Si llegamos aquí es que la lectura ha ido bien y no ha saltado ninguna excepción
                lecturaOk = true ;

                if (fechaLeida.isAfter(fechaFin) || fechaLeida.isBefore(fechaInicio) ) {
                    System.out.print("\nResultado: está fuera del período escolar del curso 2019-2020.");
                } else {
                    System.out.print("\nResultado: está dentro del período escolar del curso 2019-2020.");

                    // Si está entre el 6 y 12 de abril estamos en vacaciones de Semana Santa
                    LocalDate inicioSSanta = LocalDate.of(2020, Month.APRIL, 4) ;
                    LocalDate finSSanta = LocalDate.of(2020, Month.APRIL, 13) ;

                    if (fechaLeida.isAfter(inicioSSanta) && fechaLeida.isBefore(finSSanta) ) {
                        System.out.println("\nLa fecha está dentro de Semana Santa de este curso escolar 2019-2020.");
                    }

                }
            } catch (DateTimeException ex0) {                
                System.err.println("Error: fecha no válida.\n");
            } catch (NumberFormatException ex1) {
                System.err.println("Error: no es un número entero válido. ");
            } catch (InputMismatchException ex2) {
                System.err.println("Error de lectura: formato no válido.");
            }
            
        }
        
    }
    
}

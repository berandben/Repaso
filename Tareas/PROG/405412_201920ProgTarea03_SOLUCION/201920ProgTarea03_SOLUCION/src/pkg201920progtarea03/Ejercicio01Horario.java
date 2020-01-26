package pkg201920progtarea03;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Clase donde en el método main se realiza lo necesario para atender a las 
 * siguientes consideraciones:
 * 
 * - Leer por teclado la hora (hora y minutos), que será la que se usará para
 *   realizar las comprobaciones que siguen.
 * - Calcular el momento del día escolar en el que se encuentra esa hora:
 *      1.Antes de empezar las clases (indicar en tal caso cuánto tiempo falta).
 *      2.En la hora de clase (indicar en tal caso cuánto hace que empezaron y
 *        cuánto falta para terminar).
 *      3.Después de terminar las clases (indicar en tal caso cuánto tiempo 
 *        hace que terminaron las clases).
 * 
 *  	          Lunes 	Martes 	Miércoles 	Jueves 	Viernes
 * 08:00 - 09:00 					
 * 09:00 - 10:00 					
 * 10:00 - 11:00 					
 * 11:00 - 11:30  Recreo 	Recreo 	Recreo          Recreo 	Recreo
 * 11:30 - 12:30 					
 * 12:30 - 13:30 					
 * 13:30 - 14:30 	
 * 
 * @author JJBH
 */
public class Ejercicio01Horario { 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        boolean lecturaOk = false ;
       
        
        // Iterar mientras la lectura desde teclado no sea correcta
        while (!lecturaOk) {
        
            // Leer la hora actual
            System.out.println("Introduzca la hora actual: ");
            try {
                Scanner teclado = new Scanner(System.in);
                int horaActual = teclado.nextInt() ;

                while(horaActual < 0 || horaActual > 23){
                    System.out.println("La hora debe estar entre 0 y 23.");
                    horaActual = teclado.nextInt() ;
                }

                // Leer los minutos de inicio de clases
                System.out.println("Introduzca los minutos actuales (entre 0 y 59).");
                int minutoActual = teclado.nextInt() ;
                while(minutoActual < 0 || minutoActual > 59){
                    System.out.println("Los minutos deben estar entre 0 y 59");
                    minutoActual = teclado.nextInt() ;
                }
                
                // Si llegamos aquí es que la lectura ha ido bien y no ha
                // saltado ninguna excepción
                lecturaOk = true ;
                
                // Creamos un objeto con la hora leída por teclado
                LocalTime ltAhora = LocalTime.of(horaActual, minutoActual) ;

                // Creamos un objeto con la hora de inicio de las clases (8:00)
                LocalTime ltHoraIni = LocalTime.of(8, 0) ;

                // Creamos un objeto con la hora de fin de las clases           
                LocalTime ltHoraFin = LocalTime.of(14, 30) ;

                // Informamos de la hora actual (la introducida por teclado)
                System.out.printf("\nHora actual: %02d:%02d", horaActual, minutoActual) ;
                System.out.print("\nResultado: ") ;

                // Si las clases no han empezado todavía
                if (ltAhora.isBefore(ltHoraIni)) {
                    System.out.println("Las clases no han empezado todavía");

                    // Calcular el tiempo que falta hasta el comienzo
                    long minutosFaltan = ltAhora.until(ltHoraIni, ChronoUnit.MINUTES);
                    long horas = minutosFaltan/60;
                    long minutos = minutosFaltan%60;

                    System.out.print("Faltan: ") ;
                    System.out.print(horas) ;
                    System.out.print(" horas y ") ;
                    System.out.print(minutos) ;
                    System.out.println(" minutos para que empiecen.") ;


                // Estamos dentro del horario    
                } else if ((ltAhora.isAfter(ltHoraIni) && ltAhora.isBefore(ltHoraFin)) || 
                        (ltAhora.compareTo(ltHoraIni) == 0)) {
                    System.out.print("Las clases han comenzado y estamos en");

                    LocalTime ltTramo8a9 = LocalTime.of(9, 0) ;
                    LocalTime ltTramo9a10 = LocalTime.of(10, 0) ;
                    LocalTime ltTramo10a11 = LocalTime.of(11, 0) ;
                    LocalTime ltTramorecreo = LocalTime.of(11, 30) ;
                    LocalTime ltTramocuarta = LocalTime.of(12, 30) ;
                    LocalTime ltTramoquinta = LocalTime.of(13, 30) ;

                    if (ltAhora.isBefore(ltTramo8a9)) {
                        System.out.println(" primera hora");
                    } else if (ltAhora.isBefore(ltTramo9a10)) {
                        System.out.println(" segunda hora");
                    } else if (ltAhora.isBefore(ltTramo10a11)) {
                        System.out.println(" tercera hora");
                    } else if (ltAhora.isBefore(ltTramorecreo)) {
                        System.out.println(" recreo");
                    } else if (ltAhora.isBefore(ltTramocuarta)) {
                        System.out.println(" cuarta hora");
                    } else if (ltAhora.isBefore(ltTramoquinta)) {
                        System.out.println(" quinta hora");
                    } else {
                        System.out.println(" sexta y última hora");
                    }
                    
                    // Calcular cuánto hace que empezaron
                    long minutosEmpezaron = ltHoraIni.until(ltAhora, ChronoUnit.MINUTES);
                    long horas = minutosEmpezaron / 60 ;
                    long minutos = minutosEmpezaron % 60 ;
                    
                    
                    System.out.print("Las clase empezaron hace: ") ;
                    System.out.print(horas) ;
                    System.out.print(" horas y ") ;
                    System.out.print(minutos) ;
                    System.out.println(" minutos.") ;
                    
                    // Calcular cuánto falta para que terminen las clases
                    long minutosParaAcabar = ltAhora.until(ltHoraFin, ChronoUnit.MINUTES);
                    horas = minutosParaAcabar / 60 ;
                    minutos = minutosParaAcabar % 60 ;
                    System.out.print("Las clases terminarán dentro de: ") ;
                    System.out.print(horas) ;
                    System.out.print(" horas y ") ;
                    System.out.print(minutos) ;
                    System.out.println(" minutos.") ;

                // Las clases ya han terminado    
                } else {
                    System.out.println("Las clases ya han terminado.");

                    // Calcular el tiempo que ha pasado desde el fin
                    long minutosPasados = ltHoraFin.until(ltAhora, ChronoUnit.MINUTES);
                    long horas = minutosPasados/60;
                    long minutos = minutosPasados%60;

                    System.out.print("Han pasado: ") ;
                    System.out.print(horas) ;
                    System.out.print(" horas y ") ;
                    System.out.print(minutos) ;
                    System.out.println(" minutos desde el final de las clases.") ;


                }

            } catch (NumberFormatException ex1) {
                System.err.println("Error: no es un número entero válido. ");
            } catch (InputMismatchException ex2) {
                System.err.println("Error: formato no válido.");
            }
            
        }
    }
    
}
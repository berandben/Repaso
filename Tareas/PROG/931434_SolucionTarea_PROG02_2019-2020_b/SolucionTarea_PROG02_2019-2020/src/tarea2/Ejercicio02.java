package tarea2;

/**
 * 
 * Ejercicio 2. Qué toca ahora.
 * 
 * En este ejercicio se obtiene un número aleatorio entre 0 y 86399, que 
 * corresponde con el número de segundos transcurridos en un día.
 * 
 * Después, esos segundos, se transforman a horas y minutos. Dependiendo
 * de las horas y minutos, se muestra un mensaje u otro por pantalla:
 * 
 *  - < 7:30 → “DORMIR”
 *  - >= 7:30 y <= 8:30 → “LEVANTARSE Y DESAYUNAR”
 *  - > 8:30 y <= 13:30 → “TRABAJAR”
 *  - > 13:30 y < 16:30 → “ALMORZAR”
 *  - >= 16:30 → “ESTUDIAR”
 * 
 * Ese mensaje se acompañará con un texto diferente dependiendo también de la
 * hora:
 * 
 *  - < 20:30 → “AHORA TOCA” + texto anterior
 *  - >= 20:30 → “NO TENGO GANAS DE” + texto anterior
 * 
 * @author Profesor
 */
public class Ejercicio02 {
    public static void main(String[] args) {
        
/* Resultados casos de prueba:
El número de segundos transcurridos son: 7900
Corresponde con las 2 horas y 11 minutos.
AHORA TOCA DORMIR
El número de segundos transcurridos son: 15200
Corresponde con las 4 horas y 13 minutos.
AHORA TOCA DORMIR
El número de segundos transcurridos son: 26940
Corresponde con las 7 horas y 29 minutos.
AHORA TOCA DORMIR
El número de segundos transcurridos son: 27000
Corresponde con las 7 horas y 30 minutos.
AHORA TOCA LEVANTARSE Y DESAYUNAR
El número de segundos transcurridos son: 27060
Corresponde con las 7 horas y 31 minutos.
AHORA TOCA LEVANTARSE Y DESAYUNAR
El número de segundos transcurridos son: 30540
Corresponde con las 8 horas y 29 minutos.
AHORA TOCA LEVANTARSE Y DESAYUNAR
El número de segundos transcurridos son: 30600
Corresponde con las 8 horas y 30 minutos.
AHORA TOCA LEVANTARSE Y DESAYUNAR
El número de segundos transcurridos son: 30660
Corresponde con las 8 horas y 31 minutos.
AHORA TOCA TRABAJAR
El número de segundos transcurridos son: 48540
Corresponde con las 13 horas y 29 minutos.
AHORA TOCA TRABAJAR
El número de segundos transcurridos son: 48600
Corresponde con las 13 horas y 30 minutos.
AHORA TOCA TRABAJAR
El número de segundos transcurridos son: 48660
Corresponde con las 13 horas y 31 minutos.
AHORA TOCA ALMORZAR
El número de segundos transcurridos son: 59340
Corresponde con las 16 horas y 29 minutos.
AHORA TOCA ALMORZAR
El número de segundos transcurridos son: 59400
Corresponde con las 16 horas y 30 minutos.
AHORA TOCA ESTUDIAR
El número de segundos transcurridos son: 59460
Corresponde con las 16 horas y 31 minutos.
AHORA TOCA ESTUDIAR
El número de segundos transcurridos son: 73740
Corresponde con las 20 horas y 29 minutos.
AHORA TOCA ESTUDIAR
El número de segundos transcurridos son: 73800
Corresponde con las 20 horas y 30 minutos.
NO TENGO GANAS DE ESTUDIAR
El número de segundos transcurridos son: 73860
Corresponde con las 20 horas y 31 minutos.
NO TENGO GANAS DE ESTUDIAR
El número de segundos transcurridos son: 79200
Corresponde con las 22 horas y 0 minutos.
NO TENGO GANAS DE ESTUDIAR
El número de segundos transcurridos son: 86398
Corresponde con las 23 horas y 59 minutos.
NO TENGO GANAS DE ESTUDIAR
*/
        
        int[] casosDePrueba
                = {7900,15200, 26940, 27000, 27060, 30540, 30600,30660, 48540,
                    48600, 48660,59340, 59400, 59460, 73740,
                    73800, 73860, 79200, 86398
                };
        
        int segundosTranscurridos=(int)(Math.random()*86400);
        /*for (int i = 0; i < casosDePrueba.length; i++) {
             segundosTranscurridos = casosDePrueba[i];*/

            int minutos = (segundosTranscurridos / 60) % 60;
            int horas = (segundosTranscurridos / 60) / 60;
            System.out.println("El número de segundos transcurridos son: " + segundosTranscurridos);
            System.out.println("Corresponde con las " + horas + " horas y " + minutos + " minutos.");

            String queToca;
            if (horas < 7 || horas == 7 && minutos < 30) {
                queToca = "DORMIR";
            } else if (horas < 8 || horas == 8 && minutos <= 30) {
                queToca = "LEVANTARSE Y DESAYUNAR";
            } else if (horas < 13 || horas == 13 && minutos <= 30) {
                queToca = "TRABAJAR";
            } else if (horas < 16 || horas == 16 && minutos < 30) {
                queToca = "ALMORZAR";
            } else {
                queToca = "ESTUDIAR";
            }

            if (horas < 20 || horas == 20 && minutos < 30) {
                System.out.println("AHORA TOCA " + queToca);
            } else {
                System.out.println("NO TENGO GANAS DE " + queToca);
            }
        //} //for...
    }
}

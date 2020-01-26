package tarea1201920;

/**
 * Al igual que en el apartado 11.4 se definen unidades de medida de volumen, 
 * crea ahora un pequeño programa que defina un enumerado con los nombres de
 * jugadoresde baloncesto: JOHNSON, SCOTT, WORTHY, JABBAR, GREEN, para
 * posteriormente mostrar por pantalla cada valor del enumerado declarado.
 * 
 * @author JJBH
 */
public class Actividad01 {
    
    
    public enum Lakers {JOHNSON, SCOTT, WORTHY, JABBAR, GREEN};
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        //jugador es mejor como variable local
        Lakers jugador;
        
        jugador=Lakers.JOHNSON;
        System.out.println("Jugador 1:" + jugador);
        jugador=Lakers.SCOTT;
        System.out.println("Jugador 2:" + jugador);
        jugador=Lakers.WORTHY;
        System.out.println("Jugador 3:" + jugador);
        jugador=Lakers.JABBAR;
        System.out.println("Jugador 4:" + jugador);
        jugador=Lakers.GREEN;
        System.out.println("Jugador 5:" + jugador);  
    }
    
}

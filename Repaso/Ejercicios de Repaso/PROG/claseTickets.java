
package tests;

import java.time.LocalTime;

/**
 *
 * @author jjmbe
 */
public class Ticket {
    

    private String id_ticket;
    private LocalTime hora;
    

    public Ticket(String id, int hora, int minuto) throws IllegalArgumentException {

        if (hora < 0 || hora > 24 || minuto < 0 || minuto > 60) {

            throw new IllegalArgumentException("La hora o el minuto están mal");
        } else {

            this.id_ticket = id;
            this.hora = LocalTime.of(hora, minuto);
        }
    }

    public Ticket(String id, LocalTime hora) throws IllegalArgumentException {
        this(id, hora.getHour(), hora.getMinute());
    }

    public Ticket(String id) {
        this(id, LocalTime.now().getHour(), LocalTime.now().getMinute());
    }

    public Ticket() {
        random();
    }

    private void random() {
        String cadena = "";
        int hora2, minuto;
        int aleatorio = (int) (Math.random() * ((6 + 1) - 3) + 3);

        for (int i = 0; i < aleatorio; i++) {
            char letraAleatoria = (char) (Math.random() * (('Z' + 1) - 'A') + 'A');
            cadena += String.valueOf(letraAleatoria);
        }

        hora2 = (int) (Math.random() * ((24 - 0) + 0));
        minuto = (int) (Math.random() * ((60 - 0) + 0));

        System.out.printf("Se generará una cadena de %d dígitos%n", aleatorio);
        this.id_ticket = cadena;
        this.hora = LocalTime.of(hora2, minuto);
    }

    public boolean isNocturno() {
        return (this.hora.equals(LocalTime.of(18, 0)) || this.hora.isAfter(LocalTime.of(18, 0)) || this.hora.isBefore(LocalTime.of(6, 0)));
    }

    @Override
    public String toString() {

        String formateada = String.format("id : %s - Hora: %02d:%02d", this.id_ticket, this.hora.getHour(), this.hora.getMinute());

        return formateada;
    }

    //método prueba constructor 3 param
    public static Ticket creaTicket3Param(String id, int hora, int minuto) {
        
        Ticket devuelve = null;
        System.out.printf("Intentamos crear ticket con: %s - Hora: %02d:%02d%n", id, hora, minuto);
        try {
            devuelve = new Ticket(id, hora, minuto);
        } catch (IllegalArgumentException e) {
            System.out.printf("%s.\n", e.getMessage());
        }
        System.out.println("Ticket creado: " + devuelve);
        return devuelve;
    }

    //método de prueba 2 param
    public static Ticket creaTicket2Param(String id, LocalTime hora) {
        
        Ticket devuelve = null;
        System.out.printf("Intentamos crear ticket con: %s - Hora: %s%n", id, hora);
        try {
            devuelve = new Ticket(id, hora);
        } catch (IllegalArgumentException e) {

            System.out.printf("%s.\n", e.getMessage());
        }
        System.out.println("Ticket creado: " + devuelve);
        return devuelve;
    }

    //método de prueba 1 param
    public static Ticket creaTicket1Param(String id) {
        
        Ticket devuelve = null;
        System.out.printf("Intentamos crear ticket con: %s%n", id);
        try {
            devuelve = new Ticket(id);
        } catch (IllegalArgumentException e) {
            System.out.printf("%s.\n", e.getMessage());
        }
        System.out.println("Ticket creado: " + devuelve);
        return devuelve;
    }

    //método de prueba aleatorios
    public static Ticket creaTicketAleatorio() {
        
        Ticket devuelve = null;
        System.out.println("Intentamos crear ticket aleatorio");
        try {
            devuelve = new Ticket();
        } catch (IllegalArgumentException e) {
            System.out.printf("%s.\n", e.getMessage());
        }
        if (devuelve != null && devuelve.isNocturno()) {
            System.out.printf("Ticket creado: %s, es nocturno%n", devuelve);
        } else {
            System.out.printf("Ticket creado: %s, no es nocturno%n", devuelve);
        }
        return devuelve;
    }

    //método de prueba isNocturno
    public static Ticket creaTicket3ParamIsNocturno(String id, int hora, int minuto) {
        
        Ticket devuelve = null;
        try {
            devuelve = new Ticket(id, hora, minuto);
        } catch (IllegalArgumentException e) {
            System.out.printf("%s.\n", e.getMessage());
        }
        if (devuelve != null && devuelve.isNocturno()) {
            System.out.printf("Ticket creado: %s, es nocturno%n", devuelve);
        } else {
            System.out.printf("Ticket creado: %s, no es nocturno%n", devuelve);
        }
        return devuelve;
    }


    /*======================================================*/
    public static void main(String[] args) {

        System.out.println("CASOS DE PRUEBA AUTOMÁTICOS PARA LA CLASE TICKET");
        System.out.println("------------------------------------------------\n\n");
        System.out.println("Casos de prueba para constructor con tres parámetros");

        creaTicket3Param("JUAN", 5, 21);
        creaTicket3Param("JUAN", 11, 50);
        creaTicket3Param("JUAN", 18, 00);
        creaTicket3Param("JUAN", 21, 21);
        creaTicket3Param("JUAN", 23, 59);
        
        System.out.println("------------------------------------------------\n\n");
        System.out.println("Casos de prueba para constructor con dos parámetros");

        creaTicket2Param("ANTONIO", LocalTime.of(5, 21));
        creaTicket2Param("ANTONIO", LocalTime.of(11, 50));
        creaTicket2Param("ANTONIO", LocalTime.of(18, 00));
        creaTicket2Param("ANTONIO", LocalTime.of(21, 00));
        creaTicket2Param("ANTONIO", LocalTime.of(23, 59, 46));

        System.out.println("------------------------------------------------\n\n");
        System.out.println("Casos de prueba para constructor con un parámetro");

        creaTicket1Param("JON");

        System.out.println("------------------------------------------------\n\n");
        System.out.println("Casos de prueba aleatorios");
        
        creaTicketAleatorio();
        creaTicketAleatorio();
        creaTicketAleatorio();
        creaTicketAleatorio();
        creaTicketAleatorio();
        creaTicketAleatorio();

        System.out.println("------------------------------------------------\n\n");
        System.out.println("Casos de prueba para el método isNocturno");
        
        creaTicket3ParamIsNocturno("T1", 5, 59);
        creaTicket3ParamIsNocturno("T2", 6, 0);
        creaTicket3ParamIsNocturno("T3", 17, 59);
        creaTicket3ParamIsNocturno("T4", 18, 00);
    }
}

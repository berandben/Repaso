package tarea2;

/**
 * Ejercicio 3. Estación y mes.
 * 
 * Se generan dos números aleatorios entre 1 y 4, ambos incluidos, y 
 * en base a esos números se muestra el número de mes correspondiente
 * con la estación indicada.
 * 
 * Para ello se tendrá en cuenta que el primer mes, es el mes en el
 * que comienza la estación (aunque comience a mediados de mes),
 * y que el último mes es el mes en el que termina la estación (aunque
 * termine a mediados de mes).
 * 
 * @author Profesor
 */
public class Ejercicio03 {
    public static void main(String[] args) {
        int mes;
        int estacion;
        
        mes=1+(int)(Math.random()*4);
        estacion=1+(int)(Math.random()*4);       
        
        System.out.println("Estación: "+estacion);
        System.out.println("Mes: "+mes);
        
        switch (estacion)
        {
            case 1: 
                System.out.print("El mes "+mes+" de INVIERNO es: ");
                switch(mes)
                {
                    case 1: 
                        System.out.println("DICIEMBRE");
                        break;
                    case 2: 
                        System.out.println("ENERO");
                        break;
                    case 3: 
                        System.out.println("FEBRERO");
                        break;
                    case 4: 
                        System.out.println("MARZO");
                        break;
                }
                break;
            case 2: 
                System.out.print("El mes "+mes+" de PRIMAVERA es: ");
                switch(mes)
                {
                    case 1: 
                        System.out.println("MARZO");
                        break;
                    case 2: 
                        System.out.println("ABRIL");
                        break;
                    case 3: 
                        System.out.println("MAYO");
                        break;
                    case 4: 
                        System.out.println("JUNIO");
                        break;
                }
                break;
            case 3: 
                System.out.print("El mes "+mes+" de VERANO es: ");
                switch(mes)
                {
                    case 1: 
                        System.out.println("JUNIO");
                        break;
                    case 2: 
                        System.out.println("JULIO");
                        break;
                    case 3: 
                        System.out.println("AGOSTO");
                        break;
                    case 4: 
                        System.out.println("SEPTIEMBRE");
                        break;
                }
                break;
            case 4: 
                System.out.print("El mes "+mes+" de OTOÑO es: ");
                switch(mes)
                {
                    case 1: 
                        System.out.println("SEPTIEMBRE");
                        break;
                    case 2: 
                        System.out.println("OCTUBRE");
                        break;
                    case 3: 
                        System.out.println("NOVIEMBRE");
                        break;
                    case 4: 
                        System.out.println("DICIEMBRE");
                        break;
                }
                break;
                
        }
    }
}

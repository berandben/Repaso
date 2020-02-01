public class VaciarRellenar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Paso 0: Creación del array tamaño 4 incializado a 10
        double[] cantidadDepo=new double[]{10,10,10,10};
        int its=10;                                   
       
        //Paso 1: Mostrar el contenido del array usando un bucle y printf
        System.out.printf("Estado inicial -------------------------\n",11-its);
        for (int i=0;i<cantidadDepo.length;i++)      {
            System.out.printf("Depo %d: %.2f \t",i+1,cantidadDepo[i]);                
        }
        System.out.println();
           
        //Paso 2: bucle 10 iteraciones.
        while (its>0)     {
            System.out.printf("Iteración %d -------------------------\n",11-its);
            //Paso 2.1: vaciamos aleatoriamente cada depósito
            for (int i=0;i<cantidadDepo.length;i++)        {

                double cantidad=Math.random()*4;
                System.out.printf("Se sacan %.2f del deposito %d\n",cantidad, i+1);
                if (cantidad>cantidadDepo[i])    {  //verificamos que haya cantidad suficiente
                    cantidadDepo[i]=0;
                }   else     {  
                      cantidadDepo[i]-=cantidad;
                }
            }         
 

           //Paso 2.2: Mostramos cuánto le queda a cada depósito usando printf
            for (int i=0;i<cantidadDepo.length;i++)        {
                System.out.printf("Depo %d: %.2f \t",i+1,cantidadDepo[i]);                
            }
            System.out.println();
           
            //Paso 2.3: Rellenamos aquellos depósitos que estén vacíos
            for (int i=0;i<cantidadDepo.length;i++)      {
                if (cantidadDepo[i]<=0)       {
                    cantidadDepo[i]=10;
                    System.out.printf("Se rellena el depósito %d\n",i+1);
                }
            }
           
            its--;
        }
       
       
    }
   
} 

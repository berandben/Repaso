package pkg201920progtarea05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

// ------------------------------------------------------------
//                   CLASE CuentaBancaria
// ------------------------------------------------------------
/**
 * Clase que representa una <strong>cuenta bancaria</strong>.
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar
 * información sobre:</p>
 * <ul>
 * <li><strong>Identificador</strong> de la cuenta. Este valor se establecerá
 * al crear la cuenta y ya no podrá cambiar. Es un valor constante.</li>
 * <li><strong>Fecha de creacion</strong> de la cuenta. Es también un valor
 * constante. Se establecerá al crear la cuenta y ya no podrá cambiar su valor.</li>
 * <li><strong>Porcentaje de embargo</strong> de la cuenta.</li>
 * <li><strong>Saldo actual</strong> de la cuenta.</li>
 * <li><strong>Saldo máximo</strong> que ha tenido la cuenta a lo largo de su
 * historia.</li>
 * <li><strong>Ingresos totales</strong> que ha tenido la cuenta a lo largo de
 * su historia.</li>
 * </ul>
 * <p>
 * La clase también dispone de información general independiente de los objetos
 * concretos que se hayan creado. Es el caso de:</p>
 * <ul>
 * <li><strong>Saldo global</strong> entre todas las cuentas en el momento
 * actual.</li>
 * <li><strong>Número de cuentas embargadas</strong> en el momento actual.</li>
 * <li><strong>Fecha de creación</strong> de la <strong>cuenta más moderna</strong>
 * creada hasta el momento actual.</li>
 * </ul>
 *
 * @author profe
 */
public class CuentaBancaria {

    // ------------------------------------------------------------
    //                 ATRIBUTOS ESTÁTICOS (de clase)
    // ------------------------------------------------------------
    // Atributos estáticos constantes públicos (rangos y requisitos de los atributos de objeto)
    // Son públicos, para que cualquier código cliente pueda acceder a ellos
    /**
     * Descubierto máximo permitido al crear una cuenta : {@value MAX_DESCUBIERTO} euros.
     */
    public static final double MAX_DESCUBIERTO = -2_000.00;   // euros 
    /**
     * Embargo mínimo de una cuenta : {@value MIN_EMBARGO}%.
     */
    public static final double MIN_EMBARGO = 0.00;   // porcentaje 
    /**
     * Embargo máximo de una cuenta: {@value MAX_EMBARGO} %.
     */
    public static final double MAX_EMBARGO = 100.00;   // porcentaje 
    /**
     * Año mínimo para la creación de una cuenta: {@value MIN_YEAR}.
     */
    public static final int MIN_YEAR = 1900;   // año 
    /**
     * Saldo máximo para una cuenta: {@value MAX_SALDO} euros.
     */
    public static final double MAX_SALDO = 50_000_000.00;   // euros 

    /**
     * Saldo inicial por omisión para una cuenta: {@value DEFAULT_SALDO} euros.
     */
    public static final double DEFAULT_SALDO = 0.00;   // euros 

    /**
     * Límite de descubierto por omisión para una cuenta: {@value DEFAULT_MAX_DESCUBIERTO} euros.
     */
    public static final double DEFAULT_MAX_DESCUBIERTO = 0.00;   // euros 

    // Atributos estáticos variables (privados: "estado" de la clase en global)
    private static double saldoGlobal;         // Saldo actual suma de todas las cuentas
    private static LocalDate fechaMasModerna;  // Fecha de la cuenta más moderna
    private static int numCuentasEmbargadas;   // Número de cuentas embargadas actualmente

    private static int nextId = 0;             // Id disponible para crear la siguiente cuenta 

    // ------------------------------------------------------------
    //                ATRIBUTOS DE OBJETO (privados)
    // ------------------------------------------------------------
    // Atributos de objeto constantes durante la vida de la cuenta (desde que se crea la cuenta)
    // No hace falta declararlas como variables pues no van a cambiar una vez creado el objeto.
    // Representan "características inmutables" o "de naturaleza" del objeto.
    private final long ID_CUENTA;                   // Id de cuenta
    private final LocalDate FECHA_CREACION;         // Fecha de creación de la cuenta
    private final double LIMITE_DESCUBIERTO;        // Límite de descubierto en cuenta

    // Atributos de objeto variables
    // Representan el "estado" del objeto en un instante dado.
    private double saldo;                  // Saldo actual de la cuenta (euros)
    private double porcentajeEmbargo;      // Porcentaje de embargo actual
    private double saldoMaximoHistorico;   // Máximo saldo que ha tenido la cuenta desde su creación
    private double totalIngresado;         // Cantidad total ingresada la cuenta desde su creación 

    // ------------------------------------------------------------
    //                        CONSTRUCTORES
    // ------------------------------------------------------------
    /**
     * Constructor con tres parámetros
     * @param saldoInicial Saldo inicial de la cuenta (en euros)
     * @param fechaCreacion Fecha de creación de la cuenta
     * @param limiteDescubierto Límite de descubierto de lacuenta (en euros)
     * @throws IllegalArgumentException Si alguno de los parámetros no es válido
     */
    public CuentaBancaria(double saldoInicial, LocalDate fechaCreacion, double limiteDescubierto) throws IllegalArgumentException {
        // Comprobación de que los parámetros son válidos
        // Si alguno de los parámetros de creación no es válido:
        // no se crea el objeto y se lanza una excepción
        if (saldoInicial < 0 || saldoInicial > CuentaBancaria.MAX_SALDO) { // Saldo inicial no válido: se lanza una excepción.
            throw new IllegalArgumentException(String.format("Error: Parámetros de creación de la cuenta inválidos. Saldo inicial: %.2f", saldoInicial));
        } else if (fechaCreacion == null
                || fechaCreacion.getYear() < CuentaBancaria.MIN_YEAR || fechaCreacion.isAfter(LocalDate.now())) { // Fecha de creación no válida: se lanza una excepción.
            throw new IllegalArgumentException(String.format("Error: Parámetros de creación de la cuenta inválidos. Fecha de creación no válida: %s",
                    fechaCreacion == null ? null : fechaCreacion.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        } else if (limiteDescubierto < CuentaBancaria.MAX_DESCUBIERTO || limiteDescubierto > 0.0) { // Máximo descubierto no válido: se lanza una excepción.        
            throw new IllegalArgumentException(String.format("Error: Parámetros de creación de la cuenta inválidos. Máximo descubierto: %.2f", limiteDescubierto));
        } else {
            // Los valores de los parámetros son válidos, así que construimos el objeto

            // Inicialización de los atributos constantes (características "inmutables" del objeto)
            this.FECHA_CREACION = fechaCreacion;
            this.LIMITE_DESCUBIERTO = limiteDescubierto;
            this.ID_CUENTA = CuentaBancaria.nextId;

            // Inicialización de los atributos variables de objeto ("estado" del objeto)           
            this.saldo = 0;
            this.porcentajeEmbargo = 0.0;
            this.saldoMaximoHistorico = this.saldo;
            this.totalIngresado = 0;

            // Actualización de los atributos variables de clase (estáticos)
            CuentaBancaria.nextId++;
            ingresar(saldoInicial);
            if (CuentaBancaria.fechaMasModerna != null) {
                if (this.FECHA_CREACION.isAfter(CuentaBancaria.fechaMasModerna)) {
                    CuentaBancaria.fechaMasModerna = this.FECHA_CREACION;
                }
            } else { // Si es la primera cuenta que se crea, pasa a ser la más moderna
                CuentaBancaria.fechaMasModerna = this.FECHA_CREACION;
            }
        }
    }

    /**
     * Constructor con dos parámetros.
     * Se crea una cuenta con un límite de descubierto de {@value DEFAULT_MAX_DESCUBIERTO} euros.
     * @param saldoInicial Saldo inicial de la cuenta (en euros)
     * @param fechaCreacion Fecha de creación de la cuenta
     * @throws IllegalArgumentException Si alguno de los parámetros no es válido
     */
    public CuentaBancaria(double saldoInicial, LocalDate fechaCreacion) throws IllegalArgumentException {
        this(saldoInicial, fechaCreacion, CuentaBancaria.DEFAULT_MAX_DESCUBIERTO);
    }
    
    /**
     * Constructor con un parámetro.     
     * Se crea una cuenta con un límite de descubierto de {@value DEFAULT_MAX_DESCUBIERTO} euros
     * y la fecha actual como fecha de creación de la cuenta.
     * @param saldoInicial Saldo inicial de la cuenta (en euros)
     * @throws IllegalArgumentException Si alguno de los parámetros no es válido
     */
    public CuentaBancaria(double saldoInicial) throws IllegalArgumentException {
        this(saldoInicial, LocalDate.now());
    }

    /**
     * Constructor sin parámetros.
     * Se crea una cuenta con un límite de descubierto de {@value DEFAULT_MAX_DESCUBIERTO} euros,
     * la fecha actual como fecha de creación de la cuenta y un saldo inicial de {@value DEFAULT_SALDO} euros.
     */
    public CuentaBancaria() {
        this(CuentaBancaria.DEFAULT_SALDO);
    }

    // ------------------------------------------------------------
    //                 Getters:  Métodos GET
    // ------------------------------------------------------------
    /**
     * Obtiene el identificador de la cuenta
     * @return identificador de la cuenta
     */
    public long getId() {
        return this.ID_CUENTA;
    }

    /**
     * Obtiene el saldo actual de la cuenta
     * @return saldo actual de la cuenta
     */
    public double getSaldo() {
        return this.saldo;
    }

    /**
     * Obtiene la fecha de creación de la cuenta
     * @return fecha de creación de la cuenta
     */
    public LocalDate getFechaCreacion() {
        return this.FECHA_CREACION;
    }

    /**
     * Obtiene el límite de descubierto de la cuenta
     * @return límite de descubierto de la cuenta
     */
    public double getLimiteDescubierto() {
        return this.LIMITE_DESCUBIERTO;
    }

    /**
     * Obtiene el porcentaje de embargo de la cuenta
     * @return porcentaje de embargo de la cuenta
     */
    public double getPorcentajeEmbargo() {
        return this.porcentajeEmbargo;
    }

    /**
     * Indica si la cuenta está en descubierto (saldo negativo)
     * @return la cuenta está en descubierto
     */
    public boolean isDescubierta() {
        return this.saldo < 0;
    }

    /**
     * Indica si la cuenta está embargada
     * @return la cuenta está embargada
     */
    public boolean isEmbargada() {
        return this.porcentajeEmbargo > 0;
    }

    /**
     * Obtiene la antigüedad de la cuenta en días
     * @return antigüedad de la cuenta (número de días)
     */
    public long getDiasCuenta() {
        return this.FECHA_CREACION.until(LocalDate.now(), ChronoUnit.DAYS) + 1;
    }

    /**
     * Obtiene el máximo saldo que ha llegado a tener la cuenta
     * @return máximo saldo de la cuenta
     */
    public double getSaldoMaximo() {
        return this.saldoMaximoHistorico;
    }

    /**
     * Obtiene la cantidad total que se ha ingresado en la cuenta hasta el momento
     * @return cantidad total ingresada en la cuenta
     */
    public double getTotalIngresado() {
        return this.totalIngresado;
    }

    // Métodos "get" de clase (estáticos)
    /**
     * Obtiene el saldo global total entre todas las cuentas
     * @return saldo global total
     */
    public static double getSaldoGlobal() {
        return CuentaBancaria.saldoGlobal;
    }

    /**
     * Obtiene la fecha de la cuenta más moderna creada hasta el momento (fecha más reciente)
     * @return fecha más moderna de creación de una cuenta
     */
    public static LocalDate getFechaMasModerna() {
        return CuentaBancaria.fechaMasModerna;
    }

    /**
     * Obtiene el número de cuentas embargadas en el momento actual
     * @return número de cuentas embargadas
     */
    public static int getNumCuentasEmbargadas() {
        return CuentaBancaria.numCuentasEmbargadas;
    }

    // ------------------------------------------------------------
    //                 Setters:  Métodos SET
    // ------------------------------------------------------------
    /**
     * Embargo de una cuenta
     * @param porcentajeEmbargo Porcentaje de embargo (mayor que 0.00 y hasta 100.0 como máximo)
     * @throws IllegalArgumentException Si el porcentaje de embargo no es válido
     * @throws IllegalStateException Si la cuenta ya estaba embargada
     */
    public void embargar(double porcentajeEmbargo) throws IllegalArgumentException, IllegalStateException {
        if (this.isEmbargada()) {
            throw new IllegalStateException("Error: La cuenta ya está embargada");
        } else if (porcentajeEmbargo <= MIN_EMBARGO || porcentajeEmbargo > MAX_EMBARGO) {
            throw new IllegalArgumentException(String.format("Error: Porcentaje de embargo no válido: %.1f%%", porcentajeEmbargo));
        } else {  // El embargo esposible
            // Actualización de los atributos de objeto
            this.porcentajeEmbargo = porcentajeEmbargo;

            // Actualización de los atributos de clase
            CuentaBancaria.numCuentasEmbargadas++;
        }
    }

    /**
     * Desembarga una cuenta. Pone a cero el porcentaje de embargo de la cuenta.
     * @return true si la cuenta estaba embargada y ha sido desembargada. O bien 
     * false si la cuenta no estaba embargada.
     */
    public boolean desembargar() {
        boolean resultado = true;
        if (porcentajeEmbargo > 0) {
            // La cuenta estaba embargada
            // Actualización de los atributos de objeto
            this.porcentajeEmbargo = 0;
            // Actualización de los atributos de clase
            CuentaBancaria.numCuentasEmbargadas--;
        } else {
            // La cuenta no estaba embargada
            resultado = false;
        }
        return resultado;
    }

    // ------------------------------------------------------------
    //                 Métodos de "ACCIÓN"
    // ------------------------------------------------------------
    /**
     * Ingresa una determinada cantidad en la cuenta.
     * Se permiten ingresos de 0.00 euros.
     * @param cantidad Cantidad que se desea ingresar (en euros). Se permite ingresar 0.00 euros.
     * @throws IllegalArgumentException Si la cantidad de ingreso es inválida (negativa).
     * @throws IllegalStateException  Si con ese ingreso se superaría el saldo máximo. En tal caso no se llevaría a cabo el ingreso.
     */
    public void ingresar(double cantidad) throws IllegalArgumentException, IllegalStateException {
        if (cantidad < 0) {  // Valor inválido
            throw new IllegalArgumentException(String.format("Error: cantidad de ingreso no válida: %.2f", cantidad));
        } else {
            // Calculamos el posible embargo
            double cantidadEmbargada = cantidad * this.porcentajeEmbargo / 100;
            // Comprobamos que el saldo final no superaría el saldo máximo permitido
            // La comprobación se hace con embargo, 
            // pues primero se embarga y luego se ingresa
            if (this.saldo + cantidad - cantidadEmbargada > CuentaBancaria.MAX_SALDO) { 
                throw new IllegalStateException(String.format("Error: saldo máximo superado con este ingreso: %.2f", this.saldo + cantidad));
            } else { // El ingeso es posible: actualización del estado del objeto
                // Actualización de atributos

                // Cálculo del ingreso final restando el posible embargo
                this.saldo += cantidad - cantidadEmbargada;

                // Actualización de atributos de objeto históricos
                this.totalIngresado += cantidad - cantidadEmbargada;
                this.saldoMaximoHistorico = Math.max(this.saldo, this.saldoMaximoHistorico);

                // Actualización de atributos de clase
                CuentaBancaria.saldoGlobal += cantidad - cantidadEmbargada;

            }
        }
    }
    
    /**
     * Extrae una determinada cantidad de la cuenta.
     * Se permiten extracciones de 0.00 euros.
     * @param cantidad Cantidad que se desea extraer (en euros).  Se permite extraer 0.00 euros.
     * @throws IllegalArgumentException Si la cantidad a extraer no es válida (negativa).
     * @throws IllegalStateException Si el saldo obtenido al realizar la extracción superara el límite de descubierto. En tal caso no se llevaría a cabo la extracción.
     */
    public void extraer(double cantidad) throws IllegalArgumentException, IllegalStateException {
        if (cantidad < 0) {  // Valor inválido
            throw new IllegalArgumentException(String.format("Error: cantidad de extracción no válida: %.2f", cantidad));
        } else {  // Comprobamos que no se supera el descubierto máximo
            if (this.saldo - cantidad < this.LIMITE_DESCUBIERTO) {
                throw new IllegalStateException(String.format("Error: descubierto máximo superado con esta extracción: %.2f", this.saldo - cantidad));
            } else {
                // Actualización de atributos de objeto
                this.saldo -= cantidad;

                // Actualización atributos de clase 
                CuentaBancaria.saldoGlobal -= cantidad;
            }
        }
    }

    /**
     * Transfiere una determinada cantidad (en euros) a otra cuenta.
     * Se permiten transferencias de 0.0 euros.
     * @param cantidad Cantidad que se desea transferir (en euros).
     * @param destino Cuenta a la que se desea transferir la cantidad. Se permiten transferencias de 0.0 euros.
     * @throws IllegalArgumentException Si la cuenta de destino no es válida (null) o si la cantidad a transferir no es válida (negativa).
     * @throws IllegalStateException Si la cuenta de origen supera el límite de descubierto de la cuenta si se llevara a cabo la transferencia o bien si 
     * si se supera el saldo máximo en la cuenta de destino.
     */
    public void transferir(double cantidad, CuentaBancaria destino) throws IllegalArgumentException, IllegalStateException {

        if (destino == null) {
            throw new IllegalArgumentException("Error: cuenta de destino no válida");
        } else {
            // La cuenta de destino es correcta
            // Intentamos extraer la cantidad de la cuenta origen
            try {
                this.extraer(cantidad);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(String.format("Error: cantidad a transferir no válida: %.2f", cantidad));
            } catch (IllegalStateException e) {
                throw new IllegalStateException(String.format("Error: cantidad no disponible en cuenta origen: %.2f", cantidad));
            }

            // Una vez extraida la cantidad, intentamos hacer el ingreso en la cuenta destino
            try {
                destino.ingresar(cantidad);
            } catch (IllegalStateException e) {
                // Si no se ha podido hacer el ingreso en la cuenta destino:
                // Deshacemos lo que se haya hecho en el método "extraer"
                
                // Reingresamos la cantidad extraida de la cuenta origen
                this.saldo += cantidad; // ¿Por qué no usamos "ingresar"? Para evitar un posible doble embargo

                // Deshacemos la actualización atributos de clase 
                CuentaBancaria.saldoGlobal += cantidad;

                throw new IllegalStateException(String.format("Error: saldo máximo de cuenta destino superado con esta transferencia: %.2f",
                        destino.getSaldo() + cantidad - cantidad*destino.getPorcentajeEmbargo()/100));
            }
        }
    }

    
    /**
     * Transfiere el saldo completo de una cuenta a otra cuenta.
     * Si la cuenta de origen está en descubierto, entonces se transferirán 0.0 euros.
     * @param destino Cuenta a la que se desea transferir la cantidad.
     * @throws IllegalArgumentException Si la cuenta de destino no es válida (null) o si la cantidad a transferir no es válida (negativa).
     * @throws IllegalStateException Si la cuenta de origen supera el límite de descubierto de la cuenta si se llevara a cabo la transferencia o bien si 
     * si se supera el saldo máximo en la cuenta de destino.
     */
    public void transferir(CuentaBancaria destino) throws IllegalArgumentException, IllegalStateException {
        // Aseguramos que si la cuenta está en "descubierto", se transfieran 0.0 euros
        double cantidadTransferir = 0.0;
        if (this.saldo >= 0.0) {
            cantidadTransferir = this.saldo;
        }

        transferir(cantidadTransferir, destino);
    }

    // MÉTODOS PARA MOSTRAR INFORMACIÓN
    // --------------------------------
    // Método toString
    /**
     * Devuelve una cadena que representa el estado actual de la cuenta. Esa
     * cadena proporcionará la siguiente información:
     * <ol>
     * <li><strong>Identificador</strong> de la cuenta.</li>
     * <li><strong>Saldo actual</strong> de la cuenta.</li>
     * <li>Si la cuenta está o no <strong>embargada</strong>.</li>
     * </ol>
     * <p>
     * <strong>El formato de salida</strong> será del siguiente tipo: </p>
     * <pre>Id: XXX - Saldo: YYYYYYYY.YY - Embargada: sí|no [ZZZ.Z%]</pre>
     * <p>
     * donde XXX será el identificador de la cuenta(número entero); YYYYYYYY.YY
     * será el saldo actual en euros, con dos decimales, con una anchura para
     * poder representar el máximo saldo de 50000000.00 euros; ZZZ.Z será el
     * porcentaje actual de embargo de la cuenta con una anchura de 5
     * caracteres, y con un decimal, si es que está embargada. Si no lo está, no
     * aparecerá información de porcentaje. Simplemente aparecerá "no".</p>
     * <p>
     * Algunos ejemplos de este <code>String</code> de salida podrían ser:</p>
     * <pre>Id: 0 - Saldo: 50000000,00 - Embargada: no</pre>
     * <pre>Id: 0 - Saldo:        0,00 - Embargada: no</pre>
     * <pre>Id: 0 - Saldo:    -2000,00 - Embargada: no</pre>
     * <pre>Id: 1 - Saldo:     5000,00 - Embargada: sí  25,0%</pre>
     * <pre>Id: 1 - Saldo:     3750,00 - Embargada: sí  50,0%</pre>
     * <pre>Id: 3 - Saldo:        0,00 - Embargada: sí 100,0%</pre>
     *
     * @return
     * <p>
     * Cadena que representa el estado actual de la cuenta.</p>
     */
    @Override
    public String toString() {
        // La cadena se irá construyendo sobre un objeto StringBuilder
        // El uso de StringBuilder consume menos recursos que el uso de Strings
        String sep1 = " - ";
        StringBuilder resultado = new StringBuilder();

        resultado.append("Id: ");
        resultado.append(String.format("%d", this.ID_CUENTA));
        resultado.append(sep1);

        resultado.append("Saldo: ");
        resultado.append(String.format("%11.2f", this.saldo));
        resultado.append(sep1);

        resultado.append("Embargada: ");
        resultado.append(String.format("%s", this.isEmbargada() ? "sí "
                + String.format("%5.1f%%", this.porcentajeEmbargo) : "no"));

        // Devolvemos la cadena construida*/
        return resultado.toString();
    }

}

package Logica.Autobuses;

import Logica.Asiento;
import Logica.HoraSalida;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Clase que representa el autobús Mewing Mobility.
 * Extiende de la clase abstracta Autobus.
 */
public class MewingMobility extends Autobus {

    /**
     * Constructor de la clase MewingMobility.
     * @param horaSalida Objeto HoraSalida que especifica la hora de salida del autobús.
     */
    public MewingMobility(HoraSalida horaSalida) {
        this.company = "Mewing Mobility";
        this.nPisos = "1";
        this.horaSalida = horaSalida.getTiempo();

        // Creación de los asientos del primer piso
        asientosPrimerPiso = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            asientosPrimerPiso.add(new Asiento(i + 1, false));
        }

        // El segundo piso es null porque este autobús solo tiene un piso
        asientosSegundoPiso = null;
    }

    /**
     * Retorna el precio del asiento normal en el autobús Mewing Mobility.
     * @return Precio del asiento normal en este autobús.
     */
    @Override
    public int getPrecioAsientoNormal() {
        return 8000; // Precio fijo para el asiento normal en este autobús
    }

    /**
     * Retorna el precio del asiento VIP en el autobús Mewing Mobility.
     * @return Precio del asiento VIP (siempre retorna 0 ya que no hay asientos VIP en este autobús).
     */
    @Override
    public int getPrecioAsientoVIP() {
        return 0; // No hay asientos VIP en este autobús, por lo tanto, precio 0
    }

    /**
     * Retorna la hora de llegada estimada para el autobús Mewing Mobility.
     * @return Hora de llegada estimada al destino (siempre retorna null ya que la hora de llegada no está implementada para este autobús).
     */
    @Override
    public LocalTime getHoraLlegada() {
        return null; // La hora de llegada no está implementada para este autobús
    }
}

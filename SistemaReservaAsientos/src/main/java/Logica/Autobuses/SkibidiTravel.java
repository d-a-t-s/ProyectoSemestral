package Logica.Autobuses;

import Logica.Asiento;
import Logica.HoraSalida;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Clase que representa el autobús Skibidi Travel.
 * Extiende de la clase abstracta Autobus.
 */
public class SkibidiTravel extends Autobus {

    /**
     * Constructor de la clase SkibidiTravel.
     * @param horaSalida Objeto HoraSalida que especifica la hora de salida del autobús.
     */
    public SkibidiTravel(HoraSalida horaSalida) {
        this.company = "Skibidi Travel";
        this.nPisos = "1";
        this.horaSalida = horaSalida.getTiempo();

        // Creación de los asientos del primer piso
        asientosPrimerPiso = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            asientosPrimerPiso.add(new Asiento(i + 1, false));
        }

        // Como este autobús tiene solo un piso, el segundo piso se inicializa como null
        asientosSegundoPiso = null;
    }

    /**
     * Retorna el precio del asiento normal en el autobús Skibidi Travel.
     * @return Precio del asiento normal en este autobús.
     */
    @Override
    public int getPrecioAsientoNormal() {
        return 10000; // Precio fijo para el asiento normal en este autobús
    }

    /**
     * Retorna el precio del asiento VIP en el autobús Skibidi Travel.
     * @return En este autobús no hay asientos VIP, por lo tanto el precio es 0.
     */
    @Override
    public int getPrecioAsientoVIP() {
        return 0; // En este autobús no hay asientos VIP, por lo tanto el precio es 0
    }

    /**
     * Retorna la hora de llegada estimada para el autobús Skibidi Travel.
     * @return Hora de llegada estimada al destino (siempre retorna null ya que la hora de llegada no está implementada para este autobús).
     */
    @Override
    public LocalTime getHoraLlegada() {
        return null; // La hora de llegada no está implementada para este autobús
    }
}

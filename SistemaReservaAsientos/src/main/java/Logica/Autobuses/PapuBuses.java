package Logica.Autobuses;

import Logica.Asiento;
import Logica.HoraSalida;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Clase que representa el autobús Papu Buses.
 * Extiende de la clase abstracta Autobus.
 */
public class PapuBuses extends Autobus {

    /**
     * Constructor de la clase PapuBuses.
     * @param horaSalida Objeto HoraSalida que especifica la hora de salida del autobús.
     */
    public PapuBuses(HoraSalida horaSalida) {
        this.company = "Papu Buses";
        this.nPisos = "2";
        this.horaSalida = horaSalida.getTiempo();

        // Creación de los asientos del primer piso
        asientosPrimerPiso = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            asientosPrimerPiso.add(new Asiento(i + 1, false));
        }

        // Creación de los asientos del segundo piso (VIP)
        asientosSegundoPiso = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            asientosSegundoPiso.add(new Asiento(i + 17, true));
        }
    }

    /**
     * Retorna el precio del asiento normal en el autobús Papu Buses.
     * @return Precio del asiento normal en este autobús.
     */
    @Override
    public int getPrecioAsientoNormal() {
        return 18000; // Precio fijo para el asiento normal en este autobús
    }

    /**
     * Retorna el precio del asiento VIP en el autobús Papu Buses.
     * @return Precio del asiento VIP en este autobús.
     */
    @Override
    public int getPrecioAsientoVIP() {
        return 20000; // Precio fijo para el asiento VIP en este autobús
    }

    /**
     * Retorna la hora de llegada estimada para el autobús Papu Buses.
     * @return Hora de llegada estimada al destino (siempre retorna null ya que la hora de llegada no está implementada para este autobús).
     */
    @Override
    public LocalTime getHoraLlegada() {
        return null; // La hora de llegada no está implementada para este autobús
    }
}

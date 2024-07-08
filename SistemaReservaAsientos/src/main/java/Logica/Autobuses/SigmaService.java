package Logica.Autobuses;

import Logica.Asiento;
import Logica.HoraSalida;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Clase que representa el autobús Sigma Service.
 * Extiende de la clase abstracta Autobus.
 */
public class SigmaService extends Autobus {

    /**
     * Constructor de la clase SigmaService.
     * @param horaSalida Objeto HoraSalida que especifica la hora de salida del autobús.
     */
    public SigmaService(HoraSalida horaSalida) {
        this.company = "Sigma Service";
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
     * Retorna el precio del asiento normal en el autobús Sigma Service.
     * @return Precio del asiento normal en este autobús.
     */
    @Override
    public int getPrecioAsientoNormal() {
        return 12000; // Precio fijo para el asiento normal en este autobús
    }

    /**
     * Retorna el precio del asiento VIP en el autobús Sigma Service.
     * @return En este autobús no hay asientos VIP, por lo tanto el precio es 0.
     */
    @Override
    public int getPrecioAsientoVIP() {
        return 0; // En este autobús no hay asientos VIP, por lo tanto el precio es 0
    }

    /**
     * Retorna la hora de llegada estimada para el autobús Sigma Service.
     * @return Hora de llegada estimada al destino (siempre retorna null ya que la hora de llegada no está implementada para este autobús).
     */
    @Override
    public LocalTime getHoraLlegada() {
        return null; // La hora de llegada no está implementada para este autobús
    }
}

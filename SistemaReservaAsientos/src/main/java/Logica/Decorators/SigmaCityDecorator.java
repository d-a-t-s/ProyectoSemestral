package Logica.Decorators;

import Logica.Autobuses.Autobus;
import Logica.TipoDestino;

import java.time.LocalTime;

/**
 * Decorador concreto para el destino "Sigma City".
 * Extiende de BusDecorator.
 */
public class SigmaCityDecorator extends BusDecorator {

    /**
     * Constructor del decorador para el destino "Sigma City".
     * @param bus Autobús sobre el cual se aplica el decorador.
     */
    public SigmaCityDecorator(Autobus bus) {
        super(bus);
        bus.setDestino("Sigma City"); // Establece el destino como "Sigma City"
        this.destino = bus.getDestino(); // Actualiza el destino del decorador
    }

    /**
     * Obtiene el precio del asiento normal para el autobús decorado.
     * @return Precio del asiento normal incrementado.
     */
    @Override
    public int getPrecioAsientoNormal() {
        // Añade un incremento al precio del asiento normal
        return bus.getPrecioAsientoNormal() + 15000;
    }

    /**
     * Obtiene el precio del asiento VIP para el autobús decorado.
     * @return Precio del asiento VIP incrementado o 0 si no hay segundo piso.
     */
    @Override
    public int getPrecioAsientoVIP() {
        if (bus.getAsientosSegundoPiso() == null) {
            return 0; // Si no hay segundo piso, el precio VIP es 0
        } else {
            // Añade un incremento al precio del asiento VIP
            return bus.getPrecioAsientoVIP() + 15000;
        }
    }

    /**
     * Obtiene la hora de llegada estimada para el autobús decorado.
     * @return Hora de llegada estimada sumando el tiempo específico del destino.
     */
    @Override
    public LocalTime getHoraLlegada() {
        // Calcula la hora de llegada sumando el tiempo específico del destino
        LocalTime aux = bus.getHoraSalida();
        return aux.plusHours(TipoDestino.SIGMACITY.getTiempo());
    }
}

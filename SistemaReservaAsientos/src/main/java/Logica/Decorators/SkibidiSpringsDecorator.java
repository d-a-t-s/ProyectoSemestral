package Logica.Decorators;

import Logica.Autobuses.Autobus;
import Logica.TipoDestino;

import java.time.LocalTime;

/**
 * Decorador concreto para el destino "Skibidi Springs".
 * Extiende de BusDecorator.
 */
public class SkibidiSpringsDecorator extends BusDecorator {

    /**
     * Constructor del decorador para el destino "Skibidi Springs".
     * @param bus Autobús sobre el cual se aplica el decorador.
     */
    public SkibidiSpringsDecorator(Autobus bus) {
        super(bus);
        bus.setDestino("Skibidi Springs"); // Establece el destino como "Skibidi Springs"
        this.destino = bus.getDestino(); // Actualiza el destino del decorador
    }

    /**
     * Obtiene el precio del asiento normal para el autobús decorado.
     * @return Precio del asiento normal incrementado.
     */
    @Override
    public int getPrecioAsientoNormal() {
        // Añade un incremento al precio del asiento normal
        return bus.getPrecioAsientoNormal() + 20000;
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
            return bus.getPrecioAsientoVIP() + 20000;
        }
    }

    /**
     * Obtiene la hora de llegada estimada para el autobús decorado.
     * @return Hora de llegada estimada sumando el tiempo específico del destino "Skibidi Springs".
     */
    @Override
    public LocalTime getHoraLlegada() {
        // Calcula la hora de llegada sumando el tiempo específico del destino "Skibidi Springs"
        LocalTime aux = bus.getHoraSalida();
        return aux.plusHours(TipoDestino.SKIBIDISPRINGS.getTiempo());
    }
}

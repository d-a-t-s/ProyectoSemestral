package Logica.Decorators;

import Logica.Autobuses.Autobus;
import Logica.TipoDestino;

import java.time.LocalTime;

/**
 * Decorador concreto para el destino "Tilin Town".
 * Extiende de BusDecorator.
 */
public class TilinTownDecorator extends BusDecorator {

    /**
     * Constructor del decorador TilinTownDecorator.
     * @param bus Autobús base que se decorará.
     */
    public TilinTownDecorator(Autobus bus) {
        super(bus);
        bus.setDestino("Tilin Town"); // Establece el destino como "Tilin Town"
        this.destino = bus.getDestino(); // Actualiza el destino del decorador
    }

    /**
     * Retorna el precio del asiento normal decorado con un incremento específico para "Tilin Town".
     * @return Precio del asiento normal decorado.
     */
    @Override
    public int getPrecioAsientoNormal() {
        // Añade un incremento al precio del asiento normal
        return bus.getPrecioAsientoNormal() + 10000;
    }

    /**
     * Retorna el precio del asiento VIP decorado con un incremento específico para "Tilin Town".
     * Si no hay segundo piso, el precio VIP es 0.
     * @return Precio del asiento VIP decorado.
     */
    @Override
    public int getPrecioAsientoVIP() {
        if (bus.getAsientosSegundoPiso() == null) {
            return 0; // Si no hay segundo piso, el precio VIP es 0
        } else {
            // Añade un incremento al precio del asiento VIP
            return bus.getPrecioAsientoVIP() + 10000;
        }
    }

    /**
     * Calcula la hora de llegada sumando el tiempo específico del destino "Tilin Town" a la hora de salida.
     * @return Hora de llegada estimada al destino "Tilin Town".
     */
    @Override
    public LocalTime getHoraLlegada() {
        // Calcula la hora de llegada sumando el tiempo específico del destino "Tilin Town"
        LocalTime aux = bus.getHoraSalida();
        return aux.plusHours(TipoDestino.TILINTOWN.getTiempo());
    }
}

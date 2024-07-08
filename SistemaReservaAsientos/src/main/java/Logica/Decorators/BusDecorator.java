package Logica.Decorators;

import Logica.Autobuses.Autobus;

import java.time.LocalTime;

/**
 * Clase abstracta que sirve como base para decoradores de autobuses.
 * Extiende de la clase abstracta Autobus.
 */
public class BusDecorator extends Autobus {

    // Propiedades
    protected Autobus bus;

    /**
     * Constructor de la clase BusDecorator.
     * @param bus Autobus sobre el cual se aplica el decorador.
     */
    public BusDecorator(Autobus bus) {
        this.bus = bus;
        this.horaSalida = bus.getHoraSalida();
        this.company = bus.getCompany();
        this.destino = bus.getDestino();
        this.nPisos = bus.getnPisos();
        this.asientosPrimerPiso = bus.getAsientosPrimerPiso();
        this.asientosSegundoPiso = bus.getAsientosSegundoPiso();
    }

    /**
     * Obtiene el precio del asiento normal para el autobús decorado.
     * @return Precio del asiento normal.
     */
    @Override
    public int getPrecioAsientoNormal() {
        return bus.getPrecioAsientoNormal();
    }

    /**
     * Obtiene el precio del asiento VIP para el autobús decorado.
     * @return Precio del asiento VIP.
     */
    @Override
    public int getPrecioAsientoVIP() {
        return bus.getPrecioAsientoVIP();
    }

    /**
     * Obtiene la hora de llegada estimada para el autobús decorado.
     * @return Hora de llegada estimada (suponiendo que es la misma que la hora de salida para el decorador base).
     */
    @Override
    public LocalTime getHoraLlegada() {
        return bus.getHoraSalida(); // Suponiendo que la hora de llegada es la misma que la hora de salida para el decorador base
    }

}

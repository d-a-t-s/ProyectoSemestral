package Logica.Decorators;

import Logica.Autobuses.Autobus;

import java.time.LocalTime;

public class BusDecorator extends Autobus {
    //Propiedades
    protected Autobus bus;
    //Constructor
    public BusDecorator(Autobus bus){
        this.bus = bus;
        this.horaSalida = bus.getHoraSalida();
        this.company = bus.getCompany();
        asientosPrimerPiso = bus.getAsientosPrimerPiso();
        asientosSegundoPiso = bus.getAsientosSegundoPiso();
    }
    //Metodos
    @Override
    public int getPrecioAsientoNormal(){
        return bus.getPrecioAsientoNormal();
    }
    @Override
    public int getPrecioAsientoVIP(){
        return bus.getPrecioAsientoVIP();
    }
    @Override
    public LocalTime getHoraLlegada(){
        return bus.getHoraSalida();
    }
}

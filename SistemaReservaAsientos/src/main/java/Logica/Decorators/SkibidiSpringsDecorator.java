package Logica.Decorators;

import Logica.Autobuses.Autobus;
import Logica.TipoDestino;

import java.time.LocalTime;

public class SkibidiSpringsDecorator extends BusDecorator{
    //Constructor
    public SkibidiSpringsDecorator(Autobus bus){
        super(bus);
    }
    //Metodos
    @Override
    public int getPrecioAsientoNormal(){
        return bus.getPrecioAsientoNormal() + 20000;
    }
    @Override
    public int getPrecioAsientoVIP(){
        if(bus.getAsientosSegundoPiso() == null){
            return 0;
        }else{
            return bus.getPrecioAsientoVIP() + 20000;
        }
    }
    @Override
    public LocalTime getHoraLlegada(){
        LocalTime aux = bus.getHoraSalida();
        return aux.plusHours(TipoDestino.SKIBIDISPRINGS.getTiempo());
    }
    public TipoDestino destino(){
        return TipoDestino.SKIBIDISPRINGS;
    }
}

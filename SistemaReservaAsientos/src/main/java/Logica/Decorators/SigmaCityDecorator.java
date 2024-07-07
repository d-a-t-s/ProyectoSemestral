package Logica.Decorators;

import Logica.Autobuses.Autobus;
import Logica.TipoDestino;

import java.time.LocalTime;

public class SigmaCityDecorator extends BusDecorator{
    //Constructor
    public SigmaCityDecorator(Autobus bus){
        super(bus);
        bus.setDestino("Sigma City");
        this.destino = bus.getDestino();
    }
    //Metodos
    @Override
    public int getPrecioAsientoNormal(){
        return bus.getPrecioAsientoNormal() + 15000;
    }
    @Override
    public int getPrecioAsientoVIP(){
        if(bus.getAsientosSegundoPiso() == null){
            return 0;
        }else{
            return bus.getPrecioAsientoVIP() + 15000;
        }
    }
    @Override
    public LocalTime getHoraLlegada(){
        LocalTime aux = bus.getHoraSalida();
        return aux.plusHours(TipoDestino.SIGMACITY.getTiempo());
    }
}

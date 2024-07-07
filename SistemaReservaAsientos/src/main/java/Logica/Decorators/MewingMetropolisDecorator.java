package Logica.Decorators;

import Logica.Autobuses.Autobus;
import Logica.HoraSalida;
import Logica.TipoDestino;

import java.time.LocalTime;

public class MewingMetropolisDecorator extends BusDecorator{
    //Constructor
    public MewingMetropolisDecorator(Autobus bus){
        super(bus);
        String aux = "Mewing Metr.";
        bus.setDestino(aux);
        this.destino = bus.getDestino();
    }
    //Metodos
    @Override
    public int getPrecioAsientoNormal(){
        return bus.getPrecioAsientoNormal() + 25000;
    }
    @Override
    public int getPrecioAsientoVIP(){
        if(bus.getAsientosSegundoPiso() == null){
            return 0;
        }else{
            return bus.getPrecioAsientoVIP() + 25000;
        }
    }
    @Override
    public LocalTime getHoraLlegada(){
        LocalTime aux = bus.getHoraSalida();
        return aux.plusHours(TipoDestino.MAWINGMETROPOLIS.getTiempo());
    }
}

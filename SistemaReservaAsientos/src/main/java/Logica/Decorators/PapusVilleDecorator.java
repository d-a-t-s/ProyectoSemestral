package Logica.Decorators;

import Logica.Autobuses.Autobus;
import Logica.TipoDestino;

import java.time.LocalTime;

public class PapusVilleDecorator extends BusDecorator{
    //Constructor
    public PapusVilleDecorator(Autobus bus){
        super(bus);
        bus.setDestino("Papus Ville");
        this.destino = bus.getDestino();
    }
    //Metodos
    @Override
    public int getPrecioAsientoNormal(){
        return bus.getPrecioAsientoNormal() + 8000;
    }
    @Override
    public int getPrecioAsientoVIP(){
        if(bus.getAsientosSegundoPiso() == null){
            return 0;
        }else{
            return bus.getPrecioAsientoVIP() + 8000;
        }
    }
    @Override
    public LocalTime getHoraLlegada(){
        LocalTime aux = bus.getHoraSalida();
        return aux.plusHours(TipoDestino.PAPUSVILLE.getTiempo());
    }
}

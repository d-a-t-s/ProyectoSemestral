package Logica.Autobuses;

import Logica.AsientoNormal;
import Logica.HoraSalida;

import java.time.LocalTime;
import java.util.ArrayList;

public class SkibidiTravel extends Autobus{
    //Propiedades
    private final String company = "Skibidi Travel";
    //Constructor
    public SkibidiTravel(HoraSalida horaSalida){
        this.horaSalida = horaSalida.getTiempo();
        asientosPrimerPiso = new ArrayList<>();
        asientosSegundoPiso = null;
        for(int i = 0; i < 16; i++){
            asientosPrimerPiso.add(new AsientoNormal(i+1));
        }
    }
    //Metodos
    @Override
    public int getPrecioAsientoNormal(){
        return 10000;
    }
    @Override
    public int getPrecioAsientoVIP(){
        return 0;
    }
    @Override
    public LocalTime getHoraLlegada(){
        return null;
    }
    //Getters y setters
}

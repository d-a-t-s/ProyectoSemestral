package Logica.Autobuses;

import Logica.Asiento;
import Logica.HoraSalida;

import java.time.LocalTime;
import java.util.ArrayList;

public class SkibidiTravel extends Autobus{
    //Propiedades

    //Constructor
    public SkibidiTravel(HoraSalida horaSalida){
        this.company = "Skibidi Travel";
        this.nPisos = "1";
        this.horaSalida = horaSalida.getTiempo();
        asientosPrimerPiso = new ArrayList<>();
        asientosSegundoPiso = null;
        for(int i = 0; i < 16; i++){
            asientosPrimerPiso.add(new Asiento(i+1, false));
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

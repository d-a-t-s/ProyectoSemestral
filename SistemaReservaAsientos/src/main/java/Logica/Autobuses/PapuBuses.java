package Logica.Autobuses;

import Logica.AsientoNormal;
import Logica.AsientoVIP;
import Logica.HoraSalida;

import java.time.LocalTime;
import java.util.ArrayList;

public class PapuBuses extends Autobus{
    //Propiedades
    //Constructor
    public PapuBuses(HoraSalida horaSalida){
        this.company = "Papu Buses";
        this.horaSalida = horaSalida.getTiempo();
        asientosPrimerPiso = new ArrayList<>();
        asientosSegundoPiso = new ArrayList<>();
        for(int i = 0; i < 16; i++){
            asientosPrimerPiso.add(new AsientoNormal(i+1));
            asientosSegundoPiso.add(new AsientoVIP(i+17));
        }
    }
    //Metodos
    @Override
    public int getPrecioAsientoNormal(){
        return 18000;
    }
    @Override
    public int getPrecioAsientoVIP(){
        return 20000;
    }
    @Override
    public LocalTime getHoraLlegada(){
        return null;
    }
    //Getters y setters

}

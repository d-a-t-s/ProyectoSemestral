package Logica.Autobuses;

import Logica.AsientoNormal;
import Logica.AsientoVIP;
import Logica.HoraSalida;

import java.time.LocalTime;
import java.util.ArrayList;

public class TilinExpress extends Autobus{
    //Propiedades
    private final String company = "Tilin Express";
    //Constructor
    public TilinExpress(HoraSalida horaSalida){
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
        return 16000;
    }
    @Override
    public int getPrecioAsientoVIP(){
        return 18000;
    }
    @Override
    public LocalTime getHoraLlegada(){
        return null;
    }
    //Getters y setters
}

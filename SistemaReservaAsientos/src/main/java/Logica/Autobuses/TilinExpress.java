package Logica.Autobuses;

import Logica.Asiento;
import Logica.HoraSalida;

import java.time.LocalTime;
import java.util.ArrayList;

public class TilinExpress extends Autobus{
    //Propiedades

    //Constructor
    public TilinExpress(HoraSalida horaSalida){
        this.company = "Tilin Express";
        this.nPisos = "2";
        this.horaSalida = horaSalida.getTiempo();
        asientosPrimerPiso = new ArrayList<>();
        asientosSegundoPiso = new ArrayList<>();
        for(int i = 0; i < 16; i++){
            asientosPrimerPiso.add(new Asiento(i+1, false));
            asientosSegundoPiso.add(new Asiento(i+17, true));
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

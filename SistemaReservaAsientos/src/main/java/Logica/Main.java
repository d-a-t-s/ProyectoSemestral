package Logica;

import Logica.Autobuses.Autobus;
import Logica.Autobuses.PapuBuses;
import Logica.Decorators.MewingMetropolisDecorator;
import Logica.Decorators.PapusVilleDecorator;
import Logica.Decorators.TilinTownDecorator;
import Logica.Excepciones.AsientoNoDisponibleException;
import Logica.Excepciones.SegundoPisoNoDisponibleException;

public class Main{
    public static void main(String[] args){
        Autobus p = new PapuBuses(HoraSalida.MORNING);
//        System.out.println(p.getHoraSalida());
        System.out.println(p.numeroAsientosDisponiblesPrimerPiso());
        System.out.println(p.numeroAsientosDisponiblesSegundoPiso());
        try{
            p.reservarAsientoPrimerPiso(1);
            System.out.println(p.getAsientosPrimerPiso().get(0).getDisponibilidad());
            p.reservarAsientoSegundoPiso(32);
            System.out.println(p.getAsientosSegundoPiso().get(15).getNumeroDeAsiento());
            System.out.println(p.getAsientosSegundoPiso().get(15).getDisponibilidad());
            p = new PapusVilleDecorator(p);
            System.out.println(p.numeroAsientosDisponiblesPrimerPiso());
            System.out.println(p.numeroAsientosDisponiblesSegundoPiso());
            System.out.println(p.getCompany());
//            System.out.println(p.getPrecioAsientoNormal());
//            System.out.println(p.getPrecioAsientoVIP());
//            p = new TilinTownDecorator(p);
//            System.out.println(p.getPrecioAsientoNormal());
//            System.out.println(p.getPrecioAsientoVIP());
//            p.reservarAsientoPrimerPiso(1);

        }catch(AsientoNoDisponibleException e){
            System.out.println("Asiento no disponible");
        }catch(SegundoPisoNoDisponibleException e){
            System.out.println("Segundo piso no disponible");
        }
//        System.out.println(p.precioAsientoNormal());
//        System.out.println(p.precioAsientoVIP());
//        for(int i = 0 ; i < 16; i++){
//            System.out.println("Asientos del primer piso");
//            System.out.println(p.getAsientosPrimerPiso().get(i).getNumeroDeAsiento());
//            System.out.println("Asientos del segundo piso");
//            System.out.println(p.getAsientosSegundoPiso().get(i).getNumeroDeAsiento());
//        }
//        p = new PapusVilleDecorator(p);
//        System.out.println(p.getHoraLlegada());
//        p = new MewingMetropolisDecorator(p);
//        System.out.println(p.getHoraLlegada());

    }
}

package Logica.Autobuses;

import Logica.Asiento;
import Logica.Excepciones.AsientoNoDisponibleException;
import Logica.Excepciones.SegundoPisoNoDisponibleException;
import Logica.HoraSalida;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Autobus{

    //Por simplicidad los asientos del segundo piso seran VIP y los asientos del primer piso seran normales por tanto, solo aquellos buses con dos pisos son los que tendran asientos VIP

    //Propiedades
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    protected LocalTime horaSalida;
    protected String company;
    protected ArrayList<Asiento> asientosPrimerPiso;
    protected ArrayList<Asiento> asientosSegundoPiso;
    protected String destino;
    protected String nPisos;

    //Metodos
    public abstract int getPrecioAsientoNormal();
    public abstract int getPrecioAsientoVIP();
    public abstract LocalTime getHoraLlegada();

    //Se supone que para reservar un asiento debo clickear en un recuadro correspondiente al asiento que quiero reservar, por lo que el numero a seleccionar siempre sera correcto
    //Es decir, cuando se clickee, automaticamente una variable sera igual al numero del asiento que luego se le pasara como parametro a los siguientes metodos

    public void reservarAsientoPrimerPiso(int numeroDeAsiento) throws AsientoNoDisponibleException{
        asientosPrimerPiso.get(numeroDeAsiento - 1).reservar();
    }
    public void reservarAsientoSegundoPiso(int numeroDeAsiento) throws AsientoNoDisponibleException, SegundoPisoNoDisponibleException{
        if(asientosSegundoPiso == null){
            throw new SegundoPisoNoDisponibleException("SegundoPisoNoDisponibleException");
        }
        asientosSegundoPiso.get(numeroDeAsiento - 17).reservar();
    }
    public int numeroAsientosDisponiblesPrimerPiso(){
        int aux = 0;
        for(int i = 0; i < 16; i++){
            if(asientosPrimerPiso.get(i).getDisponibilidad() == true){
                aux = aux + 1;
            }
        }
        return aux;
    }
    public int numeroAsientosDisponiblesSegundoPiso(){
        int aux = 0;
        if(asientosSegundoPiso == null){
            return aux;
        }
        for(int i = 0; i < 16; i++){
            if(asientosSegundoPiso.get(i).getDisponibilidad() == true){
                aux = aux + 1;
            }
        }
        return aux;
    }
    //Getters y setters
    public LocalTime getHoraSalida(){
        return horaSalida;
    }
    public String getHoraSalidaFormateada(){
        return horaSalida.format(formatter);
    }
    public String getCompany(){
        return company;
    }
    public String getDestino(){
        return destino;
    }
    public String getnPisos(){
        return nPisos;
    }
    public ArrayList<Asiento> getAsientosPrimerPiso(){
        return asientosPrimerPiso;
    }
    public ArrayList<Asiento> getAsientosSegundoPiso(){
        return asientosSegundoPiso;
    }
    public void setDestino(String destino){
        this.destino = destino;
    }
    public void setnPisos(String nPisos){
        this.nPisos = nPisos;
    }
}

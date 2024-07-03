package Logica.Autobuses;

import Logica.Asiento;
import Logica.Excepciones.AsientoNoDisponibleException;
import Logica.Excepciones.SegundoPisoNoDisponibleException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Autobus {

    // Por simplicidad, los asientos del segundo piso serán normales y los asientos del primer piso serán VIP
    // Propiedades
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    protected LocalTime horaSalida;
    protected String company;
    protected ArrayList<Asiento> asientosPrimerPiso;
    protected ArrayList<Asiento> asientosSegundoPiso;

    // Métodos
    public abstract int getPrecioAsientoNormal();
    public abstract int getPrecioAsientoVIP();
    public abstract LocalTime getHoraLlegada();

    public void reservarAsientoPrimerPiso(int numeroDeAsiento) throws AsientoNoDisponibleException {
        asientosPrimerPiso.get(numeroDeAsiento - 1).reservar();
    }

    public void reservarAsientoSegundoPiso(int numeroDeAsiento) throws AsientoNoDisponibleException, SegundoPisoNoDisponibleException {
        if (asientosSegundoPiso == null) {
            throw new SegundoPisoNoDisponibleException("SegundoPisoNoDisponibleException");
        }
        asientosSegundoPiso.get(numeroDeAsiento - 17).reservar();
    }

    public int numeroAsientosDisponiblesPrimerPiso() {
        int aux = 0;
        for (int i = 0; i < 16; i++) {
            if (asientosPrimerPiso.get(i).getDisponibilidad()) {
                aux = aux + 1;
            }
        }
        return aux;
    }

    public int numeroAsientosDisponiblesSegundoPiso() {
        int aux = 0;
        if (asientosSegundoPiso == null) {
            return aux;
        }
        for (int i = 0; i < 16; i++) {
            if (asientosSegundoPiso.get(i).getDisponibilidad()) {
                aux = aux + 1;
            }
        }
        return aux;
    }

    // Getters y setters
    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public String getHoraSalidaFormateada() {
        return horaSalida.format(formatter);
    }

    public String getCompany() {
        return company;
    }

    public ArrayList<Asiento> getAsientosPrimerPiso() {
        return asientosPrimerPiso;
    }

    public ArrayList<Asiento> getAsientosSegundoPiso() {
        return asientosSegundoPiso;
    }
}

package Logica.Autobuses;

import Logica.Asiento;
import Logica.Excepciones.AsientoNoDisponibleException;
import Logica.Excepciones.SegundoPisoNoDisponibleException;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Clase abstracta que representa un autobús genérico.
 */
public abstract class Autobus {

    // Propiedades
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    protected LocalTime horaSalida;
    protected String company;
    protected ArrayList<Asiento> asientosPrimerPiso;
    protected ArrayList<Asiento> asientosSegundoPiso;
    protected String destino;
    protected String nPisos;

    // Métodos abstractos que deben ser implementados por las subclases
    public abstract int getPrecioAsientoNormal();
    public abstract int getPrecioAsientoVIP();
    public abstract LocalTime getHoraLlegada();

    /**
     * Reserva un asiento en el primer piso del autobús.
     * @param numeroDeAsiento Número del asiento a reservar.
     * @throws AsientoNoDisponibleException Si el asiento no está disponible para reservar.
     */
    public void reservarAsientoPrimerPiso(int numeroDeAsiento) throws AsientoNoDisponibleException {
        asientosPrimerPiso.get(numeroDeAsiento - 1).reservar();
    }

    /**
     * Reserva un asiento en el segundo piso del autobús.
     * @param numeroDeAsiento Número del asiento a reservar.
     * @throws AsientoNoDisponibleException Si el asiento no está disponible para reservar.
     * @throws SegundoPisoNoDisponibleException Si el segundo piso no está disponible en este autobús.
     */
    public void reservarAsientoSegundoPiso(int numeroDeAsiento) throws AsientoNoDisponibleException, SegundoPisoNoDisponibleException {
        if (asientosSegundoPiso == null) {
            throw new SegundoPisoNoDisponibleException("Segundo piso no disponible en este autobús");
        }
        asientosSegundoPiso.get(numeroDeAsiento - 17).reservar();
    }

    /**
     * Obtiene el número de asientos disponibles en el primer piso del autobús.
     * @return Número de asientos disponibles.
     */
    public int numeroAsientosDisponiblesPrimerPiso() {
        int contador = 0;
        for (Asiento asiento : asientosPrimerPiso) {
            if (asiento.getDisponibilidad()) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Obtiene el número de asientos disponibles en el segundo piso del autobús.
     * @return Número de asientos disponibles.
     */
    public int numeroAsientosDisponiblesSegundoPiso() {
        if (asientosSegundoPiso == null) {
            return 0;
        }
        int contador = 0;
        for (Asiento asiento : asientosSegundoPiso) {
            if (asiento.getDisponibilidad()) {
                contador++;
            }
        }
        return contador;
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

    public String getDestino() {
        return destino;
    }

    public String getnPisos() {
        return nPisos;
    }

    public ArrayList<Asiento> getAsientosPrimerPiso() {
        return asientosPrimerPiso;
    }

    public ArrayList<Asiento> getAsientosSegundoPiso() {
        return asientosSegundoPiso;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setnPisos(String nPisos) {
        this.nPisos = nPisos;
    }
}

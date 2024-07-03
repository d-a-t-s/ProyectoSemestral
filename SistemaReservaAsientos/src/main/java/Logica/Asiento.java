package Logica;

import Logica.Excepciones.AsientoNoDisponibleException;

public class Asiento {
    // Propiedades
    private Boolean disponibilidad;
    private int numeroDeAsiento;
    private boolean esVIP;

    // Constructor
    public Asiento(int numeroDeAsiento, boolean esVIP) {
        this.numeroDeAsiento = numeroDeAsiento;
        this.disponibilidad = true; // Por defecto, el asiento está disponible
        this.esVIP = esVIP;
    }

    // Métodos
    public void reservar() throws AsientoNoDisponibleException {
        if (!disponibilidad) {
            throw new AsientoNoDisponibleException("Asiento no disponible.");
        }
        disponibilidad = false;
    }

    public void cancelarReserva() {
        disponibilidad = true;
    }

    // Getters y setters
    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public int getNumeroDeAsiento() {
        return numeroDeAsiento;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void setNumeroDeAsiento(int numeroDeAsiento) {
        this.numeroDeAsiento = numeroDeAsiento;
    }

    public boolean esVIP() {
        return esVIP;
    }

    public void setVIP(boolean esVIP) {
        this.esVIP = esVIP;
    }
}

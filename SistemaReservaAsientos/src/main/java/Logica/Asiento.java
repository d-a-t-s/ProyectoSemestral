package Logica;

import Logica.Excepciones.AsientoNoDisponibleException;

public class Asiento {
    // Propiedades
    protected Boolean disponibilidad;
    protected int numeroDeAsiento;
    private boolean esVIP;

    // Constructor
    public Asiento(int numeroDeAsiento, boolean esVIP) {
        this.numeroDeAsiento = numeroDeAsiento;
        this.disponibilidad = true;
        this.esVIP = esVIP;
    }

    // Métodos
    public void reservar() throws AsientoNoDisponibleException {
        if (disponibilidad == false) {
            throw new AsientoNoDisponibleException("AsientoNoDisponibleException");
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

    public boolean esVIP() {
        return esVIP;
    }

    public void setDisponibilidad(Boolean valor) {
        disponibilidad = valor; // Considerar provisorio por si se agrega una opción para cancelar en un futuro
    }

    public void setNumeroDeAsiento(int num) {
        numeroDeAsiento = num;
    }

    public void setEsVIP(boolean esVIP) {
        this.esVIP = esVIP;
    }

    // Sobrescribir el método toString para mostrar información detallada del asiento
    @Override
    public String toString() {
        return "Asiento " +
                "Número=" + numeroDeAsiento +
                ", VIP=" + (esVIP ? "Sí" : "No") +
                ", Disponibilidad=" + (disponibilidad ? "Disponible" : "Ocupado");
    }
}

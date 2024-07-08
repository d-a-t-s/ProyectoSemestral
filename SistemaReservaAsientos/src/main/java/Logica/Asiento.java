package Logica;

import Logica.Excepciones.AsientoNoDisponibleException;

/**
 * Clase que representa un asiento en un autobús.
 */
public class Asiento {
    // Propiedades
    protected Boolean disponibilidad;
    protected int numeroDeAsiento;
    private boolean esVIP;

    /**
     * Constructor para inicializar un asiento.
     * @param numeroDeAsiento Número del asiento.
     * @param esVIP Indica si el asiento es VIP o no.
     */
    public Asiento(int numeroDeAsiento, boolean esVIP) {
        this.numeroDeAsiento = numeroDeAsiento;
        this.disponibilidad = true; // Inicialmente disponible
        this.esVIP = esVIP;
    }

    /**
     * Método para reservar el asiento.
     * @throws AsientoNoDisponibleException Si el asiento ya está reservado.
     */
    public void reservar() throws AsientoNoDisponibleException {
        if (!disponibilidad) {
            throw new AsientoNoDisponibleException("Asiento no disponible para reservar.");
        }
        disponibilidad = false; // Marcar el asiento como no disponible
    }

    /**
     * Método para cancelar la reserva del asiento.
     */
    public void cancelarReserva() {
        disponibilidad = true; // Marcar el asiento como disponible
    }

    // Getters y setters

    /**
     * Obtiene la disponibilidad actual del asiento.
     * @return true si el asiento está disponible, false si está ocupado.
     */
    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    /**
     * Obtiene el número del asiento.
     * @return Número del asiento.
     */
    public int getNumeroDeAsiento() {
        return numeroDeAsiento;
    }

    /**
     * Indica si el asiento es VIP.
     * @return true si el asiento es VIP, false si no lo es.
     */
    public boolean esVIP() {
        return esVIP;
    }

    /**
     * Establece la disponibilidad del asiento.
     * @param valor true para disponible, false para ocupado.
     */
    public void setDisponibilidad(Boolean valor) {
        disponibilidad = valor;
    }

    /**
     * Establece el número del asiento.
     * @param num Número del asiento.
     */
    public void setNumeroDeAsiento(int num) {
        numeroDeAsiento = num;
    }

    /**
     * Establece si el asiento es VIP o no.
     * @param esVIP true si el asiento es VIP, false si no lo es.
     */
    public void setEsVIP(boolean esVIP) {
        this.esVIP = esVIP;
    }

    /**
     * Sobrescribe el método toString para mostrar información detallada del asiento.
     * @return Cadena con información detallada del asiento.
     */
    @Override
    public String toString() {
        return "Asiento{" +
                "Número=" + numeroDeAsiento +
                ", VIP=" + (esVIP ? "Sí" : "No") +
                ", Disponibilidad=" + (disponibilidad ? "Disponible" : "Ocupado") +
                '}';
    }
}

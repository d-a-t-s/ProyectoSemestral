package Logica;

import Logica.Excepciones.AsientoNoDisponibleException;

public class Asiento {
    //Propiedades
    protected Boolean disponibilidad;
    protected int numeroDeAsiento;
    private boolean esVIP;
    //Constructor
    public Asiento(int numeroDeAsiento, boolean esVIP){
        this.numeroDeAsiento = numeroDeAsiento;
        this.disponibilidad = true;
        this.esVIP = esVIP;
    }
    //Metodos
    public void reservar() throws AsientoNoDisponibleException{
        if(disponibilidad == false){
            throw new AsientoNoDisponibleException("AsientoNoDisponibleException");
        }
        disponibilidad = false;
    }
    public void cancelarReserva(){
        disponibilidad = true;
    }
    //Getters y setters
    public Boolean getDisponibilidad(){
        return disponibilidad;
    }
    public int getNumeroDeAsiento(){
        return numeroDeAsiento;
    }
    public boolean esVIP(){
        return esVIP;
    }
    public void setDisponibilidad(Boolean valor){
        disponibilidad = valor; //Considerar provisorio por si se agrega una opcion para cancelar en un futuro
    }
    public void setNumeroDeAsiento(int num){
        numeroDeAsiento = num;
    }
    public void setEsVIP(boolean esVIP){
        this.esVIP = esVIP;
    }
}

package Logica;

import Logica.Excepciones.AsientoNoDisponibleException;

public abstract class Asiento {
    //Propiedades
    protected Boolean Disponibilidad = true;
    protected int numeroDeAsiento;
    //Constructor

    //Metodos
    public void reservar() throws AsientoNoDisponibleException{
        if(Disponibilidad == false){
            throw new AsientoNoDisponibleException("AsientoNoDisponibleException");
        }
        Disponibilidad = false;
    }
    //Getters y setters
    public Boolean getDisponibilidad(){
        return Disponibilidad;
    }
    public int getNumeroDeAsiento(){
        return numeroDeAsiento;
    }
    public void setDisponibilidad(Boolean valor){
        Disponibilidad = valor; //Considerar provisorio por si se agrega una opcion para cancelar en un futuro
    }
    public void setNumeroDeAsiento(int num){
        numeroDeAsiento = num;
    }
}

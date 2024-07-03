package Logica.Excepciones;

public class AsientoNoDisponibleException extends Exception{
    //Constructor
    public AsientoNoDisponibleException(String errorMessage){
        super(errorMessage);
        System.out.println(errorMessage);
    }
}

package Logica.Excepciones;

public class SegundoPisoNoDisponibleException extends Exception{
    //Constructor
    public SegundoPisoNoDisponibleException(String errorMessage){
        super(errorMessage);
        System.out.println(errorMessage);
    }
}

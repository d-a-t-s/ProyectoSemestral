package Logica.Excepciones;

/**
 * Excepción personalizada para indicar que el segundo piso de un autobús no está disponible.
 * Extiende de la clase Exception.
 */
public class SegundoPisoNoDisponibleException extends Exception {

    /**
     * Constructor de la excepción SegundoPisoNoDisponibleException.
     * @param errorMessage Mensaje de error que describe la excepción.
     */
    public SegundoPisoNoDisponibleException(String errorMessage) {
        super(errorMessage); // Llama al constructor de la clase base (Exception) con el mensaje de error
        System.out.println(errorMessage); // Imprime el mensaje de error por consola
    }
}

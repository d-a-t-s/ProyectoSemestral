package Logica.Excepciones;

/**
 * Excepción personalizada para indicar que un asiento no está disponible.
 * Extiende de la clase Exception.
 */
public class AsientoNoDisponibleException extends Exception {

    /**
     * Constructor de la excepción AsientoNoDisponibleException.
     * @param errorMessage Mensaje de error que describe la excepción.
     */
    public AsientoNoDisponibleException(String errorMessage) {
        super(errorMessage); // Llama al constructor de la clase base (Exception) con el mensaje de error
        System.out.println(errorMessage); // Imprime el mensaje de error por consola
    }
}

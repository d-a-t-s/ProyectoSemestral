package Logica;

/**
 * Enumeración que representa diferentes tipos de destinos para autobuses,
 * donde se asocia un tiempo específico de viaje que afecta el precio.
 * De arriba hacia abajo, incrementa la distancia y por lo tanto el costo.
 */
public enum TipoDestino {

    PAPUSVILLE(3),      // Tiempo de viaje: 3 horas
    TILINTOWN(5),       // Tiempo de viaje: 5 horas
    SIGMACITY(7),       // Tiempo de viaje: 7 horas
    SKIBIDISPRINGS(8),  // Tiempo de viaje: 8 horas
    MAWINGMETROPOLIS(10);// Tiempo de viaje: 10 horas

    // Propiedades

    private int tiempo;

    // Constructor

    /**
     * Constructor de la enumeración TipoDestino.
     * @param tiempo El tiempo de viaje asociado al destino.
     */
    TipoDestino(int tiempo) {
        this.tiempo = tiempo;
    }

    // Métodos

    /**
     * Obtiene el tiempo de viaje asociado al destino.
     * @return El tiempo de viaje en horas.
     */
    public int getTiempo() {
        return tiempo;
    }
}

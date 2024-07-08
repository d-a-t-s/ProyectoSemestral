package Logica;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Enumeración que representa diferentes horas de salida para autobuses.
 */
public enum HoraSalida {
    MORNING(LocalTime.of(6, 0)),
    AFTERNOON(LocalTime.of(12, 0)),
    EVENING(LocalTime.of(18, 0)),
    NIGHT(LocalTime.of(21, 0));

    // Propiedades

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    private LocalTime horaSalida;

    // Constructor

    /**
     * Constructor de la enumeración HoraSalida.
     * @param horaSalida La hora de salida representada como LocalTime.
     */
    HoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    // Métodos

    /**
     * Obtiene la hora de salida como LocalTime.
     * @return La hora de salida.
     */
    public LocalTime getTiempo() {
        return horaSalida;
    }

    /**
     * Obtiene la hora de salida formateada como cadena en formato "HH:mm".
     * @return La hora de salida formateada.
     */
    public String getHoraFormateada() {
        return horaSalida.format(formatter);
    }
}

package Logica;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public enum HoraSalida {
    MORNING(LocalTime.of(6,0)){
    },
    AFTERNOON(LocalTime.of(12,0)){
    },
    EVENING(LocalTime.of(18,0)){
    },
    NIGHT(LocalTime.of(21,0)){
    };
    //Propiedades
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    private LocalTime horaSalida;
    //Constructor
    HoraSalida(LocalTime horaSalida){
        this.horaSalida = horaSalida;
    }
    public LocalTime getTiempo(){
        return horaSalida;
    }
    public String getHoraFormateada(){
        return horaSalida.format(formatter);
    }
}

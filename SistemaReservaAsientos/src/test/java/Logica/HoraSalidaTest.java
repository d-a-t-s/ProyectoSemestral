package Logica;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class HoraSalidaTest {

    @Test
    void getTiempo() {
        // Arrange & Act
        LocalTime morningTime = HoraSalida.MORNING.getTiempo();
        LocalTime afternoonTime = HoraSalida.AFTERNOON.getTiempo();
        LocalTime eveningTime = HoraSalida.EVENING.getTiempo();
        LocalTime nightTime = HoraSalida.NIGHT.getTiempo();

        // Assert
        assertEquals(LocalTime.of(6, 0), morningTime);
        assertEquals(LocalTime.of(12, 0), afternoonTime);
        assertEquals(LocalTime.of(18, 0), eveningTime);
        assertEquals(LocalTime.of(21, 0), nightTime);
    }

    @Test
    void getHoraFormateada() {
        // Arrange & Act
        String morningFormatted = HoraSalida.MORNING.getHoraFormateada();
        String afternoonFormatted = HoraSalida.AFTERNOON.getHoraFormateada();
        String eveningFormatted = HoraSalida.EVENING.getHoraFormateada();
        String nightFormatted = HoraSalida.NIGHT.getHoraFormateada();

        // Assert
        assertEquals("06:00", morningFormatted);
        assertEquals("12:00", afternoonFormatted);
        assertEquals("18:00", eveningFormatted);
        assertEquals("21:00", nightFormatted);
    }

    @Test
    void values() {
        // Arrange & Act
        HoraSalida[] values = HoraSalida.values();

        // Assert
        assertEquals(4, values.length);
        assertEquals(HoraSalida.MORNING, values[0]);
        assertEquals(HoraSalida.AFTERNOON, values[1]);
        assertEquals(HoraSalida.EVENING, values[2]);
        assertEquals(HoraSalida.NIGHT, values[3]);
    }

    @Test
    void valueOf() {
        // Arrange & Act
        HoraSalida morning = HoraSalida.valueOf("MORNING");
        HoraSalida afternoon = HoraSalida.valueOf("AFTERNOON");
        HoraSalida evening = HoraSalida.valueOf("EVENING");
        HoraSalida night = HoraSalida.valueOf("NIGHT");

        // Assert
        assertEquals(HoraSalida.MORNING, morning);
        assertEquals(HoraSalida.AFTERNOON, afternoon);
        assertEquals(HoraSalida.EVENING, evening);
        assertEquals(HoraSalida.NIGHT, night);
    }
}

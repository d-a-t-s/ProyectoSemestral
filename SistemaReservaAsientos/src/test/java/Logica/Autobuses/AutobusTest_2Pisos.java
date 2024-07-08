package Logica.Autobuses;

import Logica.Asiento;
import Logica.Excepciones.AsientoNoDisponibleException;
import Logica.Excepciones.SegundoPisoNoDisponibleException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AutobusTest_2Pisos {

    private Autobus autobus;

    @BeforeEach
    void setUp() {
        autobus = new Autobus() {
            @Override
            public int getPrecioAsientoNormal() {
                return 100;
            }

            @Override
            public int getPrecioAsientoVIP() {
                return 200;
            }

            @Override
            public LocalTime getHoraLlegada() {
                return LocalTime.of(22, 0);
            }
        };

        // Configurar datos de prueba
        autobus.horaSalida = LocalTime.of(10, 0);
        autobus.company = "Empresa de Prueba";
        autobus.destino = "Ciudad de Prueba";
        autobus.nPisos = "2";

        autobus.asientosPrimerPiso = new ArrayList<>();
        autobus.asientosSegundoPiso = new ArrayList<>();

        // Agregar asientos de prueba (16 para el primer piso)
        for (int i = 0; i < 16; i++) {
            autobus.asientosPrimerPiso.add(new Asiento(i + 1, false));
        }

        // Agregar asientos de prueba (16 para el segundo piso, serán VIP)
        for (int i = 0; i < 16; i++) {
            autobus.asientosSegundoPiso.add(new Asiento(i + 17, true));
        }
    }

    @Test
    void reservarAsientoPrimerPiso_AsientoDisponible_ReservaExitosa() {
        // Act
        try {
            autobus.reservarAsientoPrimerPiso(1);
            // Assert
            assertFalse(autobus.getAsientosPrimerPiso().get(0).getDisponibilidad());
        } catch (AsientoNoDisponibleException e) {
            fail("Se esperaba que el asiento estuviera disponible.");
        }
    }

    @Test
    void reservarAsientoPrimerPiso_AsientoNoDisponible_LanzaExcepcion() {
        // Arrange
        autobus.getAsientosPrimerPiso().get(0).setDisponibilidad(false);
        // Act & Assert
        assertThrows(AsientoNoDisponibleException.class, () -> {
            autobus.reservarAsientoPrimerPiso(1);
        });
    }

    @Test
    void reservarAsientoSegundoPiso_AsientoDisponible_ReservaExitosa() {
        // Act
        try {
            autobus.reservarAsientoSegundoPiso(17);
            // Assert
            assertFalse(autobus.getAsientosSegundoPiso().get(0).getDisponibilidad());
        } catch (AsientoNoDisponibleException | SegundoPisoNoDisponibleException e) {
            fail("Se esperaba que el asiento estuviera disponible y el segundo piso disponible.");
        }
    }

    @Test
    void numeroAsientosDisponiblesPrimerPiso() {
        // Act
        int disponibles = autobus.numeroAsientosDisponiblesPrimerPiso();
        // Assert
        assertEquals(16, disponibles);
    }

    @Test
    void numeroAsientosDisponiblesSegundoPiso() {
        // Act
        int disponibles = autobus.numeroAsientosDisponiblesSegundoPiso();
        // Assert
        assertEquals(16, disponibles);
    }

}

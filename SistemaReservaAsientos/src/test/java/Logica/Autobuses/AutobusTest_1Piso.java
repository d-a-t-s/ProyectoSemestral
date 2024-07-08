package Logica.Autobuses;

import Logica.Asiento;
import Logica.Excepciones.AsientoNoDisponibleException;
import Logica.Excepciones.SegundoPisoNoDisponibleException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AutobusTest_1Piso {

    private Autobus autobus;

    @BeforeEach
    void setUp() {
        // Crear una implementación de prueba para Autobus (puedes usar una clase anónima para este propósito)
        autobus = new Autobus() {
            @Override
            public int getPrecioAsientoNormal() {
                return 100;
            }

            @Override
            public int getPrecioAsientoVIP() {
                return 200; // En un autobús de un solo piso, no habrá asientos VIP
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
        autobus.nPisos = "1";

        autobus.asientosPrimerPiso = new ArrayList<>();

        // Agregar asientos de prueba (16 asientos en el primer piso)
        for (int i = 0; i < 16; i++) {
            autobus.asientosPrimerPiso.add(new Asiento(i + 1, false));
        }
        autobus.asientosSegundoPiso = null;
    }

    // Tests para métodos de la clase Autobus

    @Test
    void reservarAsientoPrimerPiso_AsientoDisponible_ReservaExitosa() {
        try {
            autobus.reservarAsientoPrimerPiso(1);
            assertFalse(autobus.getAsientosPrimerPiso().get(0).getDisponibilidad());
        } catch (AsientoNoDisponibleException e) {
            fail("Se esperaba que el asiento estuviera disponible.");
        }
    }

    @Test
    void reservarAsientoPrimerPiso_AsientoNoDisponible_LanzaExcepcion() {
        autobus.getAsientosPrimerPiso().get(0).setDisponibilidad(false);
        assertThrows(AsientoNoDisponibleException.class, () -> autobus.reservarAsientoPrimerPiso(1));
    }

    @Test
    void numeroAsientosDisponiblesPrimerPiso() {
        int disponibles = autobus.numeroAsientosDisponiblesPrimerPiso();
        assertEquals(16, disponibles);
    }

    @Test
    void getAsientosPrimerPiso() {
        ArrayList<Asiento> asientos = autobus.getAsientosPrimerPiso();
        assertEquals(16, asientos.size());
    }

    @Test
    void setDestino() {
        autobus.setDestino("Nuevo Destino");
        assertEquals("Nuevo Destino", autobus.getDestino());
    }

    @Test
    void setnPisos() {
        autobus.setnPisos("3");
        assertEquals("3", autobus.getnPisos());
    }

    @Test
    void reservarAsientoSegundoPiso_SegundoPisoNoDisponible_LanzaExcepcion() {
        assertThrows(SegundoPisoNoDisponibleException.class, () -> autobus.reservarAsientoSegundoPiso(17));
    }
}

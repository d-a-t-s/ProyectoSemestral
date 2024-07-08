package Logica.Autobuses;
import Logica.Excepciones.AsientoNoDisponibleException;
import Logica.Excepciones.SegundoPisoNoDisponibleException;
import Logica.HoraSalida;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCompraReal {
    private Autobus autobus;

    @BeforeEach
    public void setUp() {
        // Configuramos un autobús de un piso para la prueba
        autobus = new MewingMobility(HoraSalida.MORNING);
    }

    @Test
    public void testReservaAsientoExitosoPrimerPiso() {
        // Verificamos que el asiento esté disponible inicialmente
        int numeroDeAsiento = 1;
        assertTrue(autobus.getAsientosPrimerPiso().get(numeroDeAsiento - 1).getDisponibilidad());

        // Reservamos el asiento
        try {
            autobus.reservarAsientoPrimerPiso(numeroDeAsiento);
        } catch (AsientoNoDisponibleException e) {
            fail("Excepción no esperada: " + e.getMessage());
        }

        // Verificamos que el asiento ya no esté disponible
        assertFalse(autobus.getAsientosPrimerPiso().get(numeroDeAsiento - 1).getDisponibilidad());
    }

    @Test
    public void testReservaAsientoNoDisponible() {
        int numeroDeAsiento = 1;
        // Reservamos el asiento por primera vez
        try {
            autobus.reservarAsientoPrimerPiso(numeroDeAsiento);
        } catch (AsientoNoDisponibleException e) {
            fail("Excepción no esperada: " + e.getMessage());
        }

        // Intentamos reservar el mismo asiento nuevamente, debe lanzar AsientoNoDisponibleException
        assertThrows(AsientoNoDisponibleException.class, () -> {
            autobus.reservarAsientoPrimerPiso(numeroDeAsiento);
        });
    }

    @Test
    public void testReservaAsientoSegundoPisoNoDisponible() {
        int numeroDeAsiento = 17; // Primer asiento del segundo piso
        // Intentamos reservar un asiento en el segundo piso de un autobús de un solo piso
        assertThrows(SegundoPisoNoDisponibleException.class, () -> {
            autobus.reservarAsientoSegundoPiso(numeroDeAsiento);
        });
    }
}

package Logica;

import Logica.Excepciones.AsientoNoDisponibleException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsientoTest {

    private Asiento asiento;

    @BeforeEach
    void setUp() {
        // Configuración inicial para cada prueba
        asiento = new Asiento(1, false); // Crear un asiento no VIP inicialmente disponible
    }

    @Test
    void reservar_AsientoDisponible_ReservaExitosa() {
        // Act
        try {
            asiento.reservar();
            // Assert
            assertFalse(asiento.getDisponibilidad());
        } catch (AsientoNoDisponibleException e) {
            fail("Se esperaba que el asiento estuviera disponible.");
        }
    }

    @Test
    void reservar_AsientoNoDisponible_LanzaExcepcion() {
        // Arrange
        asiento.setDisponibilidad(false);
        // Act & Assert
        assertThrows(AsientoNoDisponibleException.class, () -> asiento.reservar());
    }

    @Test
    void cancelarReserva_AsientoReservado_CancelacionExitosa() {
        // Arrange
        asiento.setDisponibilidad(false);
        // Act
        asiento.cancelarReserva();
        // Assert
        assertTrue(asiento.getDisponibilidad());
    }

    @Test
    void getNumeroDeAsiento_ObtenerNumero_NumeroCorrecto() {
        // Act & Assert
        assertEquals(1, asiento.getNumeroDeAsiento());
    }

    @Test
    void esVIP_AsientoEsVIP_EsTrue() {
        // Act & Assert
        assertFalse(asiento.esVIP());
    }

    @Test
    void setDisponibilidad_CambiarDisponibilidad_DisponibilidadCambiada() {
        // Act
        asiento.setDisponibilidad(false);
        // Assert
        assertFalse(asiento.getDisponibilidad());
    }
}

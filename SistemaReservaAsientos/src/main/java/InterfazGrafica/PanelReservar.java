package InterfazGrafica;

import Logica.Excepciones.AsientoNoDisponibleException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Panel para gestionar la acción de reservar asientos.
 */
public class PanelReservar extends JPanel {
    // Constructor
    public PanelReservar() {
        super();
        setBounds(666, 669, 328, 45); // Establece las dimensiones y la posición del panel
        setOpaque(false); // Establece el panel como no opaco (transparente)

        // Manejador de eventos para el clic del mouse
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Itera sobre los asientos seleccionados para intentar reservar cada uno
                for (int i = 0; i < PanelAsiento.getAsientosSeleccionados().size(); i++) {
                    try {
                        PanelAsiento.getAsientosSeleccionados().get(i).reservar(); // Intenta reservar el asiento
                    } catch (AsientoNoDisponibleException ex) {
                        // Muestra un mensaje de error si el asiento no está disponible
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                // Repinta todos los paneles de asientos después de la operación de reserva
                for (int i = 0; i < 16; i++) {
                    PanelPrincipal.getAsientoPisoList().get(i).repaint();
                }

                // Repinta el panel principal
                Ventana.getPanelPrincipal().repaint();

                // Limpia la lista de asientos seleccionados
                PanelAsiento.getAsientosSeleccionados().clear();
            }
        });
    }
}

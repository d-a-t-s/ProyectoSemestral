package InterfazGrafica;

import Logica.Excepciones.AsientoNoDisponibleException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelReservar extends JPanel {
    // Constructor
    public PanelReservar() {
        super();
        setBounds(666, 669, 328, 45);
        setOpaque(false);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (int i = 0; i < PanelAsiento.getAsientosSeleccionados().size(); i++) {
                    try {
                        PanelAsiento.getAsientosSeleccionados().get(i).reservar();
                    } catch (AsientoNoDisponibleException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                for (int i = 0; i < 16; i++) {
                    PanelPrincipal.getAsientoPisoList().get(i).repaint();
                }
                Ventana.getPanelPrincipal().repaint();
                PanelAsiento.getAsientosSeleccionados().clear();
            }
        });
    }
}
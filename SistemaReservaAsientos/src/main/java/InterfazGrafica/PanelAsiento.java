package InterfazGrafica;

import Logica.Asiento;
import Logica.Excepciones.AsientoNoDisponibleException;
import Logica.Excepciones.SegundoPisoNoDisponibleException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PanelAsiento extends JPanel {
    // Propiedades
    private static Color color;
    private Asiento asiento;
    private static ArrayList<Asiento> asientosSeleccionados;

    // Constructor
    public PanelAsiento() {
        super();
        asientosSeleccionados = new ArrayList<>();
        setPreferredSize(new Dimension(45, 75));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                handleAsientoSelection();
            }
        });
    }

    private void handleAsientoSelection() {
        try {
            if (PanelPrincipal.getNumeroPiso() == 1) {
                PanelPrincipal.getAutobusSeleccionado().reservarAsientoPrimerPiso(asiento.getNumeroDeAsiento());
            } else if (PanelPrincipal.getNumeroPiso() == 2) {
                PanelPrincipal.getAutobusSeleccionado().reservarAsientoSegundoPiso(asiento.getNumeroDeAsiento());
            }
            asientosSeleccionados.add(asiento);
            repaint();
        } catch (AsientoNoDisponibleException | SegundoPisoNoDisponibleException ex) {
            JOptionPane.showMessageDialog(this, "El asiento no está disponible.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Métodos
    public static void inicializarAsientos(ArrayList<PanelAsiento> listaAsientos, PanelPrincipal panelPrincipal) {
        int aux = 0;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                PanelAsiento panelAsiento = new PanelAsiento();
                if (i == 2 || i == 3) {
                    panelAsiento.setBounds(697 + i * 67 + 20, 101 + j * 97, 45, 75);
                } else {
                    panelAsiento.setBounds(697 + i * 67, 101 + j * 97, 45, 75);
                }
                listaAsientos.add(panelAsiento);
                panelPrincipal.add(panelAsiento);
            }
            aux += 4;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (asiento == null) {
            color = Color.LIGHT_GRAY;
        } else if (asiento.getDisponibilidad()) {
            color = Color.GREEN;
        } else {
            color = Color.RED;
        }
        g.setColor(color);
        g.fillRect(0, 0, 45, 75);
    }

    // Getters y setters
    public Asiento getAsiento() {
        return asiento;
    }

    public static ArrayList<Asiento> getAsientosSeleccionados() {
        return asientosSeleccionados;
    }

    public static void setColor(Color col) {
        color = col;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public static void setAsientosSeleccionados(ArrayList<Asiento> asientos) {
        asientosSeleccionados = asientos;
    }
}

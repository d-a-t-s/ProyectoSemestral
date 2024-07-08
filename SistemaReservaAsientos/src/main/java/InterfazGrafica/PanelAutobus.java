package InterfazGrafica;

import Logica.Autobuses.Autobus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelAutobus extends JPanel implements PanelSeleccionable {
    // Propiedades
    private Autobus bus;
    private boolean seleccionado = false;
    private PanelInformacion panelInformacion;

    // Constructor
    public PanelAutobus(Autobus bus) {
        super();
        this.bus = bus;
        setOpaque(false);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Seleccionar este panel de autobús
                if (panelInformacion != null) {
                    panelInformacion.limpiarInformacion();
                }
                PanelPrincipal.setNumeroPiso(1);
                GestorSeleccion.seleccionarPanel(PanelAutobus.this);
                PanelPrincipal.setAutobusSeleccionado(bus);
                PanelAsiento.limpiarAsientosSeleccionados();

                // Actualizar los asientos de los pisos
                for (int i = 0; i < 16; i++) {
                    PanelPrincipal.getAsientoPiso1List().get(i).setAsientoNormal(bus.getAsientosPrimerPiso().get(i));
                    if (bus.getAsientosSegundoPiso() == null) {
                        PanelPrincipal.getAsientoPiso1List().get(i).setAsientoVIP(null);
                    } else {
                        PanelPrincipal.getAsientoPiso1List().get(i).setAsientoVIP(bus.getAsientosSegundoPiso().get(i));
                    }
                    PanelPrincipal.getAsientoPiso1List().get(i).repaint();
                }
            }
        });
    }

    // Métodos de la interfaz PanelSeleccionable
    @Override
    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
        repaint(); // Repintar el panel cuando cambia la selección
    }

    @Override
    public boolean isSelected() {
        return seleccionado;
    }

    // Método paintComponent para dibujar el panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibuja la información del autobús
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString(bus.getCompany(), 3, 28);
        g.drawString(bus.getHoraSalida() + "/" + bus.getHoraLlegada(), 148, 28);
        g.drawString(bus.getDestino(), 270, 28);
        g.drawString(bus.getnPisos(), 450, 28);

        // Dibuja el número de asientos disponibles por piso
        int aux = bus.numeroAsientosDisponiblesPrimerPiso();
        int aux1 = bus.numeroAsientosDisponiblesSegundoPiso();

        if (bus.getAsientosSegundoPiso() == null) {
            g.drawString("Piso 1: " + Integer.toString(aux), 550, 30);
        } else {
            g.drawString("Piso 1: " + Integer.toString(aux), 550, 20);
            g.drawString("Piso 2: " + Integer.toString(aux1), 550, 38);
        }

        // Si está seleccionado, dibuja un borde alrededor del panel
        if (isSelected()) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(3)); // Grosor del borde
            g.setColor(Color.BLUE);
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        }
    }
    public int getPrecioNormal(){
        return bus.getPrecioAsientoNormal();
    }
    public int getPrecioVIP(){
        return bus.getPrecioAsientoVIP();
    }
}




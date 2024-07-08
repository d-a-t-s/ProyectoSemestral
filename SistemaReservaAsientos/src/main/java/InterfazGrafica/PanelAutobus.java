package InterfazGrafica;

import Logica.Autobuses.Autobus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Panel gráfico que representa un autobús en la interfaz de usuario.
 */
public class PanelAutobus extends JPanel implements PanelSeleccionable {
    // Propiedades
    private Autobus bus;
    private boolean seleccionado = false;
    private PanelInformacion panelInformacion;

    /**
     * Constructor que inicializa el panel de autobús.
     *
     * @param bus El objeto Autobus asociado a este panel.
     */
    public PanelAutobus(Autobus bus) {
        super();
        this.bus = bus;
        setOpaque(false); // Hace que el panel sea transparente

        // Manejador de eventos de clic del ratón para seleccionar este panel de autobús
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Limpiar la información del panel de información si existe
                if (panelInformacion != null) {
                    panelInformacion.limpiarInformacion();
                }

                // Establecer el número de piso en el panel principal
                PanelPrincipal.setNumeroPiso(1);

                // Seleccionar este panel de autobús usando el GestorSeleccion
                GestorSeleccion.seleccionarPanel(PanelAutobus.this);

                // Establecer el autobús seleccionado en el panel principal
                PanelPrincipal.setAutobusSeleccionado(bus);

                // Limpiar los asientos seleccionados en el PanelAsiento
                PanelAsiento.limpiarAsientosSeleccionados();

                // Actualizar los asientos de los pisos en el PanelPrincipal
                for (int i = 0; i < 16; i++) {
                    PanelPrincipal.getAsientoPisoList().get(i).setAsientoNormal(bus.getAsientosPrimerPiso().get(i));
                    if (bus.getAsientosSegundoPiso() == null) {
                        PanelPrincipal.getAsientoPisoList().get(i).setAsientoVIP(null);
                    } else {
                        PanelPrincipal.getAsientoPisoList().get(i).setAsientoVIP(bus.getAsientosSegundoPiso().get(i));
                    }
                    PanelPrincipal.getAsientoPisoList().get(i).repaint();
                }
            }
        });
    }

    // Métodos de la interfaz PanelSeleccionable

    /**
     * Establece si el panel de autobús está seleccionado o no.
     *
     * @param seleccionado true si el panel está seleccionado, false si no lo está.
     */
    @Override
    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
        repaint(); // Repintar el panel cuando cambia la selección
    }

    /**
     * Verifica si el panel de autobús está seleccionado.
     *
     * @return true si el panel está seleccionado, false si no lo está.
     */
    @Override
    public boolean isSelected() {
        return seleccionado;
    }

    // Método paintComponent para dibujar el panel

    /**
     * Dibuja el contenido gráfico del panel de autobús.
     *
     * @param g El contexto gráfico utilizado para dibujar el componente.
     */
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

    /**
     * Obtiene el precio del asiento normal de este autobús.
     *
     * @return El precio del asiento normal.
     */
    public int getPrecioNormal() {
        return bus.getPrecioAsientoNormal();
    }

    /**
     * Obtiene el precio del asiento VIP de este autobús.
     *
     * @return El precio del asiento VIP.
     */
    public int getPrecioVIP() {
        return bus.getPrecioAsientoVIP();
    }
}

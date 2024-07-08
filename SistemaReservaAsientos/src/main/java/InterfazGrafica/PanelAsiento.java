package InterfazGrafica;

import Logica.Asiento;
import Logica.Excepciones.SegundoPisoNoDisponibleException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Panel gráfico que representa un asiento en la interfaz de usuario.
 */
public class PanelAsiento extends JPanel {
    private static Color color;
    private Asiento asientoNormal;
    private Asiento asientoVIP;
    private static ArrayList<Asiento> asientosSeleccionados;
    private PanelPrincipal panelPrincipal;

    /**
     * Constructor que inicializa el panel de asiento.
     *
     * @param panelPrincipal La instancia del panel principal al que pertenece este panel de asiento.
     */
    public PanelAsiento(PanelPrincipal panelPrincipal) {
        super();
        this.panelPrincipal = panelPrincipal;
        asientosSeleccionados = new ArrayList<>();

        // Manejador de eventos de clic del ratón para seleccionar/deseleccionar el asiento
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    if (PanelPrincipal.getNumeroPiso() == 1) {
                        if (asientosSeleccionados.contains(asientoNormal)) {
                            asientosSeleccionados.remove(asientoNormal);
                        } else {
                            asientosSeleccionados.add(asientoNormal);
                        }
                    } else if (PanelPrincipal.getNumeroPiso() == 2) {
                        if (asientoVIP == null) {
                            throw new SegundoPisoNoDisponibleException("Este autobús no tiene segundo piso.");
                        }
                        if (asientosSeleccionados.contains(asientoVIP)) {
                            asientosSeleccionados.remove(asientoVIP);
                        } else {
                            asientosSeleccionados.add(asientoVIP);
                        }
                    }
                    panelPrincipal.getPanelInformacion().actualizarInformacion(asientosSeleccionados);
                    repaint(); // Vuelve a pintar el panel después de cada clic
                } catch (SegundoPisoNoDisponibleException ex) {
                    // Captura la excepción y muestra un mensaje de error al usuario
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    /**
     * Método estático para inicializar los asientos en el panel principal.
     *
     * @param listaAsientos La lista de paneles de asientos que se inicializarán.
     * @param panelPrincipal La instancia del panel principal al que pertenecen los paneles de asientos.
     */
    public static void inicializarAsientos(ArrayList<PanelAsiento> listaAsientos, PanelPrincipal panelPrincipal) {
        int aux = 0;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                if (i == 2 || i == 3) {
                    listaAsientos.add(new PanelAsiento(panelPrincipal));
                    listaAsientos.get(i + aux).setBounds(697 + i * 67 + 20, 101 + j * 97, 45, 75);
                    panelPrincipal.add(listaAsientos.get(i + aux));
                } else {
                    listaAsientos.add(new PanelAsiento(panelPrincipal));
                    listaAsientos.get(i + aux).setBounds(697 + i * 67, 101 + j * 97, 45, 75);
                    panelPrincipal.add(listaAsientos.get(i + aux));
                }
            }
            aux = aux + 4;
        }
    }

    /**
     * Método para pintar el componente gráfico del panel de asiento.
     *
     * @param g El contexto gráfico utilizado para pintar el componente.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (PanelPrincipal.getNumeroPiso() == 1) {
            if (asientoNormal == null) {
                color = Color.LIGHT_GRAY;
            } else if (asientoNormal.getDisponibilidad()) {
                color = Color.GREEN;
            } else {
                color = Color.RED;
            }
            if (asientosSeleccionados.contains(asientoNormal)) {
                color = Color.BLUE; // Si está seleccionado, píntalo de azul
            }
            g.setColor(color);
            g.fillRect(0, 0, 45, 75);
        } else if (PanelPrincipal.getNumeroPiso() == 2) {
            if (asientoVIP == null) {
                color = Color.LIGHT_GRAY;
            } else if (asientoVIP.getDisponibilidad()) {
                color = Color.GREEN;
            } else {
                color = Color.RED;
            }
            if (asientosSeleccionados.contains(asientoVIP)) {
                color = Color.BLUE; // Si está seleccionado, píntalo de azul
            }
            g.setColor(color);
            g.fillRect(0, 0, 45, 75);
        }
    }

    // Métodos getter y setter para los asientos

    /**
     * Obtiene el asiento normal asociado a este panel.
     *
     * @return El objeto Asiento asociado al asiento normal.
     */
    public Asiento getAsientoNormal() {
        return asientoNormal;
    }

    /**
     * Obtiene el asiento VIP asociado a este panel.
     *
     * @return El objeto Asiento asociado al asiento VIP.
     */
    public Asiento getAsientoVIP() {
        return asientoVIP;
    }

    /**
     * Obtiene la lista de asientos seleccionados.
     *
     * @return La lista de asientos seleccionados.
     */
    public static ArrayList<Asiento> getAsientosSeleccionados() {
        return asientosSeleccionados;
    }

    /**
     * Establece el asiento normal asociado a este panel.
     *
     * @param asiento El objeto Asiento a establecer como asiento normal.
     */
    public void setAsientoNormal(Asiento asiento) {
        this.asientoNormal = asiento;
    }

    /**
     * Establece el asiento VIP asociado a este panel.
     *
     * @param asiento El objeto Asiento a establecer como asiento VIP.
     */
    public void setAsientoVIP(Asiento asiento) {
        this.asientoVIP = asiento;
    }

    /**
     * Establece la lista de asientos seleccionados.
     *
     * @param asientos La lista de asientos a establecer como seleccionados.
     */
    public static void setAsientosSeleccionados(ArrayList<Asiento> asientos) {
        asientosSeleccionados = asientos;
    }

    /**
     * Limpia la lista de asientos seleccionados.
     */
    public static void limpiarAsientosSeleccionados() {
        asientosSeleccionados.clear();
    }
}

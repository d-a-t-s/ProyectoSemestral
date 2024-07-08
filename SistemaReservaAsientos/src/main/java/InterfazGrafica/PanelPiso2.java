package InterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Panel gráfico que representa y gestiona la selección del segundo piso en la interfaz de usuario.
 */
public class PanelPiso2 extends JPanel implements PanelSeleccionable {
    // Propiedad para indicar si el panel está seleccionado
    private boolean isSelected = false;

    /**
     * Constructor que inicializa el panel del segundo piso.
     */
    public PanelPiso2() {
        super();
        setOpaque(false); // Hace que el panel no sea opaco para visualizar el fondo de otros componentes
        setBounds(833, 6, 161, 45); // Posición y tamaño del panel en la interfaz

        // Listener para manejar el clic del mouse en el panel
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                PanelPrincipal.setNumeroPiso(2); // Establece el segundo piso como el piso seleccionado
                for (int i = 0; i < 16; i++) {
                    PanelPrincipal.getAsientoPisoList().get(i).repaint(); // Repinta todos los asientos del piso seleccionado
                }

                // Maneja la selección del panel
                if (isSelected) {
                    GestorSeleccion.deseleccionarTodos(); // Deselecciona todos los paneles si ya está seleccionado
                } else {
                    GestorSeleccion.seleccionarPanel(PanelPiso2.this); // Selecciona este panel si no está seleccionado
                }
            }
        });
    }

    /**
     * Método para pintar el componente, ajustado para mostrar el fondo semi-transparente cuando está seleccionado.
     *
     * @param g Objeto Graphics para dibujar en el componente.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (isSelected) {
            // Color semi-transparente para el fondo seleccionado
            Color semiTransparentBlack = new Color(0, 0, 0, 64);
            g.setColor(semiTransparentBlack);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    // Implementación de métodos de la interfaz PanelSeleccionable

    /**
     * Establece si este panel está seleccionado o no.
     *
     * @param seleccionado Booleano que indica si el panel está seleccionado.
     */
    @Override
    public void setSeleccionado(boolean seleccionado) {
        isSelected = seleccionado;
        repaint(); // Vuelve a pintar el panel cuando cambia la selección
    }

    /**
     * Verifica si este panel está seleccionado.
     *
     * @return true si el panel está seleccionado, false en caso contrario.
     */
    @Override
    public boolean isSelected() {
        return isSelected;
    }
}

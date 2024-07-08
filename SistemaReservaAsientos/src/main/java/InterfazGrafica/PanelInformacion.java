package InterfazGrafica;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import Logica.Asiento;

/**
 * Panel gráfico que muestra información de los asientos seleccionados en la interfaz de usuario.
 */
public class PanelInformacion extends JPanel {
    private JTextArea areaInformacion;

    /**
     * Constructor que inicializa el panel de información de asientos.
     */
    public PanelInformacion() {
        super();
        setBackground(new Color(245, 245, 220)); // Color de fondo beige claro
        setBounds(666, 516, 328, 147); // Posición y tamaño del panel
        setLayout(new BorderLayout());

        // Crear borde con título para el panel
        TitledBorder border = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
                "Información de Asientos",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14),
                Color.DARK_GRAY
        );
        setBorder(border);

        // Crear y configurar el área de texto para mostrar la información
        areaInformacion = new JTextArea();
        areaInformacion.setEditable(false);
        areaInformacion.setLineWrap(true);
        areaInformacion.setWrapStyleWord(true);
        areaInformacion.setFont(new Font("Arial", Font.PLAIN, 12));
        areaInformacion.setBackground(new Color(255, 250, 240)); // Fondo de texto de color marfil
        areaInformacion.setForeground(Color.DARK_GRAY);

        // Agregar área de texto con scroll para manejar más contenido
        JScrollPane scrollPane = new JScrollPane(areaInformacion);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Actualiza la información mostrada en el área de texto con los asientos seleccionados.
     *
     * @param asientosSeleccionados Lista de asientos seleccionados que se mostrarán en el panel.
     */
    public void actualizarInformacion(ArrayList<Asiento> asientosSeleccionados) {
        StringBuilder informacion = new StringBuilder();
        for (Asiento asiento : asientosSeleccionados) {
            informacion.append(asiento.toString());
            // Mostrar precio según si es VIP o no
            if (asiento.esVIP()) {
                informacion.append(", Precio=").append(PanelPrincipal.getAutobusSeleccionado().getPrecioAsientoVIP());
            } else {
                informacion.append(", Precio=").append(PanelPrincipal.getAutobusSeleccionado().getPrecioAsientoNormal());
            }
            informacion.append("\n");
        }
        areaInformacion.setText(informacion.toString());
    }

    /**
     * Limpia el contenido del área de texto, eliminando toda la información mostrada.
     */
    public void limpiarInformacion() {
        areaInformacion.setText("");
    }
}

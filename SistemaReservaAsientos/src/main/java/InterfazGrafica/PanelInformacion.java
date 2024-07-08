package InterfazGrafica;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import Logica.Asiento;

public class PanelInformacion extends JPanel {
    private JTextArea areaInformacion;

    public PanelInformacion() {
        super();
        setBackground(new Color(245, 245, 220)); // Color de fondo beige claro
        setBounds(666, 516, 328, 147);
        setLayout(new BorderLayout());

        // Crear borde con título
        TitledBorder border = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
                "Información de Asientos",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14),
                Color.DARK_GRAY
        );
        setBorder(border);

        // Crear y configurar el área de texto
        areaInformacion = new JTextArea();
        areaInformacion.setEditable(false);
        areaInformacion.setLineWrap(true);
        areaInformacion.setWrapStyleWord(true);
        areaInformacion.setFont(new Font("Arial", Font.PLAIN, 12));
        areaInformacion.setBackground(new Color(255, 250, 240)); // Fondo de texto de color marfil
        areaInformacion.setForeground(Color.DARK_GRAY);

        // Agregar área de texto con scroll
        JScrollPane scrollPane = new JScrollPane(areaInformacion);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane, BorderLayout.CENTER);
    }

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

    public void limpiarInformacion() {
        areaInformacion.setText("");
    }
}

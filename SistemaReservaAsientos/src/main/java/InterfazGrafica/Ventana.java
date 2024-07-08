package InterfazGrafica;

import javax.swing.*;

/**
 * Clase que representa la ventana principal de la aplicación.
 */
public class Ventana extends JFrame {
    private static PanelPrincipal panelPrincipal;

    /**
     * Constructor de la clase Ventana.
     * Configura y muestra la ventana principal.
     */
    public Ventana() {
        super();
        this.setTitle("Transportes papu"); // Título de la ventana
        panelPrincipal = new PanelPrincipal(); // Instancia del panel principal
        this.add(panelPrincipal); // Agrega el panel principal a la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        this.pack(); // Ajusta el tamaño de la ventana según los componentes internos
        this.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        this.setVisible(true); // Hace visible la ventana
        this.setResizable(false); // Evita que se pueda redimensionar la ventana
    }

    /**
     * Método estático para obtener el panel principal de la ventana.
     * @return el panel principal de la ventana.
     */
    public static PanelPrincipal getPanelPrincipal() {
        return panelPrincipal;
    }
}

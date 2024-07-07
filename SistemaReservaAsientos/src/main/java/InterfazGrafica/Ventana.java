package InterfazGrafica;

import javax.swing.*;

public class Ventana extends JFrame{
    private static PanelPrincipal panelPrincipal;

    public Ventana(){
        super();
        this.setTitle("Expendedor");
        panelPrincipal = new PanelPrincipal();
        this.add(panelPrincipal);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    //Getters y setters
    public static PanelPrincipal getPanelPrincipal(){
        return panelPrincipal;
    }
}

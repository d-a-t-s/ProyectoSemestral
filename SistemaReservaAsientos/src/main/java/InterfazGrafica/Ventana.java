package InterfazGrafica;

import javax.swing.*;

public class Ventana extends JFrame{
    private PanelPrincipal panelPrincipal;

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
}

package InterfazGrafica;

import javax.swing.*;
import java.awt.*;

public class PanelAsiento extends JPanel{
    //Propiedades
    private Color color = null;
    //Constructor
    public PanelAsiento() {
        super();
    }
    //Metodos
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0,0,45,75);
    }
    //Getters y setters
    public void setColor(Color color){
        this.color = color;
    }
}
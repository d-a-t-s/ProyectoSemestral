package InterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelPiso2 extends JPanel{
    //Propiedades

    //Constructor
    public PanelPiso2(){
        super();
        setOpaque(false);
        setBounds(833, 6, 161, 45);


        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                PanelPrincipal.setNumeroPiso(2);
                for(int i = 0; i < 16; i++){
                    PanelPrincipal.getAsientoPiso1List().get(i).repaint();
                }
            }
        });
    }
}

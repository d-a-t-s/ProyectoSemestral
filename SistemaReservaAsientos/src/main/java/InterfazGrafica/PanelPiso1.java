package InterfazGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelPiso1 extends JPanel implements PanelSeleccionable{
    //Propiedades
    private static boolean isSelected = false;
    //Constructor
    public PanelPiso1(){
        super();
        setOpaque(false);
        setBounds(666, 6, 161, 45);


        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                PanelPrincipal.setNumeroPiso(1);
                for(int i = 0; i < 16; i++){
                    PanelPrincipal.getAsientoPiso1List().get(i).repaint();
                }

                if (isSelected) {
                    GestorSeleccion.deseleccionarTodos();
                } else {
                    GestorSeleccion.seleccionarPanel(PanelPiso1.this);
                }
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (isSelected) {
            // Color semi-transparente para el fondo seleccionado
            Color semiTransparentBlack = new Color(0, 0, 0, 64);
            g.setColor(semiTransparentBlack);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    // Implementación de métodos de PanelSeleccionable
    @Override
    public void setSeleccionado(boolean seleccionado) {
        isSelected = seleccionado;
        repaint();
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }
}
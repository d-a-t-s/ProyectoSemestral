package InterfazGrafica;

import Logica.Excepciones.AsientoNoDisponibleException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelReservar extends JPanel{
    //Propiedades

    //Constructor
    public PanelReservar(){
        super();
        setBounds(666, 669, 161, 45);
        setOpaque(false);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                for(int i = 0; i < PanelAsiento.getAsientosSeleccionados().size(); i++){
                    try {
                        PanelAsiento.getAsientosSeleccionados().get(i).reservar();
                    } catch (AsientoNoDisponibleException ex){
                        System.out.println("Asiento no disponible");
                    }
                }
                for(int i = 0; i < 16; i++){
                    if(PanelPrincipal.getNumeroPiso() == 1){
                        PanelPrincipal.getAsientoPiso1List().get(i).repaint();
                    }else if(PanelPrincipal.getNumeroPiso() == 2){
                        PanelPrincipal.getAsientoPiso2List().get(i).repaint();
                    }
                }
                PanelAsiento.getAsientosSeleccionados().clear();
            }
        });
    }
}

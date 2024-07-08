package InterfazGrafica;

import Logica.Autobuses.Autobus;

import javax.swing.*;
import javax.xml.transform.Source;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelAutobus extends JPanel{
    //Propiedades
    private Autobus bus;
    //Constructor
    public PanelAutobus(Autobus bus){
        super();
        this.bus = bus;
        setOpaque(false);


        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                PanelPrincipal.setAutobusSeleccionado(bus);
                for(int i = 0; i < 16; i++){
                    PanelPrincipal.getAsientoPiso1List().get(i).setAsientoNormal(bus.getAsientosPrimerPiso().get(i));
                    if(bus.getAsientosSegundoPiso() == null){
                        PanelPrincipal.getAsientoPiso1List().get(i).setAsientoVIP(null);
                    }else{
                        PanelPrincipal.getAsientoPiso1List().get(i).setAsientoVIP(bus.getAsientosSegundoPiso().get(i));
//                        PanelPrincipal.getAsientoPiso2List().get(i).repaint();
                    }
                    PanelPrincipal.getAsientoPiso1List().get(i).repaint();
                }
//                Ventana.getPanelPrincipal().repaint();
            }
        });
    }
    //Metodos
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString(bus.getCompany(), 3, 28);
        g.drawString(bus.getHoraSalida() + "/" + bus.getHoraLlegada(), 148, 28);
        g.drawString(bus.getDestino(), 270, 28);
        g.drawString(bus.getnPisos(), 450, 28);
        int aux = bus.numeroAsientosDisponiblesPrimerPiso();
        int aux1 = bus.numeroAsientosDisponiblesSegundoPiso();


        if(bus.getAsientosSegundoPiso() == null){
            g.drawString("Piso 1: " + Integer.toString(aux), 550, 30);
        }else{
            g.drawString("Piso 1: " + Integer.toString(aux), 550, 20);
            g.drawString("Piso 2: " + Integer.toString(aux1), 550, 38);
        }
    }
}

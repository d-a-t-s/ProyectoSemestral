package InterfazGrafica;

import Logica.Asiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PanelAsiento extends JPanel{
    //Propiedades
    private static Color color;
    private Asiento asiento;
    private ArrayList<PanelAsiento> asientosSeleccionados;
    //Constructor
    public PanelAsiento() {
        super();




//        this.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//        });
    }
    //Metodos
    public static void inicializarAsientos(ArrayList<PanelAsiento> listaAssientos, PanelPrincipal panelPrincipal){
        int aux = 0;
        for(int j = 0; j < 4; j++){
            for(int i = 0; i < 4; i++){
                if (i == 2 || i == 3) {
                    listaAssientos.add(new PanelAsiento());
                    listaAssientos.get(i + aux).setBounds(697 + i * 67 + 20, 101 + j * 97, 45, 75);
                    panelPrincipal.add(listaAssientos.get(i + aux));
                }else{

                    listaAssientos.add(new PanelAsiento());
                    listaAssientos.get(i + aux).setBounds(697 + i * 67, 101 + j * 97, 45, 75);
                    panelPrincipal.add(listaAssientos.get(i + aux));

                }
            }
            aux = aux + 4;
        }
    }
    @Override
    public void paintComponent(Graphics g){ //ESTE METODO DEBE TENERSE EN CUENTA Y PROBARSE LUEGO PUES DADO QUE TODOS LOS ASIENTOS ESTAN DISPONIBLES NO SE PUEDE SABER SI REALMENTE FUNCIONA CORRECTAMENTE
        super.paintComponent(g);

        if(asiento == null){
            color = Color.LIGHT_GRAY;
        }else if(asiento.getDisponibilidad() == true){
            color = Color.GREEN;
        }else if(asiento.getDisponibilidad() == false){
            color = Color.RED;
        }
        g.setColor(color);
        g.fillRect(0,0,45,75);
    }
    //Getters y setters
    public Asiento getAsiento(){
        return asiento;
    }

    public static void setColor(Color col){
        color = col;
    }
    public void setAsiento(Asiento asiento){
        this.asiento = asiento;
    }
}

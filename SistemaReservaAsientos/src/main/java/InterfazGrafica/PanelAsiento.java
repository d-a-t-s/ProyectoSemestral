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
    private Asiento asientoNormal;
    private Asiento asientoVIP;
    private static ArrayList<Asiento> asientosSeleccionados;
    //Constructor
    public PanelAsiento() {
        super();
        asientosSeleccionados = new ArrayList<>();



        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if(PanelPrincipal.getNumeroPiso() == 1){
                    if(asientosSeleccionados.contains(asientoNormal)){

                    }else{
                        asientosSeleccionados.add(asientoNormal);
                    }
                }else if(PanelPrincipal.getNumeroPiso() == 2){
                    if(asientosSeleccionados.contains(asientoVIP) || asientoVIP == null){

                    }else{
                        asientosSeleccionados.add(asientoVIP);
                    }
                }
//                if(PanelPrincipal.getNumeroPiso() == 1){
//                    for(int i = 0; i < 16; i++){
//                        PanelPrincipal.getAsientoPiso2List().get(i).setEnabled(false);
//                    }
//                }else if(PanelPrincipal.getNumeroPiso() == 2){
//                    for(int i = 0; i < 16; i++){
//                        PanelPrincipal.getAsientoPiso1List().get(i).setEnabled(false);
//                    }
//                }
//                asientosSeleccionados.add(asiento);
//                if(PanelPrincipal.getNumeroPiso() == 1){
//                    for(int i = 0; i < 16; i++){
//                        PanelPrincipal.getAsientoPiso2List().get(i).setEnabled(true);
//                    }
//                }else if(PanelPrincipal.getNumeroPiso() == 2){
//                    for(int i = 0; i < 16; i++){
//                        PanelPrincipal.getAsientoPiso1List().get(i).setEnabled(true);
//                    }
//                }
            }
        });
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
        if(PanelPrincipal.getNumeroPiso() == 1){
            if(asientoNormal == null){
                color = Color.LIGHT_GRAY;
            }else if(asientoNormal.getDisponibilidad() == true){
                color = Color.GREEN;
            }else if(asientoNormal.getDisponibilidad() == false){
                color = Color.RED;
            }
            g.setColor(color);
            g.fillRect(0,0,45,75);
        }else if(PanelPrincipal.getNumeroPiso() == 2){
            if(asientoVIP == null){
                color = Color.LIGHT_GRAY;
            }else if(asientoVIP.getDisponibilidad() == true){
                color = Color.GREEN;
            }else if(asientoVIP.getDisponibilidad() == false){
                color = Color.RED;
            }
            g.setColor(color);
            g.fillRect(0,0,45,75);
        }

    }
    //Getters y setters
    public Asiento getAsientoNormal(){
        return asientoNormal;
    }
    public Asiento getAsientoVIP(){
        return asientoVIP;
    }
    public static ArrayList<Asiento> getAsientosSeleccionados(){
        return asientosSeleccionados;
    }
    public static void setColor(Color col){
        color = col;
    }
    public void setAsientoNormal(Asiento asiento){
        this.asientoNormal = asiento;
    }
    public void setAsientoVIP(Asiento asiento){
        this.asientoVIP = asiento;
    }
    public static void setAsientosSeleccionados(ArrayList<Asiento> asientos){
        asientosSeleccionados = asientos;
    }
}

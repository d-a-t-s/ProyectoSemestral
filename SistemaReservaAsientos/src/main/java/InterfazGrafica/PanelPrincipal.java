package InterfazGrafica;

import Logica.Autobuses.*;
import Logica.Decorators.*;
import Logica.HoraSalida;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelPrincipal extends JPanel{
    //Propiedades
    private Image imagenInterfaz = new ImageIcon(getClass().getClassLoader().getResource("InterfazReserva.png")).getImage();
    private PanelPiso1 panelPiso1;
    private PanelPiso2 panelPiso2;
    private PanelReservar panelReservar;
    private PanelIngresar panelIngresar;
    private PanelInformacion panelInformacion;
    private ArrayList<PanelAsiento> asientoList;
    private ArrayList<PanelesAutobuses> panelesAutobuseslist;
    //Constructor
    public PanelPrincipal(){
        super();
        //Instanciamos un bus de cada uno
        Autobus bus1 = new PapuBuses(HoraSalida.MORNING);
        Autobus bus2 = new TilinExpress(HoraSalida.AFTERNOON);
        Autobus bus3 = new SigmaService(HoraSalida.EVENING);
        Autobus bus4 = new SkibidiTravel(HoraSalida.NIGHT);
        Autobus bus5 = new MewingMobility(HoraSalida.NIGHT);
        //Les asignamos un destino a cada bus
        bus1 = new PapusVilleDecorator(bus1);
        bus2 = new TilinTownDecorator(bus2);
        bus3 = new SigmaCityDecorator(bus3);
        bus4 = new SkibidiSpringsDecorator(bus4);
        bus5 = new MewingMetropolisDecorator(bus5);
        //Declaramos las condiciones basicas
        Dimension size = new Dimension(imagenInterfaz.getWidth(null), imagenInterfaz.getHeight(null));
        this.setPreferredSize(size);
        this.setLayout(null);
        //Agregamos los paneles para seleccionar el piso del autobus
        panelPiso1 = new PanelPiso1();
        this.add(panelPiso1);
        panelPiso2 = new PanelPiso2();
        this.add(panelPiso2);
        //Agregamos los paneles para reservar y para ingresar
        panelReservar = new PanelReservar();
        this.add(panelReservar);
        panelIngresar = new PanelIngresar();
        this.add(panelIngresar);
        //Agregamos el panel de informacion
        panelInformacion = new PanelInformacion();
        this.add(panelInformacion);
        //Agregamos los paneles con los que seleccionaremos los asientos
        asientoList = new ArrayList<>();
        int aux = 0;
        for(int j = 0; j < 4; j++){
            for(int i = 0; i < 4; i++){
                if (i == 2 || i == 3) {
                    asientoList.add(new PanelAsiento());
                    asientoList.get(i + aux).setBounds(697 + i * 67 + 20, 101 + j * 97, 45, 75);
                    this.add(asientoList.get(i + aux));
                }else{
                    asientoList.add(new PanelAsiento());
                    asientoList.get(i + aux).setBounds(697 + i * 67, 101 + j * 97, 45, 75);
                    this.add(asientoList.get(i + aux));
                }
            }
            aux = aux + 4;
        }
        //Agregamos los paneles con los que se seleccionaran los autobuses
        panelesAutobuseslist = new ArrayList<>();
        for(int i = 0; i < 13; i++){
            panelesAutobuseslist.add(new PanelesAutobuses());
            panelesAutobuseslist.get(i).setBounds(6,57 + i*51,654,45);
            this.add(panelesAutobuseslist.get(i));
        }
    }
    //Metodos
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenInterfaz, 0, 0, null);
    }
}
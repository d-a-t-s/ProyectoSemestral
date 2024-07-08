package InterfazGrafica;

import Logica.Autobuses.*;
import Logica.Decorators.*;
import Logica.HoraSalida;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelPrincipal extends JPanel{
    //Propiedades
    private Image imagenInterfaz = new ImageIcon(getClass().getClassLoader().getResource("InterfazReservar.png")).getImage();
    private PanelPiso1 panelPiso1;
    private PanelPiso2 panelPiso2;
    private PanelReservar panelReservar;
    private PanelInformacion panelInformacion;
    private static ArrayList<PanelAsiento> asientoPisoList;
    private ArrayList<PanelAutobus> panelesAutobuseslist;
    private ArrayList<Autobus> autobusList;
    //Variable para saber a que autobus nos estamos refiriendo
    private static Autobus autobusSeleccionado;
    //Variable para saber a que numero de píso nos estamos refiriendo
    private static int numeroPiso = 0;

    //Constructor
    public PanelPrincipal(){
        super();

        //Instanciamos un bus de cada uno
        autobusList = new ArrayList<>();
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

        //Agregamos los buses a la lista
        autobusList.add(bus1);
        autobusList.add(bus2);
        autobusList.add(bus3);
        autobusList.add(bus4);
        autobusList.add(bus5);

        //Declaramos las condiciones basicas
        Dimension size = new Dimension(imagenInterfaz.getWidth(null), imagenInterfaz.getHeight(null));
        this.setPreferredSize(size);
        this.setLayout(null);

        //Agregamos los paneles para seleccionar el piso del autobus
        panelPiso1 = new PanelPiso1();
        this.add(panelPiso1);
        panelPiso2 = new PanelPiso2();
        this.add(panelPiso2);

        //Agregamos los paneles para reservar
        panelReservar = new PanelReservar();
        this.add(panelReservar);

        //Agregamos el panel de informacion
        panelInformacion = new PanelInformacion();
        this.add(panelInformacion);

        //Agregamos los paneles con los que seleccionaremos los asientos
        asientoPisoList = new ArrayList<>();
        PanelAsiento.inicializarAsientos(asientoPisoList, this);

        //Agregamos los paneles con los que se seleccionaran los autobuses
        panelesAutobuseslist = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            panelesAutobuseslist.add(new PanelAutobus(autobusList.get(i)));
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

    //Getters y Setters
    public static Autobus getAutobusSeleccionado(){
        return autobusSeleccionado;
    }
    public static ArrayList<PanelAsiento> getAsientoPisoList(){
        return asientoPisoList;
    }
    public static int getNumeroPiso(){
        return numeroPiso;
    }

    public static void setAutobusSeleccionado(Autobus autobusSelec){
        autobusSeleccionado = autobusSelec;
    }
    public static void setAsientoPisoList(ArrayList<PanelAsiento> asientoPiso1){
        asientoPisoList = asientoPiso1;
    }
    public static void setNumeroPiso(int num){
        numeroPiso = num;
    }
    public PanelInformacion getPanelInformacion() {
        return panelInformacion;
    }

}

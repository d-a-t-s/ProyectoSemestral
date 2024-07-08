package InterfazGrafica;

import Logica.Autobuses.*;
import Logica.Decorators.*;
import Logica.HoraSalida;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Panel principal de la interfaz gráfica para la reserva de autobuses.
 */
public class PanelPrincipal extends JPanel {
    // Propiedades
    private Image imagenInterfaz = new ImageIcon(getClass().getClassLoader().getResource("InterfazReservar.png")).getImage();
    private PanelPiso1 panelPiso1;
    private PanelPiso2 panelPiso2;
    private PanelReservar panelReservar;
    private PanelInformacion panelInformacion;
    private static ArrayList<PanelAsiento> asientoPisoList;
    private ArrayList<PanelAutobus> panelesAutobuseslist;
    private ArrayList<Autobus> autobusList;
    // Variable para saber a qué autobús nos estamos refiriendo
    private static Autobus autobusSeleccionado;
    // Variable para saber a qué número de piso nos estamos refiriendo
    private static int numeroPiso = 0;

    // Constructor
    public PanelPrincipal() {
        super();

        // Instanciamos un bus de cada uno
        autobusList = new ArrayList<>();
        Autobus bus1 = new PapuBuses(HoraSalida.MORNING);
        Autobus bus2 = new TilinExpress(HoraSalida.AFTERNOON);
        Autobus bus3 = new SigmaService(HoraSalida.EVENING);
        Autobus bus4 = new SkibidiTravel(HoraSalida.NIGHT);
        Autobus bus5 = new MewingMobility(HoraSalida.NIGHT);

        // Les asignamos un destino a cada bus
        bus1 = new PapusVilleDecorator(bus1);
        bus2 = new TilinTownDecorator(bus2);
        bus3 = new SigmaCityDecorator(bus3);
        bus4 = new SkibidiSpringsDecorator(bus4);
        bus5 = new MewingMetropolisDecorator(bus5);

        // Agregamos los buses a la lista
        autobusList.add(bus1);
        autobusList.add(bus2);
        autobusList.add(bus3);
        autobusList.add(bus4);
        autobusList.add(bus5);

        // Declaramos las condiciones básicas
        Dimension size = new Dimension(imagenInterfaz.getWidth(null), imagenInterfaz.getHeight(null));
        this.setPreferredSize(size);
        this.setLayout(null);

        // Agregamos los paneles para seleccionar el piso del autobús
        panelPiso1 = new PanelPiso1();
        this.add(panelPiso1);
        panelPiso2 = new PanelPiso2();
        this.add(panelPiso2);

        // Agregamos los paneles para reservar
        panelReservar = new PanelReservar();
        this.add(panelReservar);

        // Agregamos el panel de información
        panelInformacion = new PanelInformacion();
        this.add(panelInformacion);

        // Inicializamos la lista de paneles de asiento
        asientoPisoList = new ArrayList<>();
        PanelAsiento.inicializarAsientos(asientoPisoList, this);

        // Inicializamos la lista de paneles de autobuses y los añadimos al panel principal
        panelesAutobuseslist = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            panelesAutobuseslist.add(new PanelAutobus(autobusList.get(i)));
            panelesAutobuseslist.get(i).setBounds(6, 57 + i * 51, 654, 45);
            this.add(panelesAutobuseslist.get(i));
        }
    }

    // Métodos

    /**
     * Método sobrecargado para pintar el componente con una imagen de fondo.
     *
     * @param g Objeto Graphics para dibujar en el componente.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenInterfaz, 0, 0, null); // Dibuja la imagen de fondo en el panel principal
    }

    // Getters y Setters

    /**
     * Obtiene el autobús seleccionado actualmente.
     *
     * @return El autobús seleccionado.
     */
    public static Autobus getAutobusSeleccionado() {
        return autobusSeleccionado;
    }

    /**
     * Obtiene la lista de paneles de asientos.
     *
     * @return Lista de paneles de asientos.
     */
    public static ArrayList<PanelAsiento> getAsientoPisoList() {
        return asientoPisoList;
    }

    /**
     * Obtiene el número de piso seleccionado.
     *
     * @return Número de piso seleccionado.
     */
    public static int getNumeroPiso() {
        return numeroPiso;
    }

    /**
     * Establece el autobús seleccionado.
     *
     * @param autobusSelec Autobús que se va a seleccionar.
     */
    public static void setAutobusSeleccionado(Autobus autobusSelec) {
        autobusSeleccionado = autobusSelec;
    }

    /**
     * Establece la lista de paneles de asientos.
     *
     * @param asientoPiso1 Nueva lista de paneles de asientos.
     */
    public static void setAsientoPisoList(ArrayList<PanelAsiento> asientoPiso1) {
        asientoPisoList = asientoPiso1;
    }

    /**
     * Establece el número de piso seleccionado.
     *
     * @param num Número de piso que se va a seleccionar.
     */
    public static void setNumeroPiso(int num) {
        numeroPiso = num;
    }

    /**
     * Obtiene el panel de información.
     *
     * @return Panel de información.
     */
    public PanelInformacion getPanelInformacion() {
        return panelInformacion;
    }
}

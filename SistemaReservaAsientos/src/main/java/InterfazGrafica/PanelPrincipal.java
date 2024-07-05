package InterfazGrafica;

import InterfazGrafica.Asientos.CambioPisos;
import InterfazGrafica.Asientos.PanelAsiento;
import InterfazGrafica.Asientos.PanelPiso1;
import InterfazGrafica.Asientos.PanelPiso2;

import Logica.Autobuses.*;
import Logica.Decorators.*;
import Logica.HoraSalida;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelPrincipal extends JPanel {
    // Imagen de fondo para la interfaz
    private Image imagenInterfaz = new ImageIcon(getClass().getClassLoader().getResource("InterfazReserva.png")).getImage();

    // Paneles para el primer y segundo piso
    private PanelPiso1 panelPiso1;
    private PanelPiso2 panelPiso2;

    // Listas de asientos para cada piso y lista de asientos seleccionados
    private ArrayList<PanelAsiento> asientosPiso1;
    private ArrayList<PanelAsiento> asientosPiso2;
    private ArrayList<PanelAsiento> asientosSeleccionados;

    // Clase para gestionar el cambio de piso
    private CambioPisos cambioPisos;

    private PanelReservar panelReservar;
    private PanelIngresar panelIngresar;
    private PanelInformacion panelInformacion;
    private ArrayList<PanelAutobus> panelesAutobuseslist;

    // Constructor
    public PanelPrincipal() {
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

        // Configuración del tamaño del panel según la imagen de fondo
        Dimension size = new Dimension(imagenInterfaz.getWidth(null), imagenInterfaz.getHeight(null));
        this.setPreferredSize(size);
        this.setLayout(null); // Uso de layout absoluto

        // Inicialización y ubicación del panel del primer piso
        panelPiso1 = new PanelPiso1(this);
        panelPiso1.setBounds(666, 6, 161, 45);
        this.add(panelPiso1);

        // Inicialización y ubicación del panel del segundo piso
        panelPiso2 = new PanelPiso2(this);
        panelPiso2.setBounds(833, 6, 161, 45);
        this.add(panelPiso2);

        // Inicialización de los asientos del primer piso
        asientosPiso1 = new ArrayList<>();
        inicializarAsientos(asientosPiso1, 1);

        // Inicialización de los asientos del segundo piso
        asientosPiso2 = new ArrayList<>();
        inicializarAsientos(asientosPiso2, 2);

        // Inicialización de la lista de asientos seleccionados
        asientosSeleccionados = new ArrayList<>();

        // Inicialización de la clase CambioPisos para gestionar el cambio de piso
        cambioPisos = new CambioPisos(asientosPiso1, asientosPiso2);

        //Agregamos los paneles para reservar y para ingresar
        panelReservar = new PanelReservar();
        this.add(panelReservar);
        panelIngresar = new PanelIngresar();
        this.add(panelIngresar);
        //Agregamos el panel de informacion
        panelInformacion = new PanelInformacion();
        this.add(panelInformacion);

        //Agregamos los paneles con los que se seleccionaran los autobuses
        panelesAutobuseslist = new ArrayList<>();
        for(int i = 0; i < 13; i++){
            panelesAutobuseslist.add(new PanelAutobus());
            panelesAutobuseslist.get(i).setBounds(6,57 + i*51,654,45);
            this.add(panelesAutobuseslist.get(i));
        }
    }

    // Método privado para inicializar los asientos en un piso dado
    private void inicializarAsientos(ArrayList<PanelAsiento> listaAsientos, int numeroPiso) {
        int aux = 0;
        // Creación de los asientos en filas y columnas
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                // Creación del panel de asiento en la posición especificada
                PanelAsiento asiento = new PanelAsiento(numeroPiso, i, j);
                // Ajuste de la posición en el panel principal según la columna
                if (i == 2 || i == 3) {
                    asiento.setBounds(697 + i * 67 + 20, 101 + j * 97, 45, 75);
                } else {
                    asiento.setBounds(697 + i * 67, 101 + j * 97, 45, 75);
                }
                // Agregar el panel de asiento al panel principal y a la lista de asientos
                this.add(asiento);
                listaAsientos.add(asiento);
            }
            aux = aux + 4;
        }
    }

    // Método para cambiar de piso utilizando la clase CambioPisos
    public void cambiarPiso(int numeroPiso) {
        cambioPisos.cambiarPiso(numeroPiso);
    }

    // Sobrescritura del método paintComponent para dibujar la imagen de fondo
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenInterfaz, 0, 0, null); // Dibuja la imagen de fondo en el panel
    }
}

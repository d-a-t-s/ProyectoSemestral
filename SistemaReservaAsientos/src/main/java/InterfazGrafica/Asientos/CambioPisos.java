package InterfazGrafica.Asientos;

import java.util.ArrayList;

public class CambioPisos {
    // Listas de paneles de asientos para cada piso y lista de asientos seleccionados
    private ArrayList<PanelAsiento> asientosPiso1; // Asientos del primer piso
    private ArrayList<PanelAsiento> asientosPiso2; // Asientos del segundo piso
    private ArrayList<PanelAsiento> asientosSeleccionados; // Asientos seleccionados en cualquier piso

    // Constructor que inicializa las listas de asientos para ambos pisos
    public CambioPisos(ArrayList<PanelAsiento> asientosPiso1, ArrayList<PanelAsiento> asientosPiso2) {
        this.asientosPiso1 = asientosPiso1;
        this.asientosPiso2 = asientosPiso2;
        this.asientosSeleccionados = new ArrayList<>(); // Inicializa la lista de asientos seleccionados
    }

    // Método para cambiar entre el primer y segundo piso
    public void cambiarPiso(int numeroPiso) {
        // Determina qué lista de asientos es el piso actual y cuál es el piso anterior
        ArrayList<PanelAsiento> asientosActuales = (numeroPiso == 1) ? asientosPiso1 : asientosPiso2;
        ArrayList<PanelAsiento> asientosAnteriores = (numeroPiso == 1) ? asientosPiso2 : asientosPiso1;

        // Guarda los asientos seleccionados del piso actual antes de cambiar
        asientosSeleccionados.clear();
        for (PanelAsiento asiento : asientosAnteriores) {
            if (asiento.isSeleccionado()) {
                asientosSeleccionados.add(asiento);
            }
        }

        // Oculta los asientos del piso anterior y muestra los del nuevo piso
        for (PanelAsiento asiento : asientosAnteriores) {
            asiento.setVisible(false);
        }
        for (PanelAsiento asiento : asientosActuales) {
            asiento.setVisible(true);
        }

        // Restaura la selección de asientos en el nuevo piso si existen asientos seleccionados
        for (PanelAsiento asiento : asientosSeleccionados) {
            asiento.setSeleccionado(true);
        }
    }
}

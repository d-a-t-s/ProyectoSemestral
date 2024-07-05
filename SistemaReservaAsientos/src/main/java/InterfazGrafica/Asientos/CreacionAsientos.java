package InterfazGrafica.Asientos;

import InterfazGrafica.PanelPrincipal;

import java.util.ArrayList;

public class CreacionAsientos {
    // Método para inicializar los asientos en un piso dado
    public static void inicializarAsientos(ArrayList<PanelAsiento> listaAsientos, int numeroPiso, PanelPrincipal panelPrincipal) {
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
                panelPrincipal.add(asiento);
                listaAsientos.add(asiento);
            }
            aux = aux + 4;
        }
    }
}

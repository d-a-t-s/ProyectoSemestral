package InterfazGrafica;

public class GestorSeleccion {
    private static PanelSeleccionable ultimoPanelSeleccionado;

    public static void seleccionarPanel(PanelSeleccionable panel) {
        if (ultimoPanelSeleccionado != null) {
            ultimoPanelSeleccionado.setSeleccionado(false);
        }
        panel.setSeleccionado(true);
        ultimoPanelSeleccionado = panel;
    }

    public static void deseleccionarTodos() {
        if (ultimoPanelSeleccionado != null) {
            ultimoPanelSeleccionado.setSeleccionado(false);
            ultimoPanelSeleccionado = null;
        }
    }
}
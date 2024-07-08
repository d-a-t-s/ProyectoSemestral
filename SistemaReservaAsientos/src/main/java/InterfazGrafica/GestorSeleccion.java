package InterfazGrafica;

/**
 * Clase que gestiona la selección y deselección de paneles seleccionables.
 */
public class GestorSeleccion {
    private static PanelSeleccionable ultimoPanelSeleccionado;

    /**
     * Selecciona un panel y deselecciona el último panel seleccionado, si existe.
     *
     * @param panel El panel seleccionable que se va a seleccionar.
     */
    public static void seleccionarPanel(PanelSeleccionable panel) {
        if (ultimoPanelSeleccionado != null) {
            ultimoPanelSeleccionado.setSeleccionado(false);
        }
        panel.setSeleccionado(true);
        ultimoPanelSeleccionado = panel;
    }

    /**
     * Deselecciona todos los paneles seleccionables, si hay alguno seleccionado.
     */
    public static void deseleccionarTodos() {
        if (ultimoPanelSeleccionado != null) {
            ultimoPanelSeleccionado.setSeleccionado(false);
            ultimoPanelSeleccionado = null;
        }
    }
}

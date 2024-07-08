package InterfazGrafica;

/**
 * Interfaz para definir el comportamiento de un panel seleccionable.
 */
public interface PanelSeleccionable {
    /**
     * Establece si el panel está seleccionado o no.
     * @param seleccionado true si el panel debe estar seleccionado, false de lo contrario.
     */
    void setSeleccionado(boolean seleccionado);

    /**
     * Verifica si el panel está seleccionado.
     * @return true si el panel está seleccionado, false de lo contrario.
     */
    boolean isSelected();
}

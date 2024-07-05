package InterfazGrafica.Asientos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAsiento extends JButton implements ActionListener {
    private boolean seleccionado = false;
    private int numeroPiso;
    private int fila;
    private int columna;

    public PanelAsiento(int numeroPiso, int fila, int columna) {
        super();
        this.numeroPiso = numeroPiso;
        this.fila = fila;
        this.columna = columna;
        setContentAreaFilled(false); // Para que el botón no pinte su fondo por defecto
        setPreferredSize(new Dimension(45, 75)); // Tamaño del botón
        addActionListener(this); // Agregar listener de acción
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (seleccionado) {
            g.setColor(Color.RED); // Color rojo cuando está seleccionado
        } else {
            g.setColor(Color.GREEN); // Color verde cuando no está seleccionado
        }
        g.fillRect(0, 0, getWidth(), getHeight()); // Pinta el botón con el color correspondiente
        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        seleccionado = !seleccionado; // Invierte el estado de seleccionado
        repaint(); // Vuelve a pintar el botón cuando cambia su estado de seleccionado
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
        repaint(); // Vuelve a pintar el botón cuando se cambia el estado de seleccionado
    }


}

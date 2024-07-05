package InterfazGrafica.Asientos;

import InterfazGrafica.PanelPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPiso1 extends JButton implements ActionListener {
    private PanelPrincipal panelPrincipal;

    public PanelPiso1(PanelPrincipal panelPrincipal) {
        super();
        this.panelPrincipal = panelPrincipal;
        setBackground(Color.GREEN);
        setBounds(666, 6, 161, 45);
        setText("1° Piso");
        setOpaque(true);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panelPrincipal.cambiarPiso(1); // Cambiar al primer piso
    }
}

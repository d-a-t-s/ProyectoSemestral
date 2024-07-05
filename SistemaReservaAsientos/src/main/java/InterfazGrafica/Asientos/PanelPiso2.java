package InterfazGrafica.Asientos;

import InterfazGrafica.PanelPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPiso2 extends JButton implements ActionListener {
    private PanelPrincipal panelPrincipal;

    public PanelPiso2(PanelPrincipal panelPrincipal) {
        super();
        this.panelPrincipal = panelPrincipal;
        setBackground(Color.BLUE);
        setBounds(833, 6, 161, 45);
        setText("2° Piso");
        setOpaque(true);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panelPrincipal.cambiarPiso(2); // Cambiar al segundo piso
    }
}

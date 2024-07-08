package InterfazGrafica;

import Logica.Asiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Logica.Asiento;
import Logica.Excepciones.SegundoPisoNoDisponibleException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PanelAsiento extends JPanel {
    private static Color color;
    private Asiento asientoNormal;
    private Asiento asientoVIP;
    private static ArrayList<Asiento> asientosSeleccionados;

    public PanelAsiento() {
        super();
        asientosSeleccionados = new ArrayList<>();

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    if (PanelPrincipal.getNumeroPiso() == 1) {
                        if (asientosSeleccionados.contains(asientoNormal)) {
                            asientosSeleccionados.remove(asientoNormal);
                        } else {
                            asientosSeleccionados.add(asientoNormal);
                        }
                    } else if (PanelPrincipal.getNumeroPiso() == 2) {
                        if (asientoVIP == null) {
                            throw new SegundoPisoNoDisponibleException("Este autobús no tiene segundo piso.");
                        }
                        if (asientosSeleccionados.contains(asientoVIP)) {
                            asientosSeleccionados.remove(asientoVIP);
                        } else {
                            asientosSeleccionados.add(asientoVIP);
                        }
                    }
                    repaint(); // Vuelve a pintar el panel después de cada clic
                } catch (SegundoPisoNoDisponibleException ex) {
                    // Por ejemplo, mostrar un mensaje de error al usuario
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void inicializarAsientos(ArrayList<PanelAsiento> listaAssientos, PanelPrincipal panelPrincipal) {
        int aux = 0;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                if (i == 2 || i == 3) {
                    listaAssientos.add(new PanelAsiento());
                    listaAssientos.get(i + aux).setBounds(697 + i * 67 + 20, 101 + j * 97, 45, 75);
                    panelPrincipal.add(listaAssientos.get(i + aux));
                } else {
                    listaAssientos.add(new PanelAsiento());
                    listaAssientos.get(i + aux).setBounds(697 + i * 67, 101 + j * 97, 45, 75);
                    panelPrincipal.add(listaAssientos.get(i + aux));
                }
            }
            aux = aux + 4;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (PanelPrincipal.getNumeroPiso() == 1) {
            if (asientoNormal == null) {
                color = Color.LIGHT_GRAY;
            } else if (asientoNormal.getDisponibilidad()) {
                color = Color.GREEN;
            } else {
                color = Color.RED;
            }
            if (asientosSeleccionados.contains(asientoNormal)) {
                color = Color.BLUE; // Si está seleccionado, píntalo de azul
            }
            g.setColor(color);
            g.fillRect(0, 0, 45, 75);
        } else if (PanelPrincipal.getNumeroPiso() == 2) {
            if (asientoVIP == null) {
                color = Color.LIGHT_GRAY;
            } else if (asientoVIP.getDisponibilidad()) {
                color = Color.GREEN;
            } else {
                color = Color.RED;
            }
            if (asientosSeleccionados.contains(asientoVIP)) {
                color = Color.BLUE; // Si está seleccionado, píntalo de azul
            }
            g.setColor(color);
            g.fillRect(0, 0, 45, 75);
        }
    }

    public Asiento getAsientoNormal() {
        return asientoNormal;
    }

    public Asiento getAsientoVIP() {
        return asientoVIP;
    }

    public static ArrayList<Asiento> getAsientosSeleccionados() {
        return asientosSeleccionados;
    }

    public void setAsientoNormal(Asiento asiento) {
        this.asientoNormal = asiento;
    }

    public void setAsientoVIP(Asiento asiento) {
        this.asientoVIP = asiento;
    }

    public static void setAsientosSeleccionados(ArrayList<Asiento> asientos) {
        asientosSeleccionados = asientos;
    }
}


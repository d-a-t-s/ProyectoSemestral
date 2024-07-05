package InterfazGrafica;

import javax.swing.*;
import java.awt.*;

public class PanelAutobus extends JPanel {
    private JLabel labelAgencia;
    private JLabel labelHoraSalida;
    private JLabel labelHoraLlegada;
    private JLabel labelDestino;
    private JLabel labelNumeroPisos;
    private JLabel labelCantidadAsientos;

    public PanelAutobus() {
        setLayout(new GridLayout(6, 1)); // Usar GridLayout para organizar los elementos

        labelAgencia = new JLabel();
        labelHoraSalida = new JLabel();
        labelHoraLlegada = new JLabel();
        labelDestino = new JLabel();
        labelNumeroPisos = new JLabel();
        labelCantidadAsientos = new JLabel();

        add(labelAgencia);
        add(labelHoraSalida);
        add(labelHoraLlegada);
        add(labelDestino);
        add(labelNumeroPisos);
        add(labelCantidadAsientos);
    }

    public void setAgencia(String agencia) {
        labelAgencia.setText("Agencia: " + agencia);
    }

    public void setHoraSalida(String horaSalida) {
        labelHoraSalida.setText("Hora de salida: " + horaSalida);
    }

    public void setHoraLlegada(String horaLlegada) {
        labelHoraLlegada.setText("Hora de llegada: " + horaLlegada);
    }

    public void setDestino(String destino) {
        labelDestino.setText("Destino: " + destino);
    }

    public void setNumeroPisos(int numeroPisos) {
        labelNumeroPisos.setText("Número de pisos: " + numeroPisos);
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        labelCantidadAsientos.setText("Cantidad de asientos disponibles: " + cantidadAsientos);
    }
}

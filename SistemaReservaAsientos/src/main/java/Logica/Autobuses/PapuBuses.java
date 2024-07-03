package Logica.Autobuses;

import Logica.Asiento;
import Logica.HoraSalida;

import java.time.LocalTime;
import java.util.ArrayList;

public class PapuBuses extends Autobus {
    // Propiedades
    // Constructor
    public PapuBuses(HoraSalida horaSalida) {
        this.company = "Papu Buses";
        this.horaSalida = horaSalida.getTiempo();
        asientosPrimerPiso = new ArrayList<>();
        asientosSegundoPiso = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            asientosPrimerPiso.add(new Asiento(i + 1, true)); // Asientos VIP en el primer piso
            asientosSegundoPiso.add(new Asiento(i + 17, false)); // Asientos normales en el segundo piso
        }
    }

    // Métodos
    @Override
    public int getPrecioAsientoNormal() {
        return 18000;
    }

    @Override
    public int getPrecioAsientoVIP() {
        return 20000;
    }

    @Override
    public LocalTime getHoraLlegada() {
        return null; // Implementar la lógica para calcular la hora de llegada
    }

    // Método para obtener el precio de un asiento específico
    public int calcularPrecioAsiento(Asiento asiento) {
        if (asiento.esVIP()) {
            return getPrecioAsientoVIP();
        } else {
            return getPrecioAsientoNormal();
        }
    }

    // Getters y setters
    public ArrayList<Asiento> getAsientosPrimerPiso() {
        return asientosPrimerPiso;
    }

    public ArrayList<Asiento> getAsientosSegundoPiso() {
        return asientosSegundoPiso;
    }
}

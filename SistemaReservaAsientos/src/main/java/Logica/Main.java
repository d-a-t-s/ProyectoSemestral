package Logica;

import Logica.Autobuses.Autobus;
import Logica.Autobuses.PapuBuses;
import Logica.Decorators.PapusVilleDecorator;
import Logica.Excepciones.AsientoNoDisponibleException;
import Logica.Excepciones.SegundoPisoNoDisponibleException;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear un autobús PapuBuses que sale por la mañana
            Autobus autobus = new PapuBuses(HoraSalida.MORNING);

            // Mostrar número de asientos disponibles en el primer y segundo piso
            System.out.println("Asientos disponibles en el primer piso: " + autobus.numeroAsientosDisponiblesPrimerPiso());
            System.out.println("Asientos disponibles en el segundo piso: " + autobus.numeroAsientosDisponiblesSegundoPiso());

            // Reservar el primer asiento del primer piso y mostrar su disponibilidad
            autobus.reservarAsientoPrimerPiso(1);
            System.out.println("Disponibilidad del primer asiento del primer piso: " + autobus.getAsientosPrimerPiso().get(0).getDisponibilidad());

            // Intentar reservar el asiento 32 del segundo piso y mostrar su número y disponibilidad
            autobus.reservarAsientoSegundoPiso(32);
            System.out.println("Número del asiento reservado en el segundo piso: " + autobus.getAsientosSegundoPiso().get(15).getNumeroDeAsiento());
            System.out.println("Disponibilidad del asiento reservado en el segundo piso: " + autobus.getAsientosSegundoPiso().get(15).getDisponibilidad());

            // Decorar el autobús con PapusVilleDecorator y mostrar información actualizada
            autobus = new PapusVilleDecorator(autobus);
            System.out.println("Asientos disponibles en el primer piso después de decorar: " + autobus.numeroAsientosDisponiblesPrimerPiso());
            System.out.println("Asientos disponibles en el segundo piso después de decorar: " + autobus.numeroAsientosDisponiblesSegundoPiso());
            System.out.println("Compañía del autobús después de decorar: " + autobus.getCompany());

            // Mostrar precios de asientos normal y VIP después de decorar con PapusVilleDecorator
            System.out.println("Precio del asiento normal después de decorar: " + autobus.getPrecioAsientoNormal());
            System.out.println("Precio del asiento VIP después de decorar: " + autobus.getPrecioAsientoVIP());

        } catch (AsientoNoDisponibleException e) {
            System.out.println("Error: Asiento no disponible");
        } catch (SegundoPisoNoDisponibleException e) {
            System.out.println("Error: Segundo piso no disponible");
        }
    }
}

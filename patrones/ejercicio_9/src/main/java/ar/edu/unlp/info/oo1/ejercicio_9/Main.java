package ar.edu.unlp.info.oo1.ejercicio_9;

/* Indique el patrón de diseño utilizado y las ventajas de su uso en este diseño en particular.
 
El diseño polimórfico implementado para el sistema de alquiler de automóviles utiliza el patrón de diseño Strategy.
El patrón es ideal para este diseño porque:
- Desacopla al contexto de los detalles de implementación de las estrategias.
- Soporta los requisitos de cambio dinámico de políticas y extensibilidad futura.
- Se eliminan los condicionales. */

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Creación AutoEnAlquiler con política flexible
        AutoEnAlquiler auto = new AutoEnAlquiler(50.0, 5, "Ford", new PoliticaFlexible());
        
        // Creación Usuario y agregado del auto en lista de autos alquilados
        Usuario usuario = new Usuario("Matias");
        usuario.agregarAuto(auto);
        
        // Creación Reserva
        Reserva reserva = new Reserva(10, usuario, auto);
        
        // calcularReembolso(fechaCancelacion) : La Reserva fue realizada el 17 de Abril de 2025
        LocalDate fechaCancelacion = LocalDate.of(2025, 4, 12);
        double reembolso = reserva.montoAReembolsar(fechaCancelacion);
        System.out.println("Monto total: $" + reserva.montoAPagar());
        System.out.println("Reembolso: $" + reembolso);

        // AutoEnAlquiler con política moderada
        auto.setPoliticaCancelacion(new PoliticaEstricta());
        reembolso = reserva.montoAReembolsar(fechaCancelacion);
        System.out.println("Reembolso con política moderada: $" + reembolso);
    }
}
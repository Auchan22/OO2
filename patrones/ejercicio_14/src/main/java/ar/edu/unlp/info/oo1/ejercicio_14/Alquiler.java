package ar.edu.unlp.info.oo1.ejercicio_14;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler extends PrendaBase{
    private LocalDate fechaComienzo;
    private LocalDate fechaFin;
    private double costoMensual;

    public Alquiler(LocalDate fechaComienzo, LocalDate fechaFin, double costoMensual) {
        super(0.9);
        this.fechaComienzo = fechaComienzo;
        this.fechaFin = fechaFin;
        this.costoMensual = costoMensual;
    }

    @Override
    public double calcularValor() {
        long mesesRestantes = ChronoUnit.MONTHS.between(LocalDate.now(), this.fechaFin);
        mesesRestantes = Math.max(0,mesesRestantes);
        return mesesRestantes * this.costoMensual;
    }
}

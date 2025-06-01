package oo2.ejercicios;

public class Cliente {
    private String nombre;
    private double salarioMensual;

    public Cliente(String nombre, double salarioMensual) {
        this.nombre = nombre;
        this.salarioMensual = salarioMensual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    public boolean salarioSuficiente(double valorCuota){
        return (this.salarioMensual*0.3) >= valorCuota;
    }
}

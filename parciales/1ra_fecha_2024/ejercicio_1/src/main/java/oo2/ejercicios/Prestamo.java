package oo2.ejercicios;

public abstract class Prestamo {
    private Cliente cliente;
    private double monto;
    private double cantCuotas;
    private State state;

    public Prestamo(Cliente cliente, double monto, double cantCuotas) {
        this.cliente = cliente;
        this.monto = monto;
        this.cantCuotas = cantCuotas;
        this.definirState();
    }

    private void definirState() {
        if(!cliente.salarioSuficiente(this.calcularCuota())){
            this.setState(new Rechazado());
        }else{
            this.setState(new Aprobado());
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public abstract double retornarIntereses();

    public double calcularCuota(){
        return (this.monto/this.cantCuotas)*this.retornarIntereses();
    };

    public void pagarCuota(){
        state.pagarCuota(this);
    };

    public void cancelarPrestamo(){
        state.cancelarPrestamo(this);
    }

    public abstract double calcularMontoPagado();

    public double calcularMontoRestante(){
        return this.monto - this.calcularMontoPagado();
    }

    public boolean alcanzoCuotas(){
        return this.calcularMontoRestante() == 0;
    }

    public double obtenerValorAdministrativo(){
        return this.calcularMontoRestante()*0.1;
    }

    public abstract double obtenerValorSellado();

    public double obtenerGastosCancelacion(){
        return this.calcularMontoRestante()+(this.obtenerValorAdministrativo()+this.obtenerValorSellado());
    };
}

package ar.edu.unlp.info.oo2.ejercicio_2;

public abstract class Personal {
    public abstract int basico();
    public abstract int adicional();
    public double descuento(){
        return this.basico() * 0.13 + this.adicional() * 0.05;
    };

    public double sueldo(){
        return this.basico() + this.adicional() - this.descuento();
    }
}

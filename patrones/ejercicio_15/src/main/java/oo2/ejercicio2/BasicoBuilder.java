package oo2.ejercicio2;

public class BasicoBuilder implements PCBuilder{
    private Componente componente;
    @Override
    public void setProcesador(Componente procesador) {

    }

    @Override
    public void setMemoria(Componente memoria) {

    }

    @Override
    public void setDisco(Componente disco) {

    }

    @Override
    public void setTarjetaGrafica(Componente tarjetaGrafica) {

    }

    @Override
    public void setGabinete(Componente gabinete) {

    }

    @Override
    public double calcularConsumo() {
        return 0;
    }

    @Override
    public double calcularPrecio() {
        return 0;
    }
}

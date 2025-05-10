package oo2.ejercicio2.Decorators;

import oo2.ejercicio2.WeatherData;

public class PromedioDecorator extends WeatherDecorator{
    public PromedioDecorator(WeatherData wrapee) {
        super(wrapee);
    }

    @Override
    public String displayData() {
        return super.displayData() + " Promedio: "+this.calcPromedio()+";";
    }

    private double calcPromedio(){
        return this.getTemperaturas().stream().mapToDouble(Double::doubleValue).sum();
    }
}

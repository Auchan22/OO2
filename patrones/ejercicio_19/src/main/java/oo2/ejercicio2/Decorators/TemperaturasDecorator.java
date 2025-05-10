package oo2.ejercicio2.Decorators;

import oo2.ejercicio2.WeatherData;

public class TemperaturasDecorator extends WeatherDecorator{
    public TemperaturasDecorator(WeatherData wrapee) {
        super(wrapee);
    }

    @Override
    public String displayData() {
        return super.displayData() + " Mínimo: "+this.temperaturaMin()+" Máximo: "+this.temperaturaMax()+";";
    }

    private double temperaturaMin(){
        return this.getTemperaturas().stream().mapToDouble(t-> t).min().orElse(0.0);
    }

    private double temperaturaMax(){
        return this.getTemperaturas().stream().mapToDouble(t-> t).max().orElse(0.0);
    }
}

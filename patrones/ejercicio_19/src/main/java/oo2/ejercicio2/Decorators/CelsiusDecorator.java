package oo2.ejercicio2.Decorators;

import oo2.ejercicio2.WeatherData;

public class CelsiusDecorator extends WeatherDecorator {
    public CelsiusDecorator(WeatherData wrapee) {
        super(wrapee);
    }

    @Override
    public String displayData() {
        return super.displayData() + " Temperatura C: "+Math.round(this.getTemperatura())+";";
    }

    @Override
    public double getTemperatura() {
        return ((super.getTemperatura() - 32)/1.8);
    }
}

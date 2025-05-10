package oo2.ejercicio2.Decorators;

import oo2.ejercicio2.WeatherData;

public class PresionDecorator extends WeatherDecorator {
    public PresionDecorator(WeatherData wrapee) {
        super(wrapee);
    }

    @Override
    public String displayData() {
        return super.displayData() + " Presión atmosf: "+Math.round(this.getPresion())+";";
    }
}

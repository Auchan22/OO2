package oo2.ejercicio2.Decorators;

import oo2.ejercicio2.WeatherData;

public class RadiacionDecorator extends WeatherDecorator {
    public RadiacionDecorator(WeatherData wrapee) {
        super(wrapee);
    }

    @Override
    public String displayData() {
        return super.displayData() + " Radiación solar: " + Math.round(getRadiacionSolar())+";";
    }
}

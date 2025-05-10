package oo2.ejercicio2.Decorators;

import oo2.ejercicio2.WeatherData;

public class FarenheitDecorator extends WeatherDecorator {
    public FarenheitDecorator(WeatherData wrapee) {
        super(wrapee);
    }

    @Override
    public String displayData() {
        return super.displayData() + "Temperatura F: "+ Math.round(this.getTemperatura()) +";";
    }
}

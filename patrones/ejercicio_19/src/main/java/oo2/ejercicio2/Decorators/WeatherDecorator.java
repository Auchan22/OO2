package oo2.ejercicio2.Decorators;

import oo2.ejercicio2.WeatherData;

import java.util.List;

public abstract class WeatherDecorator implements WeatherData {
    private WeatherData wrapee;

    public WeatherDecorator(WeatherData wrapee) {
        this.wrapee = wrapee;
    }

    @Override
    public double getTemperatura() {
        return this.wrapee.getTemperatura();
    }

    @Override
    public double getPresion() {
        return this.wrapee.getPresion();
    }

    @Override
    public double getRadiacionSolar() {
        return this.wrapee.getRadiacionSolar();
    }

    @Override
    public List<Double> getTemperaturas() {
        return this.wrapee.getTemperaturas();
    }

    @Override
    public String displayData() {
        return this.wrapee.displayData();
    }
}

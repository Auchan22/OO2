package oo2.ejercicio2;

import java.util.List;

public class HomeWeatherStationAdapter implements WeatherData{
    private HomeWeatherStation wrapee;

    public HomeWeatherStationAdapter(HomeWeatherStation wrapee){
        this.wrapee = wrapee;
    }

    @Override
    public double getTemperatura() {
        return wrapee.getTemperatura();
    }

    @Override
    public double getPresion() {
        return wrapee.getPresion();
    }

    @Override
    public double getRadiacionSolar() {
        return wrapee.getRadiacionSolar();
    }

    @Override
    public List<Double> getTemperaturas() {
        return wrapee.getTemperaturas();
    }

    @Override
    public String displayData() {
        return "";
    }
}

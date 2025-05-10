package oo2.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class HomeWeatherStation {
    private double temperatura;
    private double presion;
    private double radiacion;
    private List<Double> temperaturas;

    public HomeWeatherStation(double temperatura, double presion, double radiacion) {
        this.temperatura = temperatura;
        this.presion = presion;
        this.radiacion = radiacion;
        temperaturas = new ArrayList<Double>();
    }

    //retorna la temperatura en grados Fahrenheit.
    public double getTemperatura(){
        return temperatura;
    }

    //retorna la presión atmosférica en hPa
    public double getPresion(){
        return presion;
    }

    //retorna la radiación solar
    public double getRadiacionSolar(){
        return radiacion;
    }

    //retorna una lista con todas las temperaturas sensadas hasta el momento, en grados Fahrenheit
    public List<Double> getTemperaturas(){
        return temperaturas;
    }

    public void agregarTemperatura(double temperatura){
        temperaturas.add(temperatura);
    }

    //retorna  un reporte de todos los datos: temperatura, presión, y radiación solar.
    public String displayData(){
        return "Temperatura F: " + this.getTemperatura() +
                "Presión atmosf: " + this.getPresion() +
                "Radiación solar: " + this.getRadiacionSolar();
    }

}

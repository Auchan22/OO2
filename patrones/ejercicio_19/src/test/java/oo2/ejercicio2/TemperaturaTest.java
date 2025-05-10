package oo2.ejercicio2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import oo2.ejercicio2.Decorators.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemperaturaTest {
    private HomeWeatherStation estacion;
    private HomeWeatherStationAdapter adaptador;
    private PresionDecorator presion;
    private RadiacionDecorator radiacion;
    private CelsiusDecorator celsius;
    private PromedioDecorator promedio;

    @BeforeEach
    public void setUp() throws Exception {
        //23.5 + 23.5 + 30
        this.estacion = new HomeWeatherStation(82.4, 1008, 500);
        this.estacion.agregarTemperatura(70);
        this.estacion.agregarTemperatura(80);
        this.estacion.agregarTemperatura(81);
        this.adaptador = new HomeWeatherStationAdapter(estacion);
    }

    @Test
    public void testDisplayDataOpcion2() {
        //Ejemplo 2:    “Presión atmosférica: 1008  Radiación solar: 500”
        this.presion = new PresionDecorator(adaptador);
        this.radiacion = new RadiacionDecorator(this.presion);

        assertEquals(" Presión atmosf: 1008; Radiación solar: 500;",this.radiacion.displayData());

    }

    @Test
    public void testDisplayDataOpcion3() {
        //Ejemplo 3: “Radiación solar: 500  Temperatura C: 28  Promedio de temperaturas C: 25”
        this.radiacion = new RadiacionDecorator(adaptador);
        this.celsius = new CelsiusDecorator(radiacion);
        this.promedio = new PromedioDecorator(celsius);

        assertEquals(" Radiación solar: 500; Temperatura C: 28; Promedio: 25;" ,this.promedio.displayData());

    }
}
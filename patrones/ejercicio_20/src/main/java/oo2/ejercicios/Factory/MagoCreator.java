package oo2.ejercicios.Factory;

import oo2.ejercicios.Arma.Baston;
import oo2.ejercicios.Armadura.ArmaduraDeCuero;
import oo2.ejercicios.Habilidad.Distancia;
import oo2.ejercicios.Habilidad.Magia;
import oo2.ejercicios.Personaje.Mago;
import oo2.ejercicios.Personaje.Personaje;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MagoCreator extends PersonajeCreator{
    @Override
    public Personaje crearPersonaje() {
        return new Mago("Brujin", new ArmaduraDeCuero(), new Baston(), Arrays.asList(new Magia(), new Distancia()));
    }
}

package oo2.ejercicios.Factory;

import oo2.ejercicios.Arma.Arco;
import oo2.ejercicios.Armadura.ArmaduraDeCuero;
import oo2.ejercicios.Habilidad.Distancia;
import oo2.ejercicios.Personaje.Arquero;
import oo2.ejercicios.Personaje.Personaje;

import java.util.Arrays;

public class ArqueroCreator extends PersonajeCreator{
    @Override
    public Personaje crearPersonaje() {
        return new Arquero("Legolas", new ArmaduraDeCuero(), new Arco(), Arrays.asList(new Distancia()));
    }
}

package oo2.ejercicios.Factory;

import oo2.ejercicios.Arma.Espada;
import oo2.ejercicios.Armadura.ArmaduraDeAcero;
import oo2.ejercicios.Habilidad.CuerpoACuerpo;
import oo2.ejercicios.Personaje.Guerrero;
import oo2.ejercicios.Personaje.Personaje;

import java.util.Arrays;

public class GuerreroCreator extends PersonajeCreator{
    @Override
    public Personaje crearPersonaje() {
        return new Guerrero("Migueloso", new ArmaduraDeAcero(), new Espada(), Arrays.asList(new CuerpoACuerpo()));
    }
}

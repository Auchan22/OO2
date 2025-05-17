package oo2.ejercicios.Personaje;

import oo2.ejercicios.Arma.Arma;
import oo2.ejercicios.Armadura.Armadura;
import oo2.ejercicios.Habilidad.Habilidad;

import java.util.List;

public class Arquero extends Personaje{

    public Arquero(String nombre, Armadura armadura, Arma arma, List<Habilidad> habilidades) {
        super(nombre, armadura, arma, habilidades);
    }

    public Arquero() {
        super();
    }
}

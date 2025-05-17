package oo2.ejercicios.Builder;

import oo2.ejercicios.Arma.Arma;
import oo2.ejercicios.Armadura.Armadura;
import oo2.ejercicios.Habilidad.Habilidad;
import oo2.ejercicios.Personaje.Arquero;
import oo2.ejercicios.Personaje.Mago;
import oo2.ejercicios.Personaje.Personaje;

public class ArqueroBuilder implements PersonajeBuilder{

    private Personaje personaje;

    @Override
    public void reset() {
        this.personaje = new Arquero();
    }

    @Override
    public void agregarArma(Arma arma) {
        this.personaje.setArma(arma);
    }

    @Override
    public void agregarHabilidad(Habilidad habilidad) {
        this.personaje.agregarHabilidad(habilidad);
    }

    @Override
    public void agregarArmadura(Armadura armadura) {
        this.personaje.setArmadura(armadura);
    }

    @Override
    public void definirNombre(String nombre) {
        this.personaje.setNombre(nombre);
    }

    @Override
    public Personaje getPersonaje() {
        return this.personaje;
    }
}

package oo2.ejercicios.Builder;

import oo2.ejercicios.Arma.Arma;
import oo2.ejercicios.Armadura.Armadura;
import oo2.ejercicios.Habilidad.Habilidad;
import oo2.ejercicios.Personaje.Personaje;

public interface PersonajeBuilder {
    void reset();
    void agregarArma(Arma arma);
    void agregarHabilidad(Habilidad habilidad);
    void agregarArmadura(Armadura armadura);
    void definirNombre(String nombre);
    Personaje getPersonaje();
}

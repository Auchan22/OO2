package oo2.ejercicios.Builder;

import oo2.ejercicios.Arma.Arco;
import oo2.ejercicios.Arma.Baston;
import oo2.ejercicios.Arma.Espada;
import oo2.ejercicios.Armadura.ArmaduraDeAcero;
import oo2.ejercicios.Armadura.ArmaduraDeCuero;
import oo2.ejercicios.Habilidad.CuerpoACuerpo;
import oo2.ejercicios.Habilidad.Distancia;
import oo2.ejercicios.Habilidad.Magia;

public class Director {

    public void generarMago(PersonajeBuilder builder){
        builder.reset();
        builder.definirNombre("Mago");
        builder.agregarArma(new Baston());
        builder.agregarArmadura(new ArmaduraDeCuero());
        builder.agregarHabilidad(new Distancia());
        builder.agregarHabilidad(new Magia());
    }

    public void generarArquero(PersonajeBuilder builder){
        builder.reset();
        builder.definirNombre("Arquero");
        builder.agregarArma(new Arco());
        builder.agregarArmadura(new ArmaduraDeCuero());
        builder.agregarHabilidad(new Distancia());
    }

    public void generarGuerrero(PersonajeBuilder builder){
        builder.reset();
        builder.definirNombre("Guerrero");
        builder.agregarArma(new Espada());
        builder.agregarArmadura(new ArmaduraDeAcero());
        builder.agregarHabilidad(new CuerpoACuerpo());
    }
}

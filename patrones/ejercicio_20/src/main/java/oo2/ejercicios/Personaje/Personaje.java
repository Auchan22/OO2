package oo2.ejercicios.Personaje;

import oo2.ejercicios.Arma.Arma;
import oo2.ejercicios.Armadura.Armadura;
import oo2.ejercicios.Habilidad.Habilidad;

import java.util.List;

public abstract class Personaje {
    private String nombre;
    private Armadura armadura;
    private Arma arma;
    private List<Habilidad> habilidades;
    private int vida;

    public Personaje() {
        this.vida = 100;
    }

    public Personaje(String nombre, Armadura armadura, Arma arma, List<Habilidad> habilidades) {
        this.nombre = nombre;
        this.armadura = armadura;
        this.arma = arma;
        this.habilidades = habilidades;
        this.vida = 100;
    }

    public void pelearContra(Personaje p){
        if(this.vida > 0){
            recibirDanio(p.calcularDanio(this.armadura.getTipo()));
            p.recibirDanio(this.calcularDanio(p.armadura.getTipo()));
        }
    }

    public int calcularDanio(String tipoArmadura) {
        return this.arma.calcularDanio(tipoArmadura);
    }

    public void recibirDanio(int danio){
        this.vida -= danio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void agregarHabilidad(Habilidad habilidad){
        this.habilidades.add(habilidad);
    }
}

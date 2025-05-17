package oo2.ejercicios;

import java.time.LocalDate;

public class RealMamifero implements IMamifero {

    private String identificador;
    private String especie;
    private LocalDate fechaNacimiento;
    private IMamifero padre;
    private IMamifero madre;

    public RealMamifero(String identificador, String especie, LocalDate fechaNacimiento) {
        this.identificador = identificador;
        this.especie = especie;
        this.fechaNacimiento = fechaNacimiento;
        this.padre = new NullMamifero();
        this.madre = new NullMamifero();
    }

    @Override
    public String getIdentificador() {
        return identificador;
    }

    @Override
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @Override
    public String getEspecie() {
        return especie;
    }

    @Override
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public IMamifero getPadre() {
        return padre;
    }

    @Override
    public void setPadre(IMamifero padre) {
        this.padre = padre;
    }

    @Override
    public IMamifero getMadre() {
        return madre;
    }

    @Override
    public void setMadre(IMamifero madre) {
        this.madre = madre;
    }

    @Override
    public IMamifero getAbueloMaterno() {
        return this.madre.getPadre();
    }

    @Override
    public IMamifero getAbuelaMaterna() {
        return this.madre.getMadre();
    }

    @Override
    public IMamifero getAbueloPaterno() {
        return this.padre.getPadre();
    }

    @Override
    public IMamifero getAbuelaPaterna() {
        return this.padre.getMadre();
    }

    @Override
    public boolean tieneComoAncestroA(IMamifero unMamifero) {
        if(this.padre.equals(unMamifero) || this.madre.equals(unMamifero)){
            return true;
        }
        return this.padre.tieneComoAncestroA(unMamifero) || this.madre.tieneComoAncestroA(unMamifero);
    }
}

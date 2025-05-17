package oo2.ejercicios;

import java.time.LocalDate;

public class NullMamifero implements IMamifero {
    @Override
    public String getIdentificador() {
        return "";
    }

    @Override
    public void setIdentificador(String id) {

    }

    @Override
    public String getEspecie() {
        return "";
    }

    @Override
    public void setEspecie(String especie) {

    }

    @Override
    public LocalDate getFechaNacimiento() {
        return null;
    }

    @Override
    public void setFechaNacimiento(LocalDate fechaNacimiento) {

    }

    @Override
    public IMamifero getPadre() {
        return null;
    }

    @Override
    public void setPadre(IMamifero padre) {

    }

    @Override
    public IMamifero getMadre() {
        return null;
    }

    @Override
    public void setMadre(IMamifero madre) {

    }

    @Override
    public IMamifero getAbueloMaterno() {
        return null;
    }

    @Override
    public IMamifero getAbuelaMaterna() {
        return null;
    }

    @Override
    public IMamifero getAbueloPaterno() {
        return null;
    }

    @Override
    public IMamifero getAbuelaPaterna() {
        return null;
    }

    @Override
    public boolean tieneComoAncestroA(IMamifero unMamifero) {
        return false;
    }
}

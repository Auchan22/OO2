package oo2.ejercicios;

public class Completa extends EstadoExcursion{
    public Completa(Excursion excursion) {
        super(excursion);
    }

    @Override
    public String informacionAdicional() {
        return "";
    }

    @Override
    public void inscribirUsuario(Usuario usuario) {
        Excursion excursion = getExcursion();
        excursion.agregarEnEspera(usuario);
    }
}

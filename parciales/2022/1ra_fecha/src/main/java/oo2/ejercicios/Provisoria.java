package oo2.ejercicios;

public class Provisoria extends EstadoExcursion{
    public Provisoria(Excursion excursion) {
        super(excursion);
    }

    @Override
    public String informacionAdicional() {
        return "Restantes para el cupo minimo: "+this.getExcursion().getCantidadFaltantesMinimo();
    }

    @Override
    public void inscribirUsuario(Usuario usuario) {
        Excursion excursion = this.getExcursion();
        excursion.inscribirUsuario(usuario);
        if(excursion.cumpleCupoMinimo()){
            excursion.setEstado(new Definitiva(this.getExcursion()));
        }
    }
}

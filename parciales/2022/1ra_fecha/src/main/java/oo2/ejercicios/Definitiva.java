package oo2.ejercicios;

public class Definitiva extends EstadoExcursion {
    public Definitiva(Excursion excursion) {
        super(excursion);
    }

    @Override
    public String informacionAdicional() {
        return "Mails de usuario: \n"+this.getExcursion().renderMailsUsuarios()+"\n"+
                "Restantes para cupo máximo: "+this.getExcursion().getCantidadFaltantesMaximo();
    }

    @Override
    public void inscribirUsuario(Usuario usuario) {
        Excursion excursion = this.getExcursion();
        excursion.inscribirUsuario(usuario);
        if(excursion.cumpleCupoMaximo()){
            excursion.setEstado(new Completa(excursion));
        }
    }
}

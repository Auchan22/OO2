package oo2.ejercicios;

public abstract class Etapa {
    private Proyecto proyecto;

    public Etapa(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Proyecto obtenerProyecto() {
        return proyecto;
    }

    public abstract void aprobarEtapa();

    public abstract void modificarMargenGanancia(double margenGanancia);

    public void cancelar(){
        Proyecto proyecto = this.proyecto;
        proyecto.establecerEtapa(new Cancelado(proyecto));
    };

}

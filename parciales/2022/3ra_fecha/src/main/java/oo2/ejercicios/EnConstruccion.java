package oo2.ejercicios;

public class EnConstruccion extends Etapa {
    public EnConstruccion(Proyecto proyecto) {
        super(proyecto);
    }

    @Override
    public void aprobarEtapa() {
        Proyecto p = this.obtenerProyecto();
        if(p.calcularPrecio() != 0){
            p.establecerEtapa(new EnEvaluacion(p));
        }else{
            throw new RuntimeException("El precio debe ser mayor que 0");
        }
    }

    @Override
    public void modificarMargenGanancia(double margenGanancia) {
        Proyecto p = this.obtenerProyecto();
        if(margenGanancia >= 0.08 && margenGanancia <= 0.1){
            p.setMargenGanancia(margenGanancia);
        }
    }
}

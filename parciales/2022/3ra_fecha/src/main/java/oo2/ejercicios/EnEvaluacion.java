package oo2.ejercicios;

public class EnEvaluacion extends Etapa{
    public EnEvaluacion(Proyecto proyecto) {
        super(proyecto);
    }

    @Override
    public void aprobarEtapa() {
        Proyecto p = this.obtenerProyecto();
        if(p.calcularPrecio() != 0){
            p.establecerEtapa(new Confirmada(p));
        }else{
            throw new RuntimeException("El precio debe ser mayor que 0");
        }
    }

    @Override
    public void modificarMargenGanancia(double margenGanancia) {
        Proyecto p = this.obtenerProyecto();
        if(margenGanancia >= 0.11 && margenGanancia <= 0.15){
            p.setMargenGanancia(margenGanancia);
        }
    }
}

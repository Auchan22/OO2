package oo2.ejercicios.Arma;

public class Espada implements Arma {
    @Override
    public String getDescripcion() {
        return "Espada";
    }

    @Override
    public int calcularDanio(String tipoArmadura) {
        if (tipoArmadura.equals("Armadura de Cuero")){
            return 8;
        }else if (tipoArmadura.equals("Armadura de Hierro")){
            return 5;
        }else{
            return 3;
        }
    }
}

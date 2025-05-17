package oo2.ejercicios.Arma;

public class Arco implements Arma{
    @Override
    public String getDescripcion() {
        return "Arco";
    }

    @Override
    public int calcularDanio(String tipoArmadura) {
        if (tipoArmadura.equals("Armadura de Cuero")){
            return 5;
        }else if (tipoArmadura.equals("Armadura de Hierro")){
            return 3;
        }else{
            return 2;
        }
    }
}

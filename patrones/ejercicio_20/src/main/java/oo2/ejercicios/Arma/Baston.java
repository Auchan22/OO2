package oo2.ejercicios.Arma;

public class Baston implements Arma{

    @Override
    public String getDescripcion() {
        return "Bastón";
    }

    @Override
    public int calcularDanio(String tipoArmadura) {
        if (tipoArmadura.equals("Armadura de Cuero")){
            return 2;
        }else if (tipoArmadura.equals("Armadura de Hierro")){
            return 1;
        }else{
            return 1;
        }
    }
}

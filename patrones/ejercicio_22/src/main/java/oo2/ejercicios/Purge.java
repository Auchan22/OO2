package oo2.ejercicios;

public class Purge extends ProcessStep{
    @Override
    public boolean basicExecute(MixingTank tank) {
        return tank.heatPower(0) && tank.mixerPower(0) && tank.purge();
    }
}

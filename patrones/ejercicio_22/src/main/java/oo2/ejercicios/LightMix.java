package oo2.ejercicios;

public class LightMix extends ProcessStep{
    @Override
    public boolean basicExecute(MixingTank tank) {
        return tank.heatPower(20) && tank.mixerPower(5);
    }
}

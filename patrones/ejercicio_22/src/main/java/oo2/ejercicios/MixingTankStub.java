package oo2.ejercicios;

public class MixingTankStub extends MixingTank {
    @Override
    public boolean heatPower(int percentage) {
        return true;
    }

    @Override
    public boolean mixerPower(int percentage) {
        return true;
    }

    @Override
    public boolean purge() {
        return false;
    }

    @Override
    public double upTo() {
        return 0;
    }

    @Override
    public double temperature() {
        return 0;
    }
}

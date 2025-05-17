package oo2.ejercicios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LightMixText {
    private ProcessStep lightMix;
    private MixingTank tank;

    @BeforeEach
    public void setUp() throws Exception {
        lightMix = new LightMix();
        tank = new MixingTankStub();
    }

    @Test
    void testLightMixStub() {
        lightMix.execute(tank);
        assertTrue(lightMix.isDone());
    }
}

package oo2.ejercicios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PurgeTest {
    private ProcessStep purge;
    private MixingTank tank;

    @BeforeEach
    public void setUp() throws Exception {
        purge = new Purge();
        tank = new MixingTankStub();
    }

    @Test
    void testPurgeStub() {
        purge.execute(tank);
        assertFalse(purge.isDone());
    }
}

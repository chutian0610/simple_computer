package info.victorchu.computer.simulation.circuit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author victorchu
 */
class PotentialsTest {

    @Test
    void toUnsignedInt1() {
        Assertions.assertEquals(1,Potentials.toUnsignedInt(Potentials.fromTextB("0001")));
    }
    @Test
    void toUnsignedInt6() {
        Assertions.assertEquals(6,Potentials.toUnsignedInt(Potentials.fromTextB("0110")));
    }
    @Test
    void toUnsignedInt1024() {
        Assertions.assertEquals(1024,Potentials.toUnsignedInt(Potentials.fromTextB("0100 0000 0000")));
    }

    @Test
    void fromUnsignedInt1024() {
        Assertions.assertEquals("0100 0000 0000",Potentials.toTextB(Potentials.fromUnsignedInt(1024),4));
    }
}
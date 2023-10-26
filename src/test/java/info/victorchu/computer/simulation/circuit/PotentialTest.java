package info.victorchu.computer.simulation.circuit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author victorchu
 * @date 2022/8/27 21:14
 */
class PotentialTest {
    @Test
    void testPotentialEquals(){
        Potential potential1 = Potential.high();
        Potential potential2 = Potential.high();
        assertEquals(potential1,potential2);
        Potential potential3 = Potential.low();
        Potential potential4 = Potential.low();
        assertEquals(potential3,potential4);
    }

    @Test
    void testPotentialArrayEquals(){
        Potential[] potential1 = new Potential[]{
                Potential.high(),Potential.low(),
                Potential.high(),Potential.low()
        };
        Potential[] potential2 = new Potential[]{
                Potential.high(),Potential.low(),
                Potential.high(),Potential.low()
        };
        assertArrayEquals(potential1,potential2);
    }

    @Test
    void testPotential2Text(){
        // 0111
        Potential[] array = new Potential[]{
                Potential.high(),Potential.high(),
                Potential.high(),Potential.low()
        };
        assertEquals("1110",Potentials.toText(array));
    }

}
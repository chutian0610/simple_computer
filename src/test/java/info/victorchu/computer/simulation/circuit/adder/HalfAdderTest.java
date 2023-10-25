package info.victorchu.computer.simulation.circuit.adder;

import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.Potentials;
import info.victorchu.computer.simulation.utils.CircuitUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author victorchu
 */
public class HalfAdderTest {
    static HalfAdder adder = new HalfAdder();

    @BeforeEach
    void init() {
        adder.reset();
    }
    @Test
     void input00(){
        Potential[] result= CircuitUtils.compute(adder,Potential.low(),Potential.low());
        Assertions.assertArrayEquals(result, Potentials.fromText("00"));
    }

    @Test
    void input01(){
        Potential[] result= CircuitUtils.compute(adder,Potential.low(),Potential.high());
        Assertions.assertArrayEquals(result, Potentials.fromText("01"));
    }

    @Test
    void input10(){
        Potential[] result= CircuitUtils.compute(adder,Potential.high(),Potential.low());
        Assertions.assertArrayEquals(result, Potentials.fromText("01"));
    }


    @Test
    void input11(){
        Potential[] result= CircuitUtils.compute(adder,Potential.high(),Potential.high());
        Assertions.assertArrayEquals(result, Potentials.fromText("10"));
    }

}

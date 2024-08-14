package info.victorchu.computer.simulation.circuit.adder;

import info.victorchu.computer.simulation.circuit.CircuitComponentUtils;
import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.Potentials;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author victorchu
 */
public class FullAdderTest {
    static FullAdder adder = new FullAdder();

    @BeforeEach
    void init() {
        adder.reset();
    }
    @Test
    public void input000(){
        Potential[] result= CircuitComponentUtils.compute(adder, Potentials.fromTextB("000"));
        Assertions.assertArrayEquals(result, Potentials.fromTextB("00"));
    }


    @Test
    public void input001(){
        Potential[] result= CircuitComponentUtils.compute(adder, Potentials.fromTextB("001"));
        Assertions.assertArrayEquals(result, Potentials.fromTextB("01"));
    }

    @Test
    public void input010(){
        Potential[] result= CircuitComponentUtils.compute(adder, Potentials.fromTextB("010"));
        Assertions.assertArrayEquals(result, Potentials.fromTextB("01"));
    }
    @Test
    public void input100(){
        Potential[] result= CircuitComponentUtils.compute(adder, Potentials.fromTextB("100"));
        Assertions.assertArrayEquals(result, Potentials.fromTextB("01"));
    }

    @Test
    public void input011(){
        Potential[] result= CircuitComponentUtils.compute(adder, Potentials.fromTextB("011"));
        Assertions.assertArrayEquals(result, Potentials.fromTextB("10"));
    }
    @Test
    public void input110(){
        Potential[] result= CircuitComponentUtils.compute(adder, Potentials.fromTextB("110"));
        Assertions.assertArrayEquals(result, Potentials.fromTextB("10"));
    }

    @Test
    public void input101(){
        Potential[] result= CircuitComponentUtils.compute(adder, Potentials.fromTextB("101"));
        Assertions.assertArrayEquals(result, Potentials.fromTextB("10"));
    }

    @Test
    public void input111(){
        Potential[] result= CircuitComponentUtils.compute(adder, Potentials.fromTextB("111"));
        Assertions.assertArrayEquals(result, Potentials.fromTextB("11"));
    }
}

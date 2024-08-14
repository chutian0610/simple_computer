package info.victorchu.computer.simulation.circuit.decoder;

import info.victorchu.computer.simulation.circuit.CircuitComponentUtils;
import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.Potentials;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author victorchu
 */
class Decoder1Test {
    static Decoder1 decoder = new Decoder1();

    @BeforeEach
    void init() {
        decoder.reset();
    }
    @Test
    public void input0(){
        Potential[] result= CircuitComponentUtils.compute(decoder, Potential.low());
        Assertions.assertArrayEquals(result, Potentials.fromTextB("01"));
    }
    @Test
    public void input1(){
        Potential[] result= CircuitComponentUtils.compute(decoder, Potential.high());
        Assertions.assertArrayEquals(result, Potentials.fromTextB("10"));
    }

}
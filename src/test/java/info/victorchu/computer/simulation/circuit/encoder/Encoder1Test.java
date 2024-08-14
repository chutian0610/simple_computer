package info.victorchu.computer.simulation.circuit.encoder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import info.victorchu.computer.simulation.circuit.CircuitComponentUtils;
import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.Potentials;

public class Encoder1Test {
    static Encoder1 encoder = new Encoder1();

    @BeforeEach
    void init() {
        encoder.reset();
    }

    @Test
    public void input01() {
        Potential[] result = CircuitComponentUtils.compute(encoder, Potentials.fromText("01"));
        Assertions.assertEquals("0", Potentials.toTextB(result));
    }

    @Test
    public void input10() {
        Potential[] result = CircuitComponentUtils.compute(encoder, Potentials.fromText("10"));
        Assertions.assertEquals("1", Potentials.toTextB(result));
    }
}

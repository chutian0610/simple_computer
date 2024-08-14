package info.victorchu.computer.simulation.circuit.encoder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import info.victorchu.computer.simulation.circuit.CircuitComponentUtils;
import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.Potentials;

public class Encoder2Test {
    static Encoder2 encoder = new Encoder2();

    @BeforeEach
    void init() {
        encoder.reset();
    }
    @Test
    public void input0001(){
        Potential[] result= CircuitComponentUtils.compute(encoder, Potentials.fromText("0001"));
        Assertions.assertEquals("00", Potentials.toTextB(result));
    }
    @Test
    public void input0010(){
        Potential[] result= CircuitComponentUtils.compute(encoder, Potentials.fromText("0010"));
        Assertions.assertEquals("01", Potentials.toTextB(result));
    }
    @Test
    public void input0100(){
        Potential[] result= CircuitComponentUtils.compute(encoder, Potentials.fromText("0100"));
        Assertions.assertEquals("10", Potentials.toTextB(result));
    }
    @Test
    public void input1000(){
        Potential[] result= CircuitComponentUtils.compute(encoder, Potentials.fromText("1000"));
        Assertions.assertEquals("11", Potentials.toTextB(result));
    }
}

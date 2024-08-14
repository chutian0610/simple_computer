package info.victorchu.computer.simulation.circuit.encoder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import info.victorchu.computer.simulation.circuit.CircuitComponentUtils;
import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.Potentials;

public class PriorityEncoder2Test {
        static PriorityEncoder2 encoder = new PriorityEncoder2();

    @BeforeEach
    void init() {
        encoder.reset();
    }
        @Test
    public void input0000(){
        Potential[] result= CircuitComponentUtils.compute(encoder, Potentials.fromText("0000"));
        Assertions.assertEquals("000", Potentials.toTextB(result));
    }
    @Test
    public void input0001(){
        Potential[] result= CircuitComponentUtils.compute(encoder, Potentials.fromText("0001"));
        Assertions.assertEquals("100", Potentials.toTextB(result));
    }
    @Test
    public void input0010(){
        Potential[] result= CircuitComponentUtils.compute(encoder, Potentials.fromText("0010"));
        Assertions.assertEquals("101", Potentials.toTextB(result));
    }
    @Test
    public void input0100(){
        Potential[] result= CircuitComponentUtils.compute(encoder, Potentials.fromText("0100"));
        Assertions.assertEquals("110", Potentials.toTextB(result));
    }
    @Test
    public void input1000(){
        Potential[] result= CircuitComponentUtils.compute(encoder, Potentials.fromText("1000"));
        Assertions.assertEquals("111", Potentials.toTextB(result));
    }
}

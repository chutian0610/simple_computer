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
class Decoder3Test {
    static Decoder3 decoder = new Decoder3();

    @BeforeEach
    void init() {
        decoder.reset();
    }
    @Test
    public void input000(){
        Potential[] result= CircuitComponentUtils.compute(decoder, Potentials.fromText("000"));
        Assertions.assertEquals("0000 0001", Potentials.toText(result,4));
    }
    @Test
    public void input001(){
        Potential[] result= CircuitComponentUtils.compute(decoder, Potentials.fromText("001"));
        Assertions.assertEquals("0000 0010", Potentials.toText(result,4));
    }
    @Test
    public void input010(){
        Potential[] result= CircuitComponentUtils.compute(decoder, Potentials.fromText("010"));
        Assertions.assertEquals("0000 0100", Potentials.toText(result,4));
    }
    @Test
    public void input011(){
        Potential[] result= CircuitComponentUtils.compute(decoder, Potentials.fromText("011"));
        Assertions.assertEquals("0000 1000", Potentials.toText(result,4));
    }
    @Test
    public void input100(){
        Potential[] result= CircuitComponentUtils.compute(decoder, Potentials.fromText("100"));
        Assertions.assertEquals("0001 0000", Potentials.toText(result,4));
    }
    @Test
    public void input101(){
        Potential[] result= CircuitComponentUtils.compute(decoder, Potentials.fromText("101"));
        Assertions.assertEquals("0010 0000", Potentials.toText(result,4));
    }
    @Test
    public void input110(){
        Potential[] result= CircuitComponentUtils.compute(decoder, Potentials.fromText("110"));
        Assertions.assertEquals("0100 0000", Potentials.toText(result,4));
    }
    @Test
    public void input111(){
        Potential[] result= CircuitComponentUtils.compute(decoder, Potentials.fromText("111"));
        Assertions.assertEquals("1000 0000", Potentials.toText(result,4));
    }
}
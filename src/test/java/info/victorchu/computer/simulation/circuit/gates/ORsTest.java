package info.victorchu.computer.simulation.circuit.gates;

import info.victorchu.computer.simulation.circuit.CircuitComponentUtils;
import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.Potentials;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author victorchu
 */
public class ORsTest {
    @Test
    public void input0010(){
        ORs and = new ORs(4);
        Potential[] result= CircuitComponentUtils.compute(and, Potentials.fromText("0010"));
        Assertions.assertArrayEquals(result, Potentials.fromText("1"));
    }
    @Test
    public void input1111(){
        ORs and = new ORs(4);
        Potential[] result= CircuitComponentUtils.compute(and, Potentials.fromText("0000"));
        Assertions.assertArrayEquals(result, Potentials.fromText("0"));
    }
    @Test
    public void input1110(){
        ORs and = new ORs(4);
        Potential[] result= CircuitComponentUtils.compute(and, Potentials.fromText("1110"));
        Assertions.assertArrayEquals(result, Potentials.fromText("1"));
    }
}

package info.victorchu.computer.simulation.circuit.gates;

import info.victorchu.computer.simulation.circuit.CircuitComponentUtils;
import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.Potentials;
import info.victorchu.computer.simulation.circuit.biggate.BigAND;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author victorchu
 */
public class ANDsTest {
    @Test
    public void input0010(){
        BigAND and = new BigAND(4);
        Potential[] result= CircuitComponentUtils.compute(and, Potentials.fromTextB("0010"));
        Assertions.assertArrayEquals(result, Potentials.fromTextB("0"));
    }
    @Test
    public void input1111(){
        BigAND and = new BigAND(4);
        Potential[] result= CircuitComponentUtils.compute(and, Potentials.fromTextB("1111"));
        Assertions.assertArrayEquals(result, Potentials.fromTextB("1"));
    }
    @Test
    public void input1110(){
        BigAND and = new BigAND(4);
        Potential[] result= CircuitComponentUtils.compute(and, Potentials.fromTextB("1110"));
        Assertions.assertArrayEquals(result, Potentials.fromTextB("0"));
    }
}

package info.victorchu.computer.simulation.circuit.adder;

import info.victorchu.computer.simulation.circuit.CircuitComponentUtils;
import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.Potentials;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author victorchu
 */
class LogicalAdderTest {
    @Test
    public void input00_01_0(){
        LogicalAdder adder = new LogicalAdder(2);
        Potential[] result= CircuitComponentUtils.compute(adder,
                Potentials.merge(
                        Potentials.fromText("00"),
                        Potentials.fromText("01"),
                        Potential.low()
                )
        );
        Assertions.assertEquals("001", Potentials.toText(result));
    }

    @Test
    public void input00_01_1(){
        LogicalAdder adder = new LogicalAdder(2);
        Potential[] result= CircuitComponentUtils.compute(adder,
                Potentials.merge(
                        Potentials.fromText("00"),
                        Potentials.fromText("01"),
                        Potential.high()
                )
        );
        Assertions.assertEquals("010", Potentials.toText(result));
    }
}
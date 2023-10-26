package info.victorchu.computer.simulation.circuit.enabler;

import info.victorchu.computer.simulation.circuit.CircuitComponentUtils;
import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.Potentials;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author victorchu
 */
class EnablerTest {
    @Test
    public void input10_0(){
        Enabler adder = new Enabler(2);
        Potential[] result= CircuitComponentUtils.compute(adder,
                Potentials.join(
                        Potentials.fromText("10"),
                        Potential.low()
                )
        );
        Assertions.assertEquals("00", Potentials.toText(result));
    }
    @Test
    public void input101_1(){
        Enabler adder = new Enabler(3);
        Potential[] result= CircuitComponentUtils.compute(adder,
                Potentials.join(
                        Potentials.fromText("101"),
                        Potential.high()
                )
        );
        Assertions.assertEquals("101", Potentials.toText(result));
    }
}
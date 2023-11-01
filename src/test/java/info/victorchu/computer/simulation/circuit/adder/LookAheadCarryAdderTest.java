package info.victorchu.computer.simulation.circuit.adder;

import info.victorchu.computer.simulation.circuit.CircuitComponentUtils;
import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.Potentials;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author victorchu
 */
public class LookAheadCarryAdderTest {
    @Test
    public void input00_01_0(){
        LookAheadCarryAdder adder = new LookAheadCarryAdder(2);
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
        LookAheadCarryAdder adder = new LookAheadCarryAdder(2);
        Potential[] result= CircuitComponentUtils.compute(adder,
                Potentials.merge(
                        Potentials.fromText("00"),
                        Potentials.fromText("01"),
                        Potential.high()
                )
        );
        Assertions.assertEquals("010", Potentials.toText(result));
    }
    @Test
    public void input01_01_1(){
        LookAheadCarryAdder adder = new LookAheadCarryAdder(2);
        Potential[] result= CircuitComponentUtils.compute(adder,
                Potentials.merge(
                        Potentials.fromText("01"),
                        Potentials.fromText("01"),
                        Potential.high()
                )
        );
        Assertions.assertEquals("011", Potentials.toText(result));
    }
    @Test
    public void input10_01_1(){
        LookAheadCarryAdder adder = new LookAheadCarryAdder(2);
        Potential[] result= CircuitComponentUtils.compute(adder,
                Potentials.merge(
                        Potentials.fromText("10"),
                        Potentials.fromText("01"),
                        Potential.high()
                )
        );
        Assertions.assertEquals("100", Potentials.toText(result));

    }
    @Test
    public void input10_10_1(){
        LookAheadCarryAdder adder = new LookAheadCarryAdder(2);
        Potential[] result= CircuitComponentUtils.compute(adder,
                Potentials.merge(
                        Potentials.fromText("10"),
                        Potentials.fromText("10"),
                        Potential.high()
                )
        );
        Assertions.assertEquals("101", Potentials.toText(result));

    }
    @Test
    public void input11_11_1(){
        LookAheadCarryAdder adder = new LookAheadCarryAdder(2);
        Potential[] result= CircuitComponentUtils.compute(adder,
                Potentials.merge(
                        Potentials.fromText("11"),
                        Potentials.fromText("11"),
                        Potential.high()
                )
        );
        Assertions.assertEquals("111", Potentials.toText(result));
    }
    @Test
    public void input011_001_1(){
        LookAheadCarryAdder adder = new LookAheadCarryAdder(3);
        Potential[] result= CircuitComponentUtils.compute(adder,
                Potentials.merge(
                        Potentials.fromText("011"),
                        Potentials.fromText("001"),
                        Potential.high()
                )
        );
        Assertions.assertEquals("0101", Potentials.toText(result));
    }
}

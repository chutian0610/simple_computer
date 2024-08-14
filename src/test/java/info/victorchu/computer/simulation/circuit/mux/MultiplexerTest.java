package info.victorchu.computer.simulation.circuit.mux;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import info.victorchu.computer.simulation.circuit.CircuitComponentUtils;
import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.Potentials;

public class MultiplexerTest {
    @Test
    public void input00_0() {
        Multiplexer mux = new Multiplexer(1);
        Potential[] result = CircuitComponentUtils.compute(mux,
                Potentials.merge(
                        Potentials.fromText("00"),
                        Potential.low()));
        Assertions.assertEquals("0", Potentials.toTextB(result));
    }

    @Test
    public void input00_1() {
        Multiplexer mux = new Multiplexer(1);
        Potential[] result = CircuitComponentUtils.compute(mux,
                Potentials.merge(
                        Potentials.fromText("00"),
                        Potential.high()));
        Assertions.assertEquals("0", Potentials.toTextB(result));
    }

    @Test
    public void input01_0() {
        Multiplexer mux = new Multiplexer(1);
        Potential[] result = CircuitComponentUtils.compute(mux,
                Potentials.merge(
                        Potentials.fromText("01"),
                        Potential.low()));
        Assertions.assertEquals("1", Potentials.toTextB(result));
    }

    @Test
    public void input10_0() {
        Multiplexer mux = new Multiplexer(1);
        Potential[] result = CircuitComponentUtils.compute(mux,
                Potentials.merge(
                        Potentials.fromText("10"),
                        Potential.low()));
        Assertions.assertEquals("0", Potentials.toTextB(result));
    }

    @Test
    public void input0001_00() {
        Multiplexer mux = new Multiplexer(2);
        Potential[] result = CircuitComponentUtils.compute(mux,
                Potentials.merge(
                        Potentials.fromText("0001"),
                        Potentials.fromText("00")));
        Assertions.assertEquals("1", Potentials.toTextB(result));
    }
       @Test
    public void input0001_01() {
        Multiplexer mux = new Multiplexer(2);
        Potential[] result = CircuitComponentUtils.compute(mux,
                Potentials.merge(
                        Potentials.fromText("0010"),
                        Potentials.fromText("01")));
        Assertions.assertEquals("1", Potentials.toTextB(result));
    }
}

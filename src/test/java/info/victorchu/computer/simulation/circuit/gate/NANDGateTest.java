package info.victorchu.computer.simulation.circuit.gate;

import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.utils.CircuitUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author victorchu
 */
class NANDGateTest {
    static NANDGate gate = new NANDGate();

    @BeforeEach
    void init() {
        gate.reset();
    }

    /**
     * 测试输入信号是 1 1的case
     */
    @Test
    void input11() {
        Potential[] result = CircuitUtils.compute(gate, Potential.high(), Potential.high());
        assertFalse(result[0].isHigh());
    }

    /**
     * 测试输入信号是 0 0 的case
     */
    @Test
    void input00() {
        Potential[] result = CircuitUtils.compute(gate, Potential.low(), Potential.low());
        assertTrue(result[0].isHigh());
    }

    /**
     * 测试输入信号是 0 1 的case
     */
    @Test
    void input01() {
        Potential[] result = CircuitUtils.compute(gate, Potential.low(), Potential.high());
        assertTrue(result[0].isHigh());
    }

    /**
     * 测试输入信号是 1 0的case
     */
    @Test
    void input10() {
        Potential[] result = CircuitUtils.compute(gate, Potential.high(), Potential.low());
        assertTrue(result[0].isHigh());
    }
}
package info.victorchu.computer.simulation.circuit.gate;

import info.victorchu.computer.simulation.circuit.CircuitComponentUtils;
import info.victorchu.computer.simulation.circuit.Potential;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author victorchu
 */
class NOTGateTest {
    static NOTGate  gate= new NOTGate();
    @BeforeEach
    void init(){
        gate.reset();
    }
    /**
     * 测试输入信号是 1 的case
     */
    @Test
    void input0() {
        Potential[] result = CircuitComponentUtils.compute(gate,Potential.low());
        assertTrue(result[0].isHigh());
    }
    /**
     * 测试输入信号是 1 0的case
     */
    @Test
    void input1() {
        Potential[] result = CircuitComponentUtils.compute(gate,Potential.high());
        assertFalse(result[0].isHigh());
    }
}
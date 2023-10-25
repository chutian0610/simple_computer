package info.victorchu.computer.simulation.circuit.gate;

import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.SimpleCircuitComponent;

/**
 * 非门.Y=A'
 * <pre>
 * 真值表:
 * input output
 *  0     1
 *  1     0
 * </pre>
 *
 * @author victorchu
 */
public class NOTGate extends SimpleCircuitComponent {
    public NOTGate() {
        super();
        init();
    }

    @Override
    public void update() {
        state[0].input(Potential.not(input[0]));
    }

    @Override
    public int inputLength() {
        return 1;
    }

    @Override
    public int outputLength() {
        return 1;
    }
}

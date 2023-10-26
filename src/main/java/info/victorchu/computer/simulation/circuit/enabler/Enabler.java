package info.victorchu.computer.simulation.circuit.enabler;

import info.victorchu.computer.simulation.circuit.CircuitComponentUtils;
import info.victorchu.computer.simulation.circuit.DynamicSimpleCircuitComponent;
import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.gate.ANDGate;

/**
 * 开关.
 * <pre>
 *     0-N: data
 *     N+1: enable
 * </pre>
 * @author victorchu
 */
public class Enabler extends DynamicSimpleCircuitComponent {

    private ANDGate[] enables;
    public Enabler(int ways) {
        super(ways);
        init();
    }

    @Override
    protected void init() {
        super.init();
        int length = getWays();
        enables = new ANDGate[length];
        for (int i = 0; i < length; i++) {
            enables[i] = new ANDGate();
        }
    }

    @Override
    public void reset() {
        super.reset();
        int length = getWays();
        for (int i = 0; i < length; i++) {
            enables[i].reset();
        }
    }

    @Override
    public void update() {
        int length = getWays();
        Potential enable = input[inputLength()-1];
        for (int i = 0; i < length; i++) {
            CircuitComponentUtils.fire(enables[i],input[i],enable);
            state[i].input(enables[i].output(0));
        }
    }

    @Override
    public int inputLength() {
        return ways+1;
    }

    @Override
    public int outputLength() {
        return ways;
    }
}

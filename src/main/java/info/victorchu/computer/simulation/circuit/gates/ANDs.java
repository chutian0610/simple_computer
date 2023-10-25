package info.victorchu.computer.simulation.circuit.gates;

import info.victorchu.computer.simulation.circuit.DynamicSimpleCircuitComponent;
import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.gate.ANDGate;
import info.victorchu.computer.simulation.utils.CircuitUtils;
import org.apache.commons.lang3.Validate;

/**
 * N ways ANDGate.
 *
 * @author victorchu
 */
public class ANDs extends DynamicSimpleCircuitComponent {
    private ANDGate[] andGates;

    public ANDs(int ways) {
        super(ways);
        Validate.isTrue(ways>=2,"and gates ways must >=2");
        init();
    }

    @Override
    protected void init() {
        super.init();
        int length = getWays() - 1;
        andGates = new ANDGate[length];
        for (int i = 0; i < length; i++) {
            andGates[i] = new ANDGate();
        }
    }

    @Override
    public void reset() {
        super.reset();
        int length = getWays() - 1;
        for (int i = 0; i < length; i++) {
            andGates[i].reset();
        }
    }

    @Override
    public void update() {
        Potential result = input[0];
        int length = getWays();
        for (int i = 1; i < length; i++) {
            if (!result.isHigh()) {
                // fast end
                break;
            }
            result = CircuitUtils.compute(andGates[i - 1], input[i], result)[0];
        }
        state[0].input(result);
    }

    @Override
    public int inputLength() {
        return getWays();
    }

    @Override
    public int outputLength() {
        return 1;
    }
}

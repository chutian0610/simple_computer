package info.victorchu.computer.simulation.circuit.biggate;

import info.victorchu.computer.simulation.circuit.CircuitComponentUtils;
import info.victorchu.computer.simulation.circuit.DynamicSimpleCircuitComponent;
import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.circuit.gate.ORGate;

import org.apache.commons.lang3.Validate;

/**
 * @author victorchu
 */
public class BigOR extends DynamicSimpleCircuitComponent {
    private ORGate[] orGates;

    public BigOR(int ways) {
        super(ways);
        Validate.isTrue(ways>=2,"OR gates ways must >=2");
        init();
    }

    @Override
    protected void init() {
        super.init();
        int length = getWays() - 1;
        orGates = new ORGate[length];
        for (int i = 0; i < length; i++) {
            orGates[i] = new ORGate();
        }
    }

    @Override
    public void reset() {
        super.reset();
        int length = getWays() - 1;
        for (int i = 0; i < length; i++) {
            orGates[i].reset();
        }
    }

    @Override
    public void update() {
        Potential result = input[0];
        int length = getWays();
        for (int i = 1; i < length; i++) {
            if (result.isHigh()) {
                // fast end
                break;
            }
            result = CircuitComponentUtils.compute(orGates[i - 1], input[i], result)[0];
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
package info.victorchu.computer.simulation.circuit.adder;

import info.victorchu.computer.simulation.circuit.DynamicSimpleCircuitComponent;
import info.victorchu.computer.simulation.circuit.Potential;
import info.victorchu.computer.simulation.utils.CircuitUtils;

/**
 * 行波进位加法器.
 * <pre>
 *    in:  a | b |carry
 *    out:  carry|sum
 * </pre>
 * @author victorchu
 */
public class RippleCarryAdder extends DynamicSimpleCircuitComponent {
    private FullAdder[] fullAdders;

    public RippleCarryAdder(int ways) {
        super(ways);
        init();

    }

    @Override
    protected void init() {
        super.init();
        fullAdders = new FullAdder[getWays()];
        int length = getWays();
        for (int i = 0; i < length; i++) {
            fullAdders[i] = new FullAdder();
        }
    }

    @Override
    public void reset() {
        super.reset();
        int length = getWays();
        for (int i = 0; i < length; i++) {
            fullAdders[i].reset();
        }
    }

    @Override
    public void update() {
        Potential carry = input[input.length - 1];
        int length = getWays();
        for (int i = length-1; i >= 0; i--) {
            CircuitUtils.fire(fullAdders[i], input[i], input[i + length], carry);
            carry = fullAdders[i].output(0);
            state[i + 1].input(fullAdders[i].output(1));
        }
        state[0].input(carry);
    }

    @Override
    public int inputLength() {
        return 2 * getWays() + 1;
    }

    @Override
    public int outputLength() {
        return getWays() + 1;
    }
}

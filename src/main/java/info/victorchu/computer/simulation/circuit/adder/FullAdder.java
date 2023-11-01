package info.victorchu.computer.simulation.circuit.adder;

import info.victorchu.computer.simulation.circuit.CircuitComponentUtils;
import info.victorchu.computer.simulation.circuit.Potentials;
import info.victorchu.computer.simulation.circuit.SimpleCircuitComponent;
import info.victorchu.computer.simulation.circuit.gate.ORGate;

/**
 * 全加器
 * <pre>
 * input:
 *  0-> a
 *  1->b
 *  2-> carry
 * output:
 *  0-> carry
 *  1-> sum
 * </pre>
 * @author victorchu
 */
public class FullAdder extends SimpleCircuitComponent {

    private HalfAdder adder1;
    private HalfAdder adder2;

    private ORGate orGate;
    public FullAdder() {
        super();
        init();
    }

    @Override
    protected void init() {
        super.init();
        adder1 = new HalfAdder();
        adder2 = new HalfAdder();
        orGate = new ORGate();
    }

    @Override
    public void reset() {
        super.reset();
        adder1.reset();
        adder2.reset();
        orGate.reset();
    }

    @Override
    public void update() {
        CircuitComponentUtils.fire(adder1,input[0],input[1]);
        CircuitComponentUtils.fire(adder2,adder1.output(1),input[2]);
        CircuitComponentUtils.fire(orGate,adder1.output(0),adder2.output(0));
        // 大端序 output = (carry,sum)
        Potentials.mergeInto(state,orGate.output(0), adder2.output(1));
    }

    @Override
    public int inputLength() {
        return 3;
    }

    @Override
    public int outputLength() {
        return 2;
    }
}
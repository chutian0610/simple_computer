package info.victorchu.computer.simulation.circuit.adder;

import info.victorchu.computer.simulation.circuit.CircuitComponentUtils;
import info.victorchu.computer.simulation.circuit.Potentials;
import info.victorchu.computer.simulation.circuit.SimpleCircuitComponent;
import info.victorchu.computer.simulation.circuit.gate.ANDGate;
import info.victorchu.computer.simulation.circuit.gate.XORGate;

/**
 * 半加器
 * <pre>
 * input:
 *  0-> a
 *  1->b
 * output:
 *  0-> carry
 *  1-> sum
 * </pre>
 * @author victorchu
 */
public class HalfAdder extends SimpleCircuitComponent {
    private ANDGate andGate;
    private XORGate xorGate;
    public HalfAdder() {
        super();
        init();
    }

    @Override
    protected void init() {
        super.init();
        andGate = new ANDGate();
        xorGate = new XORGate();
    }


    @Override
    public void reset() {
        super.reset();
        xorGate.reset();
        andGate.reset();
    }

    @Override
    public void update() {
        CircuitComponentUtils.fire(andGate,input);
        CircuitComponentUtils.fire(xorGate,input);
        // 大端序 output = (carry,sum)
        Potentials.merge(state,CircuitComponentUtils.emit(andGate),CircuitComponentUtils.emit(xorGate));
    }

    @Override
    public int inputLength() {
        return 2;
    }

    @Override
    public int outputLength() {
        return 2;
    }
}

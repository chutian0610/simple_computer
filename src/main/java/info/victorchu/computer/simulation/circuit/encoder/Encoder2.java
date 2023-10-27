package info.victorchu.computer.simulation.circuit.encoder;

import info.victorchu.computer.simulation.circuit.CircuitComponentUtils;
import info.victorchu.computer.simulation.circuit.Potentials;
import info.victorchu.computer.simulation.circuit.SimpleCircuitComponent;
import info.victorchu.computer.simulation.circuit.gate.ANDGate;
import info.victorchu.computer.simulation.circuit.gate.ORGate;

/**
 * 4-2 编码器
 * <pre>
 *   0 0 0 1 -> 0 0
 *   0 0 1 0 -> 0 1 
 *   0 1 0 0 -> 1 0
 *   1 0 0 0 -> 1 1
 * </pre>
 * @author victorchu
 */
public class Encoder2 extends SimpleCircuitComponent {

    private ORGate orGate0;    
    private ORGate orGate1;

    public Encoder2() {
        super();
        init();
    }

    @Override
    protected void init() {
        super.init();
        orGate0 = new ORGate();
        orGate1 = new ORGate();
    }

    @Override
    public void reset() {
        super.reset();
        orGate0.reset();
        orGate1.reset();
    }

    @Override
    public void update() {
        CircuitComponentUtils.fire(orGate0, input[0],input[1]);        
        CircuitComponentUtils.fire(orGate1, input[0],input[2]);
        Potentials.fillArray(state,CircuitComponentUtils.emits(orGate0,orGate1));
    }

    @Override
    public int inputLength() {
        return 4;
    }

    @Override
    public int outputLength() {
        return 2;
    }
}

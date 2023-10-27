package info.victorchu.computer.simulation.circuit.encoder;

import info.victorchu.computer.simulation.circuit.CircuitComponentUtils;
import info.victorchu.computer.simulation.circuit.Potentials;
import info.victorchu.computer.simulation.circuit.SimpleCircuitComponent;
import info.victorchu.computer.simulation.circuit.biggate.BigOR;
import info.victorchu.computer.simulation.circuit.gate.ANDGate;
import info.victorchu.computer.simulation.circuit.gate.NOTGate;
import info.victorchu.computer.simulation.circuit.gate.ORGate;

/**
 * 2-1 编码器
 * <pre>
 *   output: v | data
 * </pre>
 * @author victorchu
 */
public class PriorityEncoder2 extends SimpleCircuitComponent {

    private ORGate orGates1;    
    private ORGate orGates2;
    private ANDGate andGate;
    private NOTGate notGate;
    private BigOR bigOR;
 
    public PriorityEncoder2() {
        super();
        init();
    }

    @Override
    protected void init() {
        super.init();
        orGates1 = new ORGate();
        orGates2 = new ORGate();

        andGate = new ANDGate();
        notGate = new NOTGate();
        bigOR = new BigOR(3);
    }

    @Override
    public void reset() {
        super.reset();
        orGates1.reset();
        orGates2.reset();
        andGate.reset();
        notGate.reset();
        bigOR.reset();
    }

    @Override
    public void update() {
        CircuitComponentUtils.fire(notGate, input[1]);
        CircuitComponentUtils.fire(orGates1, input[0],input[1]);
        CircuitComponentUtils.fire(andGate, input[2],notGate.output(0));
        CircuitComponentUtils.fire(orGates2, input[0],andGate.output(0));
        CircuitComponentUtils.fire(bigOR, orGates1.output(0),input[2],input[3]);
        Potentials.fillArray(state,CircuitComponentUtils.emits(bigOR,orGates1,orGates2));
    }

    @Override
    public int inputLength() {
        return 4;
    }

    @Override
    public int outputLength() {
        return 3;
    }
}


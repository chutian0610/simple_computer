package info.victorchu.computer.simulation.circuit.decoder;

import info.victorchu.computer.simulation.circuit.SimpleCircuitComponent;
import info.victorchu.computer.simulation.circuit.gate.ANDGate;
import info.victorchu.computer.simulation.circuit.gate.NOTGate;
import info.victorchu.computer.simulation.utils.CircuitUtils;

/**
 * 2-4线decoder.
 * @author victorchu
 */
public class Decoder2 extends SimpleCircuitComponent {

    private NOTGate[] notGates;
    private ANDGate[] andGates;

    public Decoder2() {
        super();
        init();
    }

    @Override
    protected void init() {
        super.init();
        notGates = new NOTGate[2];
        for (int i = 0; i < 2; i++) {
            notGates[i] = new NOTGate();
        }
        andGates= new ANDGate[4];
        for (int i = 0; i < 4; i++) {
            andGates[i] = new ANDGate();
        }
    }


    @Override
    public void reset() {
        super.reset();
        for (int i = 0; i < 2; i++) {
            notGates[i].reset();
        }
        for (int i = 0; i < 4; i++) {
            andGates[i].reset();
        }
    }


    @Override
    public void update() {
        CircuitUtils.fire(notGates[0],input[0]);
        CircuitUtils.fire(notGates[1],input[1]);

        CircuitUtils.fire(andGates[0],input[0],input[1]);
        CircuitUtils.fire(andGates[1],input[0],notGates[1].output(0));
        CircuitUtils.fire(andGates[2],notGates[0].output(0),input[1]);
        CircuitUtils.fire(andGates[3],notGates[0].output(0),notGates[1].output(0));

        state[0].input(andGates[0].output(0));
        state[1].input(andGates[1].output(0));
        state[2].input(andGates[2].output(0));
        state[3].input(andGates[3].output(0));
    }

    @Override
    public int inputLength() {
        return 2;
    }

    @Override
    public int outputLength() {
        return 4;
    }
}
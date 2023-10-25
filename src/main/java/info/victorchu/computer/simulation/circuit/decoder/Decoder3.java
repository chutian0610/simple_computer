package info.victorchu.computer.simulation.circuit.decoder;

import info.victorchu.computer.simulation.circuit.SimpleCircuitComponent;
import info.victorchu.computer.simulation.circuit.gate.ANDGate;
import info.victorchu.computer.simulation.utils.CircuitUtils;

/**
 * 3-8线 decoder
 * @author victorchu
 */
public class Decoder3 extends SimpleCircuitComponent {
    private Decoder1 decoder1;
    private Decoder2 decoder2;
    private ANDGate[] andGates;

    public Decoder3() {
        super();
        init();
    }

    @Override
    protected void init() {
        super.init();
        decoder1 = new Decoder1();
        decoder2 = new Decoder2();
        andGates = new ANDGate[8];
        for (int i = 0; i < 8; i++) {
            andGates[i] = new ANDGate();
        }
    }


    @Override
    public void reset() {
        super.reset();
        decoder1.reset();
        decoder2.reset();
        for (int i = 0; i < 8; i++) {
            andGates[i].reset();
        }
    }

    @Override
    public void update() {
        CircuitUtils.fire(decoder1,input[0]);
        CircuitUtils.fire(decoder2,input[1],input[2]);
        CircuitUtils.fire(andGates[0],decoder1.output(0),decoder2.output(0));
        CircuitUtils.fire(andGates[1],decoder1.output(0),decoder2.output(1));
        CircuitUtils.fire(andGates[2],decoder1.output(0),decoder2.output(2));
        CircuitUtils.fire(andGates[3],decoder1.output(0),decoder2.output(3));

        CircuitUtils.fire(andGates[4],decoder1.output(1),decoder2.output(0));
        CircuitUtils.fire(andGates[5],decoder1.output(1),decoder2.output(1));
        CircuitUtils.fire(andGates[6],decoder1.output(1),decoder2.output(2));
        CircuitUtils.fire(andGates[7],decoder1.output(1),decoder2.output(3));

        for (int i = 0; i < 8; i++) {
            state[i].input(andGates[i].output(0));
        }
    }

    @Override
    public int inputLength() {
        return 3;
    }

    @Override
    public int outputLength() {
        return 8;
    }
}

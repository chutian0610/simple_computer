package info.victorchu.computer.simulation.circuit.decoder;

import info.victorchu.computer.simulation.circuit.SimpleCircuitComponent;
import info.victorchu.computer.simulation.circuit.gate.NOTGate;
import info.victorchu.computer.simulation.utils.CircuitUtils;

/**
 * 1-2线decoder
 *
 * @author victorchu
 */
public class Decoder1 extends SimpleCircuitComponent {

    private NOTGate notGate;

    public Decoder1() {
        super();
        init();
    }

    @Override
    protected void init() {
        super.init();
        notGate = new NOTGate();
    }


    @Override
    public void reset() {
        super.reset();
        notGate.reset();
    }


    @Override
    public void update() {
        CircuitUtils.fire(notGate,input);
        state[0].input(input[0]);
        state[1].input(notGate.output(0));
    }

    @Override
    public int inputLength() {
        return 1;
    }

    @Override
    public int outputLength() {
        return 2;
    }
}
